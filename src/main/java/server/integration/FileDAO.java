package server.integration;

import common.FileDTO;
import common.FileError;
import common.LogInDetails;
import common.UserError;
import server.model.File;
import server.model.User;

import javax.persistence.*;

public class FileDAO {
    private final EntityManagerFactory factory;
    private final ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<>();

    public FileDAO() {
        factory = Persistence.createEntityManagerFactory("filePersistenceUnit");
    }

    private EntityManager beginTransaction() {
        EntityManager em = factory.createEntityManager();
        entityManagerThreadLocal.set(em);
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        return em;
    }

    private void commitTransaction() {
        entityManagerThreadLocal.get().getTransaction().commit();
    }

    public void createFile(FileDTO file) throws FileError {
        try {
            EntityManager em = beginTransaction();
            em.persist(file);
        }catch (Exception e){
            throw new FileError("Error creating file...");
        }finally {
            commitTransaction();
        }
    }

    public void deleteFile(User user, String fileName) {
        try {
            EntityManager em = beginTransaction();
            TypedQuery delFile = em.createNamedQuery("deleteFile", File.class);
            delFile.setParameter("fileName", fileName);
            delFile.setParameter("username", user.getUsername());
            delFile.setParameter("password", user.getPassword());
            delFile.executeUpdate();
        } finally {
            commitTransaction();
        }
    }

    public void createUser(User user) throws UserError {
        try {
            if(searchUser(user.getUsername()) != null)
                throw new UserError("Account already exists...");
            EntityManager em = beginTransaction();
            em.persist(new User(user.getUsername(), user.getPassword()));
        } finally {
            commitTransaction();
        }
    }

    private User searchUser(String username) throws UserError {
        if (username == null) {
            throw new UserError("No username entered...");
        }
        try {
            EntityManager em = beginTransaction();
            try {
                return em.createNamedQuery("checkUser", User.class)
                        .setParameter("username", username).getSingleResult();
            } catch (NoResultException noSuchAccount) {
                return null;
            }
        } finally {
            commitTransaction();
        }
    }

    void deleteUser(User user) {
        try {
            EntityManager em = beginTransaction();
            TypedQuery query = em.createNamedQuery("deleteUser", User.class);
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());
            query.executeUpdate();
            em.detach(user);
        } finally {
            commitTransaction();
        }
    }

    User checkLogin(LogInDetails logInDetails) throws UserError {
        try {
            EntityManager em = beginTransaction();
            try {
                TypedQuery query = em.createNamedQuery("loginUser", User.class);
                query.setParameter("username", logInDetails.getUsername());
                query.setParameter("password", logInDetails.getPassword());
                User user = query.getSingleResult();
            } catch (NoResultException noSuchAccount) {
                throw new UserError("Wrong login details!");
            }
        } finally {
            commitTransaction();
        }
        return
    }


}

package server.integration;

import common.FileDTO;
import common.FileError;
import server.model.File;
import sun.tools.asm.CatchData;

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

    private void rollbackTransaction() {

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

    public void deleteFile(String username, String password) {
        try {
            EntityManager em = beginTransaction();
            TypedQuery delFile = em.createNamedQuery("deleteFile", File.class);
            delFile.setParameter("username", username);
            delFile.setParameter("password", username);
            delFile.executeUpdate();
        } finally {
            commitTransaction();
        }
    }



}

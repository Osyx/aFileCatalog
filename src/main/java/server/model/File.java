package server.model;

import common.FileDTO;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "deleteAccountByName",
                query = "DELETE FROM Account acct WHERE acct.holder.name LIKE :holderName"
        )
        ,
        @NamedQuery(
                name = "findAccountByName",
                query = "SELECT acct FROM Account acct WHERE acct.holder.name LIKE :holderName",
                lockMode = LockModeType.OPTIMISTIC
        )
        ,
        @NamedQuery(
                name = "findAllAccounts",
                query = "SELECT acct FROM Account acct",
                lockMode = LockModeType.OPTIMISTIC
        )
})

@Entity(name = "File")
public class File implements FileDTO {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "owner", nullable = false)
    private User owner;

    @Column(name = "privateAccess", nullable = false)
    private boolean privateAccess;

    @Column(name = "writePermission", nullable = false)
    private boolean writePermission;

    @Column(name = "content", nullable = false)
    private java.io.File content;

    @Version
    @Column(name = "OPTLOCK")
    private int versionNum;

    /**
     * Creates an instance without holder and with the balance zero. A public no-arg constructor is
     * required by JPA.
     */
    public File() {
        this(null, 0);
    }

    public File(User user, java.io.File content) {
        this.owner = user;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public User getOwner() {
        return owner;
    }

    public boolean isPrivateAccess() {
        return privateAccess;
    }

    public boolean isWritePermission() {
        return writePermission;
    }

    public java.io.File getContent() {
        return content;
    }

    /**
     * Deposits the specified amount to this account.
     *
     * @param amount The amount to deposit.
     * @throws RejectedException If trying to deposit a negative amount.
     */
    public void upload(int amount) throws RejectedException {

    }

    public void download(int amount) throws RejectedException {

    }

    private String accountInfo() {
        return " " + this;
    }

    /**
     * @return A string representation of all fields in this object.
     */
    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("File: [");
        stringRepresentation.append("File name: ");
        stringRepresentation.append(name);
        stringRepresentation.append(", owner: ");
        stringRepresentation.append(owner.getName());
        stringRepresentation.append(", size: ");
        stringRepresentation.append(size);
        stringRepresentation.append(", is private: ");
        stringRepresentation.append(privateAccess);
        stringRepresentation.append(", can write: ");
        stringRepresentation.append(writePermission);
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }
}
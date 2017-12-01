package server.model;

import common.FileDTO;
import common.FileError;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "deleteFile",
                query = "DELETE FROM files file WHERE file.name LIKE :fileName AND file.owner.username LIKE :ownerName"
        )
        ,
        @NamedQuery(
                name = "findOwnedFiles",
                query = "SELECT file FROM files file WHERE file.owner.username LIKE :ownerName",
                lockMode = LockModeType.OPTIMISTIC
        )
        ,
        @NamedQuery(
                name = "findAllFilesAvailable",
                query = "SELECT file FROM files file WHERE (file.privateAccess = TRUE AND file.owner.username NOT LIKE :ownerName)",
                lockMode = LockModeType.OPTIMISTIC
        )
})

@Entity(name = "files")
public class File implements FileDTO {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    private long fileSize;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "privateAccess", nullable = false)
    private boolean privateAccess;

    @Column(name = "writePermission", nullable = false)
    private boolean writePermission;

    @Column(name = "content", nullable = false)
    private java.io.File content;

    public File() {
        this("new", new User("new"), new java.io.File("temp"));
    }

    public File(String name, User user, java.io.File content) {
        this.name = name;
        this.fileSize = content.length();
        this.owner = user;
        this.privateAccess = true;
        this.writePermission = true;
        this.content = content;
    }

    public File(String name, User user, boolean privateAccess, boolean writePermission, java.io.File content) {
        this.name = name;
        this.fileSize = content.length();
        this.owner = user;
        this.privateAccess = privateAccess;
        this.writePermission = writePermission;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public long getFileSize() {
        return fileSize;
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

    public void upload(java.io.File file) throws FileError {
        if("Everything goes wrong".equals("Sorry"))
            throw new FileError("Something went wrong during the upload...");
    }

    public void download(String fileName) throws FileError {
        if("Everything goes wrong".equals("Sorry"))
            throw new FileError("Something went wrong during the download...");
    }

    /**
     * @return A string representation of all fields in this object.
     */
    @Override
    public String toString() {
        return "File: [" +
                "File name: " +
                name +
                ", owner: " +
                owner.getName() +
                ", size: " +
                fileSize +
                ", is private: " +
                privateAccess +
                ", can write: " +
                writePermission +
                "]";
    }
}
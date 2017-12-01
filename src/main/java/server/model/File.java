package server.model;

import common.FileDTO;
import common.FileError;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "deleteFile",
                query = "DELETE FROM files WHERE files.name LIKE :fileName AND files.owner.username LIKE :ownerName"
        )
        ,
        @NamedQuery(
                name = "findOwnedFiles",
                query = "SELECT name, fileSize, owner, privateAccess, writePermission FROM files WHERE files.owner.username LIKE :ownerName",
                lockMode = LockModeType.OPTIMISTIC
        )
        ,
        @NamedQuery(
                name = "findAllFilesAvailable",
                query = "SELECT name, fileSize, owner, privateAccess, writePermission FROM files WHERE (files.privateAccess = TRUE AND files.owner.username NOT LIKE :ownerName)",
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

    @Column(name = "owner", nullable = false)
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
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("File: [");
        stringRepresentation.append("File name: ");
        stringRepresentation.append(name);
        stringRepresentation.append(", owner: ");
        stringRepresentation.append(owner.getName());
        stringRepresentation.append(", size: ");
        stringRepresentation.append(fileSize);
        stringRepresentation.append(", is private: ");
        stringRepresentation.append(privateAccess);
        stringRepresentation.append(", can write: ");
        stringRepresentation.append(writePermission);
        stringRepresentation.append("]");
        return stringRepresentation.toString();
    }
}
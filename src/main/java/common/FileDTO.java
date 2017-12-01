package common;

import java.io.Serializable;
import server.model.File;
import server.model.User;

/**
 * Specifies a read-only view of n account.
 */
public interface FileDTO extends Serializable {
    String getName();

    long getFileSize();

    String getOwner();

    boolean isPrivateAccess();

    boolean isWritePermission();

    java.io.File getContent();
}
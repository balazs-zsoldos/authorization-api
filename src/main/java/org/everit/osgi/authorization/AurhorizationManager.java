package org.everit.osgi.authorization;

/**
 * Low level API to manage permissions and permission inheritances.
 */
public interface AurhorizationManager {

    void addPermission(long authorizedResourceId, String action, long targetResourceId);

    void addPermissionInheritance(long parentResourceId, long childResourceId);

    void removePermission(long authorizedResourceId, String action, long targetResourceId);

    void removePermissionInheritance(long parentResourceId, long childResourceId);
}

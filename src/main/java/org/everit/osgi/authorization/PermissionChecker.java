package org.everit.osgi.authorization;

/**
 * Check permissions.
 */
public interface PermissionChecker {

    /**
     * Getting the resources that the current authorized resource inherits the rights from. In practice these could mean
     * user groups or roles that a user is assigned to.
     *
     * @param resourceId
     *            The id of the authorized resource.
     * @return The parent resource IDs AND the resourceId parameter.
     */
    long[] getAuthorizationScope(long resourceId);

    /**
     * Check whether the authorized resource has the permission with the given parameters.
     *
     * @param authorizedResourceId
     *            The id of the resource that we check permissions for.
     * @param actionId
     *            The id of the action. Cannot be <code>null</code>.
     * @param targetResourceId
     *            The id of the resource that the authorized resource may have permission on.
     * @return <code>true</code> if there is available permission, <code>false</code> otherwise.
     */
    boolean hasPermission(long authorizedResourceId, String actionId, long targetResourceId);

}

package org.everit.osgi.authorization.api;

/**
 * Check permissions.
 */
public interface PermissionChecker {

    /**
     * Check whether the authorized resource has the permission with the given parameters.
     *
     * @param authorizedResourceId
     *            The id of the resource that we check permissions for.
     * @param actionId
     *            The id of the action. Cannot be null.
     * @param targetResourceId
     *            The id of the resource that the authorized resource may have permission on.
     * @return The result of the permission checking.
     * @throws org.everit.util.core.validation.ValidationException
     *             If authorizedResourceId, actionId or targetResourceId is null.
     */
    boolean hasPermission(String actionId, long targetResourceId);

    /**
     * Checks whether the authorized resource has the permission with the given parameters.
     *
     * @param authorizedResourceId
     *            The id of the resource that we check permissions for.
     * @param actions
     *            The actions that describes the permission. Cannot be null.
     * @param targetResourceId
     *            The id of the resource that the authorized resource may have permission on.
     * @return <code>true</code> if one of the actions is permitted.
     * @throws org.everit.util.core.validation.ValidationException
     *             If authorizedResourceId, actions or targetResourceId is null.
     */
    boolean hasPermissionForActions(String[] actions, long targetResourceId);
}

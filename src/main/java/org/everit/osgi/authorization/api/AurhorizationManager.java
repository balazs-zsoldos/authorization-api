package org.everit.osgi.authorization.api;

/**
 * Low level API to manage permissions and permission inheritances.
 */
public interface AurhorizationManager {

    /**
     * Enables the rights to the given action for the authorized resource on the target resource in the given interval.
     *
     * @param authorizedResourceId
     *            The id of the authorized resource.
     * @param action
     *            The permitted action. Cannot be null.
     * @param targetResourceId
     *            The id of the target resource.
     * @return The created {@link Permission}.
     * @throws org.everit.util.core.validation.ValidationException
     *             If the authorizedResourceId, action, targetResourceId or validTo parameters are null. If the
     *             authorized resource is not found by authorizedResourceId or the target resource is not found by
     *             targetResourceId. If the validFrom or validTo is in the past. If the validTo is before validFrom.
     */
    boolean addPermission(long authorizedResourceId, String action, long targetResourceId);

    /**
     * Enables the association between a parent and child resource in the given interval.
     *
     * @param parentResourceId
     *            The id of the parent resource.
     * @param childResourceId
     *            The id of the child resource.
     * @return The create {@link PermissionInheritance}.
     * @throws AuthorizationServiceException
     *             If a cyclic reference created with the given parameters.
     * @throws org.everit.util.core.validation.ValidationException
     *             If the parentResourceId, childResourceId or validTo parameter is null. If the parent resource is not
     *             found by parentResourceId or the child resource is not found by childResourceId. If the validFrom or
     *             validTo is in the past. If the validTo is before validFrom.
     */
    boolean addPermissionInheritance(long parentResourceId, long childResourceId);

    void removePermission(long authorizedResourceId, String action, long targetResourceId);

    /**
     * Removes the permission inheritance.
     *
     * @throws org.everit.util.core.validation.ValidationException
     *             If the permissionInheritanceId or version parameter is null.
     */
    void removePermissionInheritance(long parentResourceId, long childResourceId);
}

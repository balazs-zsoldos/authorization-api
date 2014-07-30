/**
 * This file is part of Everit - Authorization API.
 *
 * Everit - Authorization API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Authorization API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Authorization API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authorization;

/**
 * Low level API to manage permissions and permission inheritances.
 */
public interface AuthorizationManager {

    /**
     * Defining a new permission.
     *
     * @param authorizedResourceId
     *            The resource id of the entity who is authorized.
     * @param targetResourceId
     *            The resource id of the entity which we defined the action on.
     * @param action
     *            The action that can be made on the target resource.
     */
    void addPermission(long authorizedResourceId, long targetResourceId, String action);

    /**
     * Specifying a new permission inheritance. The child will inherit all of the permissions of the parent.
     *
     * @param parentResourceId
     *            The resource id of the parent entity (role, user group, ...).
     * @param childResourceId
     *            The resource id of the child entity (e.g. user).
     */
    void addPermissionInheritance(long parentResourceId, long childResourceId);

    /**
     * Clears the cache of the authorization component.
     */
    void clearCache();

    /**
     * Removes a permission definition.
     *
     * @param authorizedResourceId
     *            The resource id of the entity who is authorized.
     * @param targetResourceId
     *            The resource id of the entity which we defined the action on.
     * @param action
     *            The action that can be made on the target resource.
     */
    void removePermission(long authorizedResourceId, long targetResourceId, String action);

    /**
     * Removes a permission inheritance.
     *
     * @param parentResourceId
     *            The resource id of the parent entity (role, user group, ...).
     * @param childResourceId
     *            The resource id of the child entity (e.g. user).
     */
    void removePermissionInheritance(long parentResourceId, long childResourceId);
}

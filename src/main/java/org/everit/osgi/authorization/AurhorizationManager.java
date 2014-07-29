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
public interface AurhorizationManager {

    /**
     * Defining a new permission.
     *
     * @param authorizedResourceId
     *            The resource id of the entity who is authorized.
     * @param action
     *            The action that can be made on the target resource.
     * @param targetResourceId
     *            The resource id of the entity which we defined the action on.
     */
    void addPermission(long authorizedResourceId, String action, long targetResourceId);

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
     * Removes a permission definition.
     *
     * @param authorizedResourceId
     *            The resource id of the entity who is authorized.
     * @param action
     *            The action that can be made on the target resource.
     * @param targetResourceId
     *            The resource id of the entity which we defined the action on.
     */
    void removePermission(long authorizedResourceId, String action, long targetResourceId);

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

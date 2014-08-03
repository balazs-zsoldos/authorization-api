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
 * Checking permissions.
 */
public interface PermissionChecker {

    /**
     * Getting the resources that the current authorized resource inherits the rights from. In practice these could mean
     * user groups or roles that a user is assigned to.
     *
     * @param authorizedResourceId
     *            The id of the authorized resource.
     * @return The parent resource IDs AND the resourceId parameter.
     */
    long[] getAuthorizationScope(long authorizedResourceId);

    /**
     * Check whether the authorized resource has the permission with the given parameters.
     *
     * @param authorizedResourceId
     *            The id of the resource that we check permissions for.
     * @param action
     *            The action of the permission. Cannot be <code>null</code>.
     * @param targetResourceId
     *            The id of the resource that the authorized resource may have permission on.
     * @return <code>true</code> if there is available permission, <code>false</code> otherwise. The function returns
     *         false if the authorized resource or target resource does not exist.
     * @throws NullPointerException
     *             if action parameter is null.
     */
    boolean hasPermission(long authorizedResourceId, long targetResourceId, String action);

}

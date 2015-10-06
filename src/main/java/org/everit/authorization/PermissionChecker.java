/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.authorization;

/**
 * Checking permissions.
 */
public interface PermissionChecker {

  /**
   * Getting the resources that the current authorized resource inherits the rights from. In
   * practice these could mean user groups or roles that a user is assigned to.
   *
   * @param authorizedResourceId
   *          The id of the authorized resource.
   * @return The parent resource IDs transitively and the resourceId parameter.
   */
  long[] getAuthorizationScope(long authorizedResourceId);

  /**
   * There must be only one system resource and it has permission to do everything.
   *
   * @return The resource id of the system.
   */
  long getSystemResourceId();

  /**
   * Check whether the authorized resource has the permission with the given parameters.
   *
   * @param authorizedResourceId
   *          The id of the resource that we check permissions for.
   * @param actions
   *          One or more actions. If multiple actions are provided, the function returns true if
   *          the authorized resource can do any of the actions on the target. At least one action
   *          must be defined.
   * @param targetResourceId
   *          The id of the resource that the authorized resource may have permission on.
   * @return <code>true</code> if there is available permission, <code>false</code> otherwise. The
   *         function returns false if the authorized resource or target resource does not exist.
   * @throws NullPointerException
   *           if action parameter is a null array or one of the actions is null.
   * @throws IllegalArgumentException
   *           if a zero length array argument is passed for the action parameter.
   */
  boolean hasPermission(long authorizedResourceId, long targetResourceId, String... actions);
}

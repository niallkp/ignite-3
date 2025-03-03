/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.sql.engine.framework;

import java.util.List;

/**
 * Represents the base interface for describing a complete set of zone-related fields.
 *
 * <p>
 * This interface serves as a foundational aspect to ensure synchronization between different variants of zone builders.
 * Implementations of this interface allow the building of zone configurations
 * with common methods that can be extended or specialized in concrete builders.
 * </p>
 *
 * @param <ChildT> The specific type of the builder implementation that will be exposed to the user, enabling fluent builder patterns.
 * @see ClusterZoneBuilder
 */
interface ZoneBuilderBase<ChildT> {
    /**
     * Sets the name of the zone.
     *
     * @param name The name to assign to the zone.
     * @return The builder instance for chaining methods.
     */
    ChildT name(String name);

    /**
     * Configures the storage profiles associated with the zone.
     *
     * @param storageProfiles A list of storage profile names to associate with the zone.
     * @return The builder instance for chaining methods.
     */
    ChildT storageProfiles(List<String> storageProfiles);
}

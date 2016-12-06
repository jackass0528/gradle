/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.artifacts.transform;

import org.gradle.api.Incubating;
import org.gradle.api.artifacts.component.ComponentIdentifier;
import org.gradle.api.attributes.AttributeContainer;

/**
 * Allows the artifacts to be filtered from a Configuration / View based on the source component identifier.
 * Artifact filters will apply to any view that matches the configured filter attributes.
 */
@Incubating
public abstract class ArtifactFilter {
    public static ArtifactFilter INCLUDE_ALL = new ArtifactFilter() {
        @Override
        public void configure(AttributeContainer filterOnAttributes) {
        }

        @Override
        public boolean include(ComponentIdentifier component) {
            return true;
        }
    };

    /**
     * Specifies the attributes that must be matched in order for this filter to apply.
     */
    public abstract void configure(AttributeContainer filterOnAttributes);

    /**
     * Specifies whether artifacts from the component should be included in the view.
     */
    public abstract boolean include(ComponentIdentifier component);
}

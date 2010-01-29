/**
 * Copyright 2005-2010 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.dataservices.internal.edm;

import org.restlet.ext.dataservices.internal.reflect.ReflectUtils;

/**
 * Represents one entity implied in an AssociationSet.
 * 
 * @author Thierry Boileau
 */
public class AssociationSetEnd {

    /** The role of this entity relatively to this association. */
    private final String role;

    /** The type of this entity. */
    private EntitySet type;

    /**
     * Constructor.
     * 
     * @param role
     *            The name of the role.
     */
    public AssociationSetEnd(String role) {
        super();
        this.role = role;
    }

    /**
     * Returns the role as a valid Java identifier.
     * 
     * @return The role as a valid Java identifier.
     */
    public String getNormalizedRole() {
        return ReflectUtils.normalize(role);
    }

    /**
     * Returns the role of this entity relatively to this association.
     * 
     * @return The role of this entity relatively to this association.
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns the type of this entity.
     * 
     * @return The type of this entity.
     */
    public EntitySet getType() {
        return type;
    }

    /**
     * Sets the type of this entity.
     * 
     * @param type
     *            The type of this entity.
     */
    public void setType(EntitySet type) {
        this.type = type;
    }
}

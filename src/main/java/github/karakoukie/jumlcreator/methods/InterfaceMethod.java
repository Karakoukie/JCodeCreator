/*
 * Copyright (C) 2019 Tristan Muller (tristan.muller@cirad.fr)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package github.karakoukie.jumlcreator.methods;

import github.karakoukie.jumlcreator.data.DataType;
import github.karakoukie.jumlcreator.elements.Element;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@ThreadSafe
public class InterfaceMethod extends Element {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/

    @GuardedBy("this")
    private DataType returnType;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<Property> properties;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public InterfaceMethod() {
        this.returnType = DataType.VOID;
        this.properties = new CopyOnWriteArrayList();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setReturnType(DataType returnType) {
        this.returnType = returnType;
    }
    
    public final void addProperty(final Property p) {
        this.properties.add(p);
    }
    
    public final void removeProperty(final Property p) {
        this.properties.remove(p);
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized DataType getReturnType() {
        return returnType;
    }
    
    public final List<Property> getProperties() {
        return Collections.unmodifiableList(properties);
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

    
    
}

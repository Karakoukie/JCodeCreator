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
package github.karakoukie.jumlcreator;

import github.karakoukie.jumlcreator.elements.Element;
import github.karakoukie.jumlcreator.methods.InterfaceMethod;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.annotation.GuardedBy;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public final class Interface extends Element {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/

    @GuardedBy("this")
    private Interface extension;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<InterfaceMethod> methods;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public Interface() {
        super();
        this.extension = null;
        this.methods = new CopyOnWriteArrayList();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final void addMethod(final InterfaceMethod method) {
        this.methods.add(method);
    }
    
    public final void removeMethod(final InterfaceMethod method) {
        this.methods.remove(method);
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized Interface getExtension() {
        return extension;
    }

    public final List<InterfaceMethod> getMethods() {
        return Collections.unmodifiableList(methods);
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

}

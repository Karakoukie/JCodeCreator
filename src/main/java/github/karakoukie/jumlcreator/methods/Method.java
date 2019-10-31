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

import github.karakoukie.jumlcreator.elements.AccessKeyword;
import github.karakoukie.jumlcreator.elements.ImplementationKeyword;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@ThreadSafe
public final class Method extends InterfaceMethod {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private AccessKeyword accessKeyword;
    
    @GuardedBy("this")
    private ImplementationKeyword implementationKeyword;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/

    public Method() {
        super();
        this.accessKeyword = AccessKeyword.PUBLIC;
        this.implementationKeyword = ImplementationKeyword.FINAL;
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setAccessKeyword(
            final AccessKeyword accessKeyword) {
        this.accessKeyword = accessKeyword;
    }
    
    public final synchronized void setImplementationKeyword(
            final ImplementationKeyword implementationKeyword) {
        this.implementationKeyword = implementationKeyword;
    }

    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized AccessKeyword getAccessKeyword() {
        return accessKeyword;
    }

    public final synchronized ImplementationKeyword getImplementationKeyword() {
        return implementationKeyword;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

}

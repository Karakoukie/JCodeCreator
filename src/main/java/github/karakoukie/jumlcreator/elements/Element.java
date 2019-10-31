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
package github.karakoukie.jumlcreator.elements;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@ThreadSafe
public abstract class Element {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private String name;
    
    @GuardedBy("this")
    private String comment;

    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public Element() {
        this.name = "";
        this.comment = "";
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setName(final String name) {
        this.name = name;
    }

    public final synchronized void setComment(String comment) {
        this.comment = comment;
    }

    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized String getName() {
        return name;
    }

    public final synchronized String getComment() {
        return comment;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/
    
}

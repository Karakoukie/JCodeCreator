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
package github.karakoukie.jumlcreator.data;

import github.karakoukie.jumlcreator.classes.JClass;
import org.apache.http.annotation.GuardedBy;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public final class JData {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/

    @GuardedBy("this")
    private JDataType dataType;
    
    @GuardedBy("this")
    private JClass classDataType;
    
    @GuardedBy("this")
    private String customDataType;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public JData() {
        this.dataType = JDataType.VOID;
        this.classDataType = null;
        this.customDataType = "";
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized void setDataType(final JDataType dataType) {
        this.dataType = dataType;
    }

    public final synchronized void setClassDataType(final JClass classDataType) {
        this.classDataType = classDataType;
    }

    public final synchronized void setCustomDataType(final String customDataType) {
        this.customDataType = customDataType;
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized JDataType getDataType() {
        return dataType;
    }

    public final synchronized JClass getClassDataType() {
        return classDataType;
    }

    public final synchronized String getCustomDataType() {
        return customDataType;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/
    
}

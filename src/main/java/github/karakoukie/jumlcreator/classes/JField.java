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
package github.karakoukie.jumlcreator.classes;

import github.karakoukie.jumlcreator.data.JData;
import github.karakoukie.jumlcreator.nodes.JElementNode;
import github.karakoukie.jumlcreator.nodes.JImplementationKeyword;
import org.apache.http.annotation.GuardedBy;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public final class JField extends JElementNode {

    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private boolean isAbstract;
    
    @GuardedBy("this")
    private JImplementationKeyword implementationKeyword;
    
    @GuardedBy("Data")
    private final JData data;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public JField() {
        super();
        this.isAbstract = false;
        this.implementationKeyword = JImplementationKeyword.FINAL;
        this.data = new JData();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    @Override
    public final String getGUIString() {
        String text = "";
        
        if (isAbstract) {
            text += " # ";
        } else {
            text += " - ";
        }
        
        text += getName();
        text += " : " + getData().getName();
        
        return text;
    }
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setIsAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }
    
    public final synchronized void setImplementationKeyword(
            final JImplementationKeyword implementationKeyword) {
        this.implementationKeyword = implementationKeyword;
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized boolean isAbstract() {
        return isAbstract;
    }
    
    public final synchronized JImplementationKeyword getImplementationKeyword() {
        return implementationKeyword;
    }
    
    public final JData getData() {
        return data;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/
    
}

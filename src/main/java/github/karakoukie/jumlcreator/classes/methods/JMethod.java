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
package github.karakoukie.jumlcreator.classes.methods;

import github.karakoukie.jumlcreator.data.JDataType;
import github.karakoukie.jumlcreator.nodes.JAccessKeyword;
import github.karakoukie.jumlcreator.nodes.JImplementationKeyword;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@ThreadSafe
public final class JMethod extends JInterfaceMethod {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private JAccessKeyword accessKeyword;
    
    @GuardedBy("this")
    private JImplementationKeyword implementationKeyword;
    
    @GuardedBy("this")
    private String code;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/

    public JMethod() {
        super();
        this.accessKeyword = JAccessKeyword.PUBLIC;
        this.implementationKeyword = JImplementationKeyword.FINAL;
        this.code = "";
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    @Override
    public final String getGUIString() {
        String text = "";
        
        switch (accessKeyword) {
            case PRIVATE : text += " - "; break;
            case PROTECTED : text += " * "; break;
            case PUBLIC : text += " + "; break;
        }
        
        switch (implementationKeyword) {
            case ABSTRACT : text += " abstract "; break;
            case FINAL : text += " final "; break;
        }
        
        text += getName();
        text += "(";
        for (int i = 0; i < properties.size(); i++) {
            text += properties.get(i).getGUIString();
            
            if (i != properties.size() - 1) {
                text += ", ";
            }
        }
        text += ")";
        
        if (getReturnType().getDataType() != JDataType.VOID) {
            text += " : " + getReturnType().getName();
        }
        
        return text;
    }
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setAccessKeyword(
            final JAccessKeyword accessKeyword) {
        this.accessKeyword = accessKeyword;
    }
    
    public final synchronized void setImplementationKeyword(
            final JImplementationKeyword implementationKeyword) {
        this.implementationKeyword = implementationKeyword;
    }

    public final synchronized void setCode(final String code) {
        this.code = code;
    }

    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized JAccessKeyword getAccessKeyword() {
        return accessKeyword;
    }

    public final synchronized JImplementationKeyword getImplementationKeyword() {
        return implementationKeyword;
    }
    
    public final synchronized String getCode() {
        return code;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

}

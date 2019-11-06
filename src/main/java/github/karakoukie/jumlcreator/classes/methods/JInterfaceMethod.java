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

import github.karakoukie.jumlcreator.data.JData;
import github.karakoukie.jumlcreator.data.JDataType;
import github.karakoukie.jumlcreator.nodes.JElementNode;
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
public class JInterfaceMethod extends JElementNode {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/

    @GuardedBy("this")
    private JData returnType;
    
    @GuardedBy("CopyOnWriteArrayList")
    protected final List<JProperty> properties;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public JInterfaceMethod() {
        this.returnType = new JData();
        this.properties = new CopyOnWriteArrayList();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/

    @Override
    public String getGUIString() {
        String text = "";
        
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

    public final synchronized void setReturnType(JData returnType) {
        this.returnType = returnType;
    }
    
    public final void addProperty(final JProperty p) {
        this.properties.add(p);
    }
    
    public final void removeProperty(final JProperty p) {
        this.properties.remove(p);
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized JData getReturnType() {
        return returnType;
    }
    
    public final List<JProperty> getProperties() {
        return Collections.unmodifiableList(properties);
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

    
    
}

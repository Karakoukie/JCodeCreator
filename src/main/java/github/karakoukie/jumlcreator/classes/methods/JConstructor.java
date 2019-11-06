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

import github.karakoukie.jumlcreator.classes.JField;
import github.karakoukie.jumlcreator.nodes.JElementNode;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @since 6 nov. 2019
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@ThreadSafe
public class JConstructor extends JElementNode {

    /* ------------------------------------------------------------------ */
    /* Fields                                                             */
    /* ------------------------------------------------------------------ */

    public final List<JProperty> properties;
    
    @GuardedBy("this")
    private String code;
    
    /* ------------------------------------------------------------------ */
    /* Constructors                                                       */
    /* ------------------------------------------------------------------ */

    public JConstructor() {
        this.properties = new CopyOnWriteArrayList();
    }
    
    /* ------------------------------------------------------------------ */
    /* Methods                                                            */
    /* ------------------------------------------------------------------ */

    public final void addProperty(final JProperty property) {
        this.properties.add(property);
    }
    
    public final void removeProperty(final JProperty property) {
        this.properties.remove(property);
    }
    
    public final String getGUIString() {        
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
        
        return text;
    }
    
    /* ------------------------------------------------------------------ */
    /* Overriden methods                                                  */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Setteurs                                                           */
    /* ------------------------------------------------------------------ */

    public final synchronized void setCode(final String code) {
        this.code = code;
    }
    
    /* ------------------------------------------------------------------ */
    /* Getteurs                                                           */
    /* ------------------------------------------------------------------ */

    public final List<JProperty> getProperties() {
        return Collections.unmodifiableList(properties);
    }
    
    public final synchronized String getCode() {
        return code;
    }
    
    /* ------------------------------------------------------------------ */
    /* Others methods                                                     */
    /* ------------------------------------------------------------------ */

}

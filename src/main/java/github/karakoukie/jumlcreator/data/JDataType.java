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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.Immutable;

/**
 *
 * @since 6 nov. 2019
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
@Immutable
public class JDataType {
    
    /* ------------------------------------------------------------------ */
    /* Static fields                                                      */
    /* ------------------------------------------------------------------ */
    
    public final static JDataType VOID = new JDataType("void", "");
    public final static JDataType BYTE = new JDataType("byte", "byt");
    public final static JDataType SHORT = new JDataType("short", "sht");
    public final static JDataType INT = new JDataType("int", "int");
    public final static JDataType FLOAT = new JDataType("float", "flt");
    public final static JDataType DOUBLE = new JDataType("float", "flt");
    public final static JDataType LONG = new JDataType("long", "lng");
    public final static JDataType BOOLEAN = new JDataType("boolean", "boo");
    public final static JDataType CHAR = new JDataType("char", "cha");
    public final static JDataType STRING = new JDataType("String", "str");
    public final static JDataType GENERIC_VALUE = new JDataType("V", "gnc");
    public final static JDataType GENERIC_TYPE = new JDataType("T", "gnc");
    public final static JDataType CLASS = new JDataType("class", "cla");
    public final static JDataType CUSTOM = new JDataType("Object", "obj");

    /* ------------------------------------------------------------------ */
    /* Fields                                                             */
    /* ------------------------------------------------------------------ */

    private final String name;
    private final String prefix;
    
    /* ------------------------------------------------------------------ */
    /* Constructors                                                       */
    /* ------------------------------------------------------------------ */

    public JDataType(final String name, final String prefix) {
        this.name = name;
        this.prefix = prefix;
    }
    
    /* ------------------------------------------------------------------ */
    /* Methods                                                            */
    /* ------------------------------------------------------------------ */

    public static final List<JDataType> getTypes() {
        final List<JDataType> types = new ArrayList();
        
        for (Field field : JDataType.class.getFields()) {
            try {
                types.add((JDataType) field.get(VOID));
            }
            catch (IllegalAccessException | IllegalArgumentException ex) {
                /* Ignore exception */
            }
        }
        
        return types;
    }
    
    public static final String[] getNames() {
        final List<JDataType> types = getTypes();
        final String[] names = new String[types.size()];
        
        for (int i = 0; i < names.length; i++) {
            names[i] = types.get(i).name;
        }
        
        return names;
    }
    
    public static final JDataType getFromName(final String name) {
        for (JDataType type : getTypes()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        
        return null;
    }
    
    /* ------------------------------------------------------------------ */
    /* Overriden methods                                                  */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Setteurs                                                           */
    /* ------------------------------------------------------------------ */

    /* ------------------------------------------------------------------ */
    /* Getteurs                                                           */
    /* ------------------------------------------------------------------ */

    public final String getName() {
        return name;
    }
    
    public final String getPrefix() {
        return prefix;
    }
    
    /* ------------------------------------------------------------------ */
    /* Others methods                                                     */
    /* ------------------------------------------------------------------ */

}

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

/**
 *
 * @author Tristan Muller (tristan.muller@cirad.fr)
 */
public enum JClassAccessibility {
    IMMUTABLE,
    THREAD_SAFE,
    NOT_THREAD_SAFE;
    
    public static final String[] getNames() {
        return new String[] {
            "Immutable",
            "TreadSafe",
            "NotThreadSafe"
        };
    }
    
    public static final JClassAccessibility getFromName(final String name) {
        switch(name) {
            case "Immutable": return IMMUTABLE;
            case "ThreadSafe": return THREAD_SAFE;
            case "NotThreadSafe": return NOT_THREAD_SAFE;
        }
        
        return null;
    }
}

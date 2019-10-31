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

import github.karakoukie.jumlcreator.elements.ImplementationKeyword;
import github.karakoukie.jumlcreator.elements.Element;
import github.karakoukie.jumlcreator.Interface;
import github.karakoukie.jumlcreator.methods.Method;
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
public final class Class extends Element {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private ClassAccessibility accessibility;
    
    @GuardedBy("this")
    private ImplementationKeyword classType;
    
    @GuardedBy("this")
    private Class extension;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<Interface> implementations;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<Field> fields;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<Method> methods;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/

    public Class() {
        super();
        this.accessibility = ClassAccessibility.NOT_THREAD_SAFE;
        this.classType = ImplementationKeyword.DEFAULT;
        this.extension = null;
        this.implementations = new CopyOnWriteArrayList();
        this.fields = new CopyOnWriteArrayList();
        this.methods = new CopyOnWriteArrayList();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setAccessibility(
            final ClassAccessibility accessibility) {
        this.accessibility = accessibility;
    }

    public final synchronized void setClassType(final ImplementationKeyword c) {
        this.classType = c;
    }

    public final synchronized void setExtension(final Class e) {
        this.extension = e;
    }
    
    public final void addImplementation(final Interface i) {
        this.implementations.add(i);
    }
    
    public final void removeImplementation(final Interface i) {
        this.implementations.remove(i);
    }
    
    public final void addField(final Field f) {
        this.fields.add(f);
    }
    
    public final void removeField(final Field f) {
        this.fields.remove(f);
    }
    
    public final void addMethod(final Method method) {
        this.methods.add(method);
    }
    
    public final void removeMethod(final Method method) {
        this.methods.remove(method);
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized ClassAccessibility getAccessibility() {
        return accessibility;
    }

    public final synchronized ImplementationKeyword getClassType() {
        return classType;
    }

    public final synchronized Class getExtension() {
        return extension;
    }

    public final List<Interface> getImplementations() {
        return Collections.unmodifiableList(implementations);
    }

    public final List<Field> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public final List<Method> getMethods() {
        return Collections.unmodifiableList(methods);
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

    
}

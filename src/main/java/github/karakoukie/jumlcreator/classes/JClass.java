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

import github.karakoukie.jumlcreator.classes.methods.JConstructor;
import github.karakoukie.jumlcreator.classes.methods.JMethod;
import github.karakoukie.jumlcreator.nodes.JChildNode;
import github.karakoukie.jumlcreator.nodes.JImplementationKeyword;
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
public final class JClass extends JChildNode {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private Package parent;
    
    @GuardedBy("this")
    private JClassConcurrencyType accessibility;
    
    @GuardedBy("this")
    private JImplementationKeyword classType;
    
    @GuardedBy("this")
    private JClass extension;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<JInterface> implementations;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<JField> fields;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<JConstructor> constructors;
    
    @GuardedBy("CopyOnWriteArrayList")
    private final List<JMethod> methods;
    
    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/

    public JClass() {
        super();
        this.parent = null;
        this.accessibility = JClassConcurrencyType.NOT_THREAD_SAFE;
        this.classType = JImplementationKeyword.EMPTY;
        this.extension = null;
        this.implementations = new CopyOnWriteArrayList();
        this.fields = new CopyOnWriteArrayList();
        this.constructors = new CopyOnWriteArrayList();
        this.methods = new CopyOnWriteArrayList();
    }
    
    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setParent(final Package parent) {
        this.parent = parent;
    }
    
    public final synchronized void setAccessibility(
            final JClassConcurrencyType accessibility) {
        this.accessibility = accessibility;
    }

    public final synchronized void setClassType(final JImplementationKeyword c) {
        this.classType = c;
    }

    public final synchronized void setExtension(final JClass e) {
        this.extension = e;
    }
    
    public final void addImplementation(final JInterface i) {
        this.implementations.add(i);
    }
    
    public final void removeImplementation(final JInterface i) {
        this.implementations.remove(i);
    }
    
    public final void addField(final JField field) {
        this.fields.add(field);
    }
    
    public final void removeField(final JField field) {
        this.fields.remove(field);
    }
    
    public final void addConstructor(final JConstructor constructor) {
        this.constructors.add(constructor);
    }
    
    public final void removeConstructor(final JConstructor constructor) {
        this.constructors.remove(constructor);
    }
    
    public final void addMethod(final JMethod method) {
        this.methods.add(method);
    }
    
    public final void removeMethod(final JMethod method) {
        this.methods.remove(method);
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized Package getParent() {
        return parent;
    }
    
    public final synchronized JClassConcurrencyType getAccessibility() {
        return accessibility;
    }

    public final synchronized JImplementationKeyword getClassType() {
        return classType;
    }

    public final synchronized JClass getExtension() {
        return extension;
    }

    public final List<JInterface> getImplementations() {
        return Collections.unmodifiableList(implementations);
    }

    public final List<JField> getFields() {
        return Collections.unmodifiableList(fields);
    }
    
    public final List<JConstructor> getConstructors() {
        return Collections.unmodifiableList(constructors);
    }

    public final List<JMethod> getMethods() {
        return Collections.unmodifiableList(methods);
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

    
}

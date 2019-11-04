/*
 * Copyright (C) 2019 Tristan Muller
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
package github.karakoukie.jumlcreator.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.annotation.GuardedBy;

/**
 *
 * @author Tristan Muller
 */
public abstract class JParentNode extends JChildNode {

    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    @GuardedBy("this")
    private List<JNode> children;

    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public JParentNode() {
        this.children = new CopyOnWriteArrayList();
    }

    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final synchronized void addChild(final JNode child) {
        this.children.add(child);
    }
    
    public final synchronized void addChildTo(final JNode child,
            final String parentName) {
        if (this.getName().equals(parentName)) {
            this.children.add(child);
        } else {
            for (JNode node : children) {
                if (node instanceof JParentNode) {
                    ((JParentNode)node).addChildTo(child, parentName);
                }
            }
        }
    }
    
    public final synchronized void removeChild(final JNode child) {
        if (children.contains(child)) {
            children.remove(child);
        } else {
            for (JNode jNode : children) {
                if (jNode instanceof JParentNode) {
                    ((JParentNode) jNode).removeChild(child);
                }
            }
        }
    }

    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/
    
    public final List<JNode> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public final JNode getHierarchicalChild(final String name) {
        for (JNode child : children) {
            if (child.getName().equals(name)) {
                return child;
            } else if (child instanceof JParentNode) {
                return ((JParentNode) child).getHierarchicalChild(name);
            }
        }
        
        return null;
    }
    
    public final List<JNode> getHierarchicalChildren(final Class<? extends JNode> type) {
        final List<JNode> list = new ArrayList();
        
        children.forEach((child) -> {
            if (type.isInstance(child)) {
                list.add(child);
            }
            
            if (child instanceof JParentNode) {
                list.addAll(((JParentNode)child).getHierarchicalChildren(type));
            }
        });
        
        return list;
    }
    
    public final List<JNode> getHierarchicalChildren() {
        final List<JNode> list = new ArrayList();
        
        list.addAll(Collections.unmodifiableList(children));
        
        children.forEach((child) -> {
            if (child instanceof JParentNode) {
                list.addAll(((JParentNode)child).getHierarchicalChildren());
            }
        });
        
        return list;
    }

    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/
    
}

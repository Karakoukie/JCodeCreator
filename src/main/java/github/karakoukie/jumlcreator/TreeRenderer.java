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
package github.karakoukie.jumlcreator;

import github.karakoukie.jumlcreator.classes.JClass;
import github.karakoukie.jumlcreator.classes.JEnum;
import github.karakoukie.jumlcreator.classes.JInterface;
import github.karakoukie.jumlcreator.packages.JPackage;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Tristan Muller
 */
public class TreeRenderer extends DefaultTreeCellRenderer {

    private final ImageIcon projectIcon;
    private final ImageIcon packageIcon;
    private final ImageIcon fileIcon;
    private final ImageIcon classIcon;
    private final ImageIcon interfaceIcon;
    private final ImageIcon enumIcon;

    public TreeRenderer() {
        this.projectIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/user-home.png"));
        this.packageIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/folder.png"));
        this.fileIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/text-x-preview.png"));
        this.classIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/text-x-generic.png"));
        this.interfaceIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/text-x-generic-template.png"));
        this.enumIcon = new javax.swing.ImageIcon(
                getClass().getResource("/icons/text-x-script.png"));
    }

    @Override
    public Component getTreeCellRendererComponent(final JTree tree,
            final Object value, final boolean selected, final boolean expanded,
            final boolean leaf, final int row, final boolean hasFocus) {
        super.getTreeCellRendererComponent(
                tree, value, selected,
                expanded, leaf, row,
                hasFocus);

        final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        
        if (node.getUserObject() instanceof JProject) {
            setIcon(projectIcon);
        } else if (node.getUserObject() instanceof JPackage) {
            setIcon(packageIcon);
        } else if (node.getUserObject() instanceof JClass) {
            setIcon(classIcon);
        } else if (node.getUserObject() instanceof JInterface) {
            setIcon(interfaceIcon);
        } else if (node.getUserObject() instanceof JEnum) {
            setIcon(enumIcon);
        } else {
            setIcon(fileIcon);
        }
        
        return this;
    }

}

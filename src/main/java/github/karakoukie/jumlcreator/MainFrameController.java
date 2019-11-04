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

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.http.annotation.ThreadSafe;

/**
 *
 * @author Tristan Muller
 */
@ThreadSafe
public class MainFrameController {
    
    /*----------------------------------------------------------------------*/
    /* FIELDS                                                               */
    /*----------------------------------------------------------------------*/
    
    private JProject project;
    private final JFileChooser chooser;

    /*----------------------------------------------------------------------*/
    /* CONSTRUCTOR                                                          */
    /*----------------------------------------------------------------------*/
    
    public MainFrameController() {
        this.project = new JProject();
        this.chooser = new JFileChooser();
        this.chooser.setMultiSelectionEnabled(false);
        this.chooser.setFileFilter(new FileNameExtensionFilter(
                "Project file (pjc)", "pjc"));
    }

    /*----------------------------------------------------------------------*/
    /* METHODS                                                              */
    /*----------------------------------------------------------------------*/
    
    public final void newProject() {
        setProject(new JProject());
    }
    
    public final void openProject(final JComponent parent) {
        final int state = chooser.showOpenDialog(parent);
        
        if (state == JFileChooser.APPROVE_OPTION) {
            final File selectedFile = chooser.getSelectedFile();
            
            // setProject(Project.load(selectedFile));
        }
    }
    
    public final void saveProject(final JComponent parent) {
        if (project != null) {
            final int state = chooser.showSaveDialog(parent);
        
            if (state == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = chooser.getSelectedFile();

                // setProject(Project.save(selectedFile));
            }
        }
    }
    
    public final void exportProject() {
        if (project != null) {
//            if (project.isAvailable()) {
//                project.export();
//            }
        }
    }
    
    /*----------------------------------------------------------------------*/
    /* SETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized void setProject(final JProject project) {
        this.project = project;
    }
    
    /*----------------------------------------------------------------------*/
    /* GETTEURS                                                             */
    /*----------------------------------------------------------------------*/

    public final synchronized JProject getProject() {
        return project;
    }
    
    /*----------------------------------------------------------------------*/
    /* OTHER METHODS                                                        */
    /*----------------------------------------------------------------------*/

}

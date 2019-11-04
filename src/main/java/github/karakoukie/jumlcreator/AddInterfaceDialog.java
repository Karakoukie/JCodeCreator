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

import java.util.function.Consumer;
import javax.swing.DefaultComboBoxModel;
import org.apache.http.annotation.GuardedBy;

/**
 *
 * @author Tristan Muller
 */
public class AddInterfaceDialog extends java.awt.Dialog {

    @GuardedBy("this")
    private Runnable onAcceptCallback;
    
    @GuardedBy("this")
    private Consumer<String> onChangeNameCallback;
    
    private boolean validName;
    
    /**
     * Creates new form CreateProjectDialog
     * @param parent
     */
    public AddInterfaceDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.onAcceptCallback = null;
        this.onChangeNameCallback = null;
        setLocationRelativeTo(parent);
        jPanelError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jDesktopPaneHeader = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jPanelPackageName = new javax.swing.JPanel();
        jLabelProjectName = new javax.swing.JLabel();
        jTextFieldProjectName = new javax.swing.JTextField();
        jPanelPackageParent = new javax.swing.JPanel();
        jLabelPackage = new javax.swing.JLabel();
        jComboBoxPackage = new javax.swing.JComboBox<>();
        jPanelProjectName1 = new javax.swing.JPanel();
        jLabelDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDesc = new javax.swing.JTextArea();
        jPanelPackageParent3 = new javax.swing.JPanel();
        jLabelExtension = new javax.swing.JLabel();
        jComboBoxExtension = new javax.swing.JComboBox<>();
        jPanelError = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelErrorMessage = new javax.swing.JLabel();
        jPanelFooter = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jButtonAccept = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(726, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                closeDialog(evt);
            }
        });

        jDesktopPaneHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREATE INTERFACE");
        jDesktopPaneHeader.add(jLabel1);

        add(jDesktopPaneHeader, java.awt.BorderLayout.NORTH);

        jPanelBody.setBorder(null);

        jLabelProjectName.setLabelFor(jLabelProjectName);
        jLabelProjectName.setText("Name :");
        jLabelProjectName.setToolTipText("");
        jLabelProjectName.setPreferredSize(new java.awt.Dimension(238, 16));
        jPanelPackageName.add(jLabelProjectName);

        jTextFieldProjectName.setPreferredSize(new java.awt.Dimension(238, 28));
        jTextFieldProjectName.addCaretListener(new javax.swing.event.CaretListener()
        {
            public void caretUpdate(javax.swing.event.CaretEvent evt)
            {
                jTextFieldProjectNameCaretUpdate(evt);
            }
        });
        jPanelPackageName.add(jTextFieldProjectName);

        jPanelBody.add(jPanelPackageName);

        jLabelPackage.setLabelFor(jComboBoxPackage);
        jLabelPackage.setText("Package :");
        jLabelPackage.setPreferredSize(new java.awt.Dimension(238, 16));
        jPanelPackageParent.add(jLabelPackage);

        jComboBoxPackage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPackage.setPreferredSize(new java.awt.Dimension(238, 26));
        jPanelPackageParent.add(jComboBoxPackage);

        jPanelBody.add(jPanelPackageParent);

        jLabelDesc.setLabelFor(jTextAreaDesc);
        jLabelDesc.setText("Description :");
        jLabelDesc.setPreferredSize(new java.awt.Dimension(238, 16));
        jPanelProjectName1.add(jLabelDesc);

        jTextAreaDesc.setColumns(20);
        jTextAreaDesc.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDesc);

        jPanelProjectName1.add(jScrollPane1);

        jPanelBody.add(jPanelProjectName1);

        jLabelExtension.setLabelFor(jComboBoxExtension);
        jLabelExtension.setText("Extended interface :");
        jLabelExtension.setPreferredSize(new java.awt.Dimension(238, 16));
        jPanelPackageParent3.add(jLabelExtension);

        jComboBoxExtension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxExtension.setPreferredSize(new java.awt.Dimension(238, 26));
        jPanelPackageParent3.add(jComboBoxExtension);

        jPanelBody.add(jPanelPackageParent3);

        jPanelError.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jPanelError.setPreferredSize(new java.awt.Dimension(478, 28));
        jPanelError.setRequestFocusEnabled(false);

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Error :");
        jPanelError.add(jLabel2);

        jLabelErrorMessage.setText("jLabel3");
        jPanelError.add(jLabelErrorMessage);

        jPanelBody.add(jPanelError);

        add(jPanelBody, java.awt.BorderLayout.CENTER);

        jPanelFooter.setBackground(new java.awt.Color(171, 181, 191));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelFooter.add(jButtonCancel);

        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAcceptActionPerformed(evt);
            }
        });
        jPanelFooter.add(jButtonAccept);

        add(jPanelFooter, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final synchronized void setOnAcceptCallback(
            final Runnable onAcceptCallback) {
        this.onAcceptCallback = onAcceptCallback;
    }

    public final synchronized void setOnChangeNameCallback(
            final Consumer<String> onChangeNameCallback) {
        this.onChangeNameCallback = onChangeNameCallback;
    }
    
    public final synchronized void setParentsNames(final String[] parents) {
        this.jComboBoxPackage.setModel(new DefaultComboBoxModel(parents));
    }
    
    public final synchronized void setInterfacesNames(final String[] interfaces) {
        this.jComboBoxExtension.setModel(new DefaultComboBoxModel(interfaces));
    }
    
    public final String getInterfaceName() {
        return jTextFieldProjectName.getText();
    }
    
    public final String getParentName() {
        return (String) jComboBoxPackage.getSelectedItem();
    }
    
    public final String getDescription() {
        return jTextAreaDesc.getText();
    }
    
    public final String getExtendedClassName() {
        return (String) jComboBoxExtension.getSelectedItem();
    }
    
    public final void setAvailableName(final boolean available) {
        this.validName = available;
        jPanelError.setVisible(!available);
        
        if (!available) {
            jLabelErrorMessage.setText("The name is not valid");
        }
    }
    
    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        closeDialog(null);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        if (jTextFieldProjectName.getText() == null || jTextFieldProjectName.getText().isEmpty()) {
            setAvailableName(false);
        }
        
        if (validName) {
            if (onAcceptCallback != null) {
                onAcceptCallback.run();
            }

            closeDialog(null);
        }
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    private void jTextFieldProjectNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldProjectNameCaretUpdate
        if (onChangeNameCallback != null) {
            onChangeNameCallback.accept(jTextFieldProjectName.getText());
        }
    }//GEN-LAST:event_jTextFieldProjectNameCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddInterfaceDialog dialog = new AddInterfaceDialog(new java.awt.Frame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox<String> jComboBoxExtension;
    private javax.swing.JComboBox<String> jComboBoxPackage;
    private javax.swing.JDesktopPane jDesktopPaneHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDesc;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JLabel jLabelExtension;
    private javax.swing.JLabel jLabelPackage;
    private javax.swing.JLabel jLabelProjectName;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelError;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelPackageName;
    private javax.swing.JPanel jPanelPackageParent;
    private javax.swing.JPanel jPanelPackageParent3;
    private javax.swing.JPanel jPanelProjectName1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDesc;
    private javax.swing.JTextField jTextFieldProjectName;
    // End of variables declaration//GEN-END:variables
}
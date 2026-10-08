package Vista;

import Modelo.Materia;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.materiaData;
import static Vista.VistaMain.wVistaMateriaAgregar;
import static Vista.VistaMain.wVistaMateriaModificar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaMateria extends javax.swing.JInternalFrame {

    private Materia elementSelected = null;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaMateria() {
        initComponents();
        jTable = jtTablaAlumnos;

        updateTable();

        jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);
        jTable.putClientProperty("JTable.showInactiveSelection", true);
        jTable.getSelectionModel().addListSelectionListener(
                new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int selection = jTable.getSelectedRow();
                    if (selection != -1) {
                        indexSelected = selection;
                        elementSelected = materiaData.getById((int) jTable.getValueAt(selection, 0));
                    }
                }
            }
        }
        );
    }

    public void selectTable(int row) {
        if (jTable.getRowCount() == 0) {
            return;
        }

        if (row == -1) {
            int lastRow = jTable.getRowCount() - 1;
            jTable.setRowSelectionInterval(lastRow, lastRow);
            return;
        }

        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (Integer.parseInt(jTable.getValueAt(i, 0).toString()) == row) {
                jTable.setRowSelectionInterval(i, i);
                jTable.scrollRectToVisible(jTable.getCellRect(i, 0, true));
                break;
            }
        }
    }
    
    public void updateTable() {
        DefaultTableModel table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.addColumn("Id");
        table.addColumn("Nombre");
        table.addColumn("Estado");
        jTable.setModel(table);

        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(100);

        for (Materia m : materiaData.getList()) {
            table.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getEstado()});
        }

        jTable.setModel(table);

        if (elementSelected != null) {
            selectTable(elementSelected.getIdMateria());
        }

        updateButtons();
    }

    public void updateButtons() {
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnAlta.setEnabled(false);
        btnBaja.setEnabled(false);
        
        if (jTable.getRowCount() > 0 && elementSelected != null) {
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
            if (elementSelected.getEstado()>1) {btnBaja.setEnabled(true);}
            if (elementSelected.getEstado()<4) {btnAlta.setEnabled(true);}
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblListaAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaAlumnos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        lblListaAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblListaAlumnos.setText("Lista de Materias:");

        jtTablaAlumnos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTablaAlumnos.setToolTipText("");
        jtTablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaAlumnos);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnBorrar.setText("Eliminar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(this::btnBorrarActionPerformed);

        btnAlta.setText("Alta");
        btnAlta.setEnabled(false);
        btnAlta.addActionListener(this::btnAltaActionPerformed);

        btnBaja.setText("Baja");
        btnBaja.setEnabled(false);
        btnBaja.addActionListener(this::btnBajaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblListaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaAlumnosMouseClicked
        updateButtons();
    }//GEN-LAST:event_jtTablaAlumnosMouseClicked

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        elementSelected.setEstado(elementSelected.getEstado()-1);
        materiaData.update(elementSelected);
        updateTable();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (elementSelected.getIdMateria() == wVistaMateriaModificar.materiaSelected.getIdMateria()) {wVistaMateriaModificar.hide();}
        materiaData.remove(elementSelected.getIdMateria());
        updateTable();

        int rowCount = jTable.getRowCount();
        if (rowCount > 0) {
            int newIndex = Math.min(indexSelected, rowCount - 1);
            jTable.setRowSelectionInterval(newIndex, newIndex);
            int idMateria = (int) jTable.getValueAt(newIndex, 0);
            elementSelected = materiaData.getById(idMateria);
        } else {
            elementSelected = null;
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        wVistaMateriaAgregar.setLocation(
                this.getX() + ((this.getWidth() - wVistaMateriaAgregar.getWidth()) / 2),
                this.getY() + ((this.getHeight() - wVistaMateriaAgregar.getHeight()) / 2)
        );
        wVistaMateriaAgregar.resetAll();
        wVistaMateriaAgregar.show();
        desktopMain.moveToFront(wVistaMateriaAgregar);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        wVistaMateriaModificar.setLocation(
                this.getX() + ((this.getWidth() - wVistaMateriaModificar.getWidth()) / 2),
                this.getY() + ((this.getHeight() - wVistaMateriaModificar.getHeight()) / 2)
        );
        wVistaMateriaModificar.materiaSelected = elementSelected;
        wVistaMateriaModificar.resetAll();
        wVistaMateriaModificar.show();
        desktopMain.moveToFront(wVistaMateriaModificar);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        elementSelected.setEstado(elementSelected.getEstado()+1);
        materiaData.update(elementSelected);
        updateTable();
    }//GEN-LAST:event_btnAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTablaAlumnos;
    private javax.swing.JLabel lblListaAlumnos;
    // End of variables declaration//GEN-END:variables
}

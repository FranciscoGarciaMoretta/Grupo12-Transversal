package Vista;

import Modelo.Alumno;
import static Vista.VistaMain.alumnData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.wVistaAlumno;
import static Vista.VistaMain.wVistaAlumnoAgregar;
import static Vista.VistaMain.wVistaAlumnoModificar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaAlumno extends javax.swing.JInternalFrame {

    private Alumno elementSelected = null;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaAlumno() {
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
                        elementSelected = alumnData.getById((int) jTable.getValueAt(selection, 0));
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
        table.addColumn("Dni");
        table.addColumn("Nombre");
        table.addColumn("Fecha de Nacimiento");
        table.addColumn("Activo");
        jTable.setModel(table);

        jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(80);

        for (Alumno a : alumnData.getList()) {
            String activo = "Inactivo";
            if (a.getActivo()) {
                activo = "Activo";
            }
            table.addRow(new Object[]{a.getIdAlumno(), a.getDni(), a.getNombre(), a.getFecNac(), activo});
        }

        jTable.setModel(table);

        if (elementSelected != null) {
            selectTable(elementSelected.getIdAlumno());
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
            btnAlta.setEnabled(!elementSelected.getActivo());
            btnBaja.setEnabled(elementSelected.getActivo());
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
        lblListaAlumnos.setText("Lista de Alumnos:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
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

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        elementSelected.setActivo(true);
        alumnData.update(elementSelected);
        updateTable();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        elementSelected.setActivo(false);
        alumnData.update(elementSelected);
        updateTable();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (elementSelected.getIdAlumno() == wVistaAlumno.elementSelected.getIdAlumno()) {wVistaAlumnoModificar.hide();}
        alumnData.remove(elementSelected.getIdAlumno());
        updateTable();

        int rowCount = jTable.getRowCount();
        if (rowCount > 0) {
            int newIndex = Math.min(indexSelected, rowCount - 1);
            jTable.setRowSelectionInterval(newIndex, newIndex);
            int idAlumno = (int) jTable.getValueAt(newIndex, 0);
            elementSelected = alumnData.getById(idAlumno);
        } else {
            elementSelected = null;
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        wVistaAlumnoAgregar.setLocation(
                this.getX() + ((this.getWidth() - wVistaAlumnoAgregar.getWidth()) / 2),
                this.getY() + ((this.getHeight() - wVistaAlumnoAgregar.getHeight()) / 2)
        );
        wVistaAlumnoAgregar.resetAll();
        wVistaAlumnoAgregar.show();
        desktopMain.moveToFront(wVistaAlumnoAgregar);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        wVistaAlumnoModificar.setLocation(
                this.getX() + ((this.getWidth() - wVistaAlumnoModificar.getWidth()) / 2),
                this.getY() + ((this.getHeight() - wVistaAlumnoModificar.getHeight()) / 2)
        );
        wVistaAlumnoModificar.alumnSelected = elementSelected;
        wVistaAlumnoModificar.resetAll();
        wVistaAlumnoModificar.show();
        desktopMain.moveToFront(wVistaAlumnoModificar);
    }//GEN-LAST:event_btnModificarActionPerformed


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

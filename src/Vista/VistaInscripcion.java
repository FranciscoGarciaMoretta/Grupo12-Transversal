package Vista;

import Modelo.Alumno;
import static Vista.VistaMain.alumnData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.wVistaAlumno;
import static Vista.VistaMain.wVistaAlumnoAgregar;
import static Vista.VistaMain.wVistaAlumnoModificar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaInscripcion extends javax.swing.JInternalFrame {

    private Alumno elementSelected = null;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaInscripcion() {
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
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblListaAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaAlumnos = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbAlumno = new javax.swing.JComboBox<>();
        jrbNoInscripto = new javax.swing.JRadioButton();
        jrbInscripto = new javax.swing.JRadioButton();
        btnBaja1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        lblListaAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblListaAlumnos.setText("Inscripciones a Materias:");

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

        btnBorrar.setText("Cerrar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(this::btnBorrarActionPerformed);

        btnBaja.setText("Eliminar inscripción");
        btnBaja.setEnabled(false);
        btnBaja.addActionListener(this::btnBajaActionPerformed);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jrbNoInscripto.setText("No inscriptas");

        jrbInscripto.setText("Inscriptas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cmbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbInscripto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbNoInscripto)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbNoInscripto)
                    .addComponent(jrbInscripto)))
        );

        btnBaja1.setText("Inscribir");
        btnBaja1.setEnabled(false);
        btnBaja1.addActionListener(this::btnBaja1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnBaja)
                    .addComponent(btnBaja1))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaAlumnosMouseClicked
        updateButtons();
    }//GEN-LAST:event_jtTablaAlumnosMouseClicked

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        elementSelected.setActivo(false);
        alumnData.update(elementSelected);
        updateTable();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (wVistaAlumnoModificar.alumnSelected != null && elementSelected.getIdAlumno() == wVistaAlumnoModificar.alumnSelected.getIdAlumno()) {wVistaAlumnoModificar.hide();}
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

    private void btnBaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaja1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaja1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBaja1;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<Alumno> cmbAlumno;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    private javax.swing.JTable jtTablaAlumnos;
    private javax.swing.JLabel lblListaAlumnos;
    // End of variables declaration//GEN-END:variables
}

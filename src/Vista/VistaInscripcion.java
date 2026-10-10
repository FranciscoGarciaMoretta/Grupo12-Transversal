package Vista;

import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;
import static Vista.VistaMain.alumnData;
import static Vista.VistaMain.cursadaData;
import static Vista.VistaMain.materiaData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.wVistaMateria;
import static Vista.VistaMain.wVistaMateriaAgregar;
import static Vista.VistaMain.wVistaMateriaModificar;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaInscripcion extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    
    private Alumno alumnSelected = null;
    private Materia materiaSelected = null;
    private boolean cInscription = false;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaInscripcion() {
        initComponents();
        jTable = jtTablaMaterias;

        updateAll();

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
                        int idMateria = 0;
                        String nameMateria = (String)jTable.getValueAt(selection, 0);
                        ArrayList<Materia> listMateria = materiaData.getList();
                        for (Materia materia : listMateria) {
                            if (materia.getNombre().equals(nameMateria)) {
                                idMateria = materia.getIdMateria();
                            }
                        }
                        if (idMateria>0) {materiaSelected = materiaData.getById(idMateria);}
                    }
                }
            }
        }
        );
    }

    public void selectTable(int idMateria) {
        if (jTable.getRowCount() == 0) {
            return;
        }
        if (idMateria != -1) {
            ArrayList<Materia> listaMaterias = materiaData.getList();

            for (int i = 0; i < jTable.getRowCount(); i++) {
                String nombreMateria = jTable.getValueAt(i, 0).toString();

                for (Materia materia : listaMaterias) {
                    if (materia.getNombre().equals(nombreMateria) && materia.getIdMateria() == idMateria) {
                        jTable.setRowSelectionInterval(i, i);
                        jTable.scrollRectToVisible(
                        jTable.getCellRect(i, 0, true)
                        );
                        return;
                    }
                }
            }
        }else if (indexSelected > 0){
            int selected = indexSelected-1;
            jTable.setRowSelectionInterval(selected, selected);
        }else if (indexSelected >= 0){
            jTable.setRowSelectionInterval(0, 0);
        }
    }
    
    public ArrayList<Materia> searchMaterias(boolean inscriptas) {
        ArrayList<Materia> devolverMaterias = materiaData.getList();
        ArrayList<Materia> encontrarMaterias = new ArrayList<>();
        if (alumnSelected != null) {
            for (Materia m : materiaData.getList()) {
                for (Cursada c : cursadaData.getList()) {
                    if (c.getIdAlumno() == alumnSelected.getIdAlumno()) {
                        if (m.getIdMateria() == c.getIdMateria()) {
                            if (!encontrarMaterias.contains(m)) {encontrarMaterias.add(m);}
                        }
                    }
                }
            }
        }
        if (inscriptas) {
            devolverMaterias = encontrarMaterias;
        }else{
            devolverMaterias.removeIf(m -> encontrarMaterias.stream().anyMatch(e -> e.getIdMateria() == m.getIdMateria()));
        }
        
        if (materiaSelected != null) {
            boolean esta = false;
            for (Materia m : devolverMaterias) {
                if (m.getNombre().equals(materiaSelected.getNombre())) {
                    esta = true;
                }
            }
            if (!esta) {
                materiaSelected = null;
            }
        }
        
        return devolverMaterias;
    }
    
    public void updateAll() {
        //JCOMBOX
        cmbAlumno.removeAllItems();
        if (cmbAlumno.getItemCount() == 0) {
            for (Alumno alumno : alumnData.getList()) {
                cmbAlumno.addItem(alumno.getNombre());
            }
            if (alumnSelected != null) {
                cmbAlumno.setSelectedItem(alumnSelected.getNombre());
            }
        }
        
        ArrayList<Materia> materiaMostrar = new ArrayList<>();
        
        //CHEECK
        if (cInscription) {
            materiaMostrar = searchMaterias(true);
            jrbInscripto.setSelected(true);
            jrbNoInscripto.setSelected(false);
            if (alumnSelected != null && materiaSelected != null) {btnEliminarInscrip.setEnabled(true);}else{btnEliminarInscrip.setEnabled(false);}
            btnInscribir.setEnabled(false);
        }else{
            materiaMostrar = searchMaterias(false);
            jrbInscripto.setSelected(false);
            jrbNoInscripto.setSelected(true);
            btnEliminarInscrip.setEnabled(false);
            if (alumnSelected != null && materiaSelected != null) {btnInscribir.setEnabled(true);}else{btnInscribir.setEnabled(false);}
        }
        
        //TABLE
        DefaultTableModel table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table.addColumn("Materias:");
        jTable.setModel(table);

        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(0).setCellRenderer(renderer);

        for (Materia m : materiaMostrar) {
            table.addRow(new Object[]{m.getNombre()});
        }
        
        jTable.setModel(table);

        if (materiaSelected != null) {
            selectTable(materiaSelected.getIdMateria());
        }else{
            selectTable(-1);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblListaAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaMaterias = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnEliminarInscrip = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbAlumno = new javax.swing.JComboBox<>();
        jrbNoInscripto = new javax.swing.JRadioButton();
        jrbInscripto = new javax.swing.JRadioButton();
        btnInscribir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        lblListaAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblListaAlumnos.setText("Inscripciones a Materias:");

        jtTablaMaterias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTablaMaterias.setToolTipText("");
        jtTablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaMaterias);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        btnEliminarInscrip.setText("Eliminar inscripción");
        btnEliminarInscrip.addActionListener(this::btnEliminarInscripActionPerformed);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbAlumno.addActionListener(this::cmbAlumnoActionPerformed);

        jrbNoInscripto.setText("No inscriptas");
        jrbNoInscripto.addActionListener(this::jrbNoInscriptoActionPerformed);

        jrbInscripto.setText("Inscriptas");
        jrbInscripto.addActionListener(this::jrbInscriptoActionPerformed);

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
            .addComponent(cmbAlumno)
            .addComponent(jrbInscripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jrbNoInscripto))
        );

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(this::btnInscribirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEliminarInscrip)
                    .addComponent(btnInscribir))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMateriasMouseClicked
        updateAll();
    }//GEN-LAST:event_jtTablaMateriasMouseClicked

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        Cursada c = new Cursada(0,alumnSelected.getIdAlumno(),materiaSelected.getIdMateria(),0,0,0);
        cursadaData.insert(c);
        indexSelected = jTable.getSelectedRow();
        updateAll();
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnEliminarInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInscripActionPerformed
        int id = 0;
        for (Cursada c : cursadaData.getList()) {
            if (c.getIdAlumno() == alumnSelected.getIdAlumno() && c.getIdMateria() == materiaSelected.getIdMateria()) {
                id = c.getIdCursada();
            }
        }
        if (id > 0) {
            cursadaData.remove(id);
            indexSelected = jTable.getSelectedRow();
            updateAll();
        }
    }//GEN-LAST:event_btnEliminarInscripActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlumnoActionPerformed
        if (cmbAlumno.getSelectedItem() != null) {
            Alumno alumn;
            String name = cmbAlumno.getSelectedItem().toString();
            for (Alumno alumno : alumnData.getList()) {
                if (alumno.getNombre().equals(name)) {
                    alumnSelected = alumno;
                }
            }
        }
        updateAll();
    }//GEN-LAST:event_cmbAlumnoActionPerformed

    private void jrbInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInscriptoActionPerformed
        cInscription = true;
        updateAll();
    }//GEN-LAST:event_jrbInscriptoActionPerformed

    private void jrbNoInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNoInscriptoActionPerformed
        cInscription = false;
        updateAll();
    }//GEN-LAST:event_jrbNoInscriptoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminarInscrip;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<String> cmbAlumno;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    private javax.swing.JTable jtTablaMaterias;
    private javax.swing.JLabel lblListaAlumnos;
    // End of variables declaration//GEN-END:variables
}

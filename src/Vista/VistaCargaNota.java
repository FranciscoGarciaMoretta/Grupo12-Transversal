package Vista;

import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;
import static Vista.VistaMain.alumnData;
import static Vista.VistaMain.cursadaData;
import static Vista.VistaMain.materiaData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.wVistaCargaNotaModificar;
import static Vista.VistaMain.wVistaMateria;
import static Vista.VistaMain.wVistaMateriaAgregar;
import static Vista.VistaMain.wVistaMateriaModificar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaCargaNota extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    
    public Alumno alumnSelected = null;
    public Materia materiaSelected = null;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaCargaNota() {
        initComponents();
        jTable = tblTablaMaterias;

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
                        String nameMateria = (String)jTable.getValueAt(selection, 0);
                        for (Materia materia : materiaData.getList()) {
                            if (materia.getNombre().equals(nameMateria)) {
                                materiaSelected = materia;
                            }
                        }
                    }
                }
            }
        }
        );
    }

    public void selectTable(int idMateria) {
        int rowCount = jTable.getRowCount();
        if (rowCount == 0) {
            materiaSelected = null;
            indexSelected = -1;
            return;
        }
        if (idMateria != -1) {
            for (int i = 0; i < rowCount; i++) {
                String nombre = jTable.getValueAt(i, 0).toString();

                for (Materia m : materiaData.getList()) {
                    if (m.getIdMateria() == idMateria
                            && m.getNombre().equals(nombre)) {
                        jTable.setRowSelectionInterval(i, i);
                        jTable.scrollRectToVisible(
                            jTable.getCellRect(i, 0, true)
                        );
                        indexSelected = i;
                        materiaSelected = m;
                        return;
                    }
                }
            }
        }
        int selected = Math.max(0, Math.min(indexSelected, rowCount - 1));
        jTable.setRowSelectionInterval(selected, selected);
        indexSelected = selected;
        String nombre = jTable.getValueAt(selected, 0).toString();
        for (Materia m : materiaData.getList()) {
            if (m.getNombre().equals(nombre)) {
                materiaSelected = m;
                break;
            }
        }
    }
    
    public ArrayList<Cursada> searchMaterias() {
        ArrayList<Cursada> devolverMaterias = new ArrayList<>();
        
        if (alumnSelected != null) {
            for (Materia m : materiaData.getList()) {
                for (Cursada c : cursadaData.getList()) {
                    if (c.getIdAlumno() == alumnSelected.getIdAlumno()) {
                        if (m.getIdMateria() == c.getIdMateria()) {
                            if (!devolverMaterias.contains(c)) {devolverMaterias.add(c);}
                        }
                    }
                }
            }
        }
        
        if (materiaSelected != null) {
            boolean esta = false;
            for (Cursada c : devolverMaterias) {
                if (c.getIdAlumno() == alumnSelected.getIdAlumno() && c.getIdMateria() == materiaSelected.getIdMateria()) {
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
        
        ArrayList<Cursada> materiaMostrar = new ArrayList<>();
        
        //CHEECK
        materiaMostrar = searchMaterias();
        if (alumnSelected != null && materiaSelected != null) {btnCargarNota.setEnabled(true);}else{btnCargarNota.setEnabled(false);}
        
        //TABLE
        DefaultTableModel table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table.addColumn("Materia:");
        table.addColumn("Nota:");
        jTable.setModel(table);

        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(1).setCellRenderer(renderer);
        
        for (Cursada c : materiaMostrar) {
            String mName = "";
            for (Materia m : materiaData.getList()) {
                if (m.getIdMateria() == c.getIdMateria()) {
                    mName = m.getNombre();
                }
            }
            String mostrar = String.valueOf(c.getNota());
            if (c.getNota() <= 0) {mostrar = "Sin nota";}
            table.addRow(new Object[]{mName, mostrar});
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

        lblTitulo = new javax.swing.JLabel();
        pnlAlumnos = new javax.swing.JPanel();
        cmbAlumno = new javax.swing.JComboBox<>();
        scpMaterias = new javax.swing.JScrollPane();
        tblTablaMaterias = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnCargarNota = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("SGULP: Cargar nota");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Cargar Nota:");

        pnlAlumnos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbAlumno.addActionListener(this::cmbAlumnoActionPerformed);

        javax.swing.GroupLayout pnlAlumnosLayout = new javax.swing.GroupLayout(pnlAlumnos);
        pnlAlumnos.setLayout(pnlAlumnosLayout);
        pnlAlumnosLayout.setHorizontalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlAlumnosLayout.setVerticalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbAlumno)
        );

        tblTablaMaterias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTablaMaterias.setToolTipText("");
        tblTablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMateriasMouseClicked(evt);
            }
        });
        scpMaterias.setViewportView(tblTablaMaterias);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        btnCargarNota.setText("Cargar Nota");
        btnCargarNota.addActionListener(this::btnCargarNotaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarNota, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpMaterias)
                    .addComponent(pnlAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnCargarNota))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMateriasMouseClicked
        updateAll();
    }//GEN-LAST:event_tblTablaMateriasMouseClicked

    private void btnCargarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarNotaActionPerformed
        wVistaCargaNotaModificar.setLocation(
                this.getX() + ((this.getWidth() - wVistaCargaNotaModificar.getWidth()) / 2),
                this.getY() + ((this.getHeight() - wVistaCargaNotaModificar.getHeight()) / 2)
        );
        wVistaCargaNotaModificar.alumnSelected = alumnSelected;
         wVistaCargaNotaModificar.materiaSelected = materiaSelected;
        wVistaCargaNotaModificar.resetAll();
        wVistaCargaNotaModificar.show();
        desktopMain.moveToFront(wVistaCargaNotaModificar);
    }//GEN-LAST:event_btnCargarNotaActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarNota;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbAlumno;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAlumnos;
    private javax.swing.JScrollPane scpMaterias;
    private javax.swing.JTable tblTablaMaterias;
    // End of variables declaration//GEN-END:variables
}

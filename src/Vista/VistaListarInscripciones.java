package Vista;

import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;
import static Vista.VistaMain.alumnData;
import static Vista.VistaMain.cursadaData;
import static Vista.VistaMain.materiaData;
import static Vista.VistaMain.desktopMain;
import static Vista.VistaMain.wVistaCargaNota;
import static Vista.VistaMain.wVistaInscripcionAgregar;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaListarInscripciones extends javax.swing.JInternalFrame {

    javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer();
    
    private Alumno alumnSelected = null;
    private int indexSelected = 0;
    private JTable jTable;

    public VistaListarInscripciones() {
        initComponents();
        jTable = tblTablaMaterias;

        updateAll();

        jTable.setShowHorizontalLines(true);
        jTable.setShowVerticalLines(true);
        jTable.putClientProperty("JTable.showInactiveSelection", true);
    }
    
    public void cmbSelection() {
        if (cmbAlumno.getSelectedItem() != null) {
            Alumno alumn;
            String name = cmbAlumno.getSelectedItem().toString();
            for (Alumno alumno : alumnData.getList()) {
                if (alumno.getNombre().equals(name)) {
                    alumnSelected = alumno;
                }
            }
        }
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
        cmbSelection();
        
        //TABLE
        DefaultTableModel table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table.addColumn("Materia");
        table.addColumn("Cursada");
        table.addColumn("Nota");
        jTable.setModel(table);

        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(2).setCellRenderer(renderer);

        if (alumnSelected != null) {
            for (Cursada c : cursadaData.getList()) {
                String materia = "";
                for (Materia m : materiaData.getList()) {
                    if (c.getIdMateria() == m.getIdMateria()) {
                        materia = m.getNombre();
                    }
                }
                String nota = String.valueOf(c.getNota());
                if (c.getNota() <= 0) {nota = "Sin nota";}
                if (alumnSelected.getIdAlumno() == c.getIdAlumno()) {
                    table.addRow(new Object[]{materia,c.getCursa(),nota});
                }
            }
        }
        
        jTable.setModel(table);
        
        if (wVistaCargaNota != null) {wVistaCargaNota.updateAll();}
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

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("SGULP: Lista de inscripciones");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Inscripciones:");

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
        tblTablaMaterias.setEnabled(false);
        tblTablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMateriasMouseClicked(evt);
            }
        });
        scpMaterias.setViewportView(tblTablaMaterias);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scpMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(pnlAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnCerrar)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMateriasMouseClicked
        updateAll();
    }//GEN-LAST:event_tblTablaMateriasMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlumnoActionPerformed
        cmbSelection();
        updateAll();
    }//GEN-LAST:event_cmbAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbAlumno;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAlumnos;
    private javax.swing.JScrollPane scpMaterias;
    private javax.swing.JTable tblTablaMaterias;
    // End of variables declaration//GEN-END:variables
}

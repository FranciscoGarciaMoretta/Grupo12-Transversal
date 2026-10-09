package Vista;

import Modelo.Alumno;
import Modelo.Materia;
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
    private int indexSelected = 0;
    private JTable jTable;

    public VistaInscripcion() {
        initComponents();
        jTable = jtTablaMaterias;

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

        table.addColumn("Materias:");
        jTable.setModel(table);

        renderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(0).setCellRenderer(renderer);

        for (Materia m : materiaData.getList()) {
            table.addRow(new Object[]{m.getNombre()});
        }
        
        jTable.setModel(table);

        if (materiaSelected != null) {
            selectTable(materiaSelected.getIdMateria());
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
        btnCerrar.setEnabled(false);

        btnEliminarInscrip.setText("Eliminar inscripción");
        btnEliminarInscrip.setEnabled(false);

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
            .addComponent(cmbAlumno)
            .addComponent(jrbInscripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jrbNoInscripto))
        );

        btnInscribir.setText("Inscribir");
        btnInscribir.setEnabled(false);

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
        updateButtons();
    }//GEN-LAST:event_jtTablaMateriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminarInscrip;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<Alumno> cmbAlumno;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    private javax.swing.JTable jtTablaMaterias;
    private javax.swing.JLabel lblListaAlumnos;
    // End of variables declaration//GEN-END:variables
}

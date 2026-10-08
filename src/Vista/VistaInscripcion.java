package Vista;

import Modelo.Alumno;
import Modelo.Cursada;
import Persistencia.AlumnoData;
import Persistencia.MateriaData;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaInscripcion extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private AlumnoData alumnos = new AlumnoData();
    private MateriaData materias = new MateriaData();
    private JTable jTable;

    public VistaInscripcion() {
        initComponents();
        armarTabla();
        cargarAlumnos();
    }

     public void armarTabla() {
        DefaultTableModel table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.addColumn("");
        table.addColumn("");
        table.addColumn("");
        jTable.setModel(table);

        jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(100);

//        for (Cursada m : materiaData.getList()) {
//            table.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getEstado()});
//        }
//
//        jTable.setModel(table);
//
//        if (elementSelected != null) {
//            selectTable(elementSelected.getIdMateria());
//        }
//
//        updateButtons();
    }
    
    public void cargarAlumnos() {
        if (!alumnos.getList().isEmpty()) {
            for (Alumno aux : alumnos.getList()) {
                cmbAlumno.addItem(aux);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgInscriptas = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        separatorTitulo = new javax.swing.JSeparator();
        scpAlumnos = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnInscribir = new javax.swing.JButton();
        btnBorrarInscripción = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pnlAlumnos = new javax.swing.JPanel();
        lblAlumno = new javax.swing.JLabel();
        jrbInscripto = new javax.swing.JRadioButton();
        jrbNoInscripto = new javax.swing.JRadioButton();
        cmbAlumno = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("Inscripciones a Materias");

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        scpAlumnos.setViewportView(tblAlumnos);

        btnInscribir.setForeground(new java.awt.Color(0, 204, 0));
        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(this::btnInscribirActionPerformed);

        btnBorrarInscripción.setForeground(new java.awt.Color(204, 0, 0));
        btnBorrarInscripción.setText("Eliminar inscripción");
        btnBorrarInscripción.addActionListener(this::btnBorrarInscripciónActionPerformed);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        lblAlumno.setText("Alumno:");

        bgInscriptas.add(jrbInscripto);
        jrbInscripto.setText("Inscriptas");

        bgInscriptas.add(jrbNoInscripto);
        jrbNoInscripto.setText("No inscriptas");

        javax.swing.GroupLayout pnlAlumnosLayout = new javax.swing.GroupLayout(pnlAlumnos);
        pnlAlumnos.setLayout(pnlAlumnosLayout);
        pnlAlumnosLayout.setHorizontalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbInscripto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbNoInscripto)
                .addContainerGap())
        );
        pnlAlumnosLayout.setVerticalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlumno)
                    .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbInscripto)
                    .addComponent(jrbNoInscripto))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrarInscripción)
                .addGap(18, 18, 18)
                .addComponent(btnInscribir)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(separatorTitulo)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pnlAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(scpAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separatorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnBorrarInscripción)
                    .addComponent(btnCerrar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        if (cmbAlumno.getSelectedItem() == null) {
            return;
        }
        
        
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnBorrarInscripciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarInscripciónActionPerformed
        
    }//GEN-LAST:event_btnBorrarInscripciónActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgInscriptas;
    private javax.swing.JButton btnBorrarInscripción;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<Alumno> cmbAlumno;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAlumnos;
    private javax.swing.JScrollPane scpAlumnos;
    private javax.swing.JSeparator separatorTitulo;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables
}

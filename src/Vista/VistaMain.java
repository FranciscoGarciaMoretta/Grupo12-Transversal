package Vista;

import Persistencia.AlumnoData;
import Persistencia.CursadaData;
import Persistencia.MateriaData;
import javax.swing.JDesktopPane;

public class VistaMain extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaMain.class.getName());
    
    public static AlumnoData alumnData = new AlumnoData();
    public static MateriaData materiaData = new MateriaData();
    public static CursadaData cursadaData = new CursadaData();
    
    public static JDesktopPane desktopMain;
    
    public static VistaAlumno wVistaAlumno = new VistaAlumno();
    public static VistaAlumnoAgregar wVistaAlumnoAgregar = new VistaAlumnoAgregar();
    public static VistaAlumnoModificar wVistaAlumnoModificar = new VistaAlumnoModificar();
    
    public static VistaMateria wVistaMateria = new VistaMateria();
    public static VistaMateriaAgregar wVistaMateriaAgregar = new VistaMateriaAgregar();
    public static VistaMateriaModificar wVistaMateriaModificar = new VistaMateriaModificar();
    
    public static VistaInscripcion wVistaInscripcion = new VistaInscripcion();
    public static VistaInscripcionAgregar wVistaInscripcionAgregar = new VistaInscripcionAgregar();
    
    public static VistaCargaNota wVistaCargaNota = new VistaCargaNota();
    public static VistaCargaNotaModificar wVistaCargaNotaModificar = new VistaCargaNotaModificar();
    
    public static VistaListarInscripciones wVistaListarInscripciones = new VistaListarInscripciones();
    
    public VistaMain() {
        initComponents();
        desktopMain = jDesktopPane1; 
        desktopMain.add(wVistaAlumno); wVistaAlumno.hide();
        desktopMain.add(wVistaAlumnoAgregar); wVistaAlumnoAgregar.hide();
        desktopMain.add(wVistaAlumnoModificar); wVistaAlumnoModificar.hide();
        desktopMain.add(wVistaMateria); wVistaMateria.hide();
        desktopMain.add(wVistaMateriaAgregar); wVistaMateriaAgregar.hide();
        desktopMain.add(wVistaMateriaModificar); wVistaMateriaModificar.hide();
        desktopMain.add(wVistaInscripcion); wVistaInscripcion.hide();
        desktopMain.add(wVistaInscripcionAgregar); wVistaInscripcionAgregar.hide();
        desktopMain.add(wVistaCargaNota); wVistaCargaNota.hide();
        desktopMain.add(wVistaCargaNotaModificar); wVistaCargaNotaModificar.hide();
        desktopMain.add(wVistaListarInscripciones); wVistaListarInscripciones.hide();
        try {
            java.awt.Image logo = java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/logo.png"));
            this.setIconImage(logo);
        } catch (Exception e) {}
    }
    
    public static void updateAllTables() {
        if (wVistaAlumno != null) {wVistaAlumno.updateTable();}
        if (wVistaMateria != null) {wVistaMateria.updateTable();}
        if (wVistaInscripcion != null) {wVistaInscripcion.updateAll();}
        if (wVistaCargaNota != null) {wVistaCargaNota.updateAll();}
        if (wVistaListarInscripciones != null) {wVistaListarInscripciones.updateAll();}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        mnbNavegador = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitSalir = new javax.swing.JMenuItem();
        mnuAlumno = new javax.swing.JMenu();
        mitListaAlumnos = new javax.swing.JMenuItem();
        mnuMateria = new javax.swing.JMenu();
        mitListaMaterias = new javax.swing.JMenuItem();
        mnuInscripciones = new javax.swing.JMenu();
        mitInscribirMaterias = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuNotas = new javax.swing.JMenu();
        mitCargarNotas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGULP");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        mnuArchivo.setText("Archivo");

        mitSalir.setText("Salir");
        mitSalir.addActionListener(this::mitSalirActionPerformed);
        mnuArchivo.add(mitSalir);

        mnbNavegador.add(mnuArchivo);

        mnuAlumno.setText("Alumno");
        mnuAlumno.addActionListener(this::mnuAlumnoActionPerformed);

        mitListaAlumnos.setText("Lista de alumnos");
        mitListaAlumnos.addActionListener(this::mitListaAlumnosActionPerformed);
        mnuAlumno.add(mitListaAlumnos);

        mnbNavegador.add(mnuAlumno);

        mnuMateria.setText("Materia");

        mitListaMaterias.setText("Lista de materias");
        mitListaMaterias.addActionListener(this::mitListaMateriasActionPerformed);
        mnuMateria.add(mitListaMaterias);

        mnbNavegador.add(mnuMateria);

        mnuInscripciones.setText("Inscripciones");

        mitInscribirMaterias.setText("Inscripción a materias");
        mitInscribirMaterias.addActionListener(this::mitInscribirMateriasActionPerformed);
        mnuInscripciones.add(mitInscribirMaterias);

        jMenuItem1.setText("Listar Inscripciones");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        mnuInscripciones.add(jMenuItem1);

        mnbNavegador.add(mnuInscripciones);

        mnuNotas.setText("Notas");

        mitCargarNotas.setText("Cargar notas");
        mitCargarNotas.addActionListener(this::mitCargarNotasActionPerformed);
        mnuNotas.add(mitCargarNotas);

        mnbNavegador.add(mnuNotas);

        setJMenuBar(mnbNavegador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlumnoActionPerformed
    }//GEN-LAST:event_mnuAlumnoActionPerformed

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Confirmación de salida", javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mitSalirActionPerformed

    private void mitListaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListaAlumnosActionPerformed
        wVistaAlumno.setLocation(50,0);
        wVistaAlumno.show();
        desktopMain.moveToFront(wVistaAlumno);
    }//GEN-LAST:event_mitListaAlumnosActionPerformed

    private void mitListaMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListaMateriasActionPerformed
        wVistaMateria.setLocation(100,0);
        wVistaMateria.show();
        desktopMain.moveToFront(wVistaMateria);
    }//GEN-LAST:event_mitListaMateriasActionPerformed

    private void mitInscribirMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitInscribirMateriasActionPerformed
        wVistaInscripcion.setLocation(150,0);
        wVistaInscripcion.show();
        desktopMain.moveToFront(wVistaInscripcion);
    }//GEN-LAST:event_mitInscribirMateriasActionPerformed

    private void mitCargarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitCargarNotasActionPerformed
        wVistaCargaNota.setLocation(235,0);
        wVistaCargaNota.show();
        desktopMain.moveToFront(wVistaCargaNota);
    }//GEN-LAST:event_mitCargarNotasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        wVistaListarInscripciones.setLocation(235,0);
        wVistaListarInscripciones.show();
        desktopMain.moveToFront(wVistaListarInscripciones);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VistaMain().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mitCargarNotas;
    private javax.swing.JMenuItem mitInscribirMaterias;
    private javax.swing.JMenuItem mitListaAlumnos;
    private javax.swing.JMenuItem mitListaMaterias;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JMenuBar mnbNavegador;
    private javax.swing.JMenu mnuAlumno;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuInscripciones;
    private javax.swing.JMenu mnuMateria;
    private javax.swing.JMenu mnuNotas;
    // End of variables declaration//GEN-END:variables
}

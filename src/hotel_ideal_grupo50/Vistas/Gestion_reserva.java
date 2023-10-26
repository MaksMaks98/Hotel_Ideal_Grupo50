/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_ideal_grupo50.Vistas;

import hotel_ideal_grupo50.AccesoDatos.HabitacionData;
import hotel_ideal_grupo50.AccesoDatos.HuespedData;
import hotel_ideal_grupo50.AccesoDatos.ReservaData;
import hotel_ideal_grupo50.AccesoDatos.TipoHabitacionData;
import hotel_ideal_grupo50.ClasesExtra.CategoriaItem;
import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Huesped;
import hotel_ideal_grupo50.Entidades.Reserva_huesped;
import hotel_ideal_grupo50.Entidades.Tipo_Habitacion;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maks
 */
public class Gestion_reserva extends javax.swing.JInternalFrame {

   private HabitacionData dataHabi;
   private List<Habitacion> listaHabi;
   private List<Reserva_huesped> listaR;
   private List<CategoriaItem> categoriasID;
   
   private String nombreSeleccionado;
   private int idSeleccionado;

   private TipoHabitacionData dataT;
   private HuespedData dataH;
   private ReservaData dataR;
   private DefaultTableModel modelo1;
   private DefaultTableModel modelo2;
   private Habitacion selec;
   private Reserva_huesped selec2;
   private Huesped huesped;
   
   
   
    public Gestion_reserva() {
        initComponents();
        
        
        listaHabi= new ArrayList<>();
        listaR= new ArrayList<>();
        dataHabi = new HabitacionData();
        dataT = new TipoHabitacionData();
        dataR=new ReservaData();
        dataH = new HuespedData();
        categoriasID= dataT.listarCategoriasID();
        huesped=new Huesped();
       
        
        
        modelo1 = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
            
        };
        modelo2 = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        
        armarCabeceraTabla();
        armarCabeceraTabla2();
        
        cargaCategoria();
        
        
       
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(0);
        nm.setMaximum(4);
        nm.setStepSize(1);
        cantidadPersonas.setModel(nm);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cantidadPersonas = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        RadioActivas2 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        fechaINGRESO = new com.toedter.calendar.JDateChooser();
        fechaSALIDA = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DateFechaIngreso = new com.toedter.calendar.JDateChooser();
        DateFechaEgreso = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        Radio2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        RadioInactivas2 = new javax.swing.JRadioButton();
        categoria = new javax.swing.JComboBox<>();
        cantPersonas = new javax.swing.JSpinner();
        DNIHuesped = new javax.swing.JTextField();
        bBuscarDNI = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tMonto = new javax.swing.JLabel();
        tDNI = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Gestión de reservas");
        setPreferredSize(new java.awt.Dimension(1400, 600));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Listado de reservas");

        jLabel3.setText("Huésped DNI:");

        jLabel5.setText("Cant. Personas:");

        jLabel8.setText("Monto:");

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Calcular");

        jLabel9.setText("dineroen$$");

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabla2);

        jButton5.setText("Confirmar reserva");

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado");

        RadioActivas2.setText("Activas");
        RadioActivas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioActivas2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Buscar disponibilidad de habitaciones");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tabla);

        jLabel12.setText("Fecha ingreso");

        jLabel13.setText("Fecha egreso");

        jLabel15.setText("Categoría:");

        jLabel16.setText("Cant. personas:");

        jLabel6.setText("Estado:");

        Radio2.setText("Activo");

        jLabel7.setText("Fecha ingreso:");

        jLabel17.setText("Fecha egreso:");

        jLabel19.setText("Huésped DNI:");

        RadioInactivas2.setText("Inactivas");
        RadioInactivas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioInactivas2ActionPerformed(evt);
            }
        });

        categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoriaItemStateChanged(evt);
            }
        });

        bBuscarDNI.setText("Buscar");
        bBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarDNIActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI:");

        jLabel4.setText("Monto:");

        tMonto.setText("$$$");

        tDNI.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(fechaINGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fechaSALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6)))))
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(239, 239, 239)))
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(categoria, 0, 131, Short.MAX_VALUE)
                                    .addComponent(tDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RadioActivas2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RadioInactivas2)
                            .addGap(49, 49, 49)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DNIHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bBuscarDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Radio2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGap(56, 56, 56)
                            .addComponent(tMonto))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(RadioActivas2)
                            .addComponent(RadioInactivas2)
                            .addComponent(DNIHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscarDNI)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(tDNI))
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel17))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DateFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(DateFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Radio2)
                            .addComponent(jLabel4)
                            .addComponent(tMonto))
                        .addGap(27, 27, 27)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fechaINGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fechaSALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RadioInactivas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioInactivas2ActionPerformed
         RadioActivas2.setSelected(false);
        DefaultTableModel model = (DefaultTableModel) Tabla2.getModel();
        model.setRowCount(0);
       listarInactivos();
        
     
    }//GEN-LAST:event_RadioInactivas2ActionPerformed

    private void bBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarDNIActionPerformed
      modelo2.setRowCount(0);
      try {
      int dni = Integer.parseInt(DNIHuesped.getText());
        huesped = dataH.buscarHuespedPorDni(DNIHuesped.getText());
        listaR.clear();
        listaR = dataR.buscarReservaPorIdHuesped(huesped.getIdHuesped());
        if (listaR.size()==0){
            JOptionPane.showMessageDialog(null, "No se encontraron reservas activas");
        }
        listarReservasPorHuesped(huesped, listaR);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "El DNI ingresado no es un número válido.");
    }
      
       
      listarReservasPorHuesped(huesped, listaR);
      
    }//GEN-LAST:event_bBuscarDNIActionPerformed

    private void categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoriaItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
            CategoriaItem categoriaselec = (CategoriaItem) categoria.getSelectedItem();

            idSeleccionado = categoriaselec.getIdCategoria();
            nombreSeleccionado = categoriaselec.getNombreCategoria();

        }
    }//GEN-LAST:event_categoriaItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            
           int dni= Integer.parseInt(tDNI.getText());
           CategoriaItem categoriaselec= (CategoriaItem)categoria.getSelectedItem();
           int cantPer= (Integer)cantPersonas.getValue();
           boolean estado= Radio2.isSelected();
           Date fechaIn = DateFechaIngreso.getDate();
           LocalDate fechaIngreso = fechaIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

           Date fechaEg = DateFechaEgreso.getDate();
           LocalDate fechaEgreso = fechaEg.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           
          Habitacion habi= dataHabi.buscarHabitacionPorID(selec2.getIdHabitacion());
          
          Tipo_Habitacion categoria = dataT.buscarCategoriaPorID(habi.getIdCategoria());
          
          double precio= categoria.getPrecio();
          
         double montoActualizado= dataR.calcularMonto(fechaIngreso, fechaEgreso, precio);
         
         Reserva_huesped reservaMod= new Reserva_huesped(selec2.getIdReserva(), selec2.getIdHuesped(),habi.getIdHabitacion(), cantPer,fechaIngreso, fechaEgreso, montoActualizado, estado);
         
         dataR.modificarReserva(reservaMod);
          
          
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Err");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RadioActivas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioActivas2ActionPerformed
         RadioInactivas2.setSelected(false);
        DefaultTableModel model = (DefaultTableModel) Tabla2.getModel();
        model.setRowCount(0);
        //listarActivos();
    }//GEN-LAST:event_RadioActivas2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        
        java.sql.Date fechain = new java.sql.Date(fechaINGRESO.getDate().getTime());
        java.sql.Date fechaeg = new java.sql.Date(fechaSALIDA.getDate().getTime());

        List<Habitacion> habitaciones=dataHabi.habitacionesDisponibles(fechain, fechaeg);
        listarHabitacionesPorFecha ( habitaciones);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNIHuesped;
    private com.toedter.calendar.JDateChooser DateFechaEgreso;
    private com.toedter.calendar.JDateChooser DateFechaIngreso;
    private javax.swing.JRadioButton Radio2;
    private javax.swing.JRadioButton RadioActivas2;
    private javax.swing.JRadioButton RadioInactivas2;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable Tabla2;
    private javax.swing.JButton bBuscarDNI;
    private javax.swing.JSpinner cantPersonas;
    private javax.swing.JSpinner cantidadPersonas;
    private javax.swing.JComboBox<CategoriaItem> categoria;
    private com.toedter.calendar.JDateChooser fechaINGRESO;
    private com.toedter.calendar.JDateChooser fechaSALIDA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel tDNI;
    private javax.swing.JLabel tMonto;
    // End of variables declaration//GEN-END:variables
private void armarCabeceraTabla() {
    ArrayList<Object> filaCabecera = new ArrayList<>();
    filaCabecera.add("ID Habi.");
    filaCabecera.add("  N°  ");
    filaCabecera.add("Categoría");
    filaCabecera.add("Piso");
    filaCabecera.add("Estado");

    for (Object it : filaCabecera) {
        modelo1.addColumn(it);
    }
    Tabla.setModel(modelo1);
    
    // Ajusta las columnas al contenido y muestra el encabezado
    Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    Tabla.getTableHeader().setVisible(true);
    
    Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            int filaSelec = Tabla.getSelectedRow();
            if (filaSelec != -1) {
                selec = listaHabi.get(filaSelec);
                Habitacion habitacion = dataHabi.buscarHabitacionPorID(selec.getIdHabitacion());
            }
        }
    });
}

private void armarCabeceraTabla2() {
    ArrayList<Object> filaCabecera = new ArrayList<>();
    filaCabecera.add("ID Res.");
    filaCabecera.add("Huésped");
    filaCabecera.add("ID Habi.");
    filaCabecera.add("Personas");
    filaCabecera.add("Fecha I.");
    filaCabecera.add("Fecha S.");
    filaCabecera.add("Monto");
    filaCabecera.add("Estado");
    
    for (Object it : filaCabecera) {
        modelo2.addColumn(it);
    }
    Tabla2.setModel(modelo2);
    
    // Ajusta las columnas al contenido y muestra el encabezado
    Tabla2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    Tabla2.getTableHeader().setVisible(true);
    
    Tabla2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            int filaSelec = Tabla2.getSelectedRow();
            if (filaSelec != -1) {
                selec2 = listaR.get(filaSelec);
                Huesped huesped = dataH.buscarHuespedPorID(selec2.getIdHuesped());
                tDNI.setText(huesped.getDni());
                categoria.setSelectedItem(nombreSeleccionado);
                cantPersonas.setValue(selec2.getCantidadPersonas());
                Radio2.setSelected(selec2.isEstado());
                DateFechaIngreso.setDate(Date.from(selec2.getCheckIn().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                DateFechaEgreso.setDate(Date.from(selec2.getCheckOut().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                tMonto.setText(String.format("%.2f", selec2.getMonto()));
            }
        }
    });
}


    private void listarReservasPorHuesped(Huesped huesped, List<Reserva_huesped> reservas) {
        
        for (Reserva_huesped m : reservas){
             String estado = (m.isEstado()) ? "✓" : "✗";
             String nombre = huesped.getNombre()+huesped.getApellido();
            modelo2.addRow(new Object[] { m.getIdReserva(), nombre, m.getIdHabitacion(), m.getCantidadPersonas(), m.getCheckIn(), m.getCheckOut(), m.getMonto(), estado });
        }
    }
    
    private void listarHabitacionesPorFecha ( List<Habitacion> habitaciones) {
        
        for (Habitacion m : habitaciones){
             String estado = (m.isEstado()) ? "✓" : "✗";
             Tipo_Habitacion categoria= dataT.buscarCategoriaPorID(m.getIdCategoria());
             String cate = categoria.getCategoria();
             
            modelo1.addRow(new Object[] { m.getIdHabitacion(), m.getNumHabitacion(), cate, m.getPiso(),  estado });
        }
    }

    private void cargaCategoria() {
        for (CategoriaItem categoriaItem : categoriasID) {
            categoria.addItem(categoriaItem);
        }
    }

    private void listarInactivos() {
       listaR= (ArrayList) dataR.listarInactivosReservas();
       
    for (Reserva_huesped m: listaR){
            String estado = (m.isEstado()) ? "✓" : "✗";
            Huesped huesped= dataH.buscarHuespedPorID(m.getIdHuesped());
            String nombre= huesped.getNombre()+huesped.getApellido();
            modelo2.addRow(new Object[] { m.getIdReserva(), nombre, m.getIdHabitacion(), m.getCantidadPersonas(), m.getCheckIn(), m.getCheckOut(), m.getMonto(), estado });
        }
    }
    }

//    private void listarActivos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


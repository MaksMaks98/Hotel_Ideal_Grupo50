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
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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
   private Habitacion habitacion;
   
   
   
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
        habitacion= new Habitacion();
        JDesktopPane desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane);
        
        
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
        
        Tabla.setRowSelectionAllowed(true); // Permite la selección de filas
        Tabla.setColumnSelectionAllowed(false); // No permite la selección de columnas
       
        
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
        tDniConfirmarRes = new javax.swing.JTextField();
        cantidadPersonas = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        BCalcular = new javax.swing.JButton();
        tMONTO = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        tMontoTotal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tDiasTotales = new javax.swing.JLabel();
        tNombreHuesped = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setResizable(true);
        setTitle("Gestión de reservas");
        setPreferredSize(new java.awt.Dimension(1400, 570));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Listado de reservas");

        jLabel3.setText("Huésped DNI");

        jLabel5.setText("Cant. Personas:");

        jLabel8.setText("Monto por noche:");

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        BCalcular.setText("Calcular");
        BCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCalcularActionPerformed(evt);
            }
        });

        tMONTO.setText(" ");

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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        tMonto.setText(" ");

        tDNI.setText(" ");

        jLabel9.setText("MONTO DE RESERVA");

        tMontoTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tMontoTotal.setText(" ");

        jLabel18.setText("Días totales: ");

        tDiasTotales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tDiasTotales.setText(" ");

        tNombreHuesped.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tNombreHuesped.setText(" ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel_ideal_grupo50/resourses/imgs/buscando.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 68, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(fechaSALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton6))))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(tMONTO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(tMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(tNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(139, 139, 139)
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tDiasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tDniConfirmarRes, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaINGRESO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel19))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(categoria, 0, 131, Short.MAX_VALUE)
                                    .addComponent(tDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(bBuscarDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Radio2)
                                .addGap(266, 266, 266)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(tDNI))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(DateFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(DateFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Radio2)
                            .addComponent(jLabel4)
                            .addComponent(tMonto))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaINGRESO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaSALIDA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tMontoTotal)
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel18)
                                                .addComponent(tDiasTotales)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tDniConfirmarRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(4, 4, 4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tMONTO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tNombreHuesped)
                                .addGap(8, 8, 8)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RadioInactivas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioInactivas2ActionPerformed
        tDNI.setText(huesped.getDni());
        categoria.setSelectedItem(categoria.getItemAt(0));
        cantPersonas.setValue(0);
        Radio2.setSelected(false);
        DateFechaIngreso.setDate(null);
        DateFechaEgreso.setDate(null);
        tMonto.setText("");
        RadioInactivas2.setSelected(false); 
        
        RadioActivas2.setSelected(false);
        DefaultTableModel model = (DefaultTableModel) Tabla2.getModel();
        model.setRowCount(0);
       listarReservasInactivas();
        
     
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
        
        LocalDate fechaIngreso = DateFechaIngreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = DateFechaEgreso.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (validarFechas(fechaIngreso,fechaSalida)) {
        
        try{
           int dni= Integer.parseInt(tDNI.getText());
           CategoriaItem categoriaselec= (CategoriaItem)categoria.getSelectedItem();
           int cantPer= (Integer)cantPersonas.getValue();
           boolean estado= Radio2.isSelected();
//           Date fechaIn = DateFechaIngreso.getDate();
//           LocalDate fechaIngreso = fechaIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//           Date fechaEg = DateFechaEgreso.getDate();
//           LocalDate fechaEgreso = fechaEg.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           
          Habitacion habi= dataHabi.buscarHabitacionPorID(selec2.getIdHabitacion());
          
          Tipo_Habitacion categoria = dataT.buscarCategoriaPorID(habi.getIdCategoria());
          
          double precio= categoria.getPrecio();
          
         double montoActualizado= dataR.calcularMonto(fechaIngreso, fechaSalida, precio);
         
         Reserva_huesped reservaMod= new Reserva_huesped(selec2.getIdReserva(), selec2.getIdHuesped(),habi.getIdHabitacion(), cantPer,fechaIngreso, fechaSalida, montoActualizado, estado);
         
         dataR.modificarReserva(reservaMod);
          
          
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        } else {
            JOptionPane.showMessageDialog(null, "El rango de fechas es inválido.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RadioActivas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioActivas2ActionPerformed
        tDNI.setText(huesped.getDni());
        categoria.setSelectedItem(categoria.getItemAt(0));
        cantPersonas.setValue(0);
        Radio2.setSelected(false);
        DateFechaIngreso.setDate(null);
        DateFechaEgreso.setDate(null);
        tMonto.setText("");
        RadioInactivas2.setSelected(false);
        DefaultTableModel model = (DefaultTableModel) Tabla2.getModel();
        model.setRowCount(0);
        listarReservasActivas();
    }//GEN-LAST:event_RadioActivas2ActionPerformed
public static boolean validarFechas(LocalDate fechaIngreso, LocalDate fechaSalida) {
        LocalDate fechaHoy = LocalDate.now();
       

        // Verificar que la fecha de ingreso no sea anterior a la fecha de hoy
        if (fechaIngreso.isBefore(fechaHoy)) {
            return false;
        }

        // Verificar que la fecha de ingreso sea anterior a la fecha de salida
        if (fechaIngreso.isAfter(fechaSalida)) {
            return false;
        }

        return true;
    }

  
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        tMontoTotal.setText("");
        tMONTO.setText("");
        tDiasTotales.setText("");
        
        try {
        LocalDate fechaIngreso = fechaINGRESO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = fechaSALIDA.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int cantPer= (Integer)cantidadPersonas.getValue();
        if (cantPer==0){
            JOptionPane.showMessageDialog(null, "Ingrese la canidad de personas.");
        } else {
        modelo1.setRowCount(0);
        
        
       if (validarFechas(fechaIngreso, fechaSalida)) {
        java.sql.Date fechain = new java.sql.Date(fechaINGRESO.getDate().getTime());
        java.sql.Date fechaeg = new java.sql.Date(fechaSALIDA.getDate().getTime());
        

        listaHabi=dataHabi.habitacionesDisponibles(fechain, fechaeg, cantPer);
        listarHabitacionesPorFecha ( listaHabi);
        } else {
           JOptionPane.showMessageDialog(null, "El rango de fechas no es válido.");
        }}
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos para realizar la búsqueda.");
        }
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCalcularActionPerformed
        
        LocalDate fechaIngreso = fechaINGRESO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = fechaSALIDA.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int filaSelec = Tabla.getSelectedRow();
        selec = listaHabi.get(filaSelec);
        Tipo_Habitacion categoria = dataT.buscarCategoriaPorID(selec.getIdCategoria());
        double montoTotal = dataR.calcularMonto(fechaIngreso, fechaSalida, categoria.getPrecio());
        
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
        String montoFormateado = decimalFormat.format(montoTotal);
        tMontoTotal.setText(montoFormateado);
        
         long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
         
        tDiasTotales.setText(dias + " día/s");
        
        
    }//GEN-LAST:event_BCalcularActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
       if (dataH.buscarHuespedPorDni(tDniConfirmarRes.getText())!=null){
           
      
        try {
        
        LocalDate fechaIngreso = fechaINGRESO.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaSalida = fechaSALIDA.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int filaSelec = Tabla.getSelectedRow();
        int cantPer= (Integer)cantidadPersonas.getValue();
        Tipo_Habitacion categoria = dataT.buscarCategoriaPorID(selec.getIdCategoria());
        double montoTotal = dataR.calcularMonto(fechaIngreso, fechaSalida, categoria.getPrecio());
        if (filaSelec != -1){
        Huesped huesped = dataH.buscarHuespedPorDni(tDniConfirmarRes.getText());
        Reserva_huesped reserva = new Reserva_huesped (huesped.getIdHuesped(), selec.getIdHabitacion(), cantPer , fechaIngreso, fechaSalida, montoTotal, true);
        dataR.crearReserva(reserva);
        }
        
       } catch (Exception ex ) {
           JOptionPane.showMessageDialog(null, "Err" + ex);
       }
       } else {
            JOptionPane.showMessageDialog(null, "El huésped no existe, diríjase a la sección de Huésped y cárguelo.");
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
            Integer.parseInt(tDniConfirmarRes.getText()); 
            
           Huesped huespeddni= dataH.buscarHuespedPorDni(tDniConfirmarRes.getText());
           
           if (huespeddni!=null){
               tNombreHuesped.setText(huespeddni.getNombre()+ " "+ huespeddni.getApellido());
           } else {
               JOptionPane.showMessageDialog(null, "El huésped no existe, debe cargarlo.");
           }
           
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Err");
         }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCalcular;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel tDNI;
    private javax.swing.JLabel tDiasTotales;
    private javax.swing.JTextField tDniConfirmarRes;
    private javax.swing.JLabel tMONTO;
    private javax.swing.JLabel tMonto;
    private javax.swing.JLabel tMontoTotal;
    private javax.swing.JLabel tNombreHuesped;
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
                Tipo_Habitacion categoria = dataT.buscarCategoriaPorID(habitacion.getIdCategoria());
                tMONTO.setText(String.format("$%.2f",categoria.getPrecio()));
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
                tMonto.setText(String.format("$%.2f", selec2.getMonto()));
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

    private void listarReservasInactivas() {
       listaR= (ArrayList) dataR.listarInactivosReservas();
       
    for (Reserva_huesped m: listaR){
            String estado = (m.isEstado()) ? "✓" : "✗";
            Huesped huesped= dataH.buscarHuespedPorID(m.getIdHuesped());
            String nombre= huesped.getNombre()+huesped.getApellido();
            modelo2.addRow(new Object[] { m.getIdReserva(), nombre, m.getIdHabitacion(), m.getCantidadPersonas(), m.getCheckIn(), m.getCheckOut(), m.getMonto(), estado });
        }
    }

    private void listarReservasActivas() {
        listaR=(ArrayList) dataR.listarActivosReservas();
       
    for (Reserva_huesped m: listaR){
            String estado = (m.isEstado()) ? "✓" : "✗";
            Huesped huesped= dataH.buscarHuespedPorID(m.getIdHuesped());
            String nombre= huesped.getNombre()+huesped.getApellido();
            modelo2.addRow(new Object[] { m.getIdReserva(), nombre, m.getIdHabitacion(), m.getCantidadPersonas(), m.getCheckIn(), m.getCheckOut(), m.getMonto(), estado });
        }
    }
    
    }



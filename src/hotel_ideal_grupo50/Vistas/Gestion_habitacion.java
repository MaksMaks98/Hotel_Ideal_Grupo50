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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maks
 */
public class Gestion_habitacion extends javax.swing.JInternalFrame {

    
  
   private List<Habitacion> listaHabi;
   private List<CategoriaItem> categoriasID;
   
   
   private int idSeleccionado;
   private Habitacion selec;
   private String nombreSeleccionado;
   private HabitacionData dataHabi;
   private TipoHabitacionData dataT;
   private DefaultTableModel modelo;

   
   
   public Gestion_habitacion() {
        initComponents();
        

        listaHabi= new ArrayList<>();
        dataHabi = new HabitacionData();
        dataT = new TipoHabitacionData();
        categoriasID = dataT.listarCategoriasID();
        
        
        modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        

        
        
        
        
        cargaCategoria();
        armarCabeceraTabla();

        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMinimum(0);
        nm.setMaximum(4);
        nm.setStepSize(1);
        numeroPiso.setModel(nm);

        SpinnerNumberModel nm1 = new SpinnerNumberModel();
        nm1.setMinimum(0);
        nm1.setMaximum(440);
        nm1.setStepSize(1);
        numeroHabitacion.setModel(nm1);
       

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Radio = new javax.swing.JRadioButton();
        numeroPiso = new javax.swing.JSpinner();
        numeroHabitacion = new javax.swing.JSpinner();
        categoria = new javax.swing.JComboBox<>();
        bBuscarNumero = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();
        cantidad = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        bModificar = new javax.swing.JButton();

        setResizable(true);
        setTitle("Gestión de habitaciones");
        setPreferredSize(new java.awt.Dimension(700, 500));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("N° de habitación");

        jLabel2.setText("Elija la categoría:");

        jLabel3.setText("N° de piso: ");

        jLabel4.setText("Estado: ");

        Radio.setText("Activo");
        Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioActionPerformed(evt);
            }
        });

        numeroPiso.setEditor(new javax.swing.JSpinner.NumberEditor(numeroPiso, ""));
        numeroPiso.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                numeroPisoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoriaItemStateChanged(evt);
            }
        });

        bBuscarNumero.setText("Buscar");
        bBuscarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarNumeroActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(Tabla);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Listar habitaciones");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        cantidad.setText("CANTIDAD");

        jButton4.setText("Cargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Cargar habitaciones");

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidad))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 599, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(20, 20, 20)
                                        .addComponent(numeroHabitacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bBuscarNumero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Radio))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(numeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscarNumero)
                            .addComponent(jLabel3)
                            .addComponent(numeroPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Radio)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(bBuscar)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidad))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioActionPerformed

    private void numeroPisoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_numeroPisoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroPisoAncestorAdded

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
       
        modelo.setRowCount(0);
        listaHabi = dataHabi.buscarHabitaciones(idSeleccionado);
        cantidad.setText("Cantidad: " + listaHabi.size());

        listarHabitacionesxCategoria();


    }//GEN-LAST:event_bBuscarActionPerformed

    private void bBuscarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarNumeroActionPerformed
       
        modelo.setRowCount(0);
        int numero = Integer.parseInt(numeroHabitacion.getValue().toString());
        
        Habitacion habitacion = dataHabi.buscarHabitacion(numero);
 
        listarHabitaciones(habitacion);


    }//GEN-LAST:event_bBuscarNumeroActionPerformed

    private void categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            CategoriaItem categoriaselec = (CategoriaItem) categoria.getSelectedItem();

            idSeleccionado = categoriaselec.getIdCategoria();
            nombreSeleccionado = categoriaselec.getNombreCategoria();

        }

    }//GEN-LAST:event_categoriaItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       try{
           
          
           
           if (Integer.parseInt(numeroHabitacion.getValue().toString())!= 0 && dataHabi.buscarHabitacion(Integer.parseInt(numeroHabitacion.getValue().toString()))!=null) {
               
               Habitacion habitacion = new Habitacion (Integer.parseInt(numeroHabitacion.getValue().toString()), idSeleccionado, Integer.parseInt(numeroPiso.getValue().toString()), Radio.isSelected());
           dataHabi.cargarHabitacion(habitacion);
           } else {
               JOptionPane.showMessageDialog(null, "El número de habitación no se puede repetir, ni ser cero.");
           }
          
           
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Datos incorrectos");
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
         try {
             
            Habitacion habitacion = new Habitacion (selec.getIdHabitacion(),Integer.parseInt(numeroHabitacion.getValue().toString()), idSeleccionado, Integer.parseInt(numeroPiso.getValue().toString()), Radio.isSelected());
            dataHabi.modificarHabitacion(habitacion);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la carga" + ex);
        }
    }//GEN-LAST:event_bModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Radio;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bBuscarNumero;
    private javax.swing.JButton bModificar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JComboBox<CategoriaItem> categoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner numeroHabitacion;
    private javax.swing.JSpinner numeroPiso;
    // End of variables declaration//GEN-END:variables
private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera =new ArrayList<>();
        filaCabecera.add("ID");
        filaCabecera.add("N° Habitación");
        filaCabecera.add("Categoría");
        filaCabecera.add("Piso");
        filaCabecera.add("Estado");
       
        
    for (Object it : filaCabecera) {
        modelo.addColumn(it);
    }
    Tabla.setModel(modelo);
    

    Tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        int filaSelec = Tabla.getSelectedRow();
        if (filaSelec != -1) {
            selec = listaHabi.get(filaSelec); 
            numeroHabitacion.setValue(selec.getNumHabitacion());
            categoria.setSelectedItem(nombreSeleccionado);
            numeroPiso.setValue(selec.getPiso());
            Radio.setSelected(selec.isEstado());
        }
    
    }
       
});
    
    
        
    }


    private void listarHabitacionesxCategoria() {
      
    for (Habitacion m: listaHabi){
            String estado = (m.isEstado()) ? "✓" : "✗";
            modelo.addRow(new Object[] { m.getIdCategoria(), m.getNumHabitacion(), nombreSeleccionado, m.getPiso(), estado });
        }  
    }

   private void cargaCategoria() {
    for (CategoriaItem categoriaItem : categoriasID) {
        categoria.addItem(categoriaItem);
    }
}

    private void listarHabitaciones(Habitacion habitacion) {
       if (listaHabi.size()>0){
           listaHabi.clear();
       } 
       
       listaHabi.add(habitacion);
      

       
        for (Habitacion m: listaHabi){
            String estado = (m.isEstado()) ? "✓" : "✗";
            
            for (CategoriaItem c : categoriasID){
                
                if (c.getIdCategoria() == habitacion.getIdCategoria())
                          modelo.addRow(new Object[] { m.getIdHabitacion(), m.getNumHabitacion(),  c.getNombreCategoria(), m.getPiso(), estado });
      
            }
        }
    }
    
    
   

}

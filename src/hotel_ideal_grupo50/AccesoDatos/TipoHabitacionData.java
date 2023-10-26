/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.ClasesExtra.CategoriaItem;
import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Tipo_Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author maks
 */
public class TipoHabitacionData {
    private Connection con=null;
        
        public TipoHabitacionData (){
                         con=Conexion.getConexion();          
        }
    
        
        
        public void crearTipoHabitacion (Tipo_Habitacion tipo_habitacion) {
            
            String sql= "INSERT INTO categoria VALUES (null,?,?,?,?,?) ";
             try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,tipo_habitacion.getCategoria());
            ps.setInt(2, tipo_habitacion.getCantidadCamas());
            ps.setInt(3, tipo_habitacion.getCantidadPersonas());
            ps.setString(4,tipo_habitacion.getTipoCamas());
            ps.setDouble(5, tipo_habitacion.getPrecio());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               tipo_habitacion.setIdTipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se cargó exitosamente la categoría");
            }
            
            ps.close();
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Categoría  "+ex.getMessage());
        }
            
        }
        
        public Tipo_Habitacion buscarCantidadPersonas (int cantPersonas ) {
            

            
                Tipo_Habitacion categoria = new Tipo_Habitacion();
        try {
            
           String sql="SELECT idCategoria, nomCategoria, cantidadCamas, cantPersonas, tipoCama, precio FROM categoria WHERE cantPersonas=?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1,cantPersonas);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 categoria.setIdTipo(rs.getInt("idCategoria"));
                 categoria.setCategoria(rs.getString("nomCategoria"));
                 categoria.setCantidadCamas(rs.getInt("cantidadCamas"));
                 categoria.setCantidadPersonas(rs.getInt("cantPersonas"));
                 categoria.setTipoCamas(rs.getString("tipoCama"));
                 categoria.setPrecio(rs.getDouble("precio"));
                               
             }
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Categorias.  "+ ex);
        }
        
        return categoria;
            
            
        }


   
         public ArrayList<CategoriaItem> listarCategoriasID() {
    ArrayList<CategoriaItem> categorias = new ArrayList<>();
    try {
        String sql = "SELECT idCategoria, nomCategoria FROM categoria";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCategoria = rs.getInt("idCategoria");
            String nombreCategoria = rs.getString("nomCategoria");
            CategoriaItem categoria = new CategoriaItem(idCategoria, nombreCategoria);
            categorias.add(categoria);
        }

        ps.close();
        return categorias;
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error, no se pudo acceder a la tabla Categoría");
        return null;
    }
}
         
         public Tipo_Habitacion buscarCategoriaPorID (int idCategoria){
             Tipo_Habitacion categoria = new Tipo_Habitacion();
             try {
                 String sql= "SELECT * FROM categoria WHERE idCategoria=?";
              PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1,idCategoria);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 categoria.setIdTipo(rs.getInt("idCategoria"));
                 categoria.setCategoria(rs.getString("nomCategoria"));
                 categoria.setCantidadCamas(rs.getInt("cantidadCamas"));
                 categoria.setCantidadPersonas(rs.getInt("cantPersonas"));
                 categoria.setTipoCamas(rs.getString("tipoCama"));
                 categoria.setPrecio(rs.getDouble("precio"));
                               
             }
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Categorias.  "+ ex);
        }
        
        return categoria;
             
         }

        
        
}

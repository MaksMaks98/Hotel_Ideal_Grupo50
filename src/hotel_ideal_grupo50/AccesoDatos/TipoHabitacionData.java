/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Tipo_Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
}

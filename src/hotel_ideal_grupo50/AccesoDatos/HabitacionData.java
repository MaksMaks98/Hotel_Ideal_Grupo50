
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.Entidades.Habitacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class HabitacionData {
    
     private Connection con=null;
        
        public HabitacionData (){
                         con=Conexion.getConexion();          
        }

        
        public void cargarHabitacion (Habitacion habitacion) {
            
            String sql= "INSERT INTO `habitacion` VALUES (null,?,?,?,?)";
            try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, habitacion.getNumHabitacion());
            ps.setInt(2, habitacion.getIdCategoria());
            ps.setInt(3, habitacion.getPiso());
            ps.setBoolean(4, habitacion.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se cargó exitosamente la habitación");
            }
            
            ps.close();
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitación  "+ex.getMessage());
        }
            
        }
    
}

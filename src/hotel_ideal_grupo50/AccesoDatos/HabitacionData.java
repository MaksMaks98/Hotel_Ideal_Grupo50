
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
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitación. El número de habitación ya se encuentra cargado.  "+ex.getMessage());
        }
            
        }
        
    public Habitacion buscarHabitacion(int numHabitacion) {
        Habitacion habitacion = null;
        String sql = "SELECT idHabitacion, numHabitacion, idCategoria, piso, estado FROM habitacion WHERE numHabitacion=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numHabitacion);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                habitacion = new Habitacion();
                habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
                habitacion.setNumHabitacion(rs.getInt("numHabitacion"));
                habitacion.setIdCategoria(rs.getInt("idCategoria"));
                habitacion.setPiso(rs.getInt("piso"));
                habitacion.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe la habitación");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitación " + ex.getMessage());

        }
        return habitacion;
    }

    public void modificarHabitacion(Habitacion habitacion) {
        String sql = "UPDATE habitacion SET habitacion.numHabitacion=?, habitacion.idCategoria=?, habitacion.piso=?, habitacion.estado=? WHERE habitacion.idHabitacion=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, habitacion.getNumHabitacion());
            ps.setInt(2, habitacion.getIdCategoria());
            ps.setInt(3, habitacion.getPiso());
            ps.setBoolean(4, habitacion.isEstado());
            ps.setInt(5, habitacion.getIdHabitacion());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó exitosamente la habitación");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la habitación. Verifica el ID.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitación: " + ex.getMessage());
        }
    }
    
}

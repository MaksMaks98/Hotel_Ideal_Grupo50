
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.Entidades.Habitacion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Habitacion buscarHabitacionPorID(int idHabitacion) {
        Habitacion habitacion = null;
        String sql = "SELECT * FROM habitacion WHERE idHabitacion=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
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





    public List<Habitacion> buscarHabitaciones (int idCategoria) {
        
        List<Habitacion> habitaciones = new ArrayList<>();
        
        try {
	     String sql = "SELECT * FROM habitacion WHERE idCategoria=?";
	     PreparedStatement ps = con.prepareStatement(sql);
              ps.setInt(1,idCategoria);
	      ResultSet rs = ps.executeQuery();
              
	while (rs.next()) {
            
	Habitacion habitacion = new Habitacion(); 
	habitacion =new Habitacion();
        
	habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
	habitacion.setNumHabitacion(rs.getInt("numHabitacion"));
	habitacion.setIdCategoria(rs.getInt("idCategoria"));
	habitacion.setPiso(rs.getInt("piso"));
        habitacion.setEstado(rs.getBoolean(5));
        habitaciones.add(habitacion);
	}
	ps.close(); 

	} catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Reserva "+ex.getMessage());
	}
	return habitaciones;
	}









    
    
    public List<Habitacion> habitacionesDisponibles (Date fechaIngreso, Date fechaEgreso, int personas){
            
            List<Habitacion> habitaciones = new ArrayList<>();
            
            try {
                
                String sql = "SELECT h.* \n" +
"FROM habitacion AS h\n" +
"LEFT JOIN reserva AS r ON h.idHabitacion = r.idHabitacion AND (r.fechaIngreso <= ? AND r.fechaSalida >= ?)\n" +
"LEFT JOIN categoria AS c ON h.idCategoria = c.idCategoria\n" +
"WHERE \n" +
"  (h.estado = 0) \n" +
"  AND (r.idReserva IS NULL OR r.estado = 0) \n" +
"  AND c.cantPersonas = ?;";
                PreparedStatement ps = con.prepareStatement(sql);
                 ps.setDate(1, fechaEgreso);
                 ps.setDate(2, fechaIngreso);
                 ps.setInt(3, personas);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
            
	Habitacion habitacion = new Habitacion(); 
	habitacion =new Habitacion();
        
	habitacion.setIdHabitacion(rs.getInt("idHabitacion"));
	habitacion.setNumHabitacion(rs.getInt("numHabitacion"));
	habitacion.setIdCategoria(rs.getInt("idCategoria"));
	habitacion.setPiso(rs.getInt("piso"));
        habitacion.setEstado(rs.getBoolean(5));
        habitaciones.add(habitacion);
	}
	ps.close(); 
                
                
            }catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva" + ex);
            }
    
            return habitaciones;
            
    }
    
}




package hotel_ideal_grupo50.AccesoDatos;


import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Reserva_huesped;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ReservaData {
    private Connection con=null;
        
        public ReservaData (){
                         con=Conexion.getConexion();          
        }
        
        public void crearReserva(Reserva_huesped reserva){
            
            String sql ="INSERT INTO reserva(idHuesped, idHabitacion, cantidadPersona, fechaIngreso, fechaSalida, monto, estado) VALUES (?,?,?,?,?,?,?) ";
            try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getIdHuesped());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setInt(3, reserva.getCantidadPersonas());
            ps.setDate (4, Date.valueOf(reserva.getCheckIn()));
            ps.setDate (5, Date.valueOf(reserva.getCheckOut()));
            ps.setDouble(6, reserva.getMonto());
            ps.setBoolean(7, reserva.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               reserva.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se cargó exitosamente la reserva");
            }
            
            ps.close();
          
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva.  "+ex.getMessage());
        }
            
        }
        
        public void modificarReserva(Reserva_huesped reserva) {
            String sql = "UPDATE reserva SET reserva.idHuesped=?, reserva.idHabitacion=?, "
                    + "reserva.cantidadPersona=?, reserva.fechaIngreso=?, reserva.fechaSalida=?, "
                    + "reserva.monto=?, reserva.estado=? WHERE reserva.idReserva=?";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, reserva.getIdHuesped());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setInt(3, reserva.getCantidadPersonas());
        java.sql.Date fechaIngreso = java.sql.Date.valueOf(reserva.getCheckIn());
        java.sql.Date fechaSalida = java.sql.Date.valueOf(reserva.getCheckOut());

            ps.setDate(4, fechaIngreso);
            ps.setDate(5, fechaSalida);
            ps.setDouble(6, reserva.getMonto());
            ps.setBoolean(7, reserva.isEstado());
            ps.setInt(8, reserva.getIdReserva());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó exitosamente la reserva");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la reserva. Verifica el ID.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + ex.getMessage());
        }
        }
              
        public List<Reserva_huesped> buscarReservaPorIdHuesped(int idHuesped) { 
            
	List<Reserva_huesped> reservas = new ArrayList<>();
        
	try {
	     String sql = "SELECT * FROM reserva WHERE idHuesped=? AND estado = 1";
	     PreparedStatement ps = con.prepareStatement(sql);
              ps.setInt(1,idHuesped);
	      ResultSet rs = ps.executeQuery();
              
	while (rs.next()) {
            
	Reserva_huesped reserva = new Reserva_huesped(); 
	reserva =new Reserva_huesped();
        
	reserva.setIdReserva(rs.getInt("idReserva"));
	reserva.setIdHuesped(rs.getInt("idHuesped"));
	reserva.setIdHabitacion(rs.getInt("idHabitacion"));
	reserva.setCantidadPersonas(rs.getInt("cantidadPersona"));
        reserva.setCheckIn(rs.getDate("fechaIngreso").toLocalDate());
	reserva.setCheckOut(rs.getDate("fechaSalida").toLocalDate());
	reserva.setMonto(rs.getDouble("monto"));
	reserva.setEstado(rs.getBoolean(8));
        reservas.add(reserva);
	}
	ps.close(); 

	} catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Reserva "+ex.getMessage());
	}
	return reservas;
	}
        
        public Double calcularMonto (LocalDate fechaIngreso, LocalDate fechaSalida, double precioCategoria){
          

         long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);

         double monto = dias * precioCategoria;

       // Reemplazar la coma por punto en el monto
    String montoFormateado = String.valueOf(monto).replace(",", ".");

    double montoTruncado = Double.parseDouble(montoFormateado);
    return montoTruncado;
            
        }
        
        public List<Reserva_huesped> listarInactivosReservas () {
       
        List<Reserva_huesped> reservas = new ArrayList<>();
        String sql ="SELECT * FROM reserva WHERE estado = 0 ";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Reserva_huesped reserva=new Reserva_huesped();
	reserva.setIdReserva(rs.getInt("idReserva"));
	reserva.setIdHuesped(rs.getInt("idHuesped"));
	reserva.setIdHabitacion(rs.getInt("idHabitacion"));
	reserva.setCantidadPersonas(rs.getInt("cantidadPersona"));
	reserva.setCheckIn(rs.getDate("fechaIngreso").toLocalDate());
	reserva.setCheckOut(rs.getDate("fechaSalida").toLocalDate());
	reserva.setMonto(rs.getDouble("monto"));
	reserva.setEstado(rs.getBoolean("estado"));
	reservas.add(reserva);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());	
        
        
    }
         return reservas;
        
        
    }
        
         public List<Reserva_huesped> listarActivosReservas() {
       
        List<Reserva_huesped> reservas = new ArrayList<>();
        String sql ="SELECT * FROM reserva WHERE estado = 1 ";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Reserva_huesped reserva=new Reserva_huesped();
	reserva.setIdReserva(rs.getInt("idReserva"));
	reserva.setIdHuesped(rs.getInt("idHuesped"));
	reserva.setIdHabitacion(rs.getInt("idHabitacion"));
	reserva.setCantidadPersonas(rs.getInt("cantidadPersona"));
	reserva.setCheckIn(rs.getDate("fechaIngreso").toLocalDate());
	reserva.setCheckOut(rs.getDate("fechaSalida").toLocalDate());
	reserva.setMonto(rs.getDouble("monto"));
	reserva.setEstado(rs.getBoolean("estado"));
	reservas.add(reserva);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());	
        
        
    }
         return reservas;
        
        
    }
         
         
         public List<Reserva_huesped> listarTodasR() {
       
        List<Reserva_huesped> reservas = new ArrayList<>();
        String sql ="SELECT * FROM reserva";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Reserva_huesped reserva=new Reserva_huesped();
	reserva.setIdReserva(rs.getInt("idReserva"));
	reserva.setIdHuesped(rs.getInt("idHuesped"));
	reserva.setIdHabitacion(rs.getInt("idHabitacion"));
	reserva.setCantidadPersonas(rs.getInt("cantidadPersona"));
	reserva.setCheckIn(rs.getDate("fechaIngreso").toLocalDate());
	reserva.setCheckOut(rs.getDate("fechaSalida").toLocalDate());
	reserva.setMonto(rs.getDouble("monto"));
	reserva.setEstado(rs.getBoolean("estado"));
	reservas.add(reserva);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());	
        
        
    }
         return reservas;
        
        
    }
         
      public void actualizarReservasVencidas(List<Reserva_huesped> reservas) {
        LocalDate fechaActual = LocalDate.now();

        for (Reserva_huesped reserva : reservas) {
            int nuevoEstado = reserva.getCheckOut().isBefore(fechaActual) ? 0 : 1;
            try {
                // Actualizar el estado de la reserva
                String updateReservaSQL = "UPDATE reserva SET estado = ? WHERE idReserva = ?";
                PreparedStatement psReserva = con.prepareStatement(updateReservaSQL);
                psReserva.setInt(1, nuevoEstado);
                psReserva.setInt(2, reserva.getIdReserva());
                psReserva.executeUpdate();
                psReserva.close();

                // Actualizar el estado del huésped
                String updateHuespedSQL = "UPDATE huesped SET estado = ? WHERE idHuesped = ?";
                PreparedStatement psHuesped = con.prepareStatement(updateHuespedSQL);
                psHuesped.setInt(1, nuevoEstado);
                psHuesped.setInt(2, reserva.getIdHuesped());
                psHuesped.executeUpdate();
                psHuesped.close();

                // Actualizar el estado de la habitación asociada a la reserva
                String updateHabitacionSQL = "UPDATE habitacion SET estado = ? WHERE idHabitacion = ?";
                PreparedStatement psHabitacion = con.prepareStatement(updateHabitacionSQL);
                psHabitacion.setInt(1, nuevoEstado);
                psHabitacion.setInt(2, reserva.getIdHabitacion());
                psHabitacion.executeUpdate();
                psHabitacion.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar reservas: " + ex.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Lista actualizada. ");
    }
            
        
        
        
        
}

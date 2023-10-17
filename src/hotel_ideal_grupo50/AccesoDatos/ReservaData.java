
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.Entidades.Reserva_huesped;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
        
        
}

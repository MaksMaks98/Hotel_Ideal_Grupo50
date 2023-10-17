
package hotel_ideal_grupo50.AccesoDatos;

import hotel_ideal_grupo50.Entidades.Huesped;
import hotel_ideal_grupo50.Entidades.Reserva_huesped;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class HuespedData {
    
    
        private Connection con=null;
        
        public HuespedData (){
                         con=Conexion.getConexion();          
        }


    public void crearHuesped(Huesped huesped) {
        String sql = "INSERT INTO `huesped` VALUES (null,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getDni());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getCelular());
            ps.setBoolean(7, huesped.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ingreso el huésped con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, el huésped ya existe. Realice la búsqueda por DNI.");
        }
    }

    public void borrarHuesped(String dni) {

        try {

            String sql = "UPDATE huesped SET estado = 0 WHERE dni = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el huésped.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Huésped");
        }
    }

    public Huesped buscarHuespedPorDni(String dni) {
        Huesped huesped = null;
        String sql = "SELECT * FROM huesped WHERE dni=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setDni(rs.getString("dni"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setCelular(rs.getString("celular"));
                huesped.setEstado(rs.getBoolean(8));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el huésped");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped " + ex.getMessage());

        }
        return huesped;
    }

    public void modificarDatosHuesped(int id, Huesped huesped) {
        String sql = "UPDATE huesped SET nombre=?, apellido=?, dni=?, domicilio=?, correo=?, celular=?, estado=?  WHERE idHuesped=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getDni());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getCelular());
            ps.setBoolean(7, huesped.isEstado());
            ps.setInt(8, id); // Establecer id en la posición correcta

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El huésped no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huésped " + ex.getMessage());
        }
    }
    
    public List<Huesped> listarTodoHuesped () {
       
        List<Huesped> huespedes = new ArrayList<>();
        String sql ="SELECT * FROM huesped ";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Huesped huesped=new Huesped();
	huesped.setIdHuesped(rs.getInt("idHuesped"));
	huesped.setNombre(rs.getString("nombre"));
	huesped.setApellido(rs.getString("apellido"));
	huesped.setDni(rs.getString("dni"));
	huesped.setDomicilio(rs.getString("domicilio"));
	huesped.setCorreo(rs.getString("correo"));
	huesped.setCelular(rs.getString("celular"));
	huesped.setEstado(rs.getBoolean("estado"));
	huespedes.add(huesped);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped "+ex.getMessage());	
        
        
    }
         return huespedes;
        
        
    }
    
    public List<Huesped> listarActivosHuesped () {
       
        List<Huesped> huespedes = new ArrayList<>();
        String sql ="SELECT * FROM huesped WHERE estado=1 ";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Huesped huesped=new Huesped();
	huesped.setIdHuesped(rs.getInt("idHuesped"));
	huesped.setNombre(rs.getString("nombre"));
	huesped.setApellido(rs.getString("apellido"));
	huesped.setDni(rs.getString("dni"));
	huesped.setDomicilio(rs.getString("domicilio"));
	huesped.setCorreo(rs.getString("correo"));
	huesped.setCelular(rs.getString("celular"));
	huesped.setEstado(rs.getBoolean("estado"));
	huespedes.add(huesped);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped "+ex.getMessage());	
        
        
    }
         return huespedes;
        
        
    }
    
    public List<Huesped> listarInactivosHuesped () {
       
        List<Huesped> huespedes = new ArrayList<>();
        String sql ="SELECT * FROM huesped WHERE estado = 0 ";
            PreparedStatement ps = null;
        try {
           ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery(); 
        
	while (rs.next()) {
           
	Huesped huesped=new Huesped();
	huesped.setIdHuesped(rs.getInt("idHuesped"));
	huesped.setNombre(rs.getString("nombre"));
	huesped.setApellido(rs.getString("apellido"));
	huesped.setDni(rs.getString("dni"));
	huesped.setDomicilio(rs.getString("domicilio"));
	huesped.setCorreo(rs.getString("correo"));
	huesped.setCelular(rs.getString("celular"));
	huesped.setEstado(rs.getBoolean("estado"));
	huespedes.add(huesped);
        }    
        ps.close();
        
        } catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped "+ex.getMessage());	
        
        
    }
         return huespedes;
        
        
    }
    
    

}
        
      
        
  

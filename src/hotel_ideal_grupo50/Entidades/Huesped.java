package hotel_ideal_grupo50.Entidades;

public class Huesped {

    private int idHuesped;

    private String nombre;
    
    private String apellido;

    private String dni;

    private String domicilio;

    private String correo;

    private String celular;
    
    private boolean estado;

    public Huesped() {
    }

    public Huesped(int idHuesped, String nombre,String apellido, String dni, String domicilio, String correo, String celular) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
        this.apellido = apellido;
    }

    public Huesped(String nombre, String apellido, String dni, String domicilio, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
    }

    public Huesped(String nombre, String apellido, String dni, String domicilio, String correo, String celular, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.celular = celular;
        this.estado = estado;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        
        
        return "ID: " + idHuesped + " Nombre: " + nombre + " DNI: " + dni + " Domicilio: " + domicilio + " Correo: " + correo + " Celular=: " + celular ;
    }

    
    
}

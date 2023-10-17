package hotel_ideal_grupo50.Entidades;

public class Tipo_Habitacion {

    private int idTipo;

    private String categoria;

    private int cantidadCamas;

    private int cantidadPersonas;

    private String tipoCamas;
    
    private double precio;

    public Tipo_Habitacion() {
    }

    public Tipo_Habitacion(int idTipo, String categoria, int cantidadCamas, int cantidadPersonas, String tipoCamas, double precio) {
        this.idTipo = idTipo;
        this.categoria = categoria;
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precio= precio;
    }

    public Tipo_Habitacion(String categoria, int cantidadCamas, int cantidadPersonas, String tipoCamas, double precio) {
        
        this.categoria = categoria;
        this.cantidadCamas = cantidadCamas;
        this.cantidadPersonas = cantidadPersonas;
        this.tipoCamas = tipoCamas;
        this.precio = precio;
    }

 
    

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipoCamas() {
        return tipoCamas;
    }

    public void setTipoCamas(String tipoCamas) {
        this.tipoCamas = tipoCamas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "tipo_Habitacion{" + "idTipo=" + idTipo + ", categoria=" + categoria + ", cantidadCamas=" + cantidadCamas + ", cantidadPersonas=" + cantidadPersonas + ", tipoCamas=" + tipoCamas + ", precio=" + precio + '}';
    }
    
    
}

package hotel_ideal_grupo50.Entidades;

public class Habitacion {

    private int idHabitacion;

    private int numHabitacion;

    private Tipo_Habitacion tpo_Habitacion;
    
    private int idCategoria;

    private int piso;

    private boolean estado;

    public Habitacion() {
    }

    

    public Habitacion(int idHabitacion, int numHabitacion, int idCategoria, int piso, boolean estado) {
        this.idHabitacion = idHabitacion;
        this.numHabitacion = numHabitacion;
        this.idCategoria = idCategoria;
        this.piso = piso;
        this.estado = estado;
    }
    
    
    public Habitacion(int numHabitacion, int idCategoria, int piso, boolean estado) {
        this.numHabitacion = numHabitacion;
        this.idCategoria = idCategoria;
        this.piso = piso;
        this.estado = estado;
    }

    public Habitacion(int numHabitacion, Tipo_Habitacion tpo_Habitacion, int piso, boolean estado) {
        this.numHabitacion = numHabitacion;
        this.tpo_Habitacion = tpo_Habitacion;
        this.piso = piso;
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
   
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Tipo_Habitacion getTpo_Habitacion() {
        return tpo_Habitacion;
    }

    public void setTpo_Habitacion(Tipo_Habitacion tpo_Habitacion) {
        this.tpo_Habitacion = tpo_Habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "habitacion{" + "idHabitacion=" + idHabitacion + ", numHabitacion=" + numHabitacion + "  idCategoria: "+ idCategoria + ", tpo_Habitacion=" + tpo_Habitacion + ", piso=" + piso + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
    
}

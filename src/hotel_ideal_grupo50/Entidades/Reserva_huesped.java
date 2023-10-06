package hotel_ideal_grupo50.Entidades;

import java.time.LocalDate;

public class Reserva_huesped {

    private int idReserva;

    private Huesped huesped;

    private Habitacion habitacion;

    private int cantidadPersonas;

    private LocalDate checkIn;

    private LocalDate checkOut;
   
    private double monto;
   
    private boolean estado;

     public Reserva_huesped() {
    }
     
    public Reserva_huesped(int idReserva, Huesped huesped, Habitacion habitacion, int cantidadPersonas, LocalDate checkIn, LocalDate checkOut, double monto, boolean estado) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.monto= monto;
        this.estado= estado;
        
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion ;
    }

    public void setHabiacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva_huesped{" + "idReserva=" + idReserva + ", huesped=" + huesped + ", habitacion=" + habitacion + ", cantidadPersonas=" + cantidadPersonas + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", monto=" + monto + ", estado=" + estado + '}';
    }

    
   
    
    
    
}

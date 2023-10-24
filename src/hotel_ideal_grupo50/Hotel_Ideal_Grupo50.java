package hotel_ideal_grupo50;

import hotel_ideal_grupo50.AccesoDatos.HabitacionData;
import hotel_ideal_grupo50.AccesoDatos.HuespedData;
import hotel_ideal_grupo50.AccesoDatos.ReservaData;
import hotel_ideal_grupo50.AccesoDatos.TipoHabitacionData;
import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Huesped;
import hotel_ideal_grupo50.Entidades.Reserva_huesped;
import hotel_ideal_grupo50.Entidades.Tipo_Habitacion;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Hotel_Ideal_Grupo50 {

   
    public static void main(String[] args) {

        HuespedData dataH = new HuespedData();
        HabitacionData dataHabi = new HabitacionData();
        ReservaData dataRes = new ReservaData();
        TipoHabitacionData dataT = new TipoHabitacionData();

        Tipo_Habitacion tipo1 = new Tipo_Habitacion("Suite Lujo", 4, 2, "2 camas matrimoniales", 14000);

        Habitacion habitacion = new Habitacion(13, 9, 1, true);

//        dataH.crearHuesped(huesped);
//        dataT.crearTipoHabitacion(tipo1);
//               dataHabi.cargarHabitacion(habitacion);
//             dataH.borrarHuesped("23345567");
//          System.out.println("Buscar huésped por DNI:  "+ dataH.buscarHuespedPorDni("234666786"));
//        Huesped huesped = new Huesped("Ciro", "Del Barco", "234666786", "La Rioja", "Ciro_example@gmail.com", "234555677");
//        Huesped huespedModi = dataH.buscarHuespedPorDni("234666786");
//
//        System.out.println(huespedModi);
//
//        dataH.modificarDatosHuesped(huespedModi.getIdHuesped(), huesped);
//      
//
//     Huesped huesped = new Huesped("Elsa", "Rivero", "678886", "San Luis", "Elsa_example@gmail.com", "6666577",true);
//     dataH.crearHuesped(huesped);

        
//        Habitacion habitacion213= dataHabi.buscarHabitacion(213);
//        System.out.println("La habitacion buscada es la 213: "+habitacion213);
//        
//        Habitacion habitacion313= new Habitacion (313, 9, 3, true);
//        dataHabi.cargarHabitacion(habitacion313);
////        
//        Modificacion de habitacion
//        dataHabi.modificarHabitacion(habitacion213b);


//Crear una reserva
//Reserva_huesped reserva = new Reserva_huesped(5, 4, 3, LocalDate.of(2022,4,21), LocalDate.of(2022,4,25), 12000, true);
//dataRes.crearReserva(reserva);

//List<Reserva_huesped> buscarReserva=dataRes.buscarReservaPorIdHuesped(5);
//
//        System.out.println("Las reservas encontradas son: "+ buscarReserva);


        System.out.println("Buscar por cantidad de personas: " + dataT.buscarCantidadPersonas(4));
        System.out.println("Listar TODOS Huesped: " + dataH.listarTodoHuesped());
//        System.out.println("Listar categorias: " +dataT.listarCategorias());
        System.out.println("Listar categorias: " +dataT.listarCategoriasID());
        System.out.println("Buscar habitacion 213 : "+ dataHabi.buscarHabitacion(213));
        
       System.out.println("Buscar habitaciones disponibles: " + dataHabi.habitacionesDisponibles(Date.valueOf("2023-02-10"), Date.valueOf("2023-05-02")));

        
        
    }


}



    



package hotel_ideal_grupo50;

import hotel_ideal_grupo50.AccesoDatos.HabitacionData;
import hotel_ideal_grupo50.AccesoDatos.HuespedData;
import hotel_ideal_grupo50.AccesoDatos.ReservaData;
import hotel_ideal_grupo50.AccesoDatos.TipoHabitacionData;
import hotel_ideal_grupo50.Entidades.Habitacion;
import hotel_ideal_grupo50.Entidades.Huesped;
import hotel_ideal_grupo50.Entidades.Tipo_Habitacion;

public class Hotel_Ideal_Grupo50 {

   
    public static void main(String[] args) {
      
        HuespedData dataH = new HuespedData();
        HabitacionData dataHabi = new HabitacionData();
        ReservaData dataR= new ReservaData();
        TipoHabitacionData dataT= new TipoHabitacionData ();
        
        
        Tipo_Habitacion tipo1= new Tipo_Habitacion("Estándar", 3, 3, "1 cama matrimonial y 1 cama individual", 10000);
        
        Habitacion habitacion=new Habitacion (13, 9, 1, true);
        
        
       
        
//        dataH.crearHuesped(huesped);
//        dataT.crearTipoHabitacion(tipo1);
 //       dataHabi.cargarHabitacion(habitacion);
   //     dataH.borrarHuesped("23345567");
   
    //  System.out.println("Buscar huésped por DNI:  "+ dataH.buscarHuespedPorDni("234666786"));
        
       Huesped huesped= new Huesped("María", "Luisa", "345666789", "La Pampa", "MariaL_example@gmail.com", "234555677");
     Huesped huespedModi = dataH.buscarHuespedPorDni("345666789");
     
        System.out.println(huespedModi);
     
        dataH.modificarDatosHuesped(huespedModi.getIdHuesped(),huesped);
    }
    
    
}

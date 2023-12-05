/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @author David
 */
public abstract class Vehiculo {
    protected String placa;
    protected Date fecha;
    protected Time horaIngreso;
    protected Time horaSalida;
    protected String tipoVehiculo;
    protected Integer tarifa;
    protected Double tiempo;
    protected Double pago;
    
    
    // Constructor sin parámetros (por defecto)
    public Vehiculo(String placa) {
        // Puedes inicializar los atributos con valores por defecto si lo deseas
        this.placa = placa;
        this.fecha = new Date(System.currentTimeMillis());
      
        this.horaIngreso = new Time(System.currentTimeMillis());
        this.horaSalida = new Time(System.currentTimeMillis());
        this.tipoVehiculo = "";
        this.tarifa =0;
        this.tiempo = 0.0;
        this.pago =0.0;
    }
    
    public abstract void setplaca(String placa);
    public abstract String getplaca();
    public abstract void setfecha(Date fecha);
    public abstract Date getfecha();
    public abstract void sethoraIngreso(Time horaIngreso);
    public abstract Time gethoraIngreso();
    public abstract void sethoraSalida(Time HoraSalida);
    public abstract Time gethoraSalida();
    public abstract void settipoVechiculo(String tipoVehiculo);
    public abstract String gettipoVechiculo();
    public abstract void settarifa(Integer tarifa);
    public abstract Integer gettarifa();
    public abstract void settiempo(Double tiempo);
    public abstract Double gettiempo();
    public abstract void setpago(Double pago);
    public abstract Double getpago();
    
}

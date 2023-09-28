/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;


/**
 *
 * @author David
 */
public class operaciones {
    final String  tabla = "vehiculos";
    
    public void guardar(Connection conexion){
        try {
 
        PreparedStatement guardar;
        
        guardar = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                "(placa,fecha,horaIngreso,horaSalida,tipoVehiculo) VALUES(?,?,?,?,?)");
        
        Date fechaActual = new Date(System.currentTimeMillis());
        Calendar calendario = Calendar.getInstance();
        Time horaActual = new Time(calendario.getTimeInMillis());
        
        guardar.setString(1, capturarDatos("Ingrese placa"));
        guardar.setDate(2, fechaActual);
        guardar.setTime(3, horaActual);
        guardar.setTime(4,horaActual);
        guardar.setString(5, capturarDatos("ingrese tipo de vechiculo"));
        
        
        
        
        guardar.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void borrar(Connection conexion){
        try  {
           PreparedStatement borrar;
           
           borrar= conexion.prepareStatement("DELETE FROM vehiculos WHERE placa =?");
           
           borrar.setString(1,capturarDatos("que placa deseas borrar"));
           borrar.executeUpdate();
           System.out.println("los datos fueron borrados ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrarTodo(Connection conexion){
        try  {
           PreparedStatement borrar;
           
           borrar= conexion.prepareStatement("DELETE FROM vehiculos");
           
           
           borrar.executeUpdate();
           System.out.println("todos los datos fueron borrados ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modificar(Connection conexion){
        try  {
            PreparedStatement modificar;
            
            modificar = conexion.prepareStatement("UPDATE vehiculos SET placa = ?, fecha = ?, horaIngreso = ?, horaSalida = ?, tipoVehiculo = ? WHERE placa = ?");
           
            modificar.setString(6, capturarDatos("cual placa vamos a modificar"));
            modificar.setString(1, capturarDatos("ingrese la nueva placa"));
            
            modificar.setDate(2,Date.valueOf(capturarDatos("ingrese la nueva fecha")) );
            modificar.setTime(3,Time.valueOf(capturarDatos("ingrese la nueva hora de ingreso")));
            modificar.setTime(4, Time.valueOf(capturarDatos("ingrese la nueva hora de salida")));
            modificar.setString(5, capturarDatos("ingrese el nuevo tipo de vehiculo"));
            
            
            
            // Ejecuta la actualización de datos
            modificar.executeUpdate();

            // Verifica cuántas filas se actualizaron
            System.out.println("Se actualizaron datos ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void consulta(Connection conexion){
        try  {
           PreparedStatement consulta;
           
           consulta= conexion.prepareStatement("SELECT * FROM vehiculos WHERE placa = ?");
           consulta.setString(1, capturarDatos("que placa deseas consultar?"));
           
           ResultSet resultSet = consulta.executeQuery();
           while (resultSet.next()) {
                // Recupera los valores de las columnas
                String columna1 = resultSet.getString("placa");
                Date columna2 = resultSet.getDate("fecha");
                Time columna3 = resultSet.getTime("horaIngreso");
                Time columna4 = resultSet.getTime("horaSalida");
                String columna5 = resultSet.getString("tipoVehiculo");
                // Realiza alguna acción con los resultados
                System.out.println("placa: " + columna1 + ", fecha: " + columna2+" HoraIngreso: "+columna3+" horaSalida: "+columna4+" tipoVehiculo: "+columna5);
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void salidaVehiculo(Connection conexion){
        try  {
            PreparedStatement modificar;
            
            modificar = conexion.prepareStatement("UPDATE vehiculos SET horaSalida = ? WHERE placa = ?");
            Calendar calendario = Calendar.getInstance();
            Time horaActual = new Time(calendario.getTimeInMillis());
           
            modificar.setString(2, capturarDatos("cual placa vamos a modificar"));
            
            modificar.setTime(1, horaActual);
           
            
            
            
            // Ejecuta la actualización de datos
            modificar.executeUpdate();

            // Verifica cuántas filas se actualizaron
            System.out.println("Se actualizo la hora de salida ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String capturarDatos(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        String tomadeDatos;
        tomadeDatos = scanner.nextLine();
        
        return tomadeDatos;
    }
}

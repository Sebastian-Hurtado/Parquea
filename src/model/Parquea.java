/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Scanner;
import modelview.Vehiculo;

public class Parquea {

    public static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/parquea";
    final String  tabla = "vehiculos";
    public static void Conectar() throws SQLException{
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }
           
        
    }

    public void guardar(Vehiculo vehiculo) throws SQLException{
        if(con==null){
            Conectar();
        }
        try {
 
        PreparedStatement guardar;
        Connection conexion = (Connection) con;
        
        guardar = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                "(placa,fecha,horaIngreso,horaSalida,tipoVehiculo,tarifa,tiempo,pago) VALUES(?,?,?,?,?,?,?,?)");
        
        java.util.Date utilDate = vehiculo.getfecha();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        
        guardar.setString(1,vehiculo.getplaca());
        guardar.setDate(2, sqlDate);
        guardar.setTime(3,vehiculo.gethoraIngreso());
        guardar.setTime(4,vehiculo.gethoraSalida());
        guardar.setString(5,vehiculo.gettipoVechiculo());
        guardar.setInt(6, vehiculo.gettarifa());
        guardar.setDouble(7, vehiculo.gettiempo());
        guardar.setDouble(8,vehiculo.getpago());
        
        
        
        guardar.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void borrar(String vehiculo) throws SQLException{
        if(con==null){
            Conectar();
        }
        try  {
           PreparedStatement borrar;
           Connection conexion = (Connection) con;
           
           borrar= conexion.prepareStatement("DELETE FROM vehiculos WHERE placa =?");
           
           borrar.setString(1,vehiculo);
           borrar.executeUpdate();
           System.out.println("los datos fueron borrados ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    
    public void modificar(Vehiculo vehiculo,String placaCambio) throws SQLException{
        if (con == null) {
            Conectar();
        }
        try  {
            PreparedStatement modificar;
            Connection conexion = (Connection) con;
            
            modificar = conexion.prepareStatement("UPDATE vehiculos SET placa = ?, fecha = ?, horaIngreso = ?, horaSalida = ?, tipoVehiculo = ?,tarifa = ?, tiempo=?, pago=? WHERE placa = ?");
           
            
            
            modificar.setString(9, placaCambio);
            modificar.setString(1, vehiculo.getplaca());
            modificar.setDate(2, (Date) vehiculo.getfecha());
            modificar.setTime(3,vehiculo.gethoraIngreso());
           
            modificar.setTime(4,vehiculo.gethoraSalida());
            modificar.setString(5, vehiculo.gettipoVechiculo());
            modificar.setInt(6,vehiculo.gettarifa());
            modificar.setDouble(7, vehiculo.gettiempo());
            modificar.setDouble(8, vehiculo.getpago());
            

            
            
//             Ejecuta la actualización de datos
            modificar.executeUpdate();

            // Verifica cuántas filas se actualizaron
            System.out.println("Se actualizaron datos ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet consulta(String placa) throws SQLException{
        if (con == null) {
            Conectar();
        }
        ResultSet vehiculo = null;
        try  {
           PreparedStatement consulta;
           Connection conexion = (Connection) con;
           consulta= conexion.prepareStatement("SELECT * FROM vehiculos WHERE placa = ?");
           consulta.setString(1, placa);
           
           vehiculo = consulta.executeQuery();

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return vehiculo;
    }
    
    
    
    public ResultSet recuperarDatos() throws SQLException {
        if (con == null) {
            Conectar();
        }
        ResultSet vehiculos = null;
        try {
        PreparedStatement consulta;
        Connection conexion = (Connection) con;
        consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla);
        vehiculos = consulta.executeQuery(); 
        
       
        
        } catch (SQLException e) {
            System.out.println(e);
        }
         return vehiculos;
    }
    
}

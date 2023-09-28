/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parquea;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Parquea {

    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/parquea";
    public static void main(String[] args) throws SQLException{
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }
           
        operaciones operacion = new operaciones();
        
        operacion.guardar(con);
        //operacion.modificar(con);
        //operacion.borrar(con);
        
        //operacion.borrarTodo(con);
        operacion.salidaVehiculo(con);
        operacion.consulta(con);
    }
    public void finalizar (Connection conexion){
        if(conexion != null){
            try{
                conexion.close();
                conexion= null;
            }catch(SQLException ex){
                System.out.println(ex.getMessage()+"error");
            } 
        }       
    }
    
}

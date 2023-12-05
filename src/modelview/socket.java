/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

/**
 *
 * @author Sebas
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class socket {
    private static final String DELIMITADOR = "\0";
    public String recibirPlaca (Socket socket) {
        String placa="";
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter(DELIMITADOR);

            if (scanner.hasNext()) {
                placa = scanner.next();
                System.out.println("Resultado recibido desde Python: " + placa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return placa;
    }
    public Socket Conexion() throws IOException{
        Socket socket = new Socket("localhost", 8889);
        return socket;
    }
    public void enviarMensaje(Socket socket, String mensaje) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(mensaje.getBytes());
            System.out.println("Mensaje enviado al servidor: " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
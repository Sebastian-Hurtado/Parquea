/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import com.fazecast.jSerialComm.SerialPort;

/**
 *
 * @author Sebas
 */
public class arduino {
    private static SerialPort port;
    private volatile int distancia ;
    private int x =100;
    public void configuracion(){
        String puertoDeseado = "COM3"; 
        port = SerialPort.getCommPort(puertoDeseado);
        port.setBaudRate(9600);
        
        
        if (!port.openPort()) {
            System.err.println("Error al abrir el puerto serial.");
            
        }
        System.out.println("Puerto serial abierto con éxito.");
        
        Thread serialThread = new Thread(() -> {
            while (true) {
                distancia =recibirYMostrarDistancia();
                
                
                }
            }
        );

        // Iniciar el hilo de comunicación serial
        serialThread.start();
        
       
        
    }
    public int getDistancia() {
        return distancia;
    }
    
    public void enviarComandoArduino(String comando) {
        // Convierte el comando a bytes y envía al Arduino
        byte[] bytes = comando.getBytes();
        port.writeBytes(bytes, bytes.length);

        System.out.println("Enviando comando al Arduino: " + comando);
    }
    public Integer recibirYMostrarDistancia() {
        byte[] buffer = new byte[64];
        int len = port.readBytes(buffer, buffer.length);
        
        if (len > 0) { // Verifica que se haya leído al menos un byte
            String mensaje = new String(buffer, 0, len).trim();
            if (!mensaje.isEmpty()) {
                try{
                x = Integer.parseInt(mensaje);
                
                //System.out.println("Distancia: " + mensaje + " cm");
                }catch(NumberFormatException e){

                }
                //System.out.println(x);
            }
        }
        return x;
    } 
    public void cerrarPuertoSerie() {
        if (port != null && port.isOpen()) {
            port.closePort();
            System.out.println("Puerto serie cerrado con éxito.");
        }
    }

}

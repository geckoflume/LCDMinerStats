package lcdminerstats;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author geckoflume
 */
public class Serial {

    private final String port;
    private SerialPort serialPort;

    public Serial(String port) {
        this.port = port;
    }

    public void open() {
        try {
            serialPort = new SerialPort(port);
            serialPort.openPort();

            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN
                    | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            TimeUnit.SECONDS.sleep(3); //Wait until Arduino bootup
        } catch (SerialPortException | InterruptedException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean send(String s) {
        try {
            serialPort.writeString(s + '\r');
            return true;
        } catch (SerialPortException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

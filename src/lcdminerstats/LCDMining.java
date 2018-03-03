package lcdminerstats;

import java.util.Timer;
import jssc.SerialPort;

/**
 *
 * @author geckoflume
 */
public class LCDMining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Serial serial = new Serial("/dev/ttyUSB2", SerialPort.BAUDRATE_115200);
        serial.open();

        Miner miner = new Miner("ETH", "MH/s", "DCR", "MH/s", 1, serial);
        miner.connect("192.168.1.122", 3333);
        miner.parse();

        miner.initDisplay();

        Timer timer = new Timer();
        timer.schedule(new RefreshTimer(miner), 0, 10000);
    }

}

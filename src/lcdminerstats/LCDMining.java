package lcdminerstats;

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
        Miner miner = new Miner("ETH", "MH/s", "DCR", "MH/s", 1);
        miner.connect("192.168.1.122", 3333);
        miner.parse();

        Serial serial = new Serial("/dev/ttyUSB2", SerialPort.BAUDRATE_115200);
        serial.open();
        miner.initDisplay(serial);
    }

}

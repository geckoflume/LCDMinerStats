package lcdminerstats;

/**
 *
 * @author geckoflume
 */
public class LCDMining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Miner miner = new Miner("eth", "dcr", 1);
        miner.connect("192.168.1.122", 3333);
        miner.parse();
        
        Serial serial = new Serial("/dev/ttyUSB1");
        serial.open();
    }
    
}

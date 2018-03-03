package lcdminerstats;

import java.util.Timer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geckoflume
 */
public class LCDMining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("config.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();

            Serial serial = new Serial(props.getProperty("serial.port"), 115200);
            serial.open();

            Miner miner = new Miner(
                    props.getProperty("currency1.name"),
                    props.getProperty("currency1.unit"),
                    props.getProperty("currency2.name"),
                    props.getProperty("currency2.unit"),
                    Integer.parseInt(props.getProperty("gpus")),
                    serial);
            miner.connect(
                    props.getProperty("host.ip"),
                    Integer.parseInt(props.getProperty("host.port")));
            miner.parse();

            miner.initDisplay();

            Timer timer = new Timer();
            timer.schedule(new RefreshTimer(miner), 0, Integer.parseInt(props.getProperty("refreshrate")));
        } catch (IOException ex) {
            Logger.getLogger(LCDMining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

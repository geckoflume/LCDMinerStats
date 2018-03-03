package lcdminerstats;

import java.util.TimerTask;

/**
 *
 * @author geckoflume
 */
public class RefreshTimer extends TimerTask {

    private Miner miner;

    public RefreshTimer(Miner miner) {
        this.miner = miner;
    }

    public void run() {
        miner.parse();
        miner.updateDisplay();
    }

}

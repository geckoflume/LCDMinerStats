package lcdminerstats;

/**
 *
 * @author geckoflume
 */
public class Miner {

    private Connexion con;
    private int min;
    private Currency eth;
    private Currency dcr;
    private GPU[] gpus;
    private Serial serial;

    public Miner(String c1, String u1, String c2, String u2, int gpuCount, Serial serial) {
        this.min = 0;
        this.eth = new Currency(c1, u1);
        this.dcr = new Currency(c2, u2);
        this.gpus = new GPU[gpuCount];
        for (int i = 0; i < gpuCount; i++) {
            this.gpus[i] = new GPU();
        }
        this.serial = serial;
    }

    public void connect(String ip, int port) {
        this.con = new Connexion(ip, port);
    }

    public void parse() {
        Parse parse = new Parse();
        parse.parseResult(this.con.request());
        parse.parseTime(this);
        parse.parseAllCurstat(this.eth, this.dcr);
        parse.parseGpustat(gpus);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void initDisplay() {
        this.serial.sendVar(SerialVars.C1, this.eth.getName());
        this.serial.sendVar(SerialVars.C2, this.dcr.getName());
        this.serial.sendVar(SerialVars.U1, this.eth.getUnit());
        this.serial.sendVar(SerialVars.U2, this.dcr.getUnit());
        updateDisplay();
    }

    public void updateDisplay() {
        this.serial.sendVar(SerialVars.C1, this.eth.getName());
        this.serial.sendVar(SerialVars.C2, this.dcr.getName());
        this.serial.sendVar(SerialVars.U1, this.eth.getUnit());
        this.serial.sendVar(SerialVars.U2, this.dcr.getUnit());
        this.serial.sendVar(SerialVars.UPTIME, String.valueOf(this.min));
        this.serial.sendVar(SerialVars.HR1, String.valueOf(this.eth.getHr()));
        this.serial.sendVar(SerialVars.HR2, String.valueOf(this.dcr.getHr()));
        this.serial.sendVar(SerialVars.SHARES1, String.valueOf(this.eth.getShares()));
        this.serial.sendVar(SerialVars.SHARES2, String.valueOf(this.dcr.getShares()));
        this.serial.sendVar(SerialVars.REJECTED1, String.valueOf(this.eth.getRejected()));
        this.serial.sendVar(SerialVars.REJECTED2, String.valueOf(this.dcr.getRejected()));
        this.serial.sendVar(SerialVars.INVALID1, String.valueOf(this.eth.getInvalid()));
        this.serial.sendVar(SerialVars.INVALID2, String.valueOf(this.dcr.getInvalid()));
        this.serial.sendVar(SerialVars.TEMP, String.valueOf(this.gpus[0].getTemp()));
        this.serial.sendVar(SerialVars.FAN, String.valueOf(this.gpus[0].getFan()));
        this.serial.sendVar(SerialVars.REFRESH, String.valueOf(0));
    }
}

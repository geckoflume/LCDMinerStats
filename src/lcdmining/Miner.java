package lcdmining;

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

    public Miner(String c1, String c2, int gpuCount) {
        this.min = 0;
        this.eth = new Currency(c1);
        this.dcr = new Currency(c2);
        this.gpus = new GPU[gpuCount];
        for (int i = 0; i < gpuCount; i++) {
            this.gpus[i] = new GPU();
        }
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

}

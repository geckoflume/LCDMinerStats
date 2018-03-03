package lcdmining;

import com.google.gson.*;

/**
 *
 * @author geckoflume
 */
public class Parse {

    private int min;
    private String[] currencyStat;
    private String gpustat;
    private String errstat;

    public Parse() {
        this.min = 0;
        this.currencyStat = new String[2];
        this.gpustat = "";
        this.errstat = "";
    }

    void parseResult(String json) {
        Gson gson = new Gson();

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray array = jsonObject.get("result").getAsJsonArray();

        this.min = gson.fromJson(array.get(1), int.class);
        this.currencyStat[0] = gson.fromJson(array.get(2), String.class);
        this.currencyStat[1] = gson.fromJson(array.get(4), String.class);
        this.gpustat = gson.fromJson(array.get(6), String.class);
        this.errstat = gson.fromJson(array.get(8), String.class);
    }

    public void parseTime(Miner m) {
        m.setMin(min);
    }

    private void parseCurstat(int curNum, Currency c) {
        String[] parts = this.currencyStat[curNum].split(";");
        c.setHr(Integer.parseInt(parts[0]));
        c.setShares(Integer.parseInt(parts[1]));
        c.setRejected(Integer.parseInt(parts[2]));
    }

    private void parseErrstat(Currency c1, Currency c2) {
        String[] parts = this.errstat.split(";");
        c1.setInvalid(Integer.parseInt(parts[0]));
        c2.setInvalid(Integer.parseInt(parts[2]));
    }

    public void parseAllCurstat(Currency c1, Currency c2) {
        parseCurstat(0, c1);
        parseCurstat(1, c2);
        parseErrstat(c1, c2);
    }

    public void parseGpustat(GPU[] g) {
        String[] parts = this.gpustat.split(";");
        for (int i = 0; i < parts.length / 2; i++) {
            g[i].setTemp(Integer.parseInt(parts[i]));
            g[i].setFan(Integer.parseInt(parts[i + 1]));
        }
    }
}

package lcdmining;

/**
 *
 * @author geckoflume
 */
public class GPU {

    private int hr;
    private int fan;
    private int temp;

    /**
     * @return the hr
     */
    public int getHr() {
        return hr;
    }

    /**
     * @param hr the hr to set
     */
    public void setHr(int hr) {
        this.hr = hr;
    }

    /**
     * @return the fan
     */
    public int getFan() {
        return fan;
    }

    /**
     * @param fan the fan to set
     */
    public void setFan(int fan) {
        this.fan = fan;
    }

    /**
     * @return the temp
     */
    public int getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }
}

package lcdminerstats;

/**
 *
 * @author geckoflume
 */
public class Currency {

    private final String name;
    private int hr;
    private int shares;
    private int rejected;
    private int invalid;
    private final String unit;

    public Currency(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }

    public int getInvalid() {
        return invalid;
    }

    public void setInvalid(int invalid) {
        this.invalid = invalid;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}

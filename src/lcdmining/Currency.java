package lcdmining;

/**
 *
 * @author geckoflume
 */
public class Currency {

    private String name;
    private int hr;
    private int shares;
    private int rejected;
    private int invalid;

    public Currency(String name) {
        this.name = name;
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

}

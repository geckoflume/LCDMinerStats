package lcdminerstats;

/**
 *
 * @author geckoflume
 */
public enum SerialVars {
    C1("0"),
    C2("1"),
    U1("2"),
    U2("3"),
    UPTIME("4"),
    HR1("5"),
    HR2("6"),
    SHARES1("7"),
    SHARES2("8"),
    REJECTED1("9"),
    REJECTED2("10"),
    INVALID1("11"),
    INVALID2("12"),
    TEMP("13"),
    FAN("14"),
    REFRESH("15");

    private final String varId;

    SerialVars(String varId) {
        this.varId = varId;
    }

    public String getVarId() {
        return this.varId;
    }
}

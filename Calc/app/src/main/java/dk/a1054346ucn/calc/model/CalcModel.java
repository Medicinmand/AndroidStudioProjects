package dk.a1054346ucn.calc.model;

/**
 * Created by martin on 13-02-2017.
 */

public class CalcModel implements ICalcModel {
    @Override
    public double add(double v1, double v2) {
        return v1+v2;
    }

    @Override
    public double subtract(double v1, double v2) {
        return v1-v2;
    }

    @Override
    public double multiply(double v1, double v2) {
        return v1*v2;
    }

    @Override
    public double divide(double v1, double v2) {
        return v1/v2;
    }
}

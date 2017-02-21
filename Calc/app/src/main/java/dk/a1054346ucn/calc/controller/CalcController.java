package dk.a1054346ucn.calc.controller;

import java.util.List;
import java.util.Objects;

import dk.a1054346ucn.calc.model.CalcModel;
import dk.a1054346ucn.calc.model.ICalcModel;

/**
 * Created by marti on 13-02-2017.
 */

public class CalcController implements ICalcController {

    ICalcModel model = new CalcModel();

    @Override
    public String calculate(String function) {
        String[] templist = function.split(" ");

        double v1 = Double.parseDouble(templist[0]);
        double v2 = Double.parseDouble(templist[2]);
        String operator = templist[1];
        double result = 0;

        if (operator.equals("+")){
            result = model.add(v1,v2);
        }
        if (operator.equals("-")){
            result = model.subtract(v1,v2);
        }
        if (operator.equals("*")){
            result = model.multiply(v1,v2);
        }
        if (operator.equals("/")){
            result = model.divide(v1,v2);
        }        
        return String.valueOf(result);
    }
}

package CASprzak.UnitaryFunctions;

import CASprzak.BinaryFunctions.Pow;
import CASprzak.CommutativeFunctions.Add;
import CASprzak.CommutativeFunctions.Multiply;
import CASprzak.Function;
import CASprzak.SpecialFunctions.Constant;
public class Atan extends UnitaryFunction {
    public Atan(Function function) {
        super(function);
    }

    @Override
    public Function getDerivative(int varID) {
        return new Multiply(function.getSimplifiedDerivative(varID), new Add(new Constant(1), new Pow(new Constant(-2), function)));
    }

    @Override
    public double evaluate(double... variableValues) {
        return Math.atan(function.evaluate(variableValues));
    }

    public Function clone() {
        return new Atan(function.clone());
    }

    public UnitaryFunction simplifyInternal() {
        return new Atan(function.simplify());
    }

    public int compareTo( Function f) {
        return 0;
    }
}

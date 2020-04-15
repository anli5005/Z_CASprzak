package functions.unitary;

import functions.Function;
import functions.commutative.Multiply;

public class Cosh extends UnitaryFunction {
	public Cosh(Function function) {
		super(function);
	}

	@Override
	public double evaluate(double... variableValues) {
		return Math.cosh(function.evaluate(variableValues));
	}

	@Override
	public Function getDerivative(int varID) {
		return new Multiply(new Sinh(function), function.getSimplifiedDerivative(varID));
	}

	public UnitaryFunction me(Function operand) {
		return new Cosh(operand);
	}

}
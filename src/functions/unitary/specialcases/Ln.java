package functions.unitary.specialcases;

import functions.GeneralFunction;
import functions.binary.BinaryFunction;
import functions.binary.Logb;
import functions.binary.Pow;
import functions.commutative.Product;
import functions.special.Constant;
import functions.unitary.UnitaryFunction;
import tools.DefaultFunctions;

import java.util.Map;


public class Ln extends SpecialCaseBinaryFunction {
	/**
	 * Constructs a new Ln
	 * @param operand The function which natural log is operating on
	 */
	public Ln(GeneralFunction operand) {
		super(operand);
	}

	@Override
	public double evaluate(Map<Character, Double> variableValues) {
		return Math.log(operand.evaluate(variableValues));
	}

	@Override
	public GeneralFunction getDerivative(char varID) {
		return new Product(operand.getSimplifiedDerivative(varID), DefaultFunctions.reciprocal(operand));
	}

	public UnitaryFunction me(GeneralFunction operand) {
		return new Ln(operand);
	}

	public BinaryFunction getClassForm() {
		return new Logb(operand, DefaultFunctions.E);
	}

	public Class<?> getInverse() {
		return Exp.class;
	}
}

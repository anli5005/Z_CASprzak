package functions.unitary.trig.inverse;

import config.Settings;
import functions.GeneralFunction;
import functions.binary.Pow;
import functions.binary.integer.Modulo;
import functions.commutative.Product;
import functions.commutative.Sum;
import functions.unitary.UnitaryFunction;
import functions.unitary.piecewise.Abs;
import functions.unitary.trig.normal.Sin;
import tools.DefaultFunctions;

import java.util.Map;


public class Asin extends InverseTrigFunction {

	/**
	 * Constructs a new {@link Asin}
	 * @param operand The function which arcsin is operating on
	 */
	public Asin(GeneralFunction operand) {
		super(operand);
	}

	/**
	 * Returns the inverse sine of the stored {@link #operand} evaluated
	 * @param variableValues The values of the variables of the {@link GeneralFunction} at the point
	 * @return the sin of {@link #operand} evaluated
	 */
	@Override
	public double evaluate(Map<String, Double> variableValues) {
		return Math.asin(operand.evaluate(variableValues));
	}

	@Override
	public GeneralFunction getDerivative(String varID) {
		return new Product(operand.getSimplifiedDerivative(varID), new Pow(DefaultFunctions.NEGATIVE_HALF, (new Sum(DefaultFunctions.ONE, DefaultFunctions.negative(new Pow(DefaultFunctions.TWO, operand))))));
	}


	public UnitaryFunction getInstance(GeneralFunction operand) {
		return new Asin(operand);
	}

	public Class<?> getInverse() {
		return Sin.class;
	}

	@Override
	public GeneralFunction simplifyInverse() {
		if (operand.getClass().isAssignableFrom(getInverse())) {
			GeneralFunction insideFunction = ((UnitaryFunction) operand).operand;
			if (Settings.enforceDomainAndRange)
				return DefaultFunctions.subtract(new Abs(DefaultFunctions.subtract(new Modulo(DefaultFunctions.TWO_PI, DefaultFunctions.subtract(insideFunction, DefaultFunctions.HALF_PI)), DefaultFunctions.PI)), DefaultFunctions.HALF_PI);
			else
				return insideFunction;
		} else
			return this;
	}
}

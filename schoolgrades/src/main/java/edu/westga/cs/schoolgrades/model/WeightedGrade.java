package edu.westga.cs.schoolgrades.model;

/**
 * This class extends GradeDecorator and therefore forwards its calculations to
 * the GradeStrategy. It applies a weight of .05 to the value and forwards it
 * using the getValue method.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 *
 */
public class WeightedGrade extends GradeDecorator {

	public WeightedGrade(Grade next) {
		super(next);
	}

	/**
	 * Calculates a weight based on the original value and .05
	 * 
	 * @return double Grade's weight
	 */
	private double applyWeight() {
		return super.getValue() * 0.05;

	}

	/**
	 * Returns the new calculated value.
	 */
	@Override
	public double getValue() {
		return (this.applyWeight() + super.getValue());
	}
}

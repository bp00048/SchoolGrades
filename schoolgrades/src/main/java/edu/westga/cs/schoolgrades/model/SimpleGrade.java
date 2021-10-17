package edu.westga.cs.schoolgrades.model;

/**
 * A Grade object that holds a double value and can return that value.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 *
 */
public class SimpleGrade implements Grade {
	private double gradeValue;

	public SimpleGrade(double gradeValue) {
		this.gradeValue = gradeValue;
	}

	@Override
	public double getValue() {
		return this.gradeValue;
	}

}

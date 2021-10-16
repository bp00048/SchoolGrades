/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

/**
 * @author windy
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

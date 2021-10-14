/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

/**
 * @author windy
 *
 */
public class SimpleGrade implements Grade {
	private double grade;

	public SimpleGrade(double gradeValue) {
		this.grade = gradeValue;
	}

	@Override
	public double getValue() {

		return this.grade;
	}

}

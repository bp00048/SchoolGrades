package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * A GradeStrategy that sums the total values of the Grade objects and returns a
 * new Grade object with that value.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 *
 */

public class SumGrade implements GradeStrategy {
	ArrayList<Grade> gradeList;

	/**
	 * Creates a Grade object with the value of all the grade's total sum.
	 */
	@Override
	public Grade calculateGrade(ArrayList<Grade> grades) {
		this.gradeList = grades;
		double sum = 0;
		for (Grade current : gradeList) {
			sum += current.getValue();
		}
		SimpleGrade newGrade = new SimpleGrade(sum);
		return newGrade;
	}

}

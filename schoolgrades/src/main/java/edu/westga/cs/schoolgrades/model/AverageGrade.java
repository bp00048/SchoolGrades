/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This class implements a GradeStrategy that calculates the average of all the
 * grades and returns the new grade.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 * 
 */
public class AverageGrade implements GradeStrategy {
	ArrayList<Grade> gradeList;

	/**
	 * Calculates the average and returns a new Grade object with that average as
	 * the value. If the value is zero, then zero is returned to avoid dividing by
	 * zero.
	 */
	@Override
	public Grade calculateGrade(ArrayList<Grade> grades) {
		this.gradeList = grades;
		double sum = 0;
		for (Grade current : gradeList) {
			sum += current.getValue();
		}
		if (sum == 0) {
			SimpleGrade newGrade = new SimpleGrade(0);
			return newGrade;
		} else {
			sum = Double.parseDouble(String.format("%.2f", sum / this.gradeList.size()));
			SimpleGrade newGrade = new SimpleGrade(sum);
			return newGrade;
		}
	}

}

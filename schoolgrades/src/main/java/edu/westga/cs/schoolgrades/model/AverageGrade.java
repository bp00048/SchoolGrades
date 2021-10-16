/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author windy
 *
 */
public class AverageGrade implements GradeStrategy {
	ArrayList<Grade> gradeList;

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

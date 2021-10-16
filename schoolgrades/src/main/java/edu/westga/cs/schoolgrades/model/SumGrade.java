/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author Blair Pattison
 *
 */
public class SumGrade implements GradeStrategy {
	ArrayList<Grade> gradeList;

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

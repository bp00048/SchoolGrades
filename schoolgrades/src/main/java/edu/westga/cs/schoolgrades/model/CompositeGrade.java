package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This Grade holds an array list of Grades and calculates a Grade object
 * depending on the type of GradingStrategy passed to it.
 * 
 * @author Blair Pattison
 * @author 10/16/2021
 * 
 */

public class CompositeGrade implements Grade {
	ArrayList<Grade> gradeList = new ArrayList<Grade>();
	GradeStrategy currentStrategy;
	double gradeValue;

	/**
	 * Initializes the list of Grades
	 */
	public CompositeGrade() {
		this.gradeList = new ArrayList<Grade>();

	}

	/**
	 * Adds a Grade to the list.
	 * 
	 * @param newGrade The new Grade object to be added.
	 */
	public void addGrade(Grade newGrade) {
		this.gradeList.add(newGrade);

	}

	/**
	 * Removes a Grade from the list.
	 * 
	 * @param newGrade The new Grade object to be removed.
	 */
	public void removeGrade(Grade newGrade) {
		this.gradeList.remove(newGrade);

	}

	/**
	 * Returns the value of the Grade calculated based on the strategy implemented.
	 * 
	 */
	public double getValue() {
		return this.currentStrategy.calculateGrade(this.gradeList).getValue();

	}

	/**
	 * Sets the grading strategy necessary for the CompositeGrade to be calculated
	 * on.
	 * 
	 * @param chosenStrategy The Strategy to calculate the grade.
	 */
	public void setStrategy(GradeStrategy chosenStrategy) {
		this.currentStrategy = chosenStrategy;
	}
}

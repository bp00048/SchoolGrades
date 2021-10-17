/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This class extends GradeStrategyDecorator and therefore forwards its
 * calculations to the GradeStrategy. It drops the lowest grade in the sequences
 * and forwards the list to the strategy.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 * 
 */

public class DroppedGrade extends GradeStrategyDecorator {
	private ArrayList<Grade> gradeList;

	public DroppedGrade(GradeStrategy next) {
		super(next);

	}

	/**
	 * Finds the lowest Grade in the list and removes it.
	 */
	private void dropLowestGrade() {
		Grade smallestGrade = this.gradeList.get(0);
		for (Grade current : this.gradeList) {
			if (current.getValue() < smallestGrade.getValue()) {
				smallestGrade = current;
			}
		}
		this.gradeList.remove(smallestGrade);
	}

	/**
	 * After dropping the lowest Grade, the list is forwarded to the super's
	 * (GradeStrategy)'s calculateGrade method.
	 */
	@Override
	public Grade calculateGrade(ArrayList<Grade> grades) {
		this.gradeList = grades;
		this.dropLowestGrade();
		return super.calculateGrade(this.gradeList);

	}

}

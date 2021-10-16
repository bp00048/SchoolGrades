/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author windy
 *
 */
public class DroppedGrade extends GradeStrategyDecorator {
	private GradeStrategy next;
	private ArrayList<Grade> gradeList;

	public DroppedGrade(GradeStrategy next) {
		super(next);
		this.next = next;

	}

	private void dropLowestGrade() {
		Grade smallestGrade = this.next.getGrades().get(0);
		for (Grade current : this.next.getGrades()) {
			if (current.getValue() < smallestGrade.getValue()) {
				smallestGrade = current;
			}
		}
		this.gradeList.remove(smallestGrade);
	}

	@Override
	public ArrayList<Grade> getGrades() {
		this.dropLowestGrade();
		return this.gradeList;
	}
}

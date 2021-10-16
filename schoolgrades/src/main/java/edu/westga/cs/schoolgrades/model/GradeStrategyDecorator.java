/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author windy
 *
 */
public abstract class GradeStrategyDecorator implements GradeStrategy {
	private GradeStrategy next;

	public GradeStrategyDecorator(GradeStrategy next) {
		this.next = next;
	}

	@Override
	public Grade calculateGrade(ArrayList<Grade> grades) {
		return this.next.calculateGrade(grades);
	};

}

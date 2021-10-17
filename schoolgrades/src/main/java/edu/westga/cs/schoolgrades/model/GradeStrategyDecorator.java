/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * This class implements GradeStrategy. In order to anticipate other decorator
 * classes in the future, it is abstract. It follows the decorator pattern by
 * forwarding the original GradeStrategy object's calculcateGrade method.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
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

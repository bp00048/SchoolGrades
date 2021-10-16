package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author Blair Pattison
 *
 */
public class CompositeGrade implements Grade {
	ArrayList<Grade> gradeList = new ArrayList<Grade>();
	GradeStrategy currentStrategy;
	Grade currentGrade;

	public CompositeGrade() {
		this.gradeList = new ArrayList<Grade>();

	}

	public void addGrade(Grade newGrade) {
		this.gradeList.add(newGrade);

	}

	public double getValue() {
		this.currentGrade = this.currentStrategy.calculateGrade(this.gradeList);
		return this.currentGrade.getValue();
		

	}

	public void setStrategy(GradeStrategy chosenStrategy) {
		this.currentStrategy = chosenStrategy;
	}
}

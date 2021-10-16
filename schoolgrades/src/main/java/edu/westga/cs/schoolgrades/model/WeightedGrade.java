package edu.westga.cs.schoolgrades.model;

public class WeightedGrade extends GradeDecorator {

	
	public WeightedGrade(Grade next) {
		super(next);
	}

	private double applyWeight() {
		return (super.getValue() + 0.5);
	}

	@Override
	public double getValue() {
		return super.getValue() + this.applyWeight();
	}
}

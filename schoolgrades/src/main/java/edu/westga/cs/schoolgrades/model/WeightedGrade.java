package edu.westga.cs.schoolgrades.model;

public class WeightedGrade implements Grade {
	private Grade currentGrade;

	public WeightedGrade(Grade currentGrade) {
		this.currentGrade = currentGrade;
		this.applyWeight();
	}

	private void applyWeight() {
		double value = this.currentGrade.getValue();
		value = (value * .05) + value;
		SimpleGrade newGrade = new SimpleGrade(value);
		this.currentGrade = newGrade;
	}

	@Override
	public double getValue() {
		return this.currentGrade.getValue();
	}
}

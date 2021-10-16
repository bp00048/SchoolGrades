package edu.westga.cs.schoolgrades.model;

public abstract class WeightedGrade implements Grade {
	private Grade currentGrade;

	public WeightedGrade(Grade currentGrade) {
		this.currentGrade = currentGrade;
		this.applyWeight();
	}

	public void applyWeight() {
		double value = this.currentGrade.getValue();
		value = (10 * value) / (10);
		SimpleGrade newGrade = new SimpleGrade(value);
		this.currentGrade = newGrade;
	}

	@Override
	public double getValue() {
		return this.currentGrade.getValue();
	}
}

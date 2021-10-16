/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

/**
 * @author windy
 *
 */
public abstract class GradeDecorator implements Grade {
	private Grade next;

	public GradeDecorator(Grade next) {
		this.next = next;
	}

	@Override
	public double getValue() {
		return this.next.getValue();
	}
	
}

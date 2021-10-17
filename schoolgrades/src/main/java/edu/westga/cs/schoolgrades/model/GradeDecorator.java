package edu.westga.cs.schoolgrades.model;

/**
 * This class implements Grade. In order to anticipate other decorator classes
 * in the future, it is abstract. It follows the decorator pattern by forwarding
 * the original Grade object's getValue method.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
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

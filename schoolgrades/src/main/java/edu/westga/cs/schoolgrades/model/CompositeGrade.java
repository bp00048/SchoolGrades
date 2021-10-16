package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author Blair Pattison
 *
 */
public class CompositeGrade implements Grade {
	ArrayList<SimpleGrade> gradeList = new ArrayList<SimpleGrade>();
	
	
	public double getValue() {
		return 0;
	}
}

/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * An interface with the method to calculate a Grade based on the arraylist of
 * Grade objects passed to it.
 * 
 * @author Blair Pattison
 * @version 10/16/2021
 */
public interface GradeStrategy {

	public Grade calculateGrade(ArrayList<Grade> grades);

}

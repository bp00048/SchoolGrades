/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * @author Blair Pattison
 *
 */
public interface GradeStrategy {
	

public Grade calculateGrade(ArrayList<Grade> grades);

}

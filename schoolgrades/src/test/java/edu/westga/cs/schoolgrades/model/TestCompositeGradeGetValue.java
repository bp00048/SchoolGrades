/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author windy
 *
 */
class TestCompositeGradeGetValue {
	Grade testGrade;
	Grade testGrade1;
	Grade testGrade2;
	CompositeGrade testCompositeGrade;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testGrade = new SimpleGrade(50);
		this.testGrade1 = new SimpleGrade(75);
		this.testGrade2 = new SimpleGrade(95);
		this.testCompositeGrade = new CompositeGrade();
	}

	@Test
	void shouldReturnTotalSum220() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 220);

	}

	@Test
	void shouldChangeSumAsGradesAdded50Then125Then220() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(testGrade);
		assertEquals(this.testCompositeGrade.getValue(), 50);
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 125);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 220);

	}

}

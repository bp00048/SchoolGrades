/**
 * 
 */
package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author windy
 *
 */
class TestWeightedGradeApplyWeight {	
Grade testGrade;
Grade testGrade1;
Grade testGrade2;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testGrade = new SimpleGrade(80);
		this.testGrade1 = new SimpleGrade(74);
		this.testGrade2 = new SimpleGrade(60);
	}

	@Test
	public void shouldReturn84AfterApplyWeight() {
		WeightedGrade testWeightedGrade = new WeightedGrade(testGrade);
		assertEquals(testWeightedGrade.getValue(), 84);
	}
	
	@Test
	public void shouldNotChangeSimpleGrade() {
		WeightedGrade testWeightedGrade = new WeightedGrade(testGrade);
		assertEquals(testWeightedGrade.getValue(), 84);
		assertEquals(this.testGrade.getValue(), 80);
	}
	
	@Test
	public void shouldApplyWeightToCompositeGradeToSingleGradeSumAndReturn84() {
		CompositeGrade testCompositeGrade = new CompositeGrade();
		testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		testCompositeGrade.setStrategy(new SumGrade());
		assertEquals(testCompositeGrade.getValue(),84);

	}
	
	@Test
	public void shouldApplyWeightToCompositeGradeToThreeGradesSumAndReturn224Point7() {
		CompositeGrade testCompositeGrade = new CompositeGrade();
		testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		testCompositeGrade.addGrade(new WeightedGrade(testGrade2));
		testCompositeGrade.setStrategy(new SumGrade());
		assertEquals(testCompositeGrade.getValue(),224.7);

	}

	@Test
	public void shouldApplyWeightToCompositeGradeAverageWithAllGradesWeightedShouldBe74Point9() {
		CompositeGrade testCompositeGrade = new CompositeGrade();
		testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		testCompositeGrade.addGrade(new WeightedGrade(testGrade2));
		testCompositeGrade.setStrategy(new AverageGrade());
		assertEquals(testCompositeGrade.getValue(),74.9);

	}
}

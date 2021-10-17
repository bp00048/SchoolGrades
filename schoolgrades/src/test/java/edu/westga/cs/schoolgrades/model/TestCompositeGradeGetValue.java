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
public class TestCompositeGradeGetValue {
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
/**
 * Sum Tests
 */
	@Test
	public void shouldReturnTotalSum220() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 220);

	}

	@Test
	public void shouldChangeSumAsGradesAdded50Then125Then220() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(testGrade);
		assertEquals(this.testCompositeGrade.getValue(), 50);
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 125);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 220);

	}
	
	/**
	 * Average Tests
	 */

	@Test
	public void shouldAverageGradeAs73Point33() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 73.33);

	}

	@Test
	public void shouldAverageGradeFrom0To0() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		SimpleGrade testGradeOfZero = new SimpleGrade(0);
		this.testCompositeGrade.addGrade(testGradeOfZero);
		assertEquals(this.testCompositeGrade.getValue(), 0);

	}

	/**
	 * Sum With Weighted Tests
	 */

	@Test
	public void shouldSumWithOneWeightedGradeAndOneSimpleShouldBe127Point5() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 127.5);

	}

	@Test
	public void shouldSumWithAllWeightedGradeShouldBe231() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade2));
		assertEquals(this.testCompositeGrade.getValue(), 231);
	}

	/**
	 * Average With Weighted Tests
	 */
	@Test
	public void shouldAverageWithAllWeightedGradeShouldBe77() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade2));
		assertEquals(this.testCompositeGrade.getValue(), 77);
	}

	@Test
	public void shouldAverageWithOneWeightedGradeAndOneSimpleShouldBe63Point75() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 63.75);

	}

	/**
	 * Remove Grade Method Tests
	 */
	@Test
	public void shouldAverageAfterRemoveGradeBe50() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 62.5);

		this.testCompositeGrade.removeGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 50);

	}

	@Test
	public void shouldAverageAfterRemoveGradeBe52point5WithWeightedGrades() {
		this.testCompositeGrade.setStrategy(new AverageGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		WeightedGrade newWeightGrade = new WeightedGrade(testGrade1);
		this.testCompositeGrade.addGrade(newWeightGrade);
		assertEquals(this.testCompositeGrade.getValue(), 65.63);

		this.testCompositeGrade.removeGrade(newWeightGrade);
		assertEquals(this.testCompositeGrade.getValue(), 52.5);

	}

	@Test
	public void shouldSumAfterRemoveGradeBe50() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 125);

		this.testCompositeGrade.removeGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 50);

	}

	@Test
	public void shouldSumAfterRemoveGradeBe52point5WithWeightedGrades() {
		this.testCompositeGrade.setStrategy(new SumGrade());
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		WeightedGrade newWeightGrade = new WeightedGrade(testGrade1);
		this.testCompositeGrade.addGrade(newWeightGrade);
		assertEquals(this.testCompositeGrade.getValue(), 131.25);

		this.testCompositeGrade.removeGrade(newWeightGrade);
		assertEquals(this.testCompositeGrade.getValue(), 52.5);
	}

	/**
	 * Drop Lowest Tests
	 */
	@Test
	public void shouldSumAfterDropLowestGradeTo75() {
		this.testCompositeGrade.setStrategy(new DroppedGrade(new SumGrade()));
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		assertEquals(this.testCompositeGrade.getValue(), 75);

	}

	@Test
	public void shouldSumAfterDropLowestGradeTo78Point75WithWeighted() {
		this.testCompositeGrade.setStrategy(new DroppedGrade(new SumGrade()));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		assertEquals(this.testCompositeGrade.getValue(), 78.75);

	}

	@Test
	public void shouldAverageAfterDropLowestGradeTo82() {
		this.testCompositeGrade.setStrategy(new DroppedGrade(new AverageGrade()));
		this.testCompositeGrade.addGrade(testGrade);
		this.testCompositeGrade.addGrade(testGrade1);
		this.testCompositeGrade.addGrade(testGrade2);
		assertEquals(this.testCompositeGrade.getValue(), 85);

	}

	@Test
	public void shouldAverageAfterDropLowestGradeTo89Point25WithWeighted() {
		this.testCompositeGrade.setStrategy(new DroppedGrade(new AverageGrade()));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade1));
		this.testCompositeGrade.addGrade(new WeightedGrade(testGrade2));
		assertEquals(this.testCompositeGrade.getValue(), 89.25);

	}

}

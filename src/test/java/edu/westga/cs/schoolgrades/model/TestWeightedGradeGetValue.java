package edu.westga.cs.schoolgrades.model;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private mockGrade simpleGrade;
	
	@BeforeEach
	public void setup() {
		simpleGrade = new mockGrade(Grade.class);
		when(mockGrade.getValue()).thenReturn(100.00);
		
	}
	
	@Test
	public void shouldApplyZeroWeight() {
		weightedGrade = new WeightedGrade(simpleGrade, 0);
		assertEquals(0, weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightOfOne() {
		weightedGrade = new WeightedGrade(simpleGrade, 1);
		assertEquals(100, weightedGrade.getValue(), DELTA);
	}
	
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		weightedGrade = new WeightedGrade(simpleGrade, 0.5);
		assertEquals(50, weightedGrade.getValue(), DELTA);
	}

}

package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockChildStrategy;
	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	private List<Grade> mockGrades;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade0 = mock(Grade.class);
		mockGrade1 = mock(Grade.class);
		mockGrade2 = mock(Grade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		when(mockGrade1.getValue()).thenReturn(20.00);
		when(mockGrade2.getValue()).thenReturn(30.00);
		
		mockGrades = new ArrayList<Grade>();
		
		mockChildStrategy = mock(GradeCalculationStrategy.class);
		dropLowestStrategy =  mock(DropLowestStrategy.class);
	}

	@Test
	public void shouldNotAllowNullmockGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfmockGradesListIsEmpty() {
		assertEquals(0, dropLowestStrategy.calculate(mockGrades), DELTA);
	}
	
	public void shouldNotDropLowestIfmockGradesListHasOneElement() {
		mockGrades.add(mockGrade0);
		assertEquals(mockGrade0.getValue(), dropLowestStrategy.calculate(mockGrades), DELTA);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade2);
		dropLowestStrategy.calculate(mockGrades);
		verify(dropLowestStrategy).calculate(mockGrades);
		
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade2);
		mockGrades.add(mockGrade0);
		dropLowestStrategy.calculate(mockGrades);
		verify(dropLowestStrategy).calculate(mockGrades);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade2);
		dropLowestStrategy.calculate(mockGrades);
		verify(dropLowestStrategy).calculate(mockGrades);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestmockGrades() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade2);
		mockGrades.add(mockGrade0);
		dropLowestStrategy.calculate(mockGrades);
		verify(dropLowestStrategy).calculate(mockGrades);
	}
}

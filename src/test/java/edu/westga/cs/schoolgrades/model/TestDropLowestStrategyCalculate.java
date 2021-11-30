package edu.westga.cs.schoolgrades.model;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	
	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private GradeCalculationStrategy mockStrategy;
	private DropLowestStrategy dropLowest;
	
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
		
		mockStrategy = mock(GradeCalculationStrategy.class);
		dropLowest = new DropLowestStrategy(mockStrategy);
		
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new DropLowestStrategy(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfmockGradesListIsEmpty() {
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		verify(mockStrategy).calculate(testList);
	}
	
	public void shouldNotDropLowestIfmockGradesListHasOneElement() {
		mockGrades.add(mockGrade0);
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		testList.add(mockGrade0);
		verify(mockStrategy).calculate(testList);
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade2);
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		testList.add(mockGrade1);
		testList.add(mockGrade2);
		verify(mockStrategy).calculate(testList);
		
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade2);
		mockGrades.add(mockGrade0);
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		testList.add(mockGrade1);
		testList.add(mockGrade2);
		verify(mockStrategy).calculate(testList);
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade2);
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		testList.add(mockGrade1);
		testList.add(mockGrade2);
		verify(mockStrategy).calculate(testList);
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestmockGrades() {
		mockGrades.add(mockGrade1);
		mockGrades.add(mockGrade0);
		mockGrades.add(mockGrade2);
		mockGrades.add(mockGrade0);
		dropLowest.calculate(mockGrades);
		List<Grade> testList = new ArrayList<>();
		testList.add(mockGrade1);
		testList.add(mockGrade2);
		testList.add(mockGrade0);
		verify(mockStrategy).calculate(testList);
	}
}

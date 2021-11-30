package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompositeGradeConstructor {

	private CompositeGrade mockGrade;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockGrade = mock(CompositeGrade.class);
	}
	
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new CompositeGrade(null);
		});
	}
	
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		assertTrue(mockGrade.getGrades().isEmpty());
	}

}

package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;

import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import javafx.scene.control.Button;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

/**
 * This class is the calculates and displays the GradesWorksheet gui.
 * 
 * @author Blair Pattison
 * @version 11/08/2021
 * 
 */
public class SchoolGradesController implements Initializable {
	@FXML
	private ListView<SimpleGrade> examsList;
	@FXML
	private ListView<SimpleGrade> hwList;
	@FXML
	private ListView<SimpleGrade> quizzesList;

	private ObservableList<SimpleGrade> hwGradesList;
	private ObservableList<SimpleGrade> quizGradesList;
	private ObservableList<SimpleGrade> examGradesList;

	@FXML
	private MenuButton dataMenuButton;
	@FXML
	private MenuItem addQuizGrade;
	@FXML
	private MenuItem addHwGrade;
	@FXML
	private MenuItem addExamGrade;

	@FXML
	private TextArea finalGradeSubtotal;
	@FXML
	private TextArea quizSubtotal;
	@FXML
	private TextArea examSubtotal;
	@FXML
	private TextArea hwSubtotal;
	@FXML
	private Button calculateGradeButton;

	private CompositeGrade quizGrades;
	private CompositeGrade homeworkGrades;
	private CompositeGrade examGrades;

	public void SchoolGradesControlleR() {
		this.dataMenuButton = new MenuButton();

		this.examsList = new ListView<>();
		this.hwList = new ListView<>();
		this.quizzesList = new ListView<>();

		this.addQuizGrade = new MenuItem();
		this.addExamGrade = new MenuItem();
		this.addHwGrade = new MenuItem();

		this.quizSubtotal = new TextArea();
		this.finalGradeSubtotal = new TextArea();
		this.examSubtotal = new TextArea();
		this.hwSubtotal = new TextArea();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.hwGradesList = FXCollections.observableArrayList();
		this.examGradesList = FXCollections.observableArrayList();
		this.quizGradesList = FXCollections.observableArrayList();

		this.quizGrades = new CompositeGrade(new SumOfGradesStrategy());
		this.homeworkGrades = new CompositeGrade(new DropLowestStrategy(new AverageOfGradesStrategy()));
		this.examGrades = new CompositeGrade(new AverageOfGradesStrategy());

		this.buildListView(this.quizzesList, this.quizGradesList, this.addQuizGrade);
		this.buildListView(this.examsList, this.examGradesList, this.addExamGrade);
		this.buildListView(this.hwList, this.hwGradesList, this.addHwGrade);

		this.calculateGradeButton.setOnMousePressed(new CalculateGrade());

	}

	/**
	 * Displays the list view for the quizzes.
	 */
	private void buildListView(ListView<SimpleGrade> list, ObservableList<SimpleGrade> grades, MenuItem menu) {
		list.setItems(grades);
		list.setEditable(true);
		list.setCellFactory(lv -> {
			TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<>();
			cell.setConverter(new GradeConverter(cell));
			return cell;
		});
		menu.setOnAction(event -> {
			grades.add(new SimpleGrade(0));
		});
	}

	/**
	 * Converts and calculates the Grade's value into a string to be editable by the
	 * user in the ListView's cell factory.
	 * 
	 * @author Blair Pattison
	 *
	 */
	public static class GradeConverter extends StringConverter<SimpleGrade> {
		private final ListCell<SimpleGrade> cell;

		public GradeConverter(ListCell<SimpleGrade> cell) {
			this.cell = cell;
		}

		@Override
		public String toString(SimpleGrade grade) {
			return String.valueOf(grade.getValue());
		}

		@Override
		public SimpleGrade fromString(String string) {
			SimpleGrade grade = cell.getItem();
			grade.setValue(Double.parseDouble(string));
			return grade;
		}

	}

	/**
	 * Controls the Calculate Grade button and displays the subsequent grade
	 * subtotals and final totals.
	 * 
	 * @author Blair Pattison
	 *
	 */
	private class CalculateGrade implements EventHandler<MouseEvent> {
		public void handle(MouseEvent me) {
			quizGrades = new CompositeGrade(new SumOfGradesStrategy());
			quizGrades.addAll(quizGradesList);

			homeworkGrades = new CompositeGrade(new DropLowestStrategy(new AverageOfGradesStrategy()));
			homeworkGrades.addAll(hwGradesList);

			examGrades = new CompositeGrade(new AverageOfGradesStrategy());
			examGrades.addAll(examGradesList);

			subtotalCalculator(quizGrades, quizSubtotal);
			subtotalCalculator(homeworkGrades, hwSubtotal);
			subtotalCalculator(examGrades, examSubtotal);

			finalGradeCalculator();
		}

	}

	/**
	 * Calculates the desired subtotal and displays it.
	 * 
	 * @param grade    the CompositeGrade to calculate
	 * @param subtotal The subtotal textarea to display it in.
	 */
	private void subtotalCalculator(CompositeGrade grade, TextArea subtotal) {
		if (grade == null) {
			subtotal.setText("0.0");
		} else {
			subtotal.setText(String.valueOf(grade.getValue()));
		}
	}

	/**
	 * Calculates the final grade and displays it in the TextArea.
	 */
	private void finalGradeCalculator() {
		String finalGrade;
		WeightedGrade finalGrade1 = new WeightedGrade(quizGrades, 0.2);
		WeightedGrade finalGrade2 = new WeightedGrade(homeworkGrades, 0.3);
		WeightedGrade finalGrade3 = new WeightedGrade(examGrades, 0.5);
		double finalGradeDouble = finalGrade1.getValue() + finalGrade2.getValue() + finalGrade3.getValue();
		finalGrade = String.valueOf(finalGradeDouble);
		finalGradeSubtotal.setText(finalGrade);
	}

}

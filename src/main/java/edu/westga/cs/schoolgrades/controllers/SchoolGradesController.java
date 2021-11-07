package edu.westga.cs.schoolgrades.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * @author windy
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
	private TextArea quizSubtotal;
	@FXML
	private Button calculateGradeButton;
	private CompositeGrade quizGrades;

	public void SchoolGradesControlleR() {
		this.dataMenuButton = new MenuButton();
		this.examsList = new ListView<>();
		this.hwList = new ListView<>();
		this.quizzesList = new ListView<>();
		this.dataMenuButton = new MenuButton();
		this.addQuizGrade = new MenuItem();
		this.addExamGrade = new MenuItem();
		this.addHwGrade = new MenuItem();
		this.quizSubtotal = new TextArea();


	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.hwGradesList = FXCollections.observableArrayList();
		this.examGradesList = FXCollections.observableArrayList();
		this.quizGradesList = FXCollections.observableArrayList();
		this.quizGrades = new CompositeGrade(new SumOfGradesStrategy());

		this.buildQuizList();
		this.buildExamList();
		this.buildHwList();
		this.calculateGradeButton.setOnMousePressed(new CalculateGrade());
		

	}

	private void buildExamList() {
		this.examsList.setItems(this.examGradesList);
		this.examsList.setEditable(true);
		this.examsList.setCellFactory(lv -> {
			TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<>();
			cell.setConverter(new GradeConverter(cell));
			return cell;

		});
		this.addExamGrade.setOnAction(event -> {
			this.examGradesList.add(new SimpleGrade(0));
		});
	}

	private void buildHwList() {
		this.hwList.setItems(this.hwGradesList);
		this.hwList.setEditable(true);
		this.hwList.setCellFactory(lv -> {
			TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<>();
			cell.setConverter(new GradeConverter(cell));
			return cell;

		});
		addHwGrade.setOnAction(event -> {
			this.hwGradesList.add(new SimpleGrade(0));
		});
	}

	private void buildQuizList() {
		this.quizzesList.setItems(this.quizGradesList);
		this.quizzesList.setEditable(true);
		this.quizzesList.setCellFactory(lv -> {
			TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<>();
			cell.setConverter(new GradeConverter(cell));
			return cell;

		});
		addQuizGrade.setOnAction(event -> {
			this.quizGradesList.add(new SimpleGrade(0));
		});
	}

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

	private class CalculateGrade implements EventHandler<MouseEvent> {
		public void handle(MouseEvent me) {
			quizGrades = new CompositeGrade(new SumOfGradesStrategy());
			quizGrades.addAll(quizGradesList);
			if (quizGrades == null) {
				quizSubtotal.setText("0");
			} else {
				
				quizSubtotal.setText(String.valueOf(quizGrades.getValue()));
			}
		}

	}
}

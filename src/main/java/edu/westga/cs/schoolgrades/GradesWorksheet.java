package edu.westga.cs.schoolgrades;

import java.net.URL;

import edu.westga.cs.schoolgrades.controllers.SchoolGradesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starting point for application.
 * 
 * @author Blair Pattison
 * @version 11/08/2021
 *
 */

public class GradesWorksheet extends Application {
	private static final String GUI_RESOURCE = "edu/westga/cs/schoolgrades/views/SchoolGradesGUI.fxml";

	@Override
	public void start(Stage primaryStage) throws Exception {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL resource = classLoader.getResource(GradesWorksheet.GUI_RESOURCE);
		FXMLLoader loader = new FXMLLoader(resource);
		loader.setController(new SchoolGradesController());
		Parent root = (Parent) loader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Grades Worksheet");
		primaryStage.show();
	}

	/**
	 * Start point for the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

}

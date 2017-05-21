package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane grid = new GridPane();

			Label title = new Label();
			title.setFont(Font.font ("Verdana", 18));
			title.setText("BMR Calculator");
			grid.add(title, 2, 0);
			

			Label al = new Label();
			al.setText("Age :");
			grid.add(al, 1, 1);
		
			TextField at = new TextField();
			grid.add(at, 2, 1);
			
			Label gn = new Label();
			gn.setText("Gender :");
			grid.add(gn, 1, 2);
			
			final ToggleGroup group = new ToggleGroup();
			RadioButton rb1 = new RadioButton("Male");
			rb1.setToggleGroup(group);
			RadioButton rb2 = new RadioButton("Female");
			rb2.setToggleGroup(group);
			
			grid.add(rb1, 2, 2);
			grid.add(rb2, 3, 2);
			
			
			Label ht = new Label();
			ht.setText("Height: ");
			grid.add(ht, 1, 3);
			

			TextField hf = new TextField();
			grid.add(hf, 2, 3);
			
			Label wt = new Label();
			wt.setText("Weight: ");
			grid.add(wt, 1, 4);
			

			TextField wf = new TextField();
			grid.add(wf, 2, 4);

			Button btn = new Button("Calculate");
			grid.add(btn, 1, 5, 2, 1);
			Label out = new Label();
			grid.add(out, 2, 8, 2, 1);
			
		
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					
					String agestring = at.getText();
					int age = Integer.parseInt(agestring);
					
					boolean male = false;
					double BMR;
					
					if(rb1.getToggleGroup()!= null && rb2.getToggleGroup() == null){
						 male = true;
					}			
					else if(rb2.getToggleGroup()!= null && rb1.getToggleGroup() == null){
						male = false;
					}
					else out.setText("Invalid Entry");
					
					String heightString = hf.getText();
					int height = Integer.parseInt(heightString);
					
					String weightString = wf.getText();
					int weight = Integer.parseInt(weightString);
					
					if(male == true){
						
						BMR = 10 * weight + 6.25 * height - 5 * age + 5;
					}
					else{
						BMR = 10 * weight + 6.25 * height - 5 * age - 161;
					}
					
					out.setText("BMR= " + BMR + " Calories");
				
				}
			});

			

			Scene scene = new Scene(grid, 270, 310);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

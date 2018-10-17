import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import org.omg.CORBA.portable.ApplicationException;

import javafx.application.Application;
import javafx.stage.Stage;


public class app extends Application {

	
	public static void main(String[] args) {
		launch(args);}
		
	@Override
	public void start(Stage  primaryStage) throws Exception {
		Model md;
		
			 md = new Model();
			View view = new View(primaryStage, md);


			
		
	}

}



		
	

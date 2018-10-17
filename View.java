

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class View implements Ifinals{
	
	
	private Stage  primaryStage;
	private HBox imagePane,primaryPane,firstRowPane,secondRowPane,thirdRowPane,fourthRowPane,rightColumnUp,rightColumnDown,rightColumnCenter;
	private VBox leftColumn,rightColumn;
	private Label niodim,moneyPerHour,triple,mobilePhone,madraga,sum,Hours;
	private TextField jtfHours,jtfNiodim,jtfTriple , jtfmobilePhone,jtfmadrga,jtfsum,jtfmoneyPerHour;
	private Button jbtCalaculate;
	private Scene primaryScene;
	private Model model;
	private int numOfNiodim,numOfTriple,numOfMobilePhone;
	private double numOfHours;
	private double salary;
	private Image image;

	
	
	public View(Stage  primaryStage,Model model){
		this.model=model;
		this.primaryStage=primaryStage;
		primaryPane = new HBox(10); // the primary pane
		leftColumn=new VBox(15);
		image = new Image("image/HOME.gif");
		imagePane=new HBox(5);
		imagePane.getChildren().add((new ImageView(image)));
	
		firstLeftRow();
	
		secondLeftRow();
		
		thirdLeftRow();
		
		fourthLeftRow();
		
		jbtCalaculate=new Button("Calculate salary: ");
		jbtCalaculate.setStyle("-fx-border-color: blue;");
		VBox buutonPane = new VBox(5.5);
		buutonPane.getChildren().add(jbtCalaculate);
		jbtCalaculate.setAlignment(Pos.CENTER);
		leftColumn.getChildren().addAll(firstRowPane,secondRowPane,thirdRowPane,fourthRowPane,buutonPane);
		jbtCalaculate.setOnAction(e -> calculate());
		
		rightcolumn();
	
		primaryPane.getChildren().addAll(leftColumn,rightColumn,imagePane);
		primaryScene = new Scene(primaryPane);
		goodProperties();
	}

	private void calculate() {
		loadTheNumberFromTheTextField();
		
		this.salary=this.model.calcTheSalary(numOfNiodim,numOfTriple,numOfMobilePhone,numOfHours);
		presentTheDate();
		
	}
	
	private void presentTheDate(){
		jtfsum.setText("" + this.salary + " Shekels");
		jtfmadrga.setText("" + model.whichMadraga(numOfNiodim));
		if(numOfHours !=0){
			jtfmoneyPerHour.setText("" + ((this.salary)/(numOfHours)) + " Shekels");
		}else{
			jtfmoneyPerHour.setText("" + 0 + " Shekels");
		}
	}
	
	private void loadTheNumberFromTheTextField(){
		if(jtfNiodim.getText().equals("")){
			numOfNiodim=0;
		}else{
			numOfNiodim =  Integer.parseInt(jtfNiodim.getText()); // convert string to int
		}
		System.out.println(niodim);
		if(jtfTriple.getText().equals("")){
			numOfTriple=0;
		}else{
		numOfTriple =  Integer.parseInt(jtfTriple.getText());
		}
		System.out.println(triple);
		if(jtfmobilePhone.getText().equals("")){
			numOfMobilePhone=0;
		}else{
		numOfMobilePhone= Integer.parseInt(jtfmobilePhone.getText());
		}
		System.out.println(mobilePhone);
		if(jtfHours.getText().equals("")){
			numOfHours=0;
		}else{
		numOfHours= Double.parseDouble(jtfHours.getText());
		}
		System.out.println(numOfHours);
		
	}

	private void rightcolumn() {
		madraga= new Label("You reach to madraga number: ");
		jtfmadrga= new TextField();
		jtfmadrga.setEditable(false);// cant write in this text field
		rightColumnUp=new HBox(5.5);
		rightColumnUp.getChildren().addAll(madraga,jtfmadrga);
		sum = new Label("Salary: ");
		jtfsum = new TextField();
		jtfsum.setEditable(false); // cant write in this text field
		rightColumnDown = new HBox(5.5);
		rightColumnDown.getChildren().addAll(sum,jtfsum);
		moneyPerHour = new Label("Money per hour:  ");
		jtfmoneyPerHour = new TextField();
		jtfmoneyPerHour.setEditable(false); // cant write in this text field
		rightColumnCenter= new HBox(5.5);
		rightColumnCenter.getChildren().addAll(moneyPerHour,jtfmoneyPerHour);
		rightColumn = new VBox(15);
		rightColumn.getChildren().addAll(rightColumnUp,rightColumnCenter,rightColumnDown);
		
	}

	private void fourthLeftRow() {
		fourthRowPane= new HBox(5.5);
		mobilePhone=new Label("Number Of Mobile Phone: ");
		jtfmobilePhone =new TextField();
		fourthRowPane.getChildren().add(mobilePhone);
		fourthRowPane.getChildren().add(jtfmobilePhone ); 
	}

	private void thirdLeftRow() {
		thirdRowPane= new HBox(5.5);
		triple=new Label("Number Of Triple: ");
		jtfTriple =new TextField();
		thirdRowPane.getChildren().add(triple);
		thirdRowPane.getChildren().add(jtfTriple );
	}

	private void secondLeftRow() {
		secondRowPane= new HBox(5.5);
		niodim=new Label("Number Of Niodim: ");
		jtfNiodim=new TextField();
		secondRowPane.getChildren().add(niodim);
		secondRowPane.getChildren().add(jtfNiodim);
	}
	private void firstLeftRow() {
		firstRowPane= new HBox(5.5);
		Hours=new Label("Number Of Hours: ");
		jtfHours=new TextField();
		firstRowPane.getChildren().add(Hours);
		firstRowPane.getChildren().add(jtfHours);
	}
	public void goodProperties() {
		primaryStage.setTitle("Calculate Salary"); // Set the stage title
		primaryStage.setScene(primaryScene); // Place the scene in the stage
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show(); // Display the stage
	}
	
	
	

}

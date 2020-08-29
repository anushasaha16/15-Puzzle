import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Front-end program
 * @author anush
 *
 */
public class GameApp extends Application{
	private Scene myGameScene;				//scene with the puzzle
	private Scene myCongratulationScene;	//ending scene when the puzzle is completed
	private Game myGame;
	private Map<Integer, Button> myButtons;	//maps the tile buttons to heir corresponding numbers
	private boolean hasStarted;				//true if the user started the game by pressing the start button
    
	public GameApp()
	{
		myGame = new Game();
		myButtons = new HashMap<>();
		hasStarted = false;
	}
	@Override
	/**
	 * Launches the application
	 */
	public void start(Stage primaryStage) throws Exception{
	        
	primaryStage.setTitle("Fifteen Puzzle");

	/**
	 * Sets up the starting scene with the puzzle
	 */
	BorderPane titleBox = new BorderPane();
	titleBox.setPadding(new Insets(20, 20, 20, 20));
	titleBox.setPrefHeight(100);
	titleBox.setPrefWidth(1000);
	Text title = new Text("Fifteen Puzzle     ");
	title.setFont(Font.font ("Courier New", 45));
	titleBox.setCenter(title);
	titleBox.setLeft(this.updateMoves());
	
	/**
	 * Creates all 16 buttons which represent 15 tiles numbered 1-15 and one blank tile
	 */
	Button one = new Button("1");
	myButtons.put(1, one);
	one.setPrefSize(100, 100);
	one.setFont(new Font(40));
	one.setTextFill(Color.WHITE);
	one.setStyle("-fx-background-color: PowderBlue");
	Button two = new Button("2");
	myButtons.put(2, two);
	two.setPrefSize(100, 100);
	two.setFont(new Font(40));
	two.setTextFill(Color.WHITE);
	two.setStyle("-fx-background-color: PowderBlue");
	Button three = new Button("3");
	myButtons.put(3, three);
	three.setPrefSize(100, 100);
	three.setFont(new Font(40));
	three.setTextFill(Color.WHITE);
	three.setStyle("-fx-background-color: PowderBlue");
	Button four = new Button("4");
	myButtons.put(4, four);
	four.setPrefSize(100, 100);
	four.setFont(new Font(40));
	four.setTextFill(Color.WHITE);
	four.setStyle("-fx-background-color: PowderBlue");
	Button five = new Button("5");
	myButtons.put(5, five);
	five.setPrefSize(100, 100);
	five.setFont(new Font(40));
	five.setTextFill(Color.WHITE);
	five.setStyle("-fx-background-color: PowderBlue");
	Button six = new Button("6");
	myButtons.put(6, six);
	six.setPrefSize(100, 100);
	six.setFont(new Font(40));
	six.setTextFill(Color.WHITE);
	six.setStyle("-fx-background-color: PowderBlue");
	Button seven = new Button("7");
	myButtons.put(7, seven);
	seven.setPrefSize(100, 100);
	seven.setFont(new Font(40));
	seven.setTextFill(Color.WHITE);
	seven.setStyle("-fx-background-color: PowderBlue");
	Button eight = new Button("8");
	myButtons.put(8, eight);
	eight.setPrefSize(100, 100);
	eight.setFont(new Font(40));
	eight.setTextFill(Color.WHITE);
	eight.setStyle("-fx-background-color: PowderBlue");
	Button nine = new Button("9");
	myButtons.put(9, nine);
	nine.setPrefSize(100, 100);
	nine.setFont(new Font(40));
	nine.setTextFill(Color.WHITE);
	nine.setStyle("-fx-background-color: PowderBlue");
	Button ten = new Button("10");
	myButtons.put(10, ten);
	ten.setPrefSize(100, 100);
	ten.setFont(new Font(40));
	ten.setTextFill(Color.WHITE);
	ten.setStyle("-fx-background-color: PowderBlue");
	Button eleven = new Button("11");
	myButtons.put(11, eleven);
	eleven.setPrefSize(100, 100);
	eleven.setFont(new Font(40));
	eleven.setTextFill(Color.WHITE);
	eleven.setStyle("-fx-background-color: PowderBlue");
	Button twelve = new Button("12");
	myButtons.put(12, twelve);
	twelve.setPrefSize(100, 100);
	twelve.setFont(new Font(40));
	twelve.setTextFill(Color.WHITE);
	twelve.setStyle("-fx-background-color: PowderBlue");
	Button thirteen = new Button("13");
	myButtons.put(13, thirteen);
	thirteen.setPrefSize(100, 100);
	thirteen.setFont(new Font(40));
	thirteen.setTextFill(Color.WHITE);
	thirteen.setStyle("-fx-background-color: PowderBlue");
	Button fourteen = new Button("14");
	myButtons.put(14, fourteen);
	fourteen.setPrefSize(100, 100);
	fourteen.setFont(new Font(40));
	fourteen.setTextFill(Color.WHITE);
	fourteen.setStyle("-fx-background-color: PowderBlue");
	Button fifteen = new Button("15");
	myButtons.put(15, fifteen);
	fifteen.setPrefSize(100, 100);
	fifteen.setFont(new Font(40));
	fifteen.setTextFill(Color.WHITE);
	fifteen.setStyle("-fx-background-color: PowderBlue");
	Button space = new Button("  ");
	myButtons.put(-1, space);
	space.setPrefSize(100, 100);
	space.setStyle("-fx-background-color: Lavender");
	
	/**
	 * Sets the functionality of all buttons
	 * Once each button is clicked, it switches positions with the blank button if it can and rearranges the puzzle
	 * accordingly.
	 * Updates the number of moves if a valid move was made and checks to see if that move completed the game.
	 * If the game is finished, switches scenes to the ending scene. 
	 */
	one.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(1);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()) {
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});
	
	two.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(2);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	three.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(3);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	four.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(4);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	five.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(5);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	six.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(6);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	seven.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(7);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	eight.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(8);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	nine.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(9);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	ten.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(10);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	eleven.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(11);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	twelve.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(12);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	thirteen.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(13);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	fourteen.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(14);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
		}});

	fifteen.setOnAction(e -> {
		if(hasStarted == true){
		myGame.move(15);
		GridPane newPuzzle = this.setPuzzle(myGame.getNum());
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		titleBox.setLeft(this.updateMoves());
		if(myGame.finished()){
			this.finalMoves();
			primaryStage.setScene(myCongratulationScene);}
	}});
	
	GridPane puzzle = this.setPuzzle(myGame.getNum());
	puzzle.setAlignment(Pos.CENTER);
	
	Button start = new Button("Start");
	start.setPrefSize(100, 40);
	start.setFont(new Font(20));
	start.setStyle("-fx-background-color: LightGreen");
	
	BorderPane bottomBox = new BorderPane();
	bottomBox.setPrefHeight(100);
	bottomBox.setCenter(start);
	
	/**
	 * Once the start button is clicked, the puzzle randomizes.
	 */
	start.setOnAction(e -> {
		int[][] p = myGame.scramble();
		hasStarted = true;
		titleBox.setLeft(this.updateMoves());
		GridPane newPuzzle = this.setPuzzle(p);
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
	});
	
	myGameScene= new Scene(new BorderPane(), 1250, 650);
	((BorderPane) myGameScene.getRoot()).setTop(titleBox);
	((BorderPane) myGameScene.getRoot()).setCenter(puzzle);
	((BorderPane) myGameScene.getRoot()).setBottom(bottomBox);
	((BorderPane) myGameScene.getRoot()).setStyle("-fx-background-color: Lavender");
	               
	/**
	 * Sets up the scene that is displayed when the user wins the game
	 */
	Text t = new Text("Congratulations! You have completed the Fifteen Puzzle!");
	t.setFont(Font.font ("Courier New", 45));
	t.setWrappingWidth(800);
	Text t2 = this.updateMoves();
	t2.setFont(Font.font ("Courier New", 40));
	VBox texts = new VBox();
	texts.getChildren().add(t);
	texts.getChildren().add(t2);
	texts.setAlignment(Pos.CENTER);
	Button newGame = new Button("New Game");
	newGame.setFont(new Font(25));
	newGame.setStyle("-fx-background-color: LightGreen");
	
	/*Starts a new game once the newGame button is clicked*/
	newGame.setOnAction(e -> {
		int[][] p = myGame.scramble();
		hasStarted = true;
		titleBox.setLeft(this.updateMoves());
		GridPane newPuzzle = this.setPuzzle(p);
		newPuzzle.setAlignment(Pos.CENTER);
		((BorderPane) myGameScene.getRoot()).setCenter(newPuzzle);
		primaryStage.setScene(myGameScene);	//Switches back to the scene with puzzle to start new game
	});
	myCongratulationScene = new Scene(new BorderPane(), 1250, 650);
	((BorderPane) myCongratulationScene.getRoot()).setCenter(texts);
	BorderPane bottomBox2 = new BorderPane();
	bottomBox2.setPrefHeight(100);
	bottomBox2.setCenter(newGame);
	((BorderPane) myCongratulationScene.getRoot()).setBottom(bottomBox2);
	((BorderPane) myCongratulationScene.getRoot()).setStyle("-fx-background-color: Pink");
	        
	        
	primaryStage.setScene(myGameScene);	//sets the scene to the puzzle at the start of the game
	primaryStage.show();
	}

	public static void main(String[] args) {
	launch(args);
	}
	
	/**
	 * Given a 2D array of numbers, arranges the tiles corresponding to those numbers accordingly
	 * @param arr	2D array of integers representing the current state of the puzzle
	 * @return		GridPane with buttons/tiles arranged according to the parameter
	 */
	public GridPane setPuzzle(int[][] arr)
	{
		 GridPane p = new GridPane();
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				p.add(myButtons.get(arr[i][j]), j, i);
			}
		}
		return p;
	}
	
	/**
	 * 
	 * @return	Text containing updated number of moves
	 */
	public Text updateMoves()
	{
		Text t = new Text("Moves: " + myGame.getNumMoves());
		t.setFont(Font.font ("Courier New", 30));
		return t;
	}
	
	/**
	 * Displays the final number of moves the user made at the end of the game
	 */
	public void finalMoves()
	{
		Text t = new Text("Congratulations! You have completed the Fifteen Puzzle!");
		t.setFont(Font.font ("Courier New", 45));
		t.setWrappingWidth(800);
		Text t2 = this.updateMoves();
		t2.setFont(Font.font ("Courier New", 40));
		VBox texts = new VBox();
		texts.getChildren().add(t);
		texts.getChildren().add(t2);
		texts.setAlignment(Pos.CENTER);
		((BorderPane) myCongratulationScene.getRoot()).setCenter(texts);
	}

}

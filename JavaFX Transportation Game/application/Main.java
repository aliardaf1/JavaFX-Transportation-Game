package application;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;

public class Main extends Application {
	private Stage primaryStage;
	private Scene mainMenu;
	private Scene level1;
	private Scene level2;
	private Scene level3;
	
	int fix1X;
	int fix1Y;
	double startX1 = 50;
	double startY1 = 50;
	double startX2 = 350;
	double startY2 = 350;
	double startX3 = 475;
	double startY3 = 175;
	double endX;
	double endY;
	double fixX;
	double fixY;

	public City getCityById(ArrayList<City> cities, int id) {
		for (City city : cities) {
			if (city.getCityId() == id) {
				return city;
			}
		}
		return null;
	}

	

	public void start(Stage primaryStage) throws FileNotFoundException {
		this.primaryStage = primaryStage;
		primaryStage.setResizable(false);
		
		
		BorderPane pane = new BorderPane();
		BorderPane pane2 = new BorderPane();
		BorderPane pane3 = new BorderPane();
		
		//TopPane for each level.
		BorderPane topPane = new BorderPane();
		BorderPane topPane2 = new BorderPane();
		BorderPane topPane3 = new BorderPane();

		topPane.setStyle("-fx-border-color: black");
		topPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		topPane2.setStyle("-fx-border-color: black");
		topPane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		topPane3.setStyle("-fx-border-color: black");
		topPane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setTop(topPane);
		pane2.setTop(topPane2);
		pane3.setTop(topPane3);

		BorderPane bottomPane = new BorderPane();
		bottomPane.setStyle("-fx-border-color: black");
		bottomPane.setPadding(new Insets(11.5 * 5, 12.5 * 5, 13.5 * 5, 14.5 * 5));
		BorderPane bottomPane2 = new BorderPane();
		bottomPane2.setStyle("-fx-border-color: black");
		bottomPane2.setPadding(new Insets(11.5 * 5, 12.5 * 5, 13.5 * 5, 14.5 * 5));
		BorderPane bottomPane3 = new BorderPane();
		bottomPane3.setStyle("-fx-border-color: black");
		bottomPane3.setPadding(new Insets(11.5 * 5, 12.5 * 5, 13.5 * 5, 14.5 * 5));
		pane.setBottom(bottomPane);
		pane2.setBottom(bottomPane2);
		pane3.setBottom(bottomPane3);

		
		Button nextLevelButton = new Button("Next Level >>");
		nextLevelButton.setStyle("-fx-border-color: black;");
		Button nextLevelButton2 = new Button("Next Level >>");
		nextLevelButton2.setStyle("-fx-border-color: black;");
		Button nextLevelButton3 = new Button("Main Menu >>");
		nextLevelButton2.setStyle("-fx-border-color: black;");
		topPane.setRight(nextLevelButton);
		topPane2.setRight(nextLevelButton2);
		topPane3.setRight(nextLevelButton3);

		Button driveButton = new Button("DRIVE");
		Button driveButton2 = new Button("DRIVE");
		Button driveButton3 = new Button("DRIVE");
		Font font = Font.font("Arial", FontWeight.BOLD, 20);
		Font font2 = Font.font("Arial", FontWeight.BOLD, 20);
		Font font3 = Font.font("Arial", FontWeight.BOLD, 20);
		driveButton.setStyle("-fx-border-color: transparent");
		driveButton.setFont(font);
		driveButton.setPrefSize(120, 100);
		driveButton2.setStyle("-fx-border-color: transparent");
		driveButton2.setFont(font2);
		driveButton2.setPrefSize(120, 100);
		driveButton3.setStyle("-fx-border-color: transparent");
		driveButton3.setFont(font3);
		driveButton3.setPrefSize(120, 100);
		
		//Placing Drive Button for each level.
		bottomPane.setRight(driveButton);
		bottomPane2.setRight(driveButton2);
		bottomPane3.setRight(driveButton3);

		Pane centerPane = new Pane();
		pane.setCenter(centerPane);
		Pane centerPane2 = new Pane();
		pane2.setCenter(centerPane2);
		Pane centerPane3 = new Pane();
		pane3.setCenter(centerPane3);

		//Adding images of City's and Vehicles.
		Image istanbulImage = new Image("Istanbul.jpeg");
		Image adanaImage = new Image("Adana.png");
		Image bursaImage = new Image("Bursa.jpeg");
		Image boluImage = new Image("Bolu.jpeg");
		Image mersinImage = new Image("Mersin.jpeg");
		Image erzincanImage = new Image("Erzincan.jpeg");
		Image carImage = new Image("car.png");
		Image minibusImage = new Image("Minibus.png");
		Image busImage = new Image("Bus.png");
		Image fixedImage = new Image("Fixed.png");

		// Main Menu -----------------------------------------------------------------------------------------------------
		Pane paneMain = new Pane();
		
		Text gameName = new Text("Intercity Travel");
		gameName.setFont(Font.font("HP Simplified", FontWeight.EXTRA_BOLD, 50));
		gameName.setX(80);
        gameName.setY(260);
        
		Button playButton = new Button("Play!");
		playButton.setStyle("-fx-background-color: gray;");
		Font font4 = Font.font("HP Simplified", FontWeight.BOLD, 40);
		playButton.setFont(font4);
		playButton.setOpacity(10);
		playButton.setLayoutX(185);
		playButton.setLayoutY(500);
		paneMain.getChildren().addAll(playButton, gameName);
		
		FileInputStream backgroundInput = new FileInputStream("background-2.jpg");
		Image backgroundForBackgroundImage = new Image(backgroundInput);
		BackgroundImage backgroundForBackground = new BackgroundImage(backgroundForBackgroundImage, BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true));
		Background background = new Background(backgroundForBackground);
		paneMain.setBackground(background);
		
		// This lines for Level 1
		// -----------------------------------------------------------------------------------
		File file1 = new File("level1.txt");
		Scanner sc = new Scanner(file1);
		ArrayList<City> cities = new ArrayList<City>();
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		ArrayList<Fixed> fixeds = new ArrayList<Fixed>();
		ArrayList<Score> scores = new ArrayList<Score>();
        // This lines for calculating score
		while (sc.hasNextLine()) {
			var line = sc.nextLine();
			var parts = line.split(",");

			if (parts[0].equals("City")) {
				cities.add(new City(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[1]));
			} else if (parts[0].equals("Fixed")) {
				fixeds.add(new Fixed(Integer.parseInt(parts[1])));
			} else if (parts[0].equals("Passenger")) {
				passengers.add(
						new Passenger(Integer.parseInt(parts[1]),
								getCityById(cities, Integer.parseInt(parts[2])),
								getCityById(cities, Integer.parseInt(parts[3]))));

			} else if (parts[0].equals("Vehicle")) {
				vehicles.add(new Vehicle(getCityById(cities, Integer.parseInt(parts[1])), Integer.parseInt(parts[2])));
			}
		}
		for (var passenger : passengers) {
			scores.add(new Score(passenger));
		}
		sc.close();
		
		// To invoke scoreCalculation method.
		double sumOfScore1 = 0;
		for(int i = 0; i < scores.size(); i++) {
			sumOfScore1 += scores.get(i).scoreCalculation();
			sumOfScore1 = ((int)sumOfScore1 * 100)/100.0; 
		}
		
		int city11X = IDtoX(cities.get(0).getCellId());
		startX1 = city11X*1.0;
		int city11Y = IDtoY(cities.get(0).getCellId());
		startY1 = city11Y*1.0;
		
		int city12X = IDtoX(cities.get(1).getCellId());
		int city12Y = IDtoY(cities.get(1).getCellId());
		
		int city13X = IDtoX(cities.get(2).getCellId());
		int city13Y = IDtoY(cities.get(2).getCellId());
		
		int fix1X = IDtoX(fixeds.get(0).getCellId());
		int fix1Y = IDtoY(fixeds.get(0).getCellId());
		
		int carX = IDtoX(vehicles.get(0).getCurrentCity().getCellId());
		int carY = IDtoY(vehicles.get(0).getCurrentCity().getCellId());
		
		// To place features of Top Pane.
		Text score1text = new Text("Score: " + sumOfScore1);
		topPane.setCenter(score1text);
		Text level1text = new Text("Level-1");
		Font level1textFone = new Font("Arial", 20);
		level1text.setFont(level1textFone);
		topPane.setLeft(level1text);

		ImageView car1;
		ImageView istanbul1;
		ImageView adana1;
		ImageView mersin1;
		ImageView fixed1;
		
		//This lines for City Names which is shown under the images
		istanbul1 = new ImageView(istanbulImage);
		setSizeOfCity(istanbul1);
		setXandY(istanbul1, city11X, city11Y);
		Text istanbulText = new Text(55, 110, "Istanbul");

		adana1 = new ImageView(adanaImage);
		setSizeOfCity(adana1);
		setXandY(adana1, city12X, city12Y);
		Text adanaText = new Text(255, 460, "Adana");

		mersin1 = new ImageView(mersinImage);
		setSizeOfCity(mersin1);
		setXandY(mersin1, city13X, city13Y);
		Text mersinText = new Text(355, 160, "Mersin");

		fixed1 = new ImageView(fixedImage);
		setSizeOfCity(fixed1);
		setXandY(fixed1, fix1X, fix1Y);

		car1 = new ImageView(carImage);
		setSizeOfVehicle(car1);
		setXandY(car1, carX+15, carY+15);

		
		//This block of code is activated when the user presses the mouse
		centerPane.setOnMousePressed(e -> {
			//this if statment checks if the user selected the adana city
			if (e.getX() > city12X && e.getX() < city12X+50 && e.getY() > city12Y && e.getY() < city12Y+50) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(car1.getX(), car1.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, car1);
				
				centerPane.getChildren().remove(polyline);
				endX = city12X+25;
				endY = city12Y+25;
				drawLine1(polyline);
				centerPane.getChildren().add(polyline);
				
				driveButton.setOnAction(e2 -> {
					path.play();
					centerPane.getChildren().remove(polyline);
				});
				
				Text infoText1 = new Text("Adana "+ "(City ID:"+ cities.get(1).getCellId() 
						+ " Distance:" + distance(cities.get(1), car1) + " Vehicle Capacity:" + vehicles.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers.get(0).getStartCity().getCityName() + "->" + passengers.get(0).getDestCity().getCityName() +  "(" + 
						passengers.get(0).getNumberOfPassengers() + ")");
				
				infoText1.setWrappingWidth(150);
				infoText1.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane.setLeft(infoText1);
				
				
				car1.setX(city12X+25);
				car1.setY(city12Y+25);
			//this if statment checks if the user selected the istanbul city
			} else if (e.getX() > city11X && e.getX() < city11X+50 && e.getY() > city11Y && e.getY() < city11Y+50) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(car1.getX(), car1.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, car1);
				
				centerPane.getChildren().remove(polyline);
				endX = city11X+25;
				endY = city11Y+25;
				drawLine1(polyline);
				centerPane.getChildren().add(polyline);
				
				driveButton.setOnAction(e2 -> {
					path.play();
					centerPane.getChildren().remove(polyline);
				});
				
				Text infoText1 = new Text("Istanbul "+ "(City ID:"+ cities.get(0).getCellId() 
						+ " Distance:" + distance(cities.get(0), car1) + " Vehicle Capacity:" + vehicles.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers.get(1).getStartCity().getCityName() + "->" + passengers.get(1).getDestCity().getCityName() +  "(" + 
						passengers.get(1).getNumberOfPassengers() + ")");
			
				infoText1.setWrappingWidth(150);
				infoText1.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane.setLeft(infoText1);
				
				car1.setX(city11X+25);
				car1.setY(city11Y+25);
			//this if statment checks if the user selected the mersin city
			} else if (e.getX() > city13X && e.getX() < city13X+50 && e.getY() > city13Y && e.getY() < city13Y+50) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(car1.getX(), car1.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, car1);
				
				centerPane.getChildren().remove(polyline);
				endX = city13X+25;
				endY = city13Y+25;
				drawLine1(polyline);
				centerPane.getChildren().add(polyline);
				
				driveButton.setOnAction(e2 -> {
					path.play();
					centerPane.getChildren().remove(polyline);
				});
				
				Text infoText1 = new Text("Mersin "+ "(City ID:"+ cities.get(2).getCellId() 
						+ " Distance:" + distance(cities.get(2), car1) + " Vehicle Capacity:" + vehicles.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers.get(2).getStartCity().getCityName() + "->" + passengers.get(2).getDestCity().getCityName() +  "(" + 
						passengers.get(2).getNumberOfPassengers() + ")");
				
				infoText1.setWrappingWidth(150);
				infoText1.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane.setLeft(infoText1);
				
				car1.setX(city13X+25);
				car1.setY(city13Y+25);
			}
		});

		centerPane.getChildren().addAll(istanbul1, istanbulText, adana1, adanaText, mersin1, mersinText, fixed1, car1);

		// This lines for Level 2
		// ------------------------------------------------------------------------------------------
		File file2 = new File("level2.txt");
		Scanner sc2 = new Scanner(file2);
		ArrayList<City> cities2 = new ArrayList<City>();
		ArrayList<Passenger> passengers2 = new ArrayList<Passenger>();
		ArrayList<Vehicle> vehicles2 = new ArrayList<Vehicle>();
		ArrayList<Fixed> fixeds2 = new ArrayList<Fixed>();
		ArrayList<Score> scores2 = new ArrayList<Score>();
        // This while loop reads the level2.txt file and creates the objects
		while (sc2.hasNextLine()) {
			var line2 = sc2.nextLine();
			var parts2 = line2.split(",");

			if (parts2[0].equals("City")) {
				cities2.add(new City(Integer.parseInt(parts2[2]), Integer.parseInt(parts2[3]), parts2[1]));
			} else if (parts2[0].equals("Fixed")) {
				fixeds2.add(new Fixed(Integer.parseInt(parts2[1])));
			} else if (parts2[0].equals("Passenger")) {
				passengers2.add(
						new Passenger(Integer.parseInt(parts2[1]),
								getCityById(cities2, Integer.parseInt(parts2[2])),
								getCityById(cities2, Integer.parseInt(parts2[3]))));

			} else if (parts2[0].equals("Vehicle")) {
				vehicles2.add(new Vehicle(getCityById(cities2, Integer.parseInt(parts2[1])), Integer.parseInt(parts2[2])));
			}
		}
		// This for loop adds the passengers to the scores2 arraylist
		for (var passenger : passengers2) {
			scores2.add(new Score(passenger));
		}
		sc2.close();
		// in this loop we calculate the score
		double sumOfScore2 = 0;
		for(int i = 0; i < scores2.size(); i++) {
			sumOfScore2 += scores2.get(i).scoreCalculation();
			sumOfScore2 = ((int)sumOfScore2 * 100)/100.0; 
		}
		Text score2text = new Text("Score: " + sumOfScore2);
		topPane2.setCenter(score2text);
		Text level2text = new Text("Level-2");
		Font level2textFone = new Font("Arial", 20);
		level2text.setFont(level2textFone);
		topPane2.setLeft(level2text);

		ImageView istanbul2;
		ImageView bolu2;
		ImageView erzincan2;
		ImageView bursa2;
		ImageView mersin2;
		ImageView minibus2;
		ImageView fixed2;
		ImageView fixed22;
		ImageView fixed222;

		istanbul2 = new ImageView(istanbulImage);
		setSizeOfCity(istanbul2);
		setXandY(istanbul2, 325, 325);
		Text istanbulText2 = new Text(355, 360, "ÃƒÆ’Ã¢â‚¬Å¾Ãƒâ€šÃ‚Â°stanbul");

		bolu2 = new ImageView(boluImage);
		setSizeOfCity(bolu2);
		setXandY(bolu2, 225, 75);
		Text boluText2 = new Text(260, 160, "Bolu");

		erzincan2 = new ImageView(erzincanImage);
		setSizeOfCity(erzincan2);
		setXandY(erzincan2, 25, 375);
		Text erzincanText2 = new Text(55, 460, "Erzincan");

		bursa2 = new ImageView(bursaImage);
		setSizeOfCity(bursa2);
		setXandY(bursa2, 25, 25);
		Text bursaText2 = new Text(55, 110, "Bursa");

		mersin2 = new ImageView(mersinImage);
		setSizeOfCity(mersin2);
		setXandY(mersin2, 375, 125);
		Text mersinText2 = new Text(405, 210, "Mersin");

		fixed2 = new ImageView(fixedImage);
		setSizeOfCity(fixed2);
		setXandY(fixed2, 325, 225);
		fixed22 = new ImageView(fixedImage);
		setSizeOfCity(fixed22);
		setXandY(fixed22, 75, 75);
		fixed222 = new ImageView(fixedImage);
		setSizeOfCity(fixed222);
		setXandY(fixed222, 275, 225);

		minibus2 = new ImageView(minibusImage);
		setSizeOfVehicle(minibus2);
		setXandY(minibus2, 350, 350);

		//This block of code is activated when the user presses the mouse
		centerPane2.setOnMousePressed(e -> {
			//this if statment checks if the user selected the istanbul city
			if (e.getX() > 325 && e.getX() < 375 && e.getY() > 325 && e.getY() < 375) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(minibus2.getX(), minibus2.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane2.getChildren().remove(polyline);
				endX = 350;
				endY = 350;
				drawLine2(polyline);
				centerPane2.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, minibus2);
				//this block of code plays the animation when the user presses the drive button
				driveButton2.setOnAction(e2 -> {
					path.play();
					centerPane2.getChildren().remove(polyline);
				});
				
				Text infoText2 = new Text("Istanbul "+ "(City ID:"+ cities2.get(0).getCellId() 
						+ " Distance:" + distance(cities2.get(0), minibus2) + " Vehicle Capacity:" + vehicles2.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers2.get(0).getStartCity().getCityName() + "->" + passengers2.get(0).getDestCity().getCityName() +  "(" + 
						passengers2.get(0).getNumberOfPassengers() + ")");
				
				infoText2.setWrappingWidth(150);
				infoText2.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane2.setLeft(infoText2);
				
				minibus2.setX(350);
				minibus2.setY(350);
				//this if statment checks if the user selected the bolu city	
			} else if (e.getX() > 225 && e.getX() < 275 && e.getY() > 75 && e.getY() < 125) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(minibus2.getX(), minibus2.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane2.getChildren().remove(polyline);
				endX = 250;
				endY = 100;
				drawLine2(polyline);
				centerPane2.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, minibus2);
				//this block of code plays the animation when the user presses the drive button
				driveButton2.setOnAction(e2 -> {
					path.play();
					centerPane2.getChildren().remove(polyline);
				});
				
				Text infoText2 = new Text("Bolu "+ "(City ID:"+ cities2.get(1).getCellId() 
						+ " Distance:" + distance(cities2.get(1), minibus2) + " Vehicle Capacity:" + vehicles2.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers2.get(1).getStartCity().getCityName() + "->" + passengers2.get(1).getDestCity().getCityName() +  "(" + 
						passengers2.get(1).getNumberOfPassengers() + ")");
				
				infoText2.setWrappingWidth(150);
				infoText2.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane2.setLeft(infoText2);
				
				minibus2.setX(250);
				minibus2.setY(100);
				//this if statment checks if the user selected the bursa city	
			} else if (e.getX() > 25 && e.getX() < 75 && e.getY() > 25 && e.getY() < 75) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(minibus2.getX(), minibus2.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane2.getChildren().remove(polyline);
				endX = 50;
				endY = 50;
				drawLine2(polyline);
				centerPane2.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, minibus2);
				//this block of code plays the animation when the user presses the drive button
				driveButton2.setOnAction(e2 -> {
					path.play();
					centerPane2.getChildren().remove(polyline);
				});
				
				Text infoText2 = new Text("Bursa "+ "(City ID:"+ cities2.get(2).getCellId() 
						+ " Distance:" + distance(cities2.get(2), minibus2) + " Vehicle Capacity:" + vehicles2.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers2.get(2).getStartCity().getCityName() + "->" + passengers2.get(2).getDestCity().getCityName() +  "(" + 
						passengers2.get(2).getNumberOfPassengers() + ")");
				
				infoText2.setWrappingWidth(150);
				infoText2.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane2.setLeft(infoText2);
				
				minibus2.setX(50);
				minibus2.setY(50);
				//this if statment checks if the user selected the erzincan city	
			} else if (e.getX() > 25 && e.getX() < 75 && e.getY() > 375 && e.getY() < 425) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(minibus2.getX(), minibus2.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane2.getChildren().remove(polyline);
				endX = 50;
				endY = 400;
				drawLine2(polyline);
				centerPane2.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, minibus2);
				//this block of code plays the animation when the user presses the drive button
				driveButton2.setOnAction(e2 -> {
					path.play();
					centerPane2.getChildren().remove(polyline);
				});
				
				Text infoText2 = new Text("Erzincan "+ "(City ID:"+ cities2.get(3).getCellId() 
						+ " Distance:" + distance(cities2.get(3), minibus2) + " Vehicle Capacity:" + vehicles2.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers2.get(3).getStartCity().getCityName() + "->" + passengers2.get(3).getDestCity().getCityName() +  "(" + 
						passengers2.get(3).getNumberOfPassengers() + ")");
				
				infoText2.setWrappingWidth(150);
				infoText2.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane2.setLeft(infoText2);
				
				minibus2.setX(50);
				minibus2.setY(400);
				//this if statment checks if the user selected the mersin city	
			} else if (e.getX() > 375 && e.getX() < 425 && e.getY() > 125 && e.getY() < 175) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(minibus2.getX(), minibus2.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane2.getChildren().remove(polyline);
				endX = 400;
				endY = 150;
				drawLine2(polyline);
				centerPane2.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, minibus2);
				//this block of code plays the animation when the user presses the drive button
				driveButton2.setOnAction(e2 -> {
					path.play();
					centerPane2.getChildren().remove(polyline);
				});
				
				Text infoText2 = new Text("Mersin "+ "(City ID:"+ cities2.get(4).getCellId() 
						+ " Distance:" + distance(cities2.get(4), minibus2) + " Vehicle Capacity:" + vehicles2.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers2.get(4).getStartCity().getCityName() + "->" + passengers2.get(4).getDestCity().getCityName() +  "(" + 
						passengers2.get(4).getNumberOfPassengers() + ")");
				
				infoText2.setWrappingWidth(150);
				infoText2.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane2.setLeft(infoText2);
				
				minibus2.setX(400);
				minibus2.setY(150);
			}
		});

		centerPane2.getChildren().addAll(istanbul2, istanbulText2, bolu2, boluText2, erzincan2, erzincanText2,
				bursa2, bursaText2, mersin2, mersinText2, minibus2, fixed2, fixed22, fixed222);

		// This lines for Level 3
		// ----------------------------------------------------------------------------------
		File file3 = new File("level3.txt");
		Scanner sc3 = new Scanner(file3);
		ArrayList<City> cities3 = new ArrayList<City>();
		ArrayList<Passenger> passengers3 = new ArrayList<Passenger>();
		ArrayList<Vehicle> vehicles3 = new ArrayList<Vehicle>();
		ArrayList<Fixed> fixeds3 = new ArrayList<Fixed>();
		ArrayList<Score> scores3 = new ArrayList<Score>();
		// This while loop reads the level3.txt file and creates the objects
		while (sc3.hasNextLine()) {
			var line3 = sc3.nextLine();
			var parts3 = line3.split(",");

			if (parts3[0].equals("City")) {
				cities3.add(new City(Integer.parseInt(parts3[2]), Integer.parseInt(parts3[3]), parts3[1]));
			} else if (parts3[0].equals("Fixed")) {
				fixeds3.add(new Fixed(Integer.parseInt(parts3[1])));
			} else if (parts3[0].equals("Passenger")) {
				passengers3.add(
						new Passenger(Integer.parseInt(parts3[1]),
								getCityById(cities3, Integer.parseInt(parts3[2])),
								getCityById(cities3, Integer.parseInt(parts3[3]))));

			} else if (parts3[0].equals("Vehicle")) {
				vehicles3.add(new Vehicle(getCityById(cities3, Integer.parseInt(parts3[1])), Integer.parseInt(parts3[2])));
			}
		}
		for (var passenger : passengers3) {
			scores3.add(new Score(passenger));
		}
		sc3.close();
		
		double sumOfScore3 = 0;
		
		for(int i = 0; i < scores3.size(); i++) {
			sumOfScore3 += scores3.get(i).scoreCalculation();
			sumOfScore3 = ((int)sumOfScore3 * 100)/100.0; 
		}
		
		Text score3text = new Text("Score: " + sumOfScore3);
		topPane3.setCenter(score3text);
		Text level3text = new Text("Level-3");
		Font level3textFone = new Font("Arial", 20);
		level3text.setFont(level3textFone);
		topPane3.setLeft(level3text);

		ImageView istanbul3;
		ImageView bolu3;
		ImageView erzincan3;
		ImageView bursa3;
		ImageView mersin3;
		ImageView adana3;
		ImageView bus3;
		ImageView fixed3;
		ImageView fixed33;
		ImageView fixed333;
		ImageView fixed3333;
		ImageView fixed33333;
		ImageView fixed333333;

		istanbul3 = new ImageView(istanbulImage);
		setSizeOfCity(istanbul3);
		setXandY(istanbul3, 50, 0);
		Text istanbulText3 = new Text(55, 60, "Istanbul");

		bolu3 = new ImageView(boluImage);
		setSizeOfCity(bolu3);
		setXandY(bolu3, 50, 350);
		Text boluText3 = new Text(60, 410, "Bolu");

		erzincan3 = new ImageView(erzincanImage);
		setSizeOfCity(erzincan3);
		setXandY(erzincan3, 150, 100);
		Text erzincanText3 = new Text(155, 160, "Erzincan");

		bursa3 = new ImageView(bursaImage);
		setSizeOfCity(bursa3);
		setXandY(bursa3, 450, 0);
		Text bursaText3 = new Text(455, 60, "Bursa");

		mersin3 = new ImageView(mersinImage);
		setSizeOfCity(mersin3);
		setXandY(mersin3, 250, 300);
		Text mersinText3 = new Text(255, 360, "Mersin");

		adana3 = new ImageView(adanaImage);
		setSizeOfCity(adana3);
		setXandY(adana3, 450, 150);
		Text adanaText3 = new Text(455, 210, "Adana");

		bus3 = new ImageView(busImage);
		setSizeOfVehicle(bus3);
		setXandY(bus3, 475, 175);

		fixed3 = new ImageView(fixedImage);
		setSizeOfCity(fixed3);
		setXandY(fixed3, 450, 100);
		fixed33 = new ImageView(fixedImage);
		setSizeOfCity(fixed33);
		setXandY(fixed33, 400, 100);
		fixed333 = new ImageView(fixedImage);
		setSizeOfCity(fixed333);
		setXandY(fixed333, 350, 100);
		fixed3333 = new ImageView(fixedImage);
		setSizeOfCity(fixed3333);
		setXandY(fixed3333, 300, 100);
		fixed33333 = new ImageView(fixedImage);
		setSizeOfCity(fixed33333);
		setXandY(fixed33333, 250, 100);
		fixed333333 = new ImageView(fixedImage);
		setSizeOfCity(fixed333333);
		setXandY(fixed333333, 200, 100);

		//this if statment checks if the user selected the istanbul city
		centerPane3.setOnMousePressed(e -> {
			//this if statment checks if the user selected the bolu city
			if (e.getX() > 50 && e.getX() < 100 && e.getY() > 350 && e.getY() < 400) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 75;
				endY = 375;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Bolu "+ "(City ID:"+ cities3.get(0).getCellId() 
						+ " Distance:" + distance(cities3.get(0), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(0).getStartCity().getCityName() + "->" + passengers3.get(0).getDestCity().getCityName() +  "(" + 
						passengers3.get(0).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(75);
				bus3.setY(375);
				//this if statment checks if the user selected the istanbul city
			} else if (e.getX() > 50 && e.getX() < 100 && e.getY() > 0 && e.getY() < 50) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 75;
				endY = 25;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Istanbul "+ "(City ID:"+ cities3.get(1).getCellId() 
						+ " Distance:" + distance(cities3.get(1), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(1).getStartCity().getCityName() + "->" + passengers3.get(1).getDestCity().getCityName() +  "(" + 
						passengers3.get(1).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(75);
				bus3.setY(25);
				//this if statment checks if the user selected the erzincan city	
			} else if (e.getX() > 150 && e.getX() < 200 && e.getY() > 100 && e.getY() < 150) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 175;
				endY = 125;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Erzincan "+ "(City ID:"+ cities3.get(2).getCellId() 
						+ " Distance:" + distance(cities3.get(2), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(2).getStartCity().getCityName() + "->" + passengers3.get(2).getDestCity().getCityName() +  "(" + 
						passengers3.get(2).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(175);
				bus3.setY(125);
				//this if statment checks if the user selected the bursa city	
			} else if (e.getX() > 450 && e.getX() < 500 && e.getY() > 0 && e.getY() < 50) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 475;
				endY = 25;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Bursa "+ "(City ID:"+ cities3.get(3).getCellId() 
						+ " Distance:" + distance(cities3.get(3), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(3).getStartCity().getCityName() + "->" + passengers.get(3).getDestCity().getCityName() +  "(" + 
						passengers3.get(3).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(475);
				bus3.setY(25);
				//this if statment checks if the user selected the mersin city	
			} else if (e.getX() > 250 && e.getX() < 300 && e.getY() > 300 && e.getY() < 350) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 275;
				endY = 325;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Mersin "+ "(City ID:"+ cities3.get(4).getCellId() 
						+ " Distance:" + distance(cities3.get(4), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(4).getStartCity().getCityName() + "->" + passengers.get(4).getDestCity().getCityName() +  "(" + 
						passengers3.get(4).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(275);
				bus3.setY(325);
				//this if statment checks if the user selected the adana city	
			} else if (e.getX() > 450 && e.getX() < 500 && e.getY() > 150 && e.getY() < 200) {
				Polyline polyline = new Polyline();
				polyline.getPoints().addAll(bus3.getX(), bus3.getY());
				polyline.setStrokeWidth(5);
				polyline.setStroke(Color.LIMEGREEN);
				polyline.setFocusTraversable(true);
				
				centerPane3.getChildren().remove(polyline);
				endX = 475;
				endY = 175;
				drawLine3(polyline);
				centerPane3.getChildren().add(polyline);
				
				PathTransition path = new PathTransition(Duration.seconds(5), polyline, bus3);
				//this block of code plays the animation when the user presses the drive button
				driveButton3.setOnAction(e2 -> {
					path.play();
					centerPane3.getChildren().remove(polyline);
				});
				
				Text infoText3 = new Text("Adana "+ "(City ID:"+ cities3.get(5).getCellId() 
						+ " Distance:" + distance(cities3.get(5), bus3) + " Vehicle Capacity:" + vehicles3.get(0).getPassengerCapacity()+ ")" +
						"\n"+ passengers3.get(5).getStartCity().getCityName() + "->" + passengers.get(5).getDestCity().getCityName() +  "(" + 
						passengers3.get(5).getNumberOfPassengers() + ")");
				
				infoText3.setWrappingWidth(150);
				infoText3.setTextAlignment(TextAlignment.JUSTIFY);
				bottomPane3.setLeft(infoText3);
				
				bus3.setX(475);
				bus3.setY(175);
			}
		});

		centerPane3.getChildren().addAll(istanbul3, istanbulText3, bolu3, boluText3, erzincan3, erzincanText3, bursa3,
				bursaText3, mersin3, mersinText3, adana3, adanaText3, bus3, fixed3, fixed33, fixed333, fixed3333,
				fixed33333, fixed333333);
		
		// For each level, there are another Scenes.
		mainMenu = new Scene(paneMain ,500,800);
		level1 = new Scene(pane, 500, 800);
		level2 = new Scene(pane2, 500, 800);
		level3 = new Scene(pane3, 500, 800);

		primaryStage.setTitle("");
		primaryStage.setScene(mainMenu);
		
		playButton.setOnAction(e -> changeScene());
		nextLevelButton.setOnAction(e -> changeScene());
		nextLevelButton2.setOnAction(e -> changeScene());
		nextLevelButton3.setOnAction(e -> changeScene());
		// Place the scene in the stage
		primaryStage.show();
	}
	/*in City class, there are 3 variables; cellID, cityID and cityName. 
	  This Class is used to calculate score and get the id's for later.*/
	public class City {
		private int cellId;
		private int cityId;
		private String cityName;

		public City(int cellId, int cityId, String cityName) {
			this.cellId = cellId;
			this.cityId = cityId;
			this.cityName = cityName;
		}

		public int getCellId() {
			return cellId;
		}

		public int getCityId() {
			return cityId;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
	}
	
	// In this class, Fixed cell's are implemented.
	
	public class Fixed {
		private int cellId;

		public Fixed(int cellId) {
			this.cellId = cellId;
		}

		public int getCellId() {
			return cellId;
		}
	}
	/* In this class, Passenger constructor is invoked with number of passengers , start point and destination point.
	   It is used for calculating score.*/
	public class Passenger {
		private int numberOfPassengers;
		private City startCity;
		private City destCity;

		public Passenger(int numberOfPassengers, City startCity, City destCity) {
			this.numberOfPassengers = numberOfPassengers;
			this.startCity = startCity;
			this.destCity = destCity;
		}

		public int getNumberOfPassengers() {
			return numberOfPassengers;
		}

		public City getStartCity() {
			return startCity;
		}

		public City getDestCity() {
			return destCity;
		}
	}
	/* In this Class, Vehicle Class is implemented with its capacity. */
	public class Vehicle {
		private City currentCity;
		private int passengerCapacity;

		public Vehicle(City currentCity, int passengerCapacity) {
			this.passengerCapacity = passengerCapacity;
			this.currentCity = currentCity;
		}

		public City getCurrentCity() {
			return currentCity;
		}

		public int getPassengerCapacity() {
			return passengerCapacity;
		}
	}
	//This Class represents "Score" that calculates a score based on a given passenger's data
	public class Score {
		private double score;
		private Passenger passenger;
		
		public Score(Passenger passenger) {
			this.passenger = passenger;
			score = scoreCalculation();
		}

		public double scoreCalculation() {
			double distance = Math.sqrt(Math.pow(passenger.getStartCity().getCellId(), 2) + Math.pow(passenger.getDestCity().getCellId(), 2));
			double income = passenger.getNumberOfPassengers() * distance * 0.2;
			return income - distance;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public Passenger getPassenger() {
			return passenger;
		}

		public void setPassenger(Passenger passenger) {
			this.passenger = passenger;
		}
	}
	// This method is used for changing scene according to Scene.
	public void changeScene() {
		if (primaryStage.getScene() == mainMenu) {
			primaryStage.setScene(level1);
		} else if (primaryStage.getScene() == level1) {
			primaryStage.setScene(level2);
		} else if (primaryStage.getScene() == level2) {
			primaryStage.setScene(level3);
		} else if (primaryStage.getScene() == level3) {
			primaryStage.setScene(mainMenu);
		}
		

	}
	//To set size of images.
	public void setSizeOfCity(ImageView image) {
		image.setFitHeight(50);
		image.setFitWidth(50);
	}
	//To set size of images.
	public void setSizeOfVehicle(ImageView image) {
		image.setFitHeight(30);
		image.setFitWidth(30);
	}
	//To set cordinates of images.
	public void setXandY(ImageView image, int x, int y) {
		image.setX(x);
		image.setY(y);
	}
	//This method is used for calculating the column of City Cell.
	public int calculateColumn(City city) {
		int cell = city.getCellId();
		int column = cell % 10; 
		
		if (column == 0)
			return 10;
		else
			return column;
	}
	//This method is used for calculating the row of City Cell.
	public int calculateRow(City city) {
		int cell = city.getCellId();
		int row ; 
		if (cell % 10 == 0) {
			row = (cell / 10);
			return row;
		}
		else {
			row = (cell / 10) + 1;
			return row;
		}	
	}
	// This method is used for score calculation and getting information to text below. 
	public double distance(City city , ImageView car) {
		double distance = 0;
		
		int row1 = calculateRow(city);
		int column1 = calculateColumn(city);
		
		int row2 = (int)(car.getY()/50);
		int column2 = (int)(car.getX()/50);
		
		distance = Math.sqrt(Math.abs(row1-row2)*Math.abs(row1-row2) 
						+ 	Math.abs(column1 - column2)*Math.abs(column1 - column2) );
		
		;
		
		return Math.ceil(distance);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//this method calculates the X coordinate of the city or fixed cell from ID
	public int IDtoX(int id) {
		int X = 0;
		int a = id%10;
		if(a == 0)
			a = 10;
		X = (a*50);
		return X;
	}
	//this method calculates the Y coordinate of the city of the fixed cell from ID
	public int IDtoY(int id) {
		int Y = 0;
		int a = (id/10) + 1;
		int b = id%10;
		if(b == 0)
			a -= 1;
		Y = (a*50);
		return Y;
	}
	//this method draws line for level one
	public void drawLine1(Polyline polyline) {
		boolean bool2 = false;
		do {
			boolean bool = false;
			//these line are for checking if the road is clear or not
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX1);
			line1.setStartY(startY1);
			line1.setEndX(endX);
			line1.setEndY(startY1);
			
			//these if block check if there is a fixed cell in the line in the x axis
			if(line1.contains(fix1X+25,fix1Y+25)) {
				fixX = fix1X+25;
				fixY = fix1Y+25;
				bool = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the X axis if there is a fixed cell
			if(bool) {
				//if start x is higher than end x
				if(startX1 > endX) {
					polyline.getPoints().addAll(fixX+50,startY1);
					//if start y is higher than end y
					if(startY1 > endY) {
						polyline.getPoints().addAll(fixX+50,startY1-50);
						startX1 = fixX+50;
						startY1 = startY1-50;
						
					}
					//if start y is lower end y
					else {
						polyline.getPoints().addAll(fixX+50,startY1+50);
						startX1 = fixX+50;
						startY1 = endY+50;
						
					}
				}
				//if end x is lower than end x
				else {
					polyline.getPoints().addAll(fixX-50,startY1);
					//if start y is higher than end y
					if(startY1 > endY) {
						polyline.getPoints().addAll(fixX-50,startY1-50);
						startX1 = fixX-50;
						startY1 = startY1-50;
						
					}
					//if start y is lower end y
					else {
						polyline.getPoints().addAll(fixX-50,startY1+50);
						startX1 = fixX-50;
						startY1 = startY1+50;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the X axis
			else {
				startX1 = endX;
				polyline.getPoints().addAll(endX,startY1);

			}
			bool2 = false;
			line2.setStartX(startX1);
			line2.setStartY(startY1);
			line2.setEndX(endX);
			line2.setEndY(endY);
			//these if block check if there is a fixed cell in the line y axis
			if(line2.contains(250,100)) {
				fixX = 250;
				fixY = 100;
				bool2 = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the Y axis if there is a fixed cell
			if(bool2) {
				//if start y is lower than end y
				if(startY1 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					//if start x is lower than end x
					if(startX1 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX1 = endX-50;
						startY1 = fixY;
						
					}
					//if start x is higher than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX1 = endX+50;
						startY1 = fixY;
						
					}
				}
				//if start y is higher than end y
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					//if start x is lower than end x
					if(startX1 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX1 = endX-50;
						startY1 = fixY;
						
					}
					//if start x is higher than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX1 = endX+50;
						startY1 = fixY;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the y axis
			else {
				startY1 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}while(bool2);
	}
	//this method draws line for level two
	public void drawLine2(Polyline polyline) {
		boolean bool2 = false;
		do {
			boolean bool = false;	
			//these line are for checking if the road is clear or not
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX2);
			line1.setStartY(startY2);
			line1.setEndX(endX);
			line1.setEndY(startY2);
			
			//these if block check if there is a fixed cell in the line in the x axis
			if(line1.contains(350,250)) {
				fixX = 350;
				fixY = 250;
				bool = true;
			}
			if(line1.contains(100,100)) {
				fixX = 100;
				fixY = 100;
				bool = true;
			}
			if(line1.contains(300,250)) {
				fixX = 300;
				fixY = 250;
				bool = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the X axis if there is a fixed cell
			if(bool) {
				//if start x is lower than end x
				if(startX2 > endX) {
					polyline.getPoints().addAll(fixX+50,startY2);
					//if start y is lower than end y
					if(startY2 > endY) {
						polyline.getPoints().addAll(fixX+50,startY2-50);
						startX2 = fixX+50;
						startY2 = startY2-50;
						
					}
					//if start y is higher than end y
					else {
						polyline.getPoints().addAll(fixX+50,startY2+50);
						startX2 = fixX+50;
						startY2 = endY+50;
						
					}
				}
				//if start x is higher than end x
				else {
					polyline.getPoints().addAll(fixX-50,startY2);
					//if start y is higher than end y
					if(startY2 > endY) {
						polyline.getPoints().addAll(fixX-50,startY2-50);
						startX2 = fixX-50;
						startY2 = startY2-50;
						
					}
					//if start y is higher than end y
					else {
						polyline.getPoints().addAll(fixX-50,startY2+50);
						startX2 = fixX-50;
						startY2 = startY2+50;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the x axis
			else {
				startX2 = endX;
				polyline.getPoints().addAll(endX,startY2);

			}
			bool2 = false;
			line2.setStartX(startX2);
			line2.setStartY(startY2);
			line2.setEndX(endX);
			line2.setEndY(endY);
			//these if block check if there is a fixed cell in the line y axis
			if(line2.contains(350,250)) {
				fixX = 350;
				fixY = 250;
				bool2 = true;
			}
			
			if(line2.contains(100,100)) {
				fixX = 100;
				fixY = 100;
				bool2 = true;
			}
			
			if(line2.contains(300,250)) {
				fixX = 300;
				fixY = 250;
				bool2 = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the Y axis if there is a fixed cell
			if(bool2) {
				//if start y is lower than end y
				if(startY2 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					//if start x is higer than end x
					if(startX2 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX2 = endX-50;
						startY2 = fixY;
						
					}
					//if start x is lower than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX2 = endX+50;
						startY2 = fixY;
						
					}
				}
				//if start y is higher than end y
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					//if start x is higer than end x
					if(startX2 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX2 = endX-50;
						startY2 = fixY;
						
					}
					//if start x is lower than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX2 = endX+50;
						startY2 = fixY;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the y axis
			else {
				startY2 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}while(bool2);
	}
	//this method draws line for level three
	public void drawLine3(Polyline polyline) {
		boolean bool2 = false;
		do {
			boolean bool = false;
			//these line are for checking if the road is clear or not
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX3);
			line1.setStartY(startY3);
			line1.setEndX(endX);
			line1.setEndY(startY3);
			
			//these if block check if there is a fixed cell in the line in the x axis
			if(line1.contains(475,125)) {
				fixX = 475;
				fixY = 125;
				bool = true;
			}
			if(line1.contains(425,125)) {
				fixX = 425;
				fixY = 125;
				bool = true;
			}
			if(line1.contains(375,125)) {
				fixX = 375;
				fixY = 125;
				bool = true;
			}
			if(line1.contains(325,125)) {
				fixX = 325;
				fixY = 125;
				bool = true;
			}
			if(line1.contains(275,125)) {
				fixX = 275;
				fixY = 125;
				bool = true;
			}
			if(line1.contains(225,125)) {
				fixX = 225;
				fixY = 125;
				bool = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the X axis if there is a fixed cell
			if(bool) {
				//if start x is lower than end x
				if(startX3 > endX) {
					polyline.getPoints().addAll(fixX+50,startY3);
					//if start y is lower than end y
					if(startY3 > endY) {
						polyline.getPoints().addAll(fixX+50,startY3-50);
						startX3 = fixX+50;
						startY3 = startY3-50;
						
					}
					//if start y is higher than end y
					else {
						polyline.getPoints().addAll(fixX+50,startY3+50);
						startX3 = fixX+50;
						startY3 = endY+50;
						
					}
				}
				//if start x is higher than end x
				else {
					polyline.getPoints().addAll(fixX-50,startY3);
					//if start y is lower than end y
					if(startY3 > endY) {
						polyline.getPoints().addAll(fixX-50,startY3-50);
						startX3 = fixX-50;
						startY3 = startY3-50;
						
					}
					//if start y is higher than end y
					else {
						polyline.getPoints().addAll(fixX-50,startY3+50);
						startX3 = fixX-50;
						startY3 = startY3+50;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the y axis
			else {
				startX3 = endX;
				polyline.getPoints().addAll(endX,startY3);

			}
			bool2 = false;
			line2.setStartX(startX3);
			line2.setStartY(startY3);
			line2.setEndX(endX);
			line2.setEndY(endY);
			//these if block check if there is a fixed cell in the line y axis
			if(line2.contains(350,250)) {
				fixX = 350;
				fixY = 250;
				bool2 = true;
			}
			
			if(line2.contains(100,100)) {
				fixX = 100;
				fixY = 100;
				bool2 = true;
			}
			
			if(line2.contains(300,250)) {
				fixX = 300;
				fixY = 250;
				bool2 = true;
			}
			//this if and else blocks draw the lines depending on the locations of the destination and start citys in the Y axis if there is a fixed cell
			if(bool2) {
				//if start y is lower than end y
				if(startY3 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					//if start x is higer than end x
					if(startX3 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX3 = endX-50;
						startY3 = fixY;
						
					}
					//if start x is lower than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX3 = endX+50;
						startY3 = fixY;
						
					}
				}
				//if start y is higher than end y
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					//if start x is higer than end x
					if(startX3 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX3 = endX-50;
						startY3 = fixY;
						
					}
					//if start x is lower than end x
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX3 = endX+50;
						startY3 = fixY;
						
					}
				}
			}
			//this else block draws the line if there is no fixed cell blocking the road in the y axis
			else {
				startY3 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}while(bool2);
	}
}

package application;
	
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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
import java.io.File;
import java.util.Scanner;


public class Fixed extends Application {
	private Stage primaryStage;
    private Scene level1;
    private Scene level2;
    private Scene level3;
    private int level = 1;
    
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
    
	public void start(Stage primaryStage) throws FileNotFoundException {
		this.primaryStage = primaryStage;
		BorderPane pane = new BorderPane();
		BorderPane pane2 = new BorderPane();
		BorderPane pane3 = new BorderPane();
		
		BorderPane topPane = new BorderPane();
		BorderPane topPane2 = new BorderPane();
		BorderPane topPane3 = new BorderPane();
		
		Polyline polyline1 = new Polyline();
		Polyline polyline2 = new Polyline();
		Polyline polyline3 = new Polyline();
		
		polyline1.getPoints().addAll(50.0,50.0);
		polyline1.setStrokeWidth(5);
		polyline1.setStroke(Color.LIMEGREEN);
		polyline1.setFocusTraversable(true);
		
		polyline2.getPoints().addAll(350.0,350.0);
		polyline2.setStrokeWidth(5);
		polyline2.setStroke(Color.LIMEGREEN);
		polyline2.setFocusTraversable(true);
		
		polyline3.getPoints().addAll(475.0,175.0);
		polyline3.setStrokeWidth(5);
		polyline3.setStroke(Color.LIMEGREEN);
		polyline3.setFocusTraversable(true);
		
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
		bottomPane.setPadding(new Insets(11.5*5, 12.5*5, 13.5*5, 14.5*5));
		BorderPane bottomPane2 = new BorderPane();
		bottomPane2.setStyle("-fx-border-color: black");
		bottomPane2.setPadding(new Insets(11.5*5, 12.5*5, 13.5*5, 14.5*5));
		BorderPane bottomPane3 = new BorderPane();
		bottomPane3.setStyle("-fx-border-color: black");
		bottomPane3.setPadding(new Insets(11.5*5, 12.5*5, 13.5*5, 14.5*5));
		pane.setBottom(bottomPane);
		pane2.setBottom(bottomPane2);
		pane3.setBottom(bottomPane3);
		
		Button nextLevelButton = new Button("Next Level >>");
		nextLevelButton.setStyle("-fx-border-color: black;");
		Button nextLevelButton2 = new Button("Next Level >>");
		nextLevelButton2.setStyle("-fx-border-color: black;");
		Button nextLevelButton3 = new Button("Next Level >>");
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
		driveButton3.setFont(font);
		driveButton3.setPrefSize(120, 100);
		bottomPane.setRight(driveButton);
		bottomPane2.setRight(driveButton2);
		bottomPane3.setRight(driveButton3);
		
		Pane centerPane = new Pane();
		pane.setCenter(centerPane);
		Pane centerPane2 = new Pane();
		pane2.setCenter(centerPane2);
		Pane centerPane3 = new Pane();
		pane3.setCenter(centerPane3);
		
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
		
		
		// This lines for Level 1 -----------------------------------------------------------------------------------
			File file1 = new File("level1.txt");
			Scanner sc = new Scanner(file1);
			
			
			Text level1text = new Text("Level-1");
			Font level1textFone = new Font("Arial", 20);
			level1text.setFont(level1textFone);
			topPane.setLeft(level1text);
			
			ImageView car1;
			ImageView istanbul1;
			ImageView adana1;
			ImageView mersin1;
			ImageView fixed1;
		
			istanbul1 = new ImageView(istanbulImage);
			setSizeOfCity(istanbul1); 
			setXandY(istanbul1,25,25);
			Text istanbulText = new Text(55, 110, "İstanbul");
			
			adana1 = new ImageView(adanaImage);
			setSizeOfCity(adana1);
			setXandY(adana1, 225, 375);
			Text adanaText = new Text(255, 460, "Adana");
			
			mersin1 = new ImageView(mersinImage);
			setSizeOfCity(mersin1);
			setXandY(mersin1, 325, 75);
			Text mersinText = new Text(355, 160, "Mersin");
			
			fixed1 = new ImageView(fixedImage);
			setSizeOfCity(fixed1);
			setXandY(fixed1, 225, 75);
			
			car1 = new ImageView(carImage);
			setSizeOfVehicle(car1);
			setXandY(car1,50,50);
			
			PathTransition path1 = new PathTransition(Duration.seconds(5),polyline1,car1);
			
			driveButton.setOnAction(e ->{
				path1.play();
			});
			
			centerPane.setOnMousePressed(e ->{
				if(e.getX() > 225 && e.getX() < 275 && e.getY() > 375 && e.getY() < 425) {
					centerPane.getChildren().remove(polyline1);
					endX = 250;
					endY = 400;
					drawLine1(polyline1);
					centerPane.getChildren().add(polyline1);
				}
				else if(e.getX() > 25 && e.getX() < 75 && e.getY() > 25 && e.getY() < 75) {
					centerPane.getChildren().remove(polyline1);
					endX = 50;
					endY = 50;
					drawLine1(polyline1);
					centerPane.getChildren().add(polyline1);
				}
				else if(e.getX() > 325 && e.getX() < 375 && e.getY() > 75 && e.getY() < 125) {
					centerPane.getChildren().remove(polyline1);
					endX = 350;
					endY = 100;
					drawLine1(polyline1);
					centerPane.getChildren().add(polyline1);
				}
			});
			
			centerPane.getChildren().addAll(istanbul1, istanbulText, adana1, adanaText, mersin1, mersinText, fixed1,car1);
			
		
		// This lines for Level 2 ------------------------------------------------------------------------------------------
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
			setXandY(istanbul2,325,325);
			Text istanbulText2 = new Text(355, 360, "İstanbul");
			
			bolu2 = new ImageView(boluImage);
			setSizeOfCity(bolu2);
			setXandY(bolu2, 225, 75);
			Text boluText2 = new Text(260, 160, "Bolu");
			
			erzincan2 = new ImageView(erzincanImage);
			setSizeOfCity(erzincan2);
			setXandY(erzincan2,25,375);
			Text erzincanText2 = new Text(55, 460, "Erzincan");
			
			bursa2 = new ImageView(bursaImage);
			setSizeOfCity(bursa2);
			setXandY(bursa2,25,25);
			Text bursaText2 = new Text(55, 110, "Bursa");
			
			mersin2 = new ImageView(mersinImage);
			setSizeOfCity(mersin2);
			setXandY(mersin2,375,125);
			Text mersinText2 = new Text(405, 210, "Mersin");
			
			fixed2 = new ImageView(fixedImage);
			setSizeOfCity(fixed2);
			setXandY(fixed2,325,225);
			fixed22 = new ImageView(fixedImage);
			setSizeOfCity(fixed22);
			setXandY(fixed22,75 ,75);
			fixed222 = new ImageView(fixedImage);
			setSizeOfCity(fixed222);
			setXandY(fixed222,275 ,225);
			
			minibus2 = new ImageView(minibusImage);
			setSizeOfVehicle(minibus2);
			setXandY(minibus2,350,350);
			
			polyline2.getPoints().addAll(350.0,350.0);
			PathTransition path2 = new PathTransition(Duration.seconds(5),polyline2,minibus2);
			
			driveButton2.setOnAction(e ->{
				path2.play();
			});
			
			centerPane2.setOnMousePressed(e ->{
				if(e.getX() >325 && e.getX() < 375 && e.getY() > 325 && e.getY() < 375) {
					centerPane2.getChildren().remove(polyline2);
					endX = 350;
					endY = 350;
					drawLine2(polyline2);
					centerPane2.getChildren().add(polyline2);
				}
				else if(e.getX() > 225 && e.getX() < 275 && e.getY() > 75 && e.getY() < 125) {
					centerPane2.getChildren().remove(polyline2);
					endX = 250;
					endY = 100;
					drawLine2(polyline2);
					centerPane2.getChildren().add(polyline2);
				}
				else if(e.getX() > 25 && e.getX() < 75 && e.getY() > 25 && e.getY() < 75) {
					centerPane2.getChildren().remove(polyline2);
					endX = 50;
					endY = 50;
					drawLine2(polyline2);
					centerPane2.getChildren().add(polyline2);
				}
				else if(e.getX() > 25 && e.getX() < 75 && e.getY() > 375 && e.getY() < 425) {
					centerPane2.getChildren().remove(polyline2);
					endX = 50;
					endY = 400;
					drawLine2(polyline2);
					centerPane2.getChildren().add(polyline2);
				}
				else if(e.getX() > 375 && e.getX() < 425 && e.getY() > 125 && e.getY() < 175) {
					centerPane2.getChildren().remove(polyline2);
					endX = 400;
					endY = 150;
					drawLine2(polyline2);
					centerPane2.getChildren().add(polyline2);
				}
			});
			
			centerPane2.getChildren().addAll(istanbul2,istanbulText2, bolu2, boluText2, erzincan2, erzincanText2,
					bursa2 , bursaText2, mersin2, mersinText2, minibus2 , fixed2, fixed22, fixed222);
			
		 
		// This lines for Level 3 ----------------------------------------------------------------------------------
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
			setXandY(istanbul3,50,0);
			Text istanbulText3 = new Text(55, 60, "İstanbul");
			
			bolu3 = new ImageView(boluImage);
			setSizeOfCity(bolu3);
			setXandY(bolu3, 50, 350);
			Text boluText3 = new Text(60, 410, "Bolu");
			
			erzincan3 = new ImageView(erzincanImage);
			setSizeOfCity(erzincan3);
			setXandY(erzincan3,150,100);
			Text erzincanText3 = new Text(155, 160, "Erzincan");
			
			bursa3 = new ImageView(bursaImage);
			setSizeOfCity(bursa3);
			setXandY(bursa3,450,0);
			Text bursaText3 = new Text(455, 60, "Bursa");
			
			mersin3 = new ImageView(mersinImage);
			setSizeOfCity(mersin3);
			setXandY(mersin3,250,300);
			Text mersinText3 = new Text(255, 360, "Mersin");
			
			adana3 = new ImageView(adanaImage);
			setSizeOfCity(adana3);
			setXandY(adana3,450,150);
			Text adanaText3 = new Text(455,210,"Adana");
			
			bus3 = new ImageView(busImage);
			setSizeOfVehicle(bus3);
			setXandY(bus3,475, 175);
			
			fixed3 = new ImageView(fixedImage);
			setSizeOfCity(fixed3);
			setXandY(fixed3,450,100);
			fixed33 = new ImageView(fixedImage);
			setSizeOfCity(fixed33);
			setXandY(fixed33,400,100);
			fixed333 = new ImageView(fixedImage);
			setSizeOfCity(fixed333);
			setXandY(fixed333,350,100);
			fixed3333 = new ImageView(fixedImage);
			setSizeOfCity(fixed3333);
			setXandY(fixed3333,300,100);
			fixed33333 = new ImageView(fixedImage);
			setSizeOfCity(fixed33333);
			setXandY(fixed33333,250,100);
			fixed333333 = new ImageView(fixedImage);
			setSizeOfCity(fixed333333);
			setXandY(fixed333333,200,100);
			
			PathTransition path3 = new PathTransition(Duration.seconds(5),polyline3,bus3);
			
			driveButton3.setOnAction(e ->{
				path3.play();
			});
			
			centerPane3.setOnMousePressed(e ->{
				if(e.getX() > 50 && e.getX() < 100 && e.getY() > 350 && e.getY() < 400) {
					centerPane3.getChildren().remove(polyline3);
					endX = 75;
					endY = 375;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
				else if(e.getX() > 50 && e.getX() < 100 && e.getY() > 0 && e.getY() < 50) {
					centerPane3.getChildren().remove(polyline3);
					endX = 75;
					endY = 25;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
				else if(e.getX() > 150 && e.getX() < 200 && e.getY() > 100 && e.getY() < 150) {
					centerPane3.getChildren().remove(polyline3);
					endX = 175;
					endY = 125;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
				else if(e.getX() > 450 && e.getX() < 500 && e.getY() > 0 && e.getY() < 50) {
					centerPane3.getChildren().remove(polyline3);
					endX = 475;
					endY = 25;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
				else if(e.getX() > 250 && e.getX() < 300 && e.getY() > 300 && e.getY() < 350) {
					centerPane3.getChildren().remove(polyline3);
					endX = 275;
					endY = 325;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
				else if(e.getX() > 450 && e.getX() < 500 && e.getY() > 150 && e.getY() < 200) {
					centerPane3.getChildren().remove(polyline3);
					endX = 475;
					endY = 175;
					drawLine3(polyline3);
					centerPane3.getChildren().add(polyline3);
				}
			});
			
			centerPane3.getChildren().addAll(istanbul3, istanbulText3 , bolu3, boluText3, erzincan3, erzincanText3 , bursa3,
					bursaText3, mersin3 , mersinText3 , adana3, adanaText3 , bus3 , fixed3, fixed33, fixed333, fixed3333, fixed33333, fixed333333);
		
		
		level1 = new Scene(pane,500, 800);
		level2 = new Scene(pane2,500,800);
		level3 = new Scene(pane3,500,800);
		
		primaryStage.setTitle(""); // Set the stage title
		primaryStage.setScene(level1);
		nextLevelButton.setOnAction(e ->  changeScene() );
		nextLevelButton2.setOnAction(e ->  changeScene() );
		
		// Place the scene in the stage
		primaryStage.show();
		}
	
	public class City {
		private int cellId;
		private int cityId;
		private String cityName;
		
		public City(String city, int cell, int id) {
			cellId = cell;
			cityName = city;
			cityId = id;
		}

		public int getCellId() {
			return cellId;
		}

		public int getCityId() {
			return cityId;
		}

	}
	
	public class Fixed {
		private int cellId;
		
			public Fixed(int cellId) {
				this.cellId = cellId;
			}

			public int getCellId() {
				return cellId;
			}
	}
	
	public class Passenger {
		private int numberOfPassengers;
		private City startId;
		private City destId;
		

		public Passenger(int numberOfPassengers, City startId, City destId) {
			this.numberOfPassengers = numberOfPassengers;
			this.startId = startId;
			this.destId = destId;
		}
		
		public int getNumberOfPassengers() {
			return numberOfPassengers;
		}

		public City getStartId() {
			return startId;
		}

		public City getDestId() {
			return destId;
		}
	}
	
	public class Vehicle {
		public int currentCityId;
		public int passengerCapacity;
		
		public Vehicle(int currentCityId, int passengerCapacity) {
			this.passengerCapacity = passengerCapacity;
			this.currentCityId = currentCityId;
		}

		public int getCurrentCityId() {
			return currentCityId;
		}

		public int getPassengerCapacity() {
			return passengerCapacity;
		}
	}
		
		public void changeScene() {
			if (primaryStage.getScene() == level1) {
	            primaryStage.setScene(level2);
	        }
			else if (primaryStage.getScene() == level2) {
	            primaryStage.setScene(level3);
	        }
		
		}
		public void setSizeOfCity(ImageView image) {
			image.setFitHeight(50);
			image.setFitWidth(50);
		}
		public void setSizeOfVehicle(ImageView image) {
			image.setFitHeight(30);
			image.setFitWidth(30);
		}
		public void setXandY(ImageView image , int x, int y) {
			image.setX(x);
			image.setY(y);
		}
		
	public static void main(String[] args) {
		launch(args);
	}
	public void drawLine1(Polyline polyline) {
		while(startX1 != endX && startY1 != endY) {
			boolean bool = false;	
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX1);
			line1.setStartY(startY1);
			line1.setEndX(endX);
			line1.setEndY(startY1);
			
			if(line1.contains(250,100)) {
				fixX = 250;
				fixY = 100;
				bool = true;
			}
			
			if(bool) {
				if(startX1 > endX) {
					polyline.getPoints().addAll(fixX+50,startY1);
					if(startY1 > endY) {
						polyline.getPoints().addAll(fixX+50,startY1-50);
						startX1 = fixX+50;
						startY1 = startY1-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX+50,startY1+50);
						startX1 = fixX+50;
						startY1 = endY+50;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(fixX-50,startY1);
					if(startY1 > endY) {
						polyline.getPoints().addAll(fixX-50,startY1-50);
						startX1 = fixX-50;
						startY1 = startY1-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX-50,startY1+50);
						startX1 = fixX-50;
						startY1 = startY1+50;
						continue;
					}
				}
			}
			else {
				startX1 = endX;
				polyline.getPoints().addAll(endX,startY1);

			}
			boolean bool2 = false;
			line2.setStartX(startX1);
			line2.setStartY(startY1);
			line2.setEndX(endX);
			line2.setEndY(endY);
			
			if(line2.contains(250,100)) {
				fixX = 250;
				fixY = 100;
				bool2 = true;
			}
			
			if(bool2) {
				if(startY1 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					if(startX1 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX1 = endX-50;
						startY1 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX1 = endX+50;
						startY1 = fixY;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					if(startX1 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX1 = endX-50;
						startY1 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX1 = endX+50;
						startY1 = fixY;
						continue;
					}
				}
			}
			else {
				startY1 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}
	}
	public void drawLine2(Polyline polyline) {
		while(startX2 != endX && startY2 != endY) {
			boolean bool = false;	
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX2);
			line1.setStartY(startY2);
			line1.setEndX(endX);
			line1.setEndY(startY2);
			
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
			
			if(bool) {
				if(startX2 > endX) {
					polyline.getPoints().addAll(fixX+50,startY2);
					if(startY2 > endY) {
						polyline.getPoints().addAll(fixX+50,startY2-50);
						startX2 = fixX+50;
						startY2 = startY2-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX+50,startY2+50);
						startX2 = fixX+50;
						startY2 = endY+50;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(fixX-50,startY2);
					if(startY2 > endY) {
						polyline.getPoints().addAll(fixX-50,startY2-50);
						startX2 = fixX-50;
						startY2 = startY2-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX-50,startY2+50);
						startX2 = fixX-50;
						startY2 = startY2+50;
						continue;
					}
				}
			}
			else {
				startX2 = endX;
				polyline.getPoints().addAll(endX,startY2);

			}
			boolean bool2 = false;
			line2.setStartX(startX2);
			line2.setStartY(startY2);
			line2.setEndX(endX);
			line2.setEndY(endY);
			
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
			if(bool2) {
				if(startY2 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					if(startX2 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX2 = endX-50;
						startY2 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX2 = endX+50;
						startY2 = fixY;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					if(startX2 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX2 = endX-50;
						startY2 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX2 = endX+50;
						startY2 = fixY;
						continue;
					}
				}
			}
			else {
				startY2 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}
	}
	public void drawLine3(Polyline polyline) {
		while(startX3 != endX && startY3 != endY) {
			boolean bool = false;	
			Line line1 = new Line();
			Line line2 = new Line();

			line1.setStartX(startX3);
			line1.setStartY(startY3);
			line1.setEndX(endX);
			line1.setEndY(startY3);
			
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
			
			if(bool) {
				if(startX3 > endX) {
					polyline.getPoints().addAll(fixX+50,startY3);
					if(startY3 > endY) {
						polyline.getPoints().addAll(fixX+50,startY3-50);
						startX3 = fixX+50;
						startY3 = startY3-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX+50,startY3+50);
						startX3 = fixX+50;
						startY3 = endY+50;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(fixX-50,startY3);
					if(startY3 > endY) {
						polyline.getPoints().addAll(fixX-50,startY3-50);
						startX3 = fixX-50;
						startY3 = startY3-50;
						continue;
					}
					else {
						polyline.getPoints().addAll(fixX-50,startY3+50);
						startX3 = fixX-50;
						startY3 = startY3+50;
						continue;
					}
				}
			}
			else {
				startX3 = endX;
				polyline.getPoints().addAll(endX,startY3);

			}
			boolean bool2 = false;
			line2.setStartX(startX3);
			line2.setStartY(startY3);
			line2.setEndX(endX);
			line2.setEndY(endY);
			
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
			if(bool2) {
				if(startY3 > endY) {
					polyline.getPoints().addAll(endX,fixY+50);
					if(startX3 < endX ) {
						polyline.getPoints().addAll(endX-50,fixY+50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX3 = endX-50;
						startY3 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY+50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX3 = endX+50;
						startY3 = fixY;
						continue;
					}
				}
				else {
					polyline.getPoints().addAll(endX,fixY-50);
					if(startX3 < endX) {
						polyline.getPoints().addAll(endX-50,fixY-50);
						polyline.getPoints().addAll(endX-50,fixY);
						startX3 = endX-50;
						startY3 = fixY;
						continue;
					}
					else {
						polyline.getPoints().addAll(endX+50,fixY-50);
						polyline.getPoints().addAll(endX+50,fixY);
						startX3 = endX+50;
						startY3 = fixY;
						continue;
					}
				}
			}
			else {
				startY3 = endY;
				polyline.getPoints().addAll(endX,endY);
			}
		}
	}

}

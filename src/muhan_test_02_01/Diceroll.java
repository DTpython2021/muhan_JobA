package muhan_test_02_01;

import java.io.File;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Diceroll extends Application {
	int num1;
	int num2;
	int gameMoney=1000000;	

	@Override
	public void start(Stage stage) {
		try {
			//�ֻ��� �̹��� 6���� �迭�� ������
			Image[] images =
				{new Image("file:src/diceImage/1.png"),
				new Image("file:src/diceImage/2.png"),
				new Image("file:src/diceImage/3.png"),
				new Image("file:src/diceImage/4.png"),
				new Image("file:src/diceImage/5.png"),
				new Image("file:src/diceImage/6.png")};
		
			//6���� ������ �ٲ�� gif ������ ���� ����
			Image roll = new Image("file:src/diceImage/rolldice.gif");
			
			Image backgroundImage = new Image("file:src/diceImage/background.png");
					
			
			//�Ҹ� ȿ�� ����
			MediaPlayer audio = new MediaPlayer(new Media(new File("src/diceImage/Rolling_Dice.wav").toURI().toString()));
			
			//â ũ�� : 1280, 720
			Pane pane = new Pane();
			pane.setStyle("-fx-background-image:background;");
			Scene scene = new Scene(pane,1280,720);
			
			//��ư 3�� �����
			Button buttonOdd = new Button();
			Button buttonEven = new Button();
			Button buttonRoll = new Button();
			
			buttonOdd.setText("Ȧ��"); 
			buttonEven.setText("¦��"); 
			buttonRoll.setText("Roll"); 

			buttonOdd.setStyle("-fx-font-size:40;-fx-background-color:skyblue");//��Ʈ ũ��,����
			buttonEven.setStyle("-fx-font-size:40;-fx-background-color:skyblue");
			buttonRoll.setStyle("-fx-font-size:40");
			
			//ó�� �ȳ� �ؽ�Ʈ ǥ�� 
			Label text = new Label();
			text.setText("Roll�� ���� ���� Ȧ¦  ����");
			text.setStyle("-fx-font-size:40;-fx-text-fill:red;");	
			
			//���ӸӴ� ǥ��
			Label moneyText = new Label();
			moneyText.setText(Integer.toString(gameMoney)+"��");
			moneyText.setStyle("-fx-font-size:30;-fx-text-fill:blue;");
	
			//�ֻ��� 2���� ��Ÿ���� �̹������ 2��
			ImageView iv1 = new ImageView();
			ImageView iv2 = new ImageView();
			ImageView ivBack = new ImageView();
			
			ivBack.setImage(backgroundImage);
			iv1.setImage(images[5]);//ó���� '6'�� ǥ�õ� �ֻ��� ǥ��
            iv2.setImage(images[5]);
 	
			//Ȧ�� ��ư ������ �� �Ǵ�
			buttonOdd.setOnAction(e->{
				audio.stop();;//�Ҹ� �����
				//1~6���� ������ 2�� ��´�
				num1 = (int)(Math.random()*6)+1;
				num2 = (int)(Math.random()*6)+1;
				int sum = num1 + num2;		//2�� �հ�
								
				if(sum%2==0) {//������� �Ǵ�
					text.setText("             You Loose");
					gameMoney-=50000;//���ӸӴ� -
				}
				else {
					text.setText("             You Win");
					gameMoney+=50000;
				}	
				iv1.setImage(images[num1-1]);//������ ���� ���ڴ� 0~6�̰�, �̹��� �迭�� 0~5�̹Ƿ� -1����
	            iv2.setImage(images[num2-1]);	  
				moneyText.setText(Integer.toString(gameMoney)+"��");
				pane.getChildren().addAll(iv1, iv2, text, moneyText,buttonOdd, buttonEven, buttonRoll);
			});
			
			//¦�� ��ư ������ �� �Ǵ�
			buttonEven.setOnAction(e->{
				audio.stop();
				num1 = (int)(Math.random()*6)+1;
				num2 = (int)(Math.random()*6)+1;
				int sum = num1 + num2;		
								
				if(sum%2==0) {
					text.setText("             You Win");
					gameMoney+=50000;
				}
				else {
					text.setText("             You Loose");
					gameMoney-=50000;
				}	
				iv1.setImage(images[num1-1]);
	            iv2.setImage(images[num2-1]);	  
				moneyText.setText(Integer.toString(gameMoney)+"��");
				pane.getChildren().addAll(ivBack,iv1, iv2, text, moneyText, buttonOdd, buttonEven, buttonRoll);	
			});
			
			//Roll ��ư ������ ��
			buttonRoll.setOnAction(e->{
				audio.play();//�Ҹ� ���
				iv1.setImage(roll);
	            iv2.setImage(roll);	
	            text.setText("Ȧ¦�� �ϳ��� �����ϼ���");
				pane.getChildren().addAll(ivBack,iv1, iv2, text, moneyText, buttonOdd, buttonEven, buttonRoll);	
			});
			
            pane.getChildren().addAll(ivBack,iv1, iv2, text, moneyText, buttonOdd, buttonEven, buttonRoll);
            
            iv1.setLayoutX(90);
            iv1.setLayoutY(50);
            iv2.setLayoutX(540);
            iv2.setLayoutY(50);
            buttonOdd.setLayoutX(120);
            buttonOdd.setLayoutY(440);
            buttonEven.setLayoutX(520);
            buttonEven.setLayoutY(440);
            buttonRoll.setLayoutX(330);
            buttonRoll.setLayoutY(440);
            moneyText.setLayoutX(320);
            moneyText.setLayoutY(200);
            text.setLayoutX(150);
            text.setLayoutY(350);  
          
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}

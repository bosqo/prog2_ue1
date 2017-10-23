package uebung_1;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

	
public class Sinusfunktion extends Application {

	private Group root;
	private Group curve;


	
	int cursorX = 0;
	int cursorY = 200;
	
	
	double z0;
	double z1 = 8;  // Amplitude
	double z2 = 0;
	int i = 0;
	
	double f = 1.99;
	double d_var = 1.00;
	
	
	public void sinus() {
		if(i > 600)
			return;
		z0 = f * z1 - d_var * z2;
		z2 = z1;
		z1 = z0;
		//System.out.println(i + " " + (int)z0 ); 
		drawLine(i, (int)z0) ;
		i++;
		//f -= 0.01;
		sinus();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

	void drawLine(int x, int y) {
		int endX =  x;
		int endY =  200 - y;
		Line line = new Line(cursorX, cursorY, endX , endY);
		cursorX = endX;
		cursorY = endY;
		line.setStroke(Color.RED);
		curve.getChildren().add(line);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new Group();
		curve = new Group();


		
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scribble");
		
		Slider sliderF = new Slider(1.91,1.99,0.1);
		Slider sliderD = new Slider(0.91,1.00,0.1);
		/*sliderD.setMin(0.91);
		sliderD.setMax(1.00);*/
		sliderD.setValue(d_var);
		
		
		//slider.setMin(0);
		//slider.setMax(100);
		//slider.setValue(50);
		
		//Label sliderValue = new Label(Double.toString(slider.getValue()));
		//sliderValue.setText(Double.toString(slider.getValue()));
		

		HBox hbox1 = new HBox(8);
		Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
		
		root.getChildren().add(panel);
		hbox1.getChildren().add(sliderF);
		hbox1.getChildren().add(sliderD);
		root.getChildren().add(hbox1);
		root.getChildren().add(curve);
		
		//root.getChildren().add(sliderValue);
		
		sliderF.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	
		    		//System.out.println(newValue);
		        	
		    		i = 0;
		    		cursorX = 0;
		    		z1=8;
		    		z2=0;
		    		curve.getChildren().clear();
		    		f=(double)newValue;
		    		
		    		sinus();
	
		    		
		    }
		});
		
		sliderD.valueProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> observable,
		            Number oldValue, Number newValue) {
		    	
		    		//System.out.println(newValue);
		        	
		    		i = 0;
		    		cursorX = 0;
		    		cursorY = 200;
		    		z1=8;
		    		z2=0;
		    		curve.getChildren().clear();
		    		d_var=(double)newValue;
		    		System.out.println(d_var);
		    		
		    		sinus();
	
		    		
		    }
		});

		//System.out.println();
		primaryStage.show();		
		
		sinus();
	}
}

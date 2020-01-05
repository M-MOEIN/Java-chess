
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Graphic extends Application {
	int fI = -1  , fJ = -1;
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage theStage) {
    	Group board = new Group();
    	Scene theScene = new Scene(board);
    	theStage.setScene(theScene);
    	theStage.setTitle("Chess Game");
    	
    	Canvas canvas = new Canvas(1000, 800);
    	
    	board.getChildren().add(canvas);
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	Board.CreateBoard();
    	final int  SIZE = 70 , X= ( (int)gc.getCanvas().getWidth() - SIZE * 8 ) / 2, Y = 30 ;
    	
    	
    	
    	theScene.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
			@Override
			public void handle(javafx.scene.input.MouseEvent arg0) {

				int tJ = (int) (arg0.getX() - X);
				int tI = (int) (arg0.getY() - Y);
				if ( tI < 0 || tJ < 0 || tJ > 8 * SIZE || tI > 8 * SIZE ) {
					fI =fJ=-1;
					return;
				}
				tI /= SIZE;
				tJ /= SIZE;
				if (Board.board[tI][tJ].squarePiece == null && fI == -1 && fJ == -1) {  /* no piece was selected for moving*/
					return;
				}
				
				String temp = ( tI  )+ "," + (tJ );
				
				if (fI == -1 && fJ == -1 && Board.board[tI][tJ].squarePiece != null ) {
					fI = tI;
					fJ = tJ;
				}else { /*means 2 coordinates have been entered*/
					temp = "FROM  "+( fI  )+ "," + (fJ ) +"  TO  "+ temp;
					
					if (Board.board[fI][fJ].squarePiece.move(fI, fJ, tI, tJ) ) {
						temp = temp + "   is DONE";				
					}else {
						temp = temp + "   is INVALID";
					}
					gc.setFill(Color.GREEN);
					gc.setFont(Font.font("Aria Black", FontWeight.NORMAL, 15));
					gc.clearRect(0, 0, X, Y);
					gc.fillText(temp , 10, 20);
					fI =  fJ = -1;
				}
				Board.drawBoard(gc);
			}
        });

    	
    	Board.drawBoard(gc);
    	theStage.show();
    }	
    
}

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class Board {
	static int turn = 1; 
	static ChessSquare [][] board = new ChessSquare [8][8];


	static public void CreateBoard() {
		boolean temp = false;
		/*setting color for each chess squares*/
		for (int i = 0; i < 8; temp = !temp , i++)
			for (int j = 0; j < 8; temp = !temp ,j++) {
				if ( !temp ) 
					board[i][j] = new ChessSquare(1);
				else 
					board[i][j] = new ChessSquare(0);	
			}
		
		/*sets pawns for black(0) and white(1)*/
		for (int j = 0; j<2; j++) 
			for (int i = 0; i< 8; i ++) {
				if (j == 0)
					board[1][i].squarePiece = new Pawn(0);
				else
					board[6][i].squarePiece = new Pawn(1);
			}
		
		board[0][1].squarePiece = new Knight(0);
		board[0][6].squarePiece = new Knight(0);
		board[7][1].squarePiece = new Knight(1);
		board[7][6].squarePiece = new Knight(1);
		
		board[0][0].squarePiece = new Rook(0);
		board[0][7].squarePiece = new Rook(0);
		board[7][0].squarePiece = new Rook(1);
		board[7][7].squarePiece = new Rook(1);
		
		board[0][2].squarePiece = new Bishop(0);
		board[0][5].squarePiece = new Bishop(0);
		board[7][2].squarePiece = new Bishop(1);
		board[7][5].squarePiece = new Bishop(1);
		
		board[0][4].squarePiece = new Queen(0);
		board[7][4].squarePiece = new Queen(1);
		
	}
	
	static public void drawBoard(GraphicsContext gc) { /**note that in pixel coordinates we have x,y but in array coordinates we have y,x so we called array members by [j][i]*/
		final int  SIZE = 70 , X= ( (int)gc.getCanvas().getWidth() - SIZE * 8 ) / 2, Y = 30 ;
		
		for (int j = 0; j<8; j++) 
			for (int i = 0; i< 8; i ++) {
				if ( Board.board[j][i].squareColor == 1) 
					gc.setFill(Color.rgb(222 , 200 ,130));
				else
					gc.setFill(Color.rgb(170,100,70));
				gc.fillRoundRect(X + SIZE * i, Y + SIZE * j, SIZE, SIZE, 6, 6);
				
				if (Board.board[j][i].squarePiece != null) {
					Board.board[j][i].squarePiece.draw(X + SIZE * i, Y + SIZE * j , SIZE , gc);
				}
				
			}
		
		gc.setStroke(Color.DIMGRAY);
		gc.setLineWidth(2);
		gc.strokeLine(X, Y, X + SIZE * 8, Y);
		gc.strokeLine(X, Y, X , Y + SIZE * 8);
		gc.strokeLine(X , Y + SIZE * 8 ,X + SIZE * 8 , Y + SIZE * 8 );
		gc.strokeLine(X + SIZE * 8 , Y  ,X + SIZE * 8 , Y + SIZE * 8 );

		
	}
	
	public static void setTurn () {
		if ( turn == 1 ) {
			turn = 0;
			return;
		}
		if ( turn == 0 )
			turn = 1;
	}
}

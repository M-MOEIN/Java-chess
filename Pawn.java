import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pawn extends Piece {
	boolean moved = false;
	public Pawn(int color) {
		this.color = color;
	}
	public boolean move(int firstI , int firstJ , int lastI , int lastJ) {
		if ( Board.board[firstI][firstJ].squarePiece.color != Board.turn)
			return false;
		
	
		int direction = 1;
		if ( color == 0)
			direction = -1;
		
		if (lastJ == firstJ) {
			if (  firstI - lastI  == direction ) {
				if ( Board.board[lastI][lastJ].squarePiece == null  ) {
					Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
					Board.board[firstI][firstJ].squarePiece = null;
					moved = true;
					Board.setTurn();
					return true;
				}
			}
			if (  firstI - lastI  == 2 * direction && this.moved == false && Board.board[lastI][lastJ].squarePiece == null) {			
				Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
				Board.board[firstI][firstJ].squarePiece = null;
				moved = true;
				Board.setTurn();
				return true;
			}
			
		}
		
		if (( firstJ - lastJ == 1 || firstJ - lastJ == -1) &&  firstI - lastI  == direction  
				&& Board.board[lastI][lastJ].squarePiece != null 
				&& Board.board[lastI][lastJ].squarePiece.color != Board.board[firstI][firstJ].squarePiece.color ) {
			
			Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
			Board.board[firstI][firstJ].squarePiece = null;
			moved = true;
			Board.setTurn();
			return true;
		}
	
		return false;
		
	}
	
	public void draw(int X , int Y , int SIZE , GraphicsContext gc) {
		final int T = 17;
		if ( this.color == 1 ) 
			gc.setFill(Color.WHITESMOKE);
		else
			gc.setFill(Color.rgb(80,70,70));
		
		gc.fillRoundRect(X+T, Y+T, SIZE - 2*T , SIZE - 2*T, 3*T/4, 3*T/4);
	}
}

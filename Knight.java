import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Knight extends Piece {
	public Knight(int color) {
		this.color = color;
	}
	public boolean move(int firstI , int firstJ , int lastI , int lastJ) {
		if ( Board.board[firstI][firstJ].squarePiece.color != Board.turn)
			return false;
		
		if (absValue(firstI-lastI) * absValue(firstJ-lastJ) == 2  ) {
			if(Board.board[lastI][lastJ].squarePiece == null) {
				Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
				Board.board[firstI][firstJ].squarePiece = null;
				Board.setTurn();
				return true;
				
			}else if( Board.board[lastI][lastJ].squarePiece.color != Board.board[firstI][firstJ].squarePiece.color) {
				Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
				Board.board[firstI][firstJ].squarePiece = null;
				Board.setTurn();
				return true;
			}
		}
		return false;
	}
	
	public void draw(int X , int Y , int SIZE , GraphicsContext gc) {
		if ( this.color == 1 ) 
			gc.setFill(Color.WHITESMOKE);
		else
			gc.setFill(Color.rgb(80,70,70));
		
		double [] a1 = {X+ 10 + 25,X+ 10 +0 ,X+ 10 +25 , X+ 10 +50 };
		double [] a2 = {Y+10+ 0 , Y+10+25 ,Y+10+ 50 ,Y+10+25 };
    	gc.fillPolygon(a1, a2, 4);
		
	}
	private int absValue(int n) {
		if (n >= 0) return n;
		return -n;
	}
}

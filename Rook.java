import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rook extends Piece{
	public Rook(int color) {
		this.color = color;
	}
	
	public boolean move(int firstI , int firstJ , int lastI , int lastJ) {
		if ( Board.board[firstI][firstJ].squarePiece.color != Board.turn)
			return false;
		
		if (firstJ == lastJ  ) {
			int temp = (firstI-lastI < 0)  ? 1 : -1; 
			for(int i = firstI + temp ; i != lastI; i+=temp) {
				if (Board.board[i][firstJ].squarePiece != null)
					return false;
			}
			if (Board.board[lastI][lastJ].squarePiece == null || Board.board[lastI][lastJ].squarePiece.color != Board.board[firstI][firstJ].squarePiece.color ) {
				Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
				Board.board[firstI][firstJ].squarePiece = null;
				Board.setTurn();
				return true;
			}
		}
		
		
		if ( firstI == lastI) {
			int temp = (firstJ-lastJ < 0)  ? 1 : -1; 
			for(int i = firstJ + temp ; i != lastJ; i+=temp) {
				if (Board.board[firstI][i].squarePiece != null)
					return false;
			}
			if (Board.board[lastI][lastJ].squarePiece == null || Board.board[lastI][lastJ].squarePiece.color != Board.board[firstI][firstJ].squarePiece.color ) {
				Board.board[lastI][lastJ].squarePiece = Board.board[firstI][firstJ].squarePiece;
				Board.board[firstI][firstJ].squarePiece = null;
				Board.setTurn();
				return true;
			}
		}
		return false;
	}
	
	void draw (int X , int Y , int SIZE , GraphicsContext gc) {
//		int T = 10;
		if ( this.color == 1 ) 
			gc.setFill(Color.WHITESMOKE);
		else
			gc.setFill(Color.rgb(80,70,70));
//		gc.fillOval(X+T, Y+T, SIZE-2*T,SIZE-2*T);
		double [] a1 = {X+ 15    ,X+ SIZE/2 ,    X+ SIZE- 15 };
		double [] a2 = {Y+10+ 45     , Y+15 ,    Y+10+ 45 };
    	gc.fillPolygon(a1, a2, 3);
    	double [] a3 = {X+ 15    ,X+ SIZE/2 ,    X+ SIZE- 15 };
		double [] a4 = {Y + SIZE - (10+ 45)     , Y+ SIZE - (15) ,   Y+ SIZE - (10+ 45) };
    	gc.fillPolygon(a3, a4, 3);
	}
}

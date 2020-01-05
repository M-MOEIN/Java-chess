import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Bishop extends Piece {
	public Bishop(int color) {
		this.color = color;
	}
	public boolean move(int firstI , int firstJ , int lastI , int lastJ) {
		if ( Board.board[firstI][firstJ].squarePiece.color != Board.turn)
			return false;
		
		if (absValue(firstI-lastI) == absValue(firstJ-lastJ)   ) {
			int tempI = (lastI - firstI) / absValue(lastI - firstI);
			int tempJ = (lastJ - firstJ) / absValue(lastJ - firstJ);
			
			for (int i = firstI + tempI , j = firstJ + tempJ; i != lastI && j != lastJ ; i+= tempI , j+= tempJ) {
				if (Board.board[i][j].squarePiece != null)
					return false;
			}
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
		
		double [] a1 = {X+ 15    ,X+ SIZE/2 ,    X+ SIZE- 15 };
		double [] a2 = {Y+10+ 45     , Y+15 ,    Y+10+ 45 };
    	gc.fillPolygon(a1, a2, 3);
    	
	}
	
	private int absValue(int n) {
		if (n >= 0) return n;
		return -n;
	}
}

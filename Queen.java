import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Queen extends Piece {

		public Queen(int color) {
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

			//========================================
			
			if (  absValue(firstI-lastI) != absValue(firstJ-lastJ)   ) 
				return false;
			
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
		
			return false;
		}
		
		public void draw(int X , int Y , int SIZE , GraphicsContext gc) {

			int T = 10;
			if ( this.color == 1 ) 
				gc.setFill(Color.WHITESMOKE);
			else
				gc.setFill(Color.rgb(80,70,70));
			gc.fillOval(X+T, Y+T, SIZE-2*T,SIZE-2*T);
	    	
		}
		
		private int absValue(int n) {
			if (n >= 0) return n;
			return -n;
		}
	
}

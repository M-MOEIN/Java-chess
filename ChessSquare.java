
public class ChessSquare {
	int squareColor;
	Piece squarePiece;
	public ChessSquare() {}
	public ChessSquare(Piece p , int squareColor) {
		this.squareColor = squareColor;
		squarePiece = p;
	}
	public ChessSquare( int squareColor) { this.squareColor = squareColor; }
}

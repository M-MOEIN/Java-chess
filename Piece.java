import javafx.scene.canvas.GraphicsContext;

abstract public class Piece {
	int color;	/*1 for white ,  0 for  black**/
	abstract void draw (int X , int Y , int SIZE , GraphicsContext gc);
	abstract boolean move(int firstI , int firstJ , int lastI , int lastJ);	
}

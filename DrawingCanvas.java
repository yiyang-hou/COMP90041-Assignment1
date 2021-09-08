/*
 * DrawingCanvas class defines the canvas objects
 */
public class DrawingCanvas {
	// attribute of the canvas
	private int width = 0;
	private int height = 0;
	private char backgroundChar = ' ';

	// getters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char getBackground() {
		return backgroundChar;
	}

	// constructor
	public DrawingCanvas(int inputWidth, int inputHeight, char inputBackground) {
		width = inputWidth;
		height = inputHeight;
		backgroundChar = inputBackground;
	}

	// This method updates the current canvas.
	public void updateCanvas(int newInputWidth, int newInputHeight, char newInputBackground) {
		width = newInputWidth;
		height = newInputHeight;
		backgroundChar = newInputBackground;
		System.out.println("Drawing canvas has been updated!");
		System.out.println();
		System.out.println("Current drawing canvas settings:");
		System.out.println("- Width: " + width);
		System.out.println("- Height: " + height);
		System.out.println("- Background character: " + backgroundChar);
		System.out.println();
	}
}

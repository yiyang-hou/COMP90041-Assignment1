/*
 * The Square class contains attributes and actions for square objects.
 */
public class Square {
	private int sideLength = 0;
	private char printingChar = ' ';
	private String alignment = "left";
	private DrawingCanvas canvas;

	// empty constructor
	public Square() {
	}

	// Passing in the side length value from the user and verify the validity.
	public boolean sideLengthCheck(int inputSideLength, DrawingCanvas canvas) {
		this.canvas = canvas;
		if (inputSideLength > canvas.getWidth() || inputSideLength > canvas.getHeight()) {
			return false;
		} else
			sideLength = inputSideLength;
		return true;
	}

	// Passing in more attributes for the object.
	public void inputHandling(char inputChar, String inputAlignment) {
		printingChar = inputChar;
		alignment = inputAlignment;
	}

	// Draw the square on the given canvas.
	public void drawSquare() {
		String rowOutput = "";
		String formatString = "%" + canvas.getWidth() + "s%n";
		int midColIndex = (canvas.getWidth() - sideLength) / 2 + 1;
		int rightColIndex = canvas.getWidth() - sideLength + 1;

		// Draw the square that is not in left or default alignment.
		if (!(alignment.equals("middle") || alignment.equals("right"))) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j <= sideLength && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
		// Draw the square that is in middle alignment.
		if (alignment.equals("middle")) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= midColIndex && j < midColIndex + sideLength && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
		// Draw the square that is in right alignment.
		if (alignment.equals("right")) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= rightColIndex && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
	}

	// Zoom the square in or out.
	public void zoom(char zoomDirection) {
		if (zoomDirection == 'i' || zoomDirection == 'I') {
			++sideLength;
			if (sideLengthCheck(sideLength, canvas)) {
				drawSquare();
			} else {
				--sideLength;
				drawSquare();
			}
		}

		if (zoomDirection == 'o' || zoomDirection == 'O') {
			--sideLength;
			if (sideLength >= 1) {
				drawSquare();
			} else {
				++sideLength;
				drawSquare();
			}
		}
	}

}

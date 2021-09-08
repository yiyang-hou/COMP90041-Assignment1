/*
 * The Triangle class contains attributes and actions for triangle objects.
 */
public class Triangle {
	private int sideLength = 0;
	private char printingChar = ' ';
	private String alignment = "left";
	private DrawingCanvas canvas;
	private int rotationPosition = 0;

	// empty constructor
	public Triangle() {
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

	// Draw the triangle on the given canvas.
	public void drawTriangle() {
		String rowOutput = "";
		String formatString = "%" + canvas.getWidth() + "s%n";
		int midColIndex = (canvas.getWidth() - sideLength) / 2 + 1;
		int rightColIndex = canvas.getWidth() - sideLength + 1;

		// Draw the triangle that is not in left or default alignment.
		if (!(alignment.equals("middle") || alignment.equals("right"))) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j <= sideLength - (i - 1)) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
		// Draw the triangle that is in middle alignment.
		if (alignment.equals("middle")) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= midColIndex && j <= midColIndex + sideLength - i) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
		// Draw the triangle that is in right alignment.
		if (alignment.equals("right")) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= rightColIndex && j <= canvas.getWidth() - (i - 1)) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

	}

	// Operate rotation
	public void rotate(char direction) {
		String rowOutput = "";
		String formatString = "%" + canvas.getWidth() + "s%n";
		int midColIndex = (canvas.getWidth() - sideLength) / 2 + 1;
		int rightColIndex = canvas.getWidth() - sideLength + 1;

		if (direction == 'r' || direction == 'R') {
			++rotationPosition;
			if (rotationPosition == 4) {
				rotationPosition = 0;
			}
		}

		else if (direction == 'l' || direction == 'L') {
			--rotationPosition;
			if (rotationPosition == -4) {
				rotationPosition = 0;
			}
		}

		if (rotationPosition == 0) {
			drawTriangle();
		}
		// Rotate the triangle that is in left alignment or default alignment.
		if (!(alignment.equals("middle") || alignment.equals("right"))
				&& (rotationPosition == 1 || rotationPosition == -3)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j > i - 1 && j <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (!(alignment.equals("middle") || alignment.equals("right"))
				&& (rotationPosition == 2 || rotationPosition == -2)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j > sideLength - i && j <= sideLength && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (!(alignment.equals("middle") || alignment.equals("right"))
				&& (rotationPosition == 3 || rotationPosition == -1)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j <= i && j <= sideLength && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
		// Rotate the triangle that is in middle alignment.
		if (alignment.equals("middle") && (rotationPosition == 1 || rotationPosition == -3)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= midColIndex + (i - 1) && j < midColIndex + sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (alignment.equals("middle") && (rotationPosition == 2 || rotationPosition == -2)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= midColIndex + sideLength - i && j < midColIndex + sideLength && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (alignment.equals("middle") && (rotationPosition == 3 || rotationPosition == -1)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= midColIndex && j < midColIndex + i && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		// Rotate the triangle that is in right alignment.
		if (alignment.equals("right") && (rotationPosition == 1 || rotationPosition == -3)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= rightColIndex + (i - 1)) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (alignment.equals("right") && (rotationPosition == 2 || rotationPosition == -2)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= rightColIndex + sideLength - i && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}

		if (alignment.equals("right") && (rotationPosition == 3 || rotationPosition == -1)) {
			for (int i = 1; i <= canvas.getHeight(); i++) {
				rowOutput = "";
				for (int j = 1; j <= canvas.getWidth(); j++) {
					if (j >= rightColIndex && j < rightColIndex + i && i <= sideLength) {
						rowOutput = rowOutput + Character.toString(printingChar);
					} else {
						rowOutput = rowOutput + Character.toString(canvas.getBackground());
					}
				}
				System.out.printf(formatString, rowOutput);
			}
		}
	}
}

/*
 * Author:
 * Name: Yiyang Hou
 * Student ID: 1202537
 * Username: yiyhou1
 * 
 * Main program
 *
 */
import java.util.Scanner;

public class ConsoleDrawing {
	public static void main(String[] args) {
		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		char backgroundChar = args[2].charAt(0);
		DrawingCanvas canvas = new DrawingCanvas(width, height, backgroundChar);

		// Welcome message.
		System.out.println("----WELCOME TO MY CONSOLE DRAWING APP----");
		System.out.println("Current drawing canvas settings:");
		System.out.println("- Width: " + canvas.getWidth());
		System.out.println("- Height: " + canvas.getHeight());
		System.out.println("- Background character: " + canvas.getBackground());
		System.out.println();

		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		do {
			displayMenu();
			userInput = scanner.nextInt();
			boolean repeat = false;
			int sideLength = 0;
			char printingChar = ' ';
			String alignment = "";
			char rotatingDirection = ' ';
			char zoomDirection = ' ';
			char redraw = ' ';
			switch (userInput) {
			case 1:// Draw triangles.
				Triangle triangle = new Triangle();
				do {
					do {
						System.out.println("Side length:");
						sideLength = scanner.nextInt();
						if (!triangle.sideLengthCheck(sideLength, canvas)) {
							System.out.println("Error! The side length is too long (Current canvas size is "
									+ canvas.getWidth() + "x" + canvas.getHeight() + "). Please try again.");
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);

					System.out.println("Printing character:");
					printingChar = scanner.next().charAt(0);

					System.out.println("Alignment (left, middle, right):");
					alignment = scanner.next();
					triangle.inputHandling(printingChar, alignment);
					triangle.drawTriangle();
					do {
						System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
						rotatingDirection = scanner.next().charAt(0);
						if (rotatingDirection == 'l' || rotatingDirection == 'L' || rotatingDirection == 'r'
								|| rotatingDirection == 'R') {
							triangle.rotate(rotatingDirection);
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);

					do {
						System.out.println("Draw another triangle (Y/N)?");
						redraw = scanner.next().charAt(0);
						if (redraw != 'y' && redraw != 'Y' && redraw != 'n' && redraw != 'N') {
							System.out.println("Unsupported option. Please try again!");
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);
				} while (redraw == 'y' || redraw == 'Y');
				break;
			case 2: // Draw squares.
				Square square = new Square();
				do {
					do {
						System.out.println("Side length:");
						sideLength = scanner.nextInt();
						if (!square.sideLengthCheck(sideLength, canvas)) {
							System.out.println("Error! The side length is too long (Current canvas size is "
									+ canvas.getWidth() + "x" + canvas.getHeight() + "). Please try again.");
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);

					System.out.println("Printing character:");
					printingChar = scanner.next().charAt(0);

					System.out.println("Alignment (left, middle, right):");
					alignment = scanner.next();
					square.inputHandling(printingChar, alignment);
					square.drawSquare();
					do {
						System.out.println("Type I/O to zoom in/out. Use other keys to continue.");
						zoomDirection = scanner.next().charAt(0);
						if (zoomDirection == 'i' || zoomDirection == 'I' || zoomDirection == 'o'
								|| zoomDirection == 'O') {
							square.zoom(zoomDirection);
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);

					do {
						System.out.println("Draw another square (Y/N)?");
						redraw = scanner.next().charAt(0);
						if (redraw != 'y' && redraw != 'Y' && redraw != 'n' && redraw != 'N') {
							System.out.println("Unsupported option. Please try again!");
							repeat = true;
						} else
							repeat = false;
					} while (repeat == true);
				} while (redraw == 'y' || redraw == 'Y');
				break;
			case 3: // Update drawing canvas.
				int canvasWidth = 0;
				int canvasHeight = 0;
				char newBackgroundChar = ' ';
				System.out.print("Canvas width: ");
				canvasWidth = scanner.nextInt();
				System.out.print("Canvas height: ");
				canvasHeight = scanner.nextInt();
				System.out.print("Background character: ");
				newBackgroundChar = scanner.next().charAt(0);
				canvas.updateCanvas(canvasWidth, canvasHeight, newBackgroundChar);
				break;
			case 4:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Unsupported option. Please try again!");
				break;
			}
		} while (userInput != 4);
		scanner.close();
	}

	// Print out the main menu.
	public static void displayMenu() {
		System.out.println("Please select an option. Type 4 to exit.");
		System.out.println("1. Draw triangles");
		System.out.println("2. Draw squares");
		System.out.println("3. Update drawing canvas settings");
		System.out.println("4. Exit");
	}
}

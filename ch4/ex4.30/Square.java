import java.util.Scanner;

public class Square {
  public static void main(String[] args) {
    int width = 0;
    Scanner input = new Scanner(System.in);

    while(width == 0) {
      System.out.printf("Please enter a width for the square to be drawn: ");
      width = input.nextInt();

      if(width < 1 || width > 20) {
        System.out.println("The width must be between 1 and 20.");
        width = 0;
      }
    }

    drawSquare(width);
  }

  private static void drawSquare(int width) {
    // draw top
    for(int i = 0; i < width; i++) {
      System.out.printf("*");
    }
    System.out.printf("\n");
    
    // stop here if width is equal to 1
    if(width != 1) {
      //draw middle
      for (int row = 1; row < width - 1; row++) {
        System.out.printf("*");
        for(int i = 0; i < width - 2; i++) {
          System.out.printf(" ");
        }
        System.out.printf("*\n");
      }
      
      // draw bottom
      for(int i = 0; i < width; i++) {
        System.out.printf("*");
      }
      System.out.printf("\n");
    }
  }
}

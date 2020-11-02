// Bob Tate 11/2/2020
// JHTP Exercise 2.31

import java.util.Scanner;

public class Circle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int radius = 0;
    
    System.out.println("Enter the integer radius of a circle: ");
    radius = input.nextInt();
    System.out.println("Circle Dimensions:");
    System.out.printf("\tDiameter: %d\n\tCircumference: %f\n\tArea: %f\n", 2 * radius, 
      Math.PI * 2 * radius, Math.PI * 2 * radius * radius);
  }
}

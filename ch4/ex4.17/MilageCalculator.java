import java.util.Scanner;

public class MilageCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int totalMiles = 0;
    int totalGallons = 0;
    boolean keepGoing = true;

    while(keepGoing) {
      System.out.printf("Please enter an integer representation of the miles driven for a trip: ");
      totalMiles += input.nextInt();
      
      System.out.printf("Please enter an integer representation of gallons used for the trip: ");
      totalGallons += input.nextInt();

      System.out.print("Would you like to enter another trip? (y/n):");
      keepGoing = input.next().charAt(0) == 'y' ? true : false;
    }


    System.out.printf("You've travelled a total of %d miles and used a total of %d gallons. Your average gas mileage was %.2f mpg.\n", totalMiles, totalGallons, (float)totalMiles/(float)totalGallons);
  
  }
}

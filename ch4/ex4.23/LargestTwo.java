import java.util.Scanner;

public class LargestTwo {
  public static void main(String[] args) {
    int largest = 0;
    int secondLargest = 0;
    int number;
    Scanner input = new Scanner(System.in);

    // loop through 10 iterations
    for(int counter = 0; counter < 10; counter++) {
      // prompt for and store the number
      System.out.printf("Enter the %s number: ", ordinalCount(counter + 1));
      number = input.nextInt();

      // if number is greater than largest, replace largest with number
      if(number > largest) {
        secondLargest = largest;
        largest = number;
      } else if (number > secondLargest) {
        secondLargest = number;
      }
    }
    
    // output the largest number
    System.out.printf("The largest number was %d and the second largest number was %d.\n",
      largest, secondLargest);
  }
  // ordinalCount - Return a string representation of an ordinal number for an integer input
  private static String ordinalCount(int count) {
    if (count == 1) {
      return "1st";
    } else if (count == 2) {
      return "2nd";
    } else if (count == 3) {
      return "3rd";
    } else {
      return Integer.toString(count) + "th";
    }
  } 
}

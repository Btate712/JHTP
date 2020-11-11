import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = -1;
    // Assume the number is a palindrome until we know that it is not
    String isOrIsNotAPalindromeText = "is";

    // get the number to check
    while (number == -1) {
      System.out.printf("Please enter a five-digit number to check for palindromnity: ");
      number = input.nextInt();

      // verify that the number is a five-digit number
      if (number < 11111 || number > 99999) {
        System.out.println("You must enter exactly five digits with no leading zeros.");
        number = -1;
      }
    }

    // isOrIsNotAPalindromeText was initialized to "is" but should be "is not" if the number is not a palindrome
    if (!isPalindrome(number)) {
      isOrIsNotAPalindromeText = "is not";
    }
    System.out.printf("The number %d %s a palindrome.\n", number, isOrIsNotAPalindromeText);
  }

  public static boolean isPalindrome(int number) {
    int[] digits = {0,0,0,0,0};
    int divisor;
    int localNumber = number;

    // place the digits of number into an array representing their decimal locations
    // e.g. 23456 yields {6, 5, 4, 3, 2} since digits[0] should represent the 10^0
    // decimal location, digits[1] should represent the 10^1 decimal location, etc.
    for(int place = 4; place >= 0; place--) {
      // determine decimal place value (10^4, 10^3, 10^2, 10^1, or 10^0)
      divisor = (int)Math.pow(10, place);
      // use integer math to determine the value of the digit in the current decimal location
      digits[place] = localNumber / divisor;
      // now that the current decimal location's value has been extracted, the remainder is all 
      // we care about going forward...
      localNumber %= divisor;
    }

    // the number is a palindrome if the 1st digit matches the last digit and 
    // the 2nd digit matches the 4th digit
    return digits[4] == digits[0] && digits[3] == digits[1] ? true : false;
  }
}

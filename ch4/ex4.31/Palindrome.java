import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = -1;
    String isOrIsNot = "is";

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

    if (!isPalindrome(number)) {
      isOrIsNot = "is not";
    }
    System.out.printf("The number %d %s palindromnic.\n", number, isOrIsNot);
  }

  public static boolean isPalindrome(int number) {
    int[] digits = {0,0,0,0,0};
    int divisor;
    int localNumber = number;

    // place the digits of number into an array representing their decimal locations
    for(int place = 4; place >= 0; place--) {
      divisor = (int)Math.pow(10, place);
      digits[place] = localNumber / divisor;
      localNumber %= divisor;
    }

    return digits[4] == digits[0] && digits[3] == digits[1] ? true : false;
  }
}

import java.util.Scanner;

public class Simpletron {
  int MEMORY_SIZE = 100;

  int [] memory = new int [MEMORY_SIZE];
  int accumulator = 0;
  Scanner scanner = new Scanner();

  public void start() {
    this.showWelcomeMessage();
  }

  private void loadFromUser() {
    String input;
    boolean stop = false;
    String EOF = "-99999";
    // do {
      input = scanner.nextLine(System.in);

    // } (while input != EOF)
  }

  private static void showWelcomeMessage() {
    String [] welcomeLines = {
      "Welcome to Simpletron!\t\t\t",
      "Please enter your program one instruction\t",
      "(or data word) at a time. I will display\t", 
      "the location number and a question mark (?).",
      "You then type the word for that location.\t",
      "Type -99999 to stop entering your program.\t"
    };
  
    for(int i = 0; i < welcomeLines.length; i++) {
      System.out.printf("*** %s ***\n", welcomeLines[i]);
    }
  }


}
import java.util.Scanner;

public class Simpletron {
  int MEMORY_SIZE = 100;
  
  int [] memory = new int [MEMORY_SIZE];
  int accumulator = 0;
  Scanner scanner = new Scanner(System.in);
  
  public void start() {
    showWelcomeMessage();
    this.loadFromUser();
  }
  
  private void loadFromUser() {
    String EOF = "-99999";
    String input;
    int inputAsInteger;
    int counter = 0;

    do {
      System.out.printf(": ");
      input = scanner.next();

      inputAsInteger = Integer.parseInt(input);
      if(!input.equals(EOF) && inputAsInteger >= -99999 && inputAsInteger <= 9999) { 
        this.memory[counter] = inputAsInteger;
        counter++;
      }
    } while (!input.equals(EOF) && counter < MEMORY_SIZE);
  }

  private void showWelcomeMessage() {
    final String [] welcomeLines = {
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
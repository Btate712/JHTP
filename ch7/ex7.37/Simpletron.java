import java.util.Scanner;
import java.util.Formatter;

public class Simpletron {
  int MEMORY_SIZE = 100;
  
  int [] memory = new int [MEMORY_SIZE];
  int accumulator = 0;
  int instructionCounter = 0;
  int instructionRegister = 0;
  int operationCode = 0;
  int operand = 0;

  Scanner scanner = new Scanner(System.in);
  
  public void start() {
    showWelcomeMessage();
    this.loadFromUser();
    this.dumpToScreen();
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

  private void dumpToScreen() {
    Formatter fmt = new Formatter();

    System.out.printf(
      "REGISTERS:\naccumulator \t\t%6s\ninstructionCounter \t%6s\ninstructionRegister \t%6s\noperationCode \t\t%6s\noperand\t\t\t%6s\n\n",
      formatAsInstruction(accumulator), 
      formatAsData(instructionCounter), 
      formatAsInstruction(instructionRegister), 
      formatAsData(operationCode), 
      formatAsData(operand)
    );

    System.out.println("MEMORY:");
    this.dumpMemoryToScreen();
  }

  private void dumpMemoryToScreen() {
    // print column labels
    System.out.printf("  ");
    for (int i = 0; i < 10; i++) {
      System.out.printf("%6d", i);
    }

    // print memory contents
    for (int i = 0; i < 10; i++) {
      System.out.printf("\n%2d", i);
      for (int j = 0; j < 10; j++) {
        System.out.printf(" %s", formatAsInstruction(memory[i * 10 + j]));
      }
    }
    System.out.printf("\n");
  }

  private String formatAsData(int input) {
    return String.format("%02d", input);
  }
  
  private String formatAsInstruction(int input) {
    return String.format("%+05d", input);
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
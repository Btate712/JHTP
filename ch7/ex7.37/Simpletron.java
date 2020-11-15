import java.util.Scanner;

public class Simpletron {
  int MEMORY_SIZE = 100;
  
  boolean programFinished = false; 
  boolean error = false;

  int [] memory = new int [MEMORY_SIZE];
  int accumulator = 0;
  int instructionCounter = 0;
  int instructionRegister = 0;
  int operationCode = 0;
  int operand = 0;
  String errorMessage = "";

  Scanner scanner = new Scanner(System.in);
  
  public void start() {
    showWelcomeMessage();
    this.loadFromUser();
    this.runProgram();
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

  private void runProgram() {
    System.out.println("*** Program loading completed ***");
    System.out.println("*** Program execution begins  ***");

    while (!this.programFinished && !this.error) {
      this.instructionRegister = this.memory[this.instructionCounter];
      this.operationCode = this.instructionRegister / 100;
      this.operand = this.instructionRegister % 100;
      this.executeLine();
    }

    if(this.error) {
      System.out.printf("%s\n*** Simpletron execution abnormally terminated ***\n", this.errorMessage);
    }
  }

  private void executeLine() {
    final int READ = 10;
    final int WRITE = 11;
    final int LOAD = 20;
    final int STORE = 21;
    final int ADD = 30;
    final int SUBTRACT = 31;
    final int DIVIDE = 32;
    final int MULTIPLY = 33;
    final int BRANCH = 40;
    final int BRANCHNEG = 41;
    final int BRANCHZERO = 42;
    final int HALT = 43;

    switch (this.operationCode) {
      case READ:
        System.out.printf("? ");
        this.memory[this.operand] = this.scanner.nextInt();
        this.instructionCounter++;
        break;
      case WRITE:
        System.out.printf("%s\n", this.formatAsData(this.memory[this.operand]));
        this.instructionCounter++;
        break;
      case LOAD:
        this.accumulator = this.memory[this.operand];
        this.instructionCounter++;
        break;
      case STORE:
        this.memory[this.operand] = this.accumulator;
        this.instructionCounter++;
        break;
      case ADD:
        this.accumulator += this.memory[this.operand];
        this.instructionCounter++;
        break;
      case SUBTRACT: 
        this.accumulator -= this.memory[this.operand]; 
        this.instructionCounter++;
        break;
      case DIVIDE: 
        if(this.memory[this.operand] == 0) {
          this.error = true;
          this.errorMessage = "*** Attempt to divide by zero ***";
        } else {
          this.accumulator /= this.memory[this.operand];
          this.instructionCounter++;
        }
        break;
      case MULTIPLY: 
        this.accumulator *= this.memory[this.operand];
        this.instructionCounter++;
        break;
      case BRANCH:
        this.instructionCounter = this.operand;
        break;
      case BRANCHNEG:
        if (this.accumulator < 0) {
          this.instructionCounter = this.operand;
        } else {
          this.instructionCounter++;
        }
        break;
      case BRANCHZERO:
        if (this.accumulator == 0) {
          this.instructionCounter = this.operand;
        } else {
          this.instructionCounter++;
        }
        break;
      case HALT:
        this.programFinished = true;
        break;
      default:
        this.error = true;
        this.errorMessage = "*** Unexpected operation code encountered ***";
    }

  }

  private void dumpToScreen() {
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
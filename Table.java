// Bob Tate 11/2/2020
// JHTP Exercise 2.31
public class Table {
  public static void main(String[] args) {
    System.out.printf("%s\t%s\t%s%n", "number", "square", "cube");
    for(int i = 0; i <= 10; i++) {
      System.out.printf("%d\t%d\t%d%n", i, i * i, i * i * i);
    }
  }
}
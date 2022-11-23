package hashApp.view;

import java.util.Scanner;

public class ConsoleView {
  private Scanner scanner;

  public ConsoleView() {
    this.scanner = new Scanner(System.in, "utf-8");
  }

  public void displayInputFileDialogue() {
    System.out.println("This application will take a txt-file and apply a hashing algorithm to its content.\n" +
      "Please note that each row in the file will be treated as a separate input string, and will generate it's own hash.");
    System.out.println("Enter source filename (must be located in the 'app/data' folder): ");
  }

  public String getSourceFileName() {
    return this.scanner.nextLine();
  }
}

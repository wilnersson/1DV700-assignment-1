package cryptologyApp.view;

import java.util.Scanner;

import cryptologyApp.view.Menu.EncryptionMethod;

public class ConsoleView {
  private Scanner scanner;

  public ConsoleView() {
    this.scanner = new Scanner(System.in, "utf-8");
  }

  public void displayEncryptionMethodSelection() {
    int menuNr = 0;
    for(EncryptionMethod method : EncryptionMethod.values()) {
      menuNr++;
      System.out.println(menuNr + ". " + method);
    }

    System.out.print("Make your selection (1-" + menuNr + "): ");
  }

  public EncryptionMethod getEncryptionMethodSelection() {
    int userSelection = this.scanner.nextInt();
    this.scanner.nextLine();

    return EncryptionMethod.values()[userSelection - 1];
  }
}

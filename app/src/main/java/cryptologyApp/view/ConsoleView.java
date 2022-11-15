package cryptologyApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import cryptologyApp.view.Menu.CryptologyAction;
import cryptologyApp.view.Menu.EncryptionMethod;

public class ConsoleView {
  private Scanner scanner;

  public ConsoleView() {
    this.scanner = new Scanner(System.in, "utf-8");
  }

  public void displayEncryptionMethodSelection() {
    int menuNr = 0;
    for (EncryptionMethod method : EncryptionMethod.values()) {
      menuNr++;
      System.out.println(menuNr + ". " + method);
    }

    System.out.print("Make your selection (1-" + menuNr + "): ");
  }

  public EncryptionMethod getEncryptionMethodSelection() {
    int userSelection = this.getUserIntegerInputInRange(EncryptionMethod.values().length);

    return EncryptionMethod.values()[userSelection - 1];
  }

  private int getUserIntegerInputInRange(int maxRange) {
    try {
      int userSelection = this.scanner.nextInt();

      if (userSelection < 1 || userSelection > maxRange) {
        throw new InputMismatchException();
      }

      this.scanner.nextLine();

      return userSelection;
    } catch (InputMismatchException error) {
      this.scanner.nextLine();
      System.out.println("Invalid input, try again...");
      return this.getUserIntegerInputInRange(maxRange);
    }
  }

  public void displayCryptologyActionSelection() {
    int menuNr = 0;
    for (CryptologyAction action : CryptologyAction.values()) {
      menuNr++;
      System.out.println(menuNr + ". " + action);
    }

    System.out.print("Make your selection (1-" + menuNr + "): ");
  }

  public CryptologyAction getCryptologyActionSelection() {
    int userSelection = this.getUserIntegerInputInRange(CryptologyAction.values().length);

    return CryptologyAction.values()[userSelection - 1];
  }
}

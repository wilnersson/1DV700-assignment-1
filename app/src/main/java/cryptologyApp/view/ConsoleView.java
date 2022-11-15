package cryptologyApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import cryptologyApp.model.SubstitutionKey;
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

  public void displayKeyInputDialogue(EncryptionMethod encryptionMethod) {
    switch (encryptionMethod) {
      case SUBSTITUTION:
        System.out.print("Enter key (1 character from the Extended ASCII table): ");
        break;
      case TRANSPOSITION:
        System.out.print("Enter key (string of characters from the Extended ASCII table, any lenght): ");
        break;
    }
  }

  public SubstitutionKey getUserSubstitutionKey() {
    try {
      String input = this.scanner.nextLine();

      if (input.length() < 1) {
        throw new IllegalArgumentException("Key must be at least 1 character.");
      }

      return new SubstitutionKey(input.charAt(0));
    } catch (IllegalArgumentException error) {
      System.out.println(error.getMessage() + " Try again...");
      return this.getUserSubstitutionKey();
    }
  }
}

package cryptologyApp.controller;

import cryptologyApp.view.ConsoleView;
import cryptologyApp.view.Menu.EncryptionMethod;

public class MainController {
  private ConsoleView view;

  public MainController(ConsoleView view) {
    this.view = view;
  }

  public void start() {
    this.view.displayEncryptionMethodSelection();

    EncryptionMethod selectedMethod = this.view.getEncryptionMethodSelection();

    // Debug
    System.out.println("You selected: " + selectedMethod);
  }
}

package cryptologyApp.controller;

import cryptologyApp.model.SubstitutionKey;
import cryptologyApp.view.ConsoleView;
import cryptologyApp.view.Menu.CryptologyAction;
import cryptologyApp.view.Menu.EncryptionMethod;

public class MainController {
  private ConsoleView view;

  public MainController(ConsoleView view) {
    this.view = view;
  }

  public void start() {
    this.view.displayEncryptionMethodSelection();
    EncryptionMethod selectedMethod = this.view.getEncryptionMethodSelection();

    this.view.displayCryptologyActionSelection();
    CryptologyAction selectedAction = this.view.getCryptologyActionSelection();

    this.view.displayKeyInputDialogue(selectedMethod);
    SubstitutionKey key = this.view.getUserSubstitutionKey();

    // Debug
    System.out.println("You selected " + selectedMethod + " and " + selectedAction + " with key: " + key.getKey());
  }
}

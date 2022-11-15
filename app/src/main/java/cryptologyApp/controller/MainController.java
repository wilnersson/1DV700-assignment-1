package cryptologyApp.controller;

import cryptologyApp.model.KeyInterface;
import cryptologyApp.view.ConsoleView;
import cryptologyApp.view.Menu.CryptologyAction;
import cryptologyApp.view.Menu.EncryptionMethod;

public class MainController {
  private ConsoleView view;
  private EncryptionMethod selectedEncryptionMethod;
  private CryptologyAction selectedAction;
  private KeyInterface selectedKey;


  public MainController(ConsoleView view) {
    this.view = view;
  }

  public void start() {
    this.view.displayEncryptionMethodSelection();
    this.selectedEncryptionMethod = this.view.getEncryptionMethodSelection();

    this.view.displayCryptologyActionSelection();
    this.selectedAction = this.view.getCryptologyActionSelection();

    this.view.displayKeyInputDialogue(selectedEncryptionMethod);
    this.selectedKey = this.view.getUserKey(selectedEncryptionMethod);

    // Debug
    System.out.println("You selected " + this.selectedEncryptionMethod + " and " + this.selectedAction + " with key: " + this.selectedKey.getKey());
  }
}

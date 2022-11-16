package cryptologyApp.controller;

import cryptologyApp.model.FileHandler;
import cryptologyApp.model.KeyInterface;
import cryptologyApp.model.SubstitutionAlgorithm;
import cryptologyApp.model.SubstitutionKey;
import cryptologyApp.view.ConsoleView;
import cryptologyApp.view.Menu.CryptologyAction;
import cryptologyApp.view.Menu.EncryptionMethod;

public class MainController {
  private ConsoleView view;
  private EncryptionMethod selectedEncryptionMethod;
  private CryptologyAction selectedAction;
  private KeyInterface selectedKey;
  private String input;


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

    FileHandler fileHandler = new FileHandler();

    this.view.displaySourceFileNameInputDialogue();
    this.input = fileHandler.readFromFile(this.view.getSourceFileName());

    // Debug
    System.out.println("You selected " + this.selectedEncryptionMethod + " and " + this.selectedAction + " with key: " + this.selectedKey.getKey());
    System.out.println("File content:");
    System.out.println(this.input);

    SubstitutionAlgorithm algorithm = new SubstitutionAlgorithm(((SubstitutionKey)this.selectedKey));
    String encryptedInput = algorithm.encrypt(this.input);
    System.out.println("Encrypted string:\n" + encryptedInput);
    System.out.println("Decrypted string:\n" + algorithm.decrypt(encryptedInput));

    fileHandler.writeToFile(encryptedInput, "test-output.txt");
  }
}

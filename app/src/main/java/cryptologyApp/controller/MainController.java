package cryptologyApp.controller;

import java.io.FileNotFoundException;

import cryptologyApp.model.FileHandler;
import cryptologyApp.model.KeyInterface;
import cryptologyApp.model.SubstitutionAlgorithm;
import cryptologyApp.model.SubstitutionKey;
import cryptologyApp.view.ConsoleView;
import cryptologyApp.view.Menu.CryptologyAction;
import cryptologyApp.view.Menu.EncryptionMethod;

public class MainController {
  private ConsoleView view;
  private FileHandler fileHandler;
  private EncryptionMethod selectedEncryptionMethod;
  private CryptologyAction selectedAction;
  private KeyInterface selectedKey;
  private String input;


  public MainController(ConsoleView view) {
    this.view = view;
    this.fileHandler = new FileHandler();
  }

  public void start() {
    this.setEncryptionMethod();
    this.setCryptologyAction();
    this.setKey();
    this.setInput();
    this.runProgramCycle();

    // Debug
    System.out.println("You selected " + this.selectedEncryptionMethod + " and " + this.selectedAction + " with key: " + this.selectedKey.getKey());
    System.out.println("File content:");
    System.out.println(this.input);

    SubstitutionAlgorithm algorithm = new SubstitutionAlgorithm(((SubstitutionKey)this.selectedKey));
    String encryptedInput = algorithm.encrypt(this.input);
    System.out.println("Encrypted string:\n" + encryptedInput);
    System.out.println("Decrypted string:\n" + algorithm.decrypt(encryptedInput));
  }

  private void setEncryptionMethod() {
    this.view.displayEncryptionMethodSelection();
    this.selectedEncryptionMethod = this.view.getEncryptionMethodSelection();
  }

  private void setCryptologyAction() {
    this.view.displayCryptologyActionSelection();
    this.selectedAction = this.view.getCryptologyActionSelection();
  }

  private void setKey() {
    this.view.displayKeyInputDialogue(selectedEncryptionMethod);
    this.selectedKey = this.view.getUserKey(selectedEncryptionMethod);
  }

  private void setInput() {
    try {
      FileHandler fileHandler = new FileHandler();

      this.view.displaySourceFileNameInputDialogue();
      this.input = fileHandler.readFromFile(this.view.getSourceFileName());
    } catch (FileNotFoundException e) {
      this.setInput();
    }
  }

  private void runProgramCycle() {
    if (selectedEncryptionMethod == EncryptionMethod.SUBSTITUTION) {
      this.runSubstitution();
    } else if (selectedEncryptionMethod == EncryptionMethod.TRANSPOSITION) {
      this.runTransposition();
    }
  }

  private void runSubstitution() {
    SubstitutionAlgorithm algorithm = new SubstitutionAlgorithm((SubstitutionKey)this.selectedKey);

    if (selectedAction == CryptologyAction.ENCRYPT) {
      String cipherText = algorithm.encrypt(this.input);
      this.createOutputFile(cipherText, "substitution-encryption");
    } else if (selectedAction == CryptologyAction.DECRYPT) {
      String plainText = algorithm.decrypt(this.input);
      this.createOutputFile(plainText, "substitution-decryption");
    }
  }

  private void runTransposition() {
    // TODO: Implement transposition cycle.
  }

  private void createOutputFile(String fileContent, String fileName) {
    String currentDateTime = java.time.LocalDateTime.now().toString();
    this.fileHandler.writeToFile(fileContent, fileName + "_" + currentDateTime + ".txt");
  }
}

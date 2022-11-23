package hashApp.controller;

import java.io.FileNotFoundException;

import cryptologyApp.model.FileHandler;
import hashApp.model.HashingAlgorithm;
import hashApp.view.ConsoleView;

public class MainController {
  private ConsoleView view;
  private FileHandler fileHandler;
  private String input;

  public MainController(ConsoleView view) {
    this.view = view;
    this.fileHandler = new FileHandler();
  }

  public void start() {
    this.setInput();
    String hashes = this.generateHashes();
    this.saveHashesToFile(hashes);
  }

  private void setInput() {
    try {
      this.view.displayInputFileDialogue();
      this.input = this.fileHandler.readFromFile(this.view.getSourceFileName());
    } catch (FileNotFoundException e) {
      this.setInput();
    }
  }

  private String generateHashes() {
    String[] input = this.input.split("\n");
    HashingAlgorithm hashingAlgorithm = new HashingAlgorithm();
    String output = "";

    for (String inputLine : input) {
      output += hashingAlgorithm.hash(inputLine);
      output += "\n";
    }

    return output;
  }

  private void saveHashesToFile(String hashes) {
    String currentDateTime = java.time.LocalDateTime.now().toString();
    this.fileHandler.writeToFile(hashes, "hashes_" + currentDateTime + ".txt");
  }
}

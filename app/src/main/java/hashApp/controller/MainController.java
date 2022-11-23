package hashApp.controller;

import java.io.FileNotFoundException;

import cryptologyApp.model.FileHandler;
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
  }

  private void setInput() {
    try {
      this.view.displayInputFileDialogue();
      this.input = this.fileHandler.readFromFile(this.view.getSourceFileName());
    } catch (FileNotFoundException e) {
      this.setInput();
    }
  }
}

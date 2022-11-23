package hashApp.controller;

import hashApp.view.ConsoleView;

public class App {
  public static void main(String[] args) {
    ConsoleView view = new ConsoleView();
    MainController controller = new MainController(view);
    
    controller.start();
  }
}

package cryptologyApp.model;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
  private static final String PATH = "data/";

  public void writeToFile(String fileContent, String fileName) {
    try {
      FileWriter writer = new FileWriter(PATH + fileName);
      writer.write(fileContent);
      writer.close();
    } catch (IOException error) {
      System.out.println(error.getMessage());
    }
  }
}

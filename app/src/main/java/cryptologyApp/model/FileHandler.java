package cryptologyApp.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

  public String readFromFile(String fileName) throws FileNotFoundException {
    try {
      File sourceFile = new File(PATH + fileName);
      Scanner scanner = new Scanner(sourceFile, "utf-8");
      String result = "";

      while (scanner.hasNextLine()) {
        result += scanner.nextLine();

        if (scanner.hasNextLine()) {
          result += "\n";
        }
      }

      scanner.close();
      return result;
    } catch (IOException error) {
      System.out.println(error.getMessage());
      throw new FileNotFoundException();
    }
  }
}

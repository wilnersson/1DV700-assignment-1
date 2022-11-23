package hashApp.model;

public class HashingAlgorithm {
  public int hash(String input) {
    long inputTotalValue = 0;

    for (int i = 0; i < input.length(); i++) {
      int currentCharValue  = input.charAt(i);
      inputTotalValue += currentCharValue * currentCharValue;
    }

    int result = (int)(inputTotalValue % 256);

    return result;
  }
}

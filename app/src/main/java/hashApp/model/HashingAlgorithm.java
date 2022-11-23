package hashApp.model;

public class HashingAlgorithm {
  private final int NR_OF_BUCKETS = 256;

  public int hash(String input) {
    long inputTotalValue = 0;

    for (int i = 0; i < input.length(); i++) {
      int currentCharValue  = input.charAt(i);
      inputTotalValue += Math.pow(currentCharValue, 2);
    }

    int result = (int)(inputTotalValue % NR_OF_BUCKETS);

    return result;
  }
}

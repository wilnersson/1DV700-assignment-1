package cryptologyApp.model;

public class TranspositionKey implements KeyInterface {
  private String key;
  private static final int MIN_ALLOWED_CHAR_VALUE = 0;
  private static final int MAX_ALLOWED_CHAR_VALUE = 255;

  public TranspositionKey(String key) {
    this.validateKey(key);
    this.key = key;
  }

  private void validateKey(String key) {
    for (int i = 0; i < key.length(); i++) {
      if (key.charAt(i) < MIN_ALLOWED_CHAR_VALUE || key.charAt(i) > MAX_ALLOWED_CHAR_VALUE) {
        throw new IllegalArgumentException("Key must only contain characters from the ASCII- or Extended ASCII-table.");
      }
    }
  }

  public String getKey() {
    return key;
  }
}

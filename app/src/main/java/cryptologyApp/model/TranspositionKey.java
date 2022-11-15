package cryptologyApp.model;

public class TranspositionKey {
  private String key;

  public TranspositionKey(String key) {
    this.validateKey(key);
    this.key = key;
  }

  private void validateKey(String key) {
    for (int i = 0; i < key.length(); i++) {
      if (key.charAt(i) < 0 || key.charAt(i) > 255) {
        throw new IllegalArgumentException("Key must only contain characters from the ASCII- or Extended ASCII-table.");
      }
    }
  }

  public String getKey() {
    return key;
  }
}

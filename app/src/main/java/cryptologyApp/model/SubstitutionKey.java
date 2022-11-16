package cryptologyApp.model;

public class SubstitutionKey implements KeyInterface {
  private String key;
  private static final int CHAR_POSITION_ZERO = 0;

  public SubstitutionKey(String key) {
    this.validateKey(key);
    this.key = key;
  }

  private void validateKey(String key) {
    if (key.length() != 1) {
      throw new IllegalArgumentException("Key must be exactly one character in length.");
    }

    if (key.charAt(CHAR_POSITION_ZERO) < 0 || key.charAt(CHAR_POSITION_ZERO) > 255) {
      throw new IllegalArgumentException("Key must be part of the ASCII- or Extended ASCII-table.");
    }
  }

  public String getKey() {
    return this.key;
  }

  public char getKeyAsChar() {
    return this.key.charAt(CHAR_POSITION_ZERO);
  }
}

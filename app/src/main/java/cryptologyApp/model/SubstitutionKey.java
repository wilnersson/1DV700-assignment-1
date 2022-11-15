package cryptologyApp.model;

public class SubstitutionKey {
  private char key;

  public SubstitutionKey(char key) {
    this.validateKey(key);
    this.key = key;
  }

  private void validateKey(char key) {
    if (key < 0 || key > 255) {
      throw new IllegalArgumentException("Key must be part of the ASCII- or Extended ASCII-table.");
    }
  }

  public char getKey() {
    return this.key;
  }
}

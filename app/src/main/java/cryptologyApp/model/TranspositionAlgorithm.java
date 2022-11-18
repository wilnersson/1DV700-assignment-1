package cryptologyApp.model;

public class TranspositionAlgorithm {
  private TranspositionKey key;

  public TranspositionAlgorithm (TranspositionKey key) {
    this.key = key;
  }

  public String encrypt(String plainText) {
    StringBuilder cipherText = new StringBuilder(plainText);
    String key = this.key.getKey();

    for (int i = 0; i < cipherText.length(); i++) {
      char currentChar = cipherText.charAt(i);
      int newPosition = ( i + key.charAt(i % key.length()) ) % plainText.length();
      char charOnNewPosition = cipherText.charAt(newPosition);

      cipherText.setCharAt(i, charOnNewPosition);
      cipherText.setCharAt(newPosition, currentChar);
    }

    return cipherText.toString();
  }

  public String decrypt(String cipherText) {
    // TODO: Add decrypt implementation.

    return "";
  }
}

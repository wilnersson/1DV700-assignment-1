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
    StringBuilder plainText = new StringBuilder(cipherText);
    String key = this.key.getKey();

    for (int i = cipherText.length() - 1; i >= 0; i--) {
      char currentChar = plainText.charAt(i);
      int newPosition = ( i + key.charAt(i % key.length()) ) % cipherText.length();
      char charOnNewPosition = plainText.charAt(newPosition);

      plainText.setCharAt(i, charOnNewPosition);
      plainText.setCharAt(newPosition, currentChar);
    }

    return plainText.toString();
  }
}

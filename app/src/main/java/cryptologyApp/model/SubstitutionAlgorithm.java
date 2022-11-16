package cryptologyApp.model;

public class SubstitutionAlgorithm {
  private SubstitutionKey key;

  public SubstitutionAlgorithm (SubstitutionKey key) {
    this.key = key;
  }

  public String encrypt(String plainText) {
    int keyValue = this.key.getKeyAsChar();
    String cipherText = "";

    for (int i = 0; i < plainText.length(); i++) {
      char currentCharacter = plainText.charAt(i);
      cipherText += Character.toString(currentCharacter + keyValue);
    }

    return cipherText;
  }

  public String decrypt(String cipherText) {
    int keyValue = this.key.getKeyAsChar();
    String plainText = "";

    for (int i = 0; i < cipherText.length(); i++) {
      char currentCharacter = cipherText.charAt(i);
      plainText += Character.toString(currentCharacter - keyValue);
    }

    return plainText;
  }
}

public class Account {

    private final String name;
    private boolean isNameValid;
    private boolean isCharacterFound;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        String specialCharacters = "'\"!#$%&'()*+,-./:;<=>?@[]^_`{|}";

        if (name.length() >= 3 && name.length() <= 19 && !name.startsWith(" ") && !name.endsWith(" ") && name.contains(" ")) {
            for (int i = 0; i < specialCharacters.length(); i++) {
                if (name.contains(Character.toString(specialCharacters.charAt(i)))) {
                    isCharacterFound = true;
                    break;
                }
            }
            if (!isCharacterFound) {
                isNameValid = true;
            }
        }

        return isNameValid;
    }
}

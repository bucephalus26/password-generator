package randompassword;

public class PasswordGenerator {

    private int total;
    private int length;
    private int type;
    private char password;



    public PasswordGenerator(int total, int length, int type) {
        this.total = total;
        this.length = length;
        this.type = type;
    }

    // Stores and returns passwords
    public String passwords(){
        // Store passwords in an array
        String[] randomPasswords = new String[total];

        // Loop through total number of passwords
        for (int i = 0; i < total; i++) {
            String randomPassword = "";
            for (int j = 0; j < length; j++) {

                // Generate random password
                randomPassword += createPassword();
            }
            // Add password to array
            randomPasswords[i] = randomPassword;
        }

        return randomPasswords[0];
    }

    // Creates password based on user desired type
    public char createPassword() {

        switch (type) {
            case 1:
                password = GenerateLowercase();
                break;
            case 2:
                password = GenerateUppercase();
                break;
            case 3:
                password = GenerateNumbers();
                break;
            case 4:
                password = GenerateLetters();
                break;
            case 5:
                password = GenerateLettersAndNumbers();
                break;
            case 6:
                password = GenerateLettersNumbersAndSymbols();
                break;
        }
        return password;
    }


    // Generating random passwords representing all possible characters between 33-126 in ASCII

    // Lowercase letters
    // a - z => 97-122 in ASCII
    // 26 uppercase letters = 26 possible characters
    public char GenerateLowercase() {
        int rand = (int) (Math.random() * 26);
        rand += 97;
        return (char) (rand);
    }

    // Uppercase letters
    // A - Z => 65-90 in ASCII
    // 26 uppercase letters = 26 possible characters
    public char GenerateUppercase() {
        int rand = (int) (Math.random() * 26);
        rand += 65;
        return (char) (rand);
    }

    // Numbers
    // 0 - 9 => 48-57 in ASCII
    // 10 Digits = 10 possible characters
    public char GenerateNumbers() {
        int rand = (int) (Math.random() * 10);
        rand += 48;
        return (char) (rand);
    }

    // Mix of uppercase and lowercase letters
    // 26 uppercase letters + 26 lowercase letters = 52 possible characters
    public char GenerateLetters() {
        int rand = (int) (Math.random() * 52);
        if ( rand <= 25) { // Uppercase letters
            rand += 65;
        } else { // Lowercase letters
            rand += 71;
        }
        return (char) (rand);
    }

    // Mix of letters and numbers
    // 10 digits + 26 uppercase letters + 26 lowercase letters = 62 possible characters
    public char GenerateLettersAndNumbers() {
        int rand = (int) (Math.random() * 62);
        if (rand <= 9) { // Numbers
            rand += 48;
            return (char) (rand);
        } else if (rand <= 35) { // Uppercase letters
            rand += 55;
            return (char) (rand);
        } else {
            rand += 61; // Lowercase letters
            return (char) (rand);
        }
    }

    // Mix of letters, numbers and symbols
    // 10 digits + 26 uppercase letters + 26 lowercase letters + 32 symbols = 94 possible characters
    public char GenerateLettersNumbersAndSymbols() {
        int rand = (int) (Math.random() * 94);
        if (rand <= 14){ // Symbols ! - / => 33-47 in ASCII
            rand += 33;
            return (char) (rand);
        } else if (rand <= 23) { // Numbers
            rand += 32;
            return (char) (rand);
        } else if (rand <= 30) { // Symbols : - @ => 58-63 in ASCII
            rand += +32;
            return (char) (rand);
        } else if (rand <= 56) { // Uppercase letters
            rand += 32;
            return (char) (rand);
        } else if (rand <= 62){ // Symbols [ - ` => 91-96 in ASCII
            rand += 32;
            return (char) (rand);
        } else if (rand <= 88){ // Lowercase letters
            rand += 32;
            return (char) (rand);
        } else {                // Symbols { - ~ => 123-126 in ASCII
            rand += 33;
            return (char) (rand);
        }
    }
}


public class Main {
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String p){
    int count = 0;    //when count is 0, it means that there are parentheses
    for(int i = 0; i<p.length(); i++){    //Starts with i=0 and goes through the loop with it
        char letter = p.charAt(i); //stores the char at position i in the variable 'letter'
        if(letter == '('){ //does the letter value contain the ( ?
            count = count + 1; //Add 1 to count to show there's an opening bracket present
        }
        else if(letter == ')'){ //does the letter value contain ) ?
            count = count - 1; //Subtract 1 to count to show that there's a closing bracket present
        }
    }
    return count == 0;  //returning a boolean (if count = 0, it will return true)
    }

    // 2. reverseInteger
    public static String reverseInteger(int number){
        String reversedNumber = "";   // string to hold the reversed number as we build it

        while(number > 0) {       // Process each digit of the number
            int lastDigit = number % 10;    // get the last digit of the number

            // append the last digit to the reversed string
            reversedNumber = reversedNumber + lastDigit;

            // remove the last digit from the number
            number = number / 10;
        }
        return reversedNumber;
    }

    // 3. encryptThis
    public static String encryptThis(String s){
        String[] words = s.split(" ");  // split the message into words
        StringBuilder encryptedString = new StringBuilder();

        for(String word : words) {       // process each word
            StringBuilder encryptedWord = new StringBuilder();

            //add ASCII code of the first letter
            int charCode = (int) word.charAt(0);
            encryptedWord.append(charCode);

            // If the word has more than 2 characters, swap the second and last characters
            if (word.length() > 2) {
                char secondChar = word.charAt(1);
                char lastChar = word.charAt(word.length() - 1);
                String middlePart = word.substring(2, word.length() - 1);

                encryptedWord.append(lastChar);
                encryptedWord.append(middlePart);
                encryptedWord.append(secondChar);
            } else if (word.length() == 2) {
                // If the word has exactly 2 characters, just append the second character
                encryptedWord.append(word.charAt(1));
            }

            // Add the encrypted word to the result
            encryptedString.append(encryptedWord);
            encryptedString.append(" ");
        }

        // return the final encrypted message, trimming the trailing space
        return encryptedString.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String s){
        String[] words = s.split(" ");   // split the message into words
        StringBuilder decipherString = new StringBuilder();

        for (String word : words) {    // process each word
            // extract the ASCII code from the beginning of the word
            StringBuilder codeString = new StringBuilder();

            int end =0;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                // Check if the character is a digit
                end = i;
                if (Character.isDigit(currentChar)) {
                    codeString.append(currentChar);
                } else {
                    break; // Stop if a non-digit character is encountered
                }
            }

            // convert the ASCII code back to the corresponding character
            int asciiCode = Integer.parseInt(codeString.toString());
            char firstChar = (char) asciiCode;

            // get the remaining part of the word (after the ASCII code)
            String remainingWord = word.substring(end);

            // Handle the case where the word has more than 2 characters
            if (remainingWord.length() > 1) {
                char secondChar = remainingWord.charAt(0);
                char lastChar = remainingWord.charAt(remainingWord.length() - 1);
                String middlePart = remainingWord.substring(1, remainingWord.length() - 1);

                // Swap the second and last characters to restore the original word
                remainingWord = lastChar + middlePart + secondChar;
            }

            // combine the first character and the processed remaining part
            String finalWord = firstChar + remainingWord;

            // append the deciphered word to the result
            decipherString.append(finalWord);
            decipherString.append(" ");
        }

        // Remove the trailing space and return the final deciphered message
        return decipherString.toString().trim();
    }
}
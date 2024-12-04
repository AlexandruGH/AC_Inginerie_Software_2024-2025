package encryption;

import java.util.Base64;

public class Base64Encoding {

    public static void main(String[] args) {
        // Encoding process
        String plaintext = "Hello, viitori ingineri!";
        String encoded_message = Base64.getEncoder().encodeToString(plaintext.getBytes());
        System.out.println("The Encoded string: " + encoded_message);

        // Decoding process
        byte[] decodedBytes = Base64.getDecoder().decode(encoded_message);
        String decodedString = new String(decodedBytes);
        System.out.println("The Decoded string: " + decodedString);
    }
}

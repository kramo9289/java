import java.io.*;
/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (4)
 */

public class AlphabetStorage {
    public static void main(String[] args) throws IOException {
        DirectAddressTable<Alphabet> alphabetTable = new DirectAddressTable<>();
        System.out.println("Enter comma-separated lower-case letters:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            for (String s : input.trim().split(","))
                alphabetTable.insert(new Alphabet(s.charAt(0)));
        }
        System.out.println(alphabetTable.toString());
    }
}

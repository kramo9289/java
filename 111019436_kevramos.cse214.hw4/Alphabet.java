/**
 *Kevin Ramos
 * 111019436
 * CSE 214 (4)
 */
public class Alphabet implements Hashable{

    private char aChar;

    public Alphabet(char letter) {
        if((int) letter <= 122 && (int) letter >= 97)
        aChar = letter;
        else throw new IllegalArgumentException("Not a lowercase letter of the alphabet");
    }

    /**
     * Returns the key of an instance of Alphabet. This is done by converting the character
     * into its ASCII format. Since the ASCII for the first letter of the alphabet 'a' is 97,
     * 97 is subtracted from its ASCII number to get the key. Guaranteed to produce a key between
     * 0 and 25;
     * @return The key of an instance of Alphabet.
     */
    @Override
    public int hash() {
        return (int) aChar - 97;
    }

    public String toString() {
        return "" + aChar;
    }

}

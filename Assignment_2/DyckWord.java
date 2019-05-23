/**
 * Kevin Ramos
 * 111019436
 * CSE 214 (2)
 */
package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * @author Ritwik Banerjee
 */
public class DyckWord {

    private final String word;

    public DyckWord(String word) {
        if (isDyckWord(word))
            this.word = word;
        else
            throw new IllegalArgumentException(String.format("%s is not a valid Dyck word.", word));
    }

    /**
     * The method takes in a word and determines whether or not it is a dyck word using the enum class Brackets.
     *
     * @param word which the method will check to see if it is Dyck or not.
     * @return true/false if the word is a dyck word.
     * @author Kevin Ramos
     */
    private static boolean isDyckWord(String word) {
        Stack dyck = new Stack();
        char[] charArr = word.toCharArray();
        for(int i=0; i<charArr.length; i++) {
            if(Brackets.isLeftBracket(charArr[i])) {
                dyck.push(charArr[i]);
            }
            if(Brackets.isRightBracket(charArr[i])) {
                if(dyck.isEmpty()) {
                    return false;
                }else if(Brackets.correspond((char)dyck.pop(), charArr[i])) continue;

                return false;
            }
        }
        return dyck.isEmpty();
    }

    public String getWord() {
        return word;
    }

}

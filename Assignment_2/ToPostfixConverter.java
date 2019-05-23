/**
 * Kevin Ramos
 * 111019436
 * CSE 214 (2)
 */
package applications.arithmetic;

import datastructures.sequential.Stack;

/**
 * The class is used to convert an expression which has already been determined to be a dyck word
 * into its correct postfix expression. The class uses three methods which contribute to creating the
 * postfix expression using the stack class that was created. The purpose of this class is to provide
 * an expression that can easily be evaluated using an algorithm. The postfix expression will be evaluated
 * in a different class.
 *
 * @author Kevin Ramos
 */
public class ToPostfixConverter implements Converter{

    /**
     * The method that converts the dyck word into a postfix expression using the other methods in this class as well
     * as the stack and enum classes.
     *
     * @param expression that is in dyck format. This ArithmeticExpression will become the postfix expression.
     * @return the String format of the postfix expression with a single space in between each token.
     */
    @Override
    public String convert(ArithmeticExpression expression) {

        String postfix = "";
        String infix = expression.getExpression();
        Stack opStack = new Stack();

        for(int i=0; i<infix.length(); i++){
            String currentToken = nextToken(infix, i);

            if(isOperand(currentToken)) {
                postfix+=currentToken+ " ";
                i+=currentToken.length()-1;
                continue;
            }

            if(Brackets.isLeftBracket(currentToken)) {
                opStack.push(currentToken);
            }

            if(Brackets.isRightBracket(currentToken)) {
                if(opStack.isEmpty()) continue;
                String topOfStack = "" + opStack.pop();
                while(!Brackets.isLeftBracket(topOfStack)) {
                    postfix+=topOfStack + " ";
                    topOfStack  = "" + opStack.pop();
                }
            }

            if(Operator.isOperator(currentToken)) {
                if(opStack.isEmpty()) {
                    opStack.push(currentToken);

                    continue;
                }
                String topOfStack = "" + opStack.peek();
                while(Operator.of(topOfStack).getRank() >= Operator.of(currentToken).getRank() && opStack.isEmpty()) {
                    postfix+= opStack.pop() + " ";
                    topOfStack = "" + opStack.peek();
                }

                opStack.push(currentToken);
            }

        }


        if(!opStack.isEmpty()) {
            String topOpStack = "" +opStack.pop();
            if(opStack.isEmpty()) {
                postfix+= topOpStack + " ";
                return postfix;
            }
            while(!opStack.isEmpty()) {
                postfix+= topOpStack + " ";
                topOpStack = "" + opStack.pop();
            }
            postfix+= topOpStack + " ";
        }

        return postfix;
    }

    /**
     * The method creates the token (no matter how long the token can be) from the string with the starting point.
     *
     * @param s the string that contains the expression
     * @param start the starting index of the string where the token will be created.
     * @return the string form of the token that will be created from the expression and the starting index.
     */
    @Override
    public String nextToken(String s, int start) {
        char[] charArr = s.toCharArray();
        TokenBuilder nextToken = new TokenBuilder();
        nextToken.append(charArr[start]);
        if(!isOperand("" + charArr[start])){
            return nextToken.build();
        }

        for(int i=start+1; i<charArr.length; i++){
            if(isOperand("" + charArr[i])) {
                nextToken.append(charArr[i]);
                continue;
            }
            break;
        }

        return nextToken.build();
    }
    /**
     * Determines whether or not the string passed is an operand or not.
     *
     * @param s the string to be determined.
     * @return true/false if the string s is an operand or not.
     */
    @Override
    public boolean isOperand(String s) {
        return ((!Operator.isOperator(s) && !Brackets.isLeftBracket(s) && !Brackets.isRightBracket(s)) || s.equals("."));
    }
}

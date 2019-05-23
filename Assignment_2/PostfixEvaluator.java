/**
 * Kevin Ramos
 * 111019436
 * CSE 214 (2)
 */
package applications.arithmetic;

import datastructures.sequential.Stack;


/**
 * The PostfixEvaluator is the final step of the process from dyck word to the postfix expression. This class
 * will evaluate the given postfix expression using the Operator enum class and using the correct algorithm. This
 * class implements the Evaluator interface and uses the stack class to evaluate the expression.
 *
 * @author Kevin Ramos
 */
public class PostfixEvaluator implements  Evaluator{

    /**
     * Takes in the postfix string expression and evaluates it using stacks.
     *
     * @param expressionString the string format of postfix expression with a space in between each token.
     * @return the correct evaluation of the expression in double format.
     */
    @Override
    public double evaluate(String expressionString) {
        String[] tokens  = expressionString.split(" ");

        Stack numStack = new Stack();

        for(int i=0; i<tokens.length; i++) {
            if(Operator.isOperator(tokens[i])) {
                double op2 = Double.parseDouble("" + numStack.pop());
                double op1 = Double.parseDouble("" + numStack.pop());
                double result = 0;
                if(Operator.of(tokens[i]).equals(Operator.ADDITION)) {
                    result = op1 + op2;
                }
                if(Operator.of(tokens[i]).equals(Operator.SUBTRACTION)) {
                    result = op1 - op2;
                }
                if(Operator.of(tokens[i]).equals(Operator.MULTIPLICATION)) {
                    result = op1 * op2;
                }
                if(Operator.of(tokens[i]).equals(Operator.DIVISION)) {
                    result = op1 / op2;
                }
                numStack.push("" + result);
            }else numStack.push(tokens[i]);
        }

        return Double.parseDouble("" + numStack.pop());
    }
}

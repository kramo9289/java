/**
 * Kevin Ramos
 * 111019436
 * CSE 214 (2)
 */
package applications.arithmetic;

/**
 * This interface is used for classes that will evaluate different expressions. To be used to define
 * the PostfixEvaluator class.
 *
 * @author Kevin Ramos
 */
public interface Evaluator {

    /**
     * The method that will be used to evaluate the expression and return the appropriate result
     *
     * @param expressionString the correct format of the expression that will be evaluated.
     * @return the result of evaluating the expression in a double format.
     */
    double evaluate(String expressionString);
}

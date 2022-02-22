package com.thealgorithms.datastructures.stacks;

import java.util.Stack;

import static com.thealgorithms.datastructures.stacks.BranchCoverage.*;

/**
 * The nested brackets problem is a problem that determines if a sequence of
 * brackets are properly nested. A sequence of brackets s is considered properly
 * nested if any of the following conditions are true: - s is empty - s has the
 * form (U) or [U] or {U} where U is a properly nested string - s has the form
 * VW where V and W are properly nested strings For example, the string
 * "()()[()]" is properly nested but "[(()]" is not. The function called
 * is_balanced takes as input a string S which is a sequence of brackets and
 * returns true if S is nested and false otherwise.
 *
 * @author akshay sharma
 * @author <a href="https://github.com/khalil2535">khalil2535<a>
 * @author shellhub
 */
class BalancedBrackets {

    /**
     * Check if {@code leftBracket} and {@code rightBracket} is paired or not
     *
     * @param leftBracket left bracket
     * @param rightBracket right bracket
     * @return {@code true} if {@code leftBracket} and {@code rightBracket} is
     * paired, otherwise {@code false}
     */
    public static boolean isPaired(char leftBracket, char rightBracket) {
        char[][] pairedBrackets = {
            {'(', ')'},
            {'[', ']'},
            {'{', '}'},
            {'<', '>'}
        };
        for (char[] pairedBracket : pairedBrackets) {
            if (pairedBracket[0] == leftBracket && pairedBracket[1] == rightBracket) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if {@code brackets} is balanced
     *
     * @param brackets the brackets
     * @return {@code true} if {@code brackets} is balanced, otherwise
     * {@code false}
     */
    public static boolean isBalanced(String brackets) {
        if (brackets == null) { visit("54");
            throw new IllegalArgumentException("brackets is null");
        } visit("56");
        Stack<Character> bracketsStack = new Stack<>();
        for (char bracket : brackets.toCharArray()) { visit("58");
            switch (bracket) {
                case '(': visit("60");
                case '[': visit("61");
                case '{': visit("62");
                    bracketsStack.push(bracket);
                    break;
                case ')': visit("65");
                case ']': visit("66");
                case '}': visit("67");
                    if (visitIf(bracketsStack.isEmpty(), "68_1") || visitIf(!isPaired(bracketsStack.pop(), bracket), "68_2")) {
                        return false;
                    } visit("70");
                    break;
                default: visit("72");
                    /* other character is invalid */
                    return false;
            }
        } visit("76");
        return bracketsStack.isEmpty();
    }

    public static void main(String[] args) {
        assert isBalanced("[()]{}{[()()]()}");
        assert !isBalanced("[(])");
        isBalanced("");
        BranchCoverage.startNewPath();
        isBalanced("()");
        BranchCoverage.startNewPath();
        isBalanced("{[}");
        System.out.println(BranchCoverage.getResults());
    }
}

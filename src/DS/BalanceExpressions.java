package DS;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalanceExpressions {
    private final List<Character> leftBrackets = Arrays.asList('<', '(','[','{');
    private final List<Character> rightBrackets = Arrays.asList('>',')',']','}');

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
        // return right =='(' && left !=')'||
        //         right =='<' && left !='>'||
        //         right =='[' && left !=']'||
        //         right =='{' && left !='}';
    }

    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for (char ch: input.toCharArray()){
            // System.out.println("ch: " + ch);

            if (isLeftBracket(ch)){
                stack.push(ch);
                // System.out.println("stack" + stack);
            }

            if (isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                // System.out.println("stack before pop: " + stack);
                // System.out.println("ch pop: " + ch);
                var top = stack.pop();
                // System.out.println("top: " + top);
                if (bracketsMatch(top, ch)) return false;
                // System.out.println("stack after pop: " + stack);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        //edge cases
        //(
        //(()
        //)(
        //(]

        String str = "(1+2)";
        BalanceExpressions exp = new BalanceExpressions();
        System.out.println(exp.isBalanced(str));
    }
}

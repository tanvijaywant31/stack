import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * 
 * Check for balanced parenthesis in an expression.
 * 
 * BB: 1
 * 
 * Complexity:
 * Time complexity: O(n) where n is length of the string.
 * Space complexity: O(n) where n is length of string (space is used by stack)
 */
public final class BalancedParanthesis {
    
    private static final Map<Character, Character> brackets = new HashMap<>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }  
    
    private BalancedParanthesis() {};
    
    /**
     * Returns true is parenthesis match open and close.
     * Understands [], {}, () as the brackets
     * It is clients responsibility to include only valid paranthesis as input.
     * A false could indicate that either parenthesis did not match or input including chars other than valid paranthesis
     * 
     * @param str   the input brackets
     * @return      true if paranthesis match.
     */
    public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            return true;
        }
        // odd number would always result in false
        if ((str.length() % 2) != 0) {
            return false;
        }
        
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (brackets.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
                return false;
            } 
        }
        return stack.isEmpty();
    } 
    
    public static void main(String[] args) {
        assertTrue(isBalanced("{}([])"));
        assertFalse(isBalanced("([}])"));
        assertTrue(isBalanced("([])"));
        assertTrue(isBalanced("()[]{}[][]"));
        assertFalse(isBalanced("[["));
    }
}

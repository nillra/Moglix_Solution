
import java.util.Stack;
import java.util.Scanner;

public class Solution {

    public static int longestValidParentheses(String parentheses) {

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);

        int longestLength = 0;

        for (int currentIndex = 0; currentIndex < parentheses.length(); currentIndex++) {

            char currentCharacter = parentheses.charAt(currentIndex);

            if (currentCharacter == '(') {

                indexStack.push(currentIndex);

            } else {

                indexStack.pop();

                if (indexStack.isEmpty()) {

                    indexStack.push(currentIndex);

                } else {

                    int currentLength = currentIndex - indexStack.peek();

                    if (currentLength > longestLength) {
                        longestLength = currentLength;
                    }
                }
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String parentheses = scanner.nextLine();

        int result = longestValidParentheses(parentheses);

        System.out.println("Longest valid parentheses length: " + result);

        scanner.close();
    }
}

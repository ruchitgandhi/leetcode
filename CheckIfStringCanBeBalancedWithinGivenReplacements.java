import java.util.Stack;

public class CheckIfStringCanBeBalancedWithinGivenReplacements {
    public static void main(String[] args) {
        String expressions[] = {"<>", "<>><"};
        int maxreplacements[] = {1, 0};
        int[] result = balancedOrNot(expressions, maxreplacements);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] result = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            result[i] = evaluate(expressions[i], maxReplacements[i]);
        }
        return result;
    }

    private static int evaluate(String expression, int maxReplacement) {
        Stack<String> record = new Stack<>();
        int unbalancedCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '<') {
                record.push("<");
            } else if (expression.charAt(i) == '>') {
                if (!record.isEmpty()) {
                    record.pop();
                } else {
                    unbalancedCount++;
                    if (unbalancedCount > maxReplacement) {
                        break;
                    }
                }
            }
        }
        if (record.isEmpty() && unbalancedCount <= maxReplacement) {
            return 1;
        }
        return 0;
    }
}

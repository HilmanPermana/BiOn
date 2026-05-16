import java.util.Stack;

public class ExpressionTree {

    // CEK OPERATOR
    public boolean isOperator(
        String s
    ) {

        return s.equals("+") ||
               s.equals("-") ||
               s.equals("*") ||
               s.equals("/");
    }

    // BUILD TREE
    public ExpNode buildTree(
        String[] postfix
    ) {

        Stack<ExpNode> stack =
            new Stack<>();

        for (String s : postfix) {

            if (!isOperator(s)) {

                stack.push(
                    new ExpNode(s)
                );

            } else {

                ExpNode node =
                    new ExpNode(s);

                node.right =
                    stack.pop();

                node.left =
                    stack.pop();

                stack.push(node);
            }
        }

        return stack.pop();
    }

    // INORDER TRAVERSAL
    public void inorder(
        ExpNode root
    ) {

        if (root != null) {

            inorder(root.left);

            System.out.print(
                root.value + " "
            );

            inorder(root.right);
        }
    }

    // EVALUATE
    public int evaluate(
        ExpNode root
    ) {

        if (root == null)
            return 0;

        if (
            !isOperator(root.value)
        ) {

            return Integer.parseInt(
                root.value
            );
        }

        int left =
            evaluate(root.left);

        int right =
            evaluate(root.right);

        switch (root.value) {

            case "+":
                return left + right;

            case "-":
                return left - right;

            case "*":
                return left * right;

            case "/":
                return left / right;
        }

        return 0;
    }
}
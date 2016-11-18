import java.util.Stack;

/**
 * Created by 余屌丝 on 2016/11/18.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Ex3_5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        Ex3_5 a = new Ex3_5();
        a.push(3);
        a.push(4);
        System.out.println(a.pop());
    }
}

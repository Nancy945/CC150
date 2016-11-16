import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 * Created by Nancy on 2016/11/16.
 */
public class Ex3_6 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new Ex3_6().twoStacksSort(new int[]{2, 7, 3, 4, 5, 1});
        System.out.println(list);
    }

    /**
     * /*
     * 思路：
     * 只用两个栈排序，一个是有序的asc，另一个是无序的buffer就可以实现对一个栈的排序。如何有序，当原始栈只有一个时就有序了
     * numbers中第一个为栈顶
     * 主要是解决buffer栈顶元素放在asc的位置
     * 1. buffer栈顶大于等于asc栈顶或asc空
     * 直接放
     * 2. buffer栈顶小于asc栈顶
     * buffer栈顶值出栈，临时变量存放buffer栈顶值
     * 循环从asc中拿出值放到buffer直至asc空或满足1条件
     */


    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int length = numbers.length;
        ArrayList<Integer> resultList = new ArrayList<>(length);
        ArrayDeque<Integer> bufferStack = new ArrayDeque<>(length);
        ArrayDeque<Integer> ascStack = new ArrayDeque<>(length);
        //初始状态，buffer中放了length-1个与numbers逆序的数串，asc只剩栈底元素
        for (int i = length - 1; i >= 0; i--) {
            bufferStack.push(numbers[i]);
        }

        //排序
        while (!bufferStack.isEmpty()) {
            if (ascStack.isEmpty() || bufferStack.peek() >= ascStack.peek()) {
                ascStack.push(bufferStack.pop());
            } else {
                int bufferTop = bufferStack.pop();
                int oldSize = bufferStack.size();
                while (!ascStack.isEmpty() && bufferTop < ascStack.peek()) {
                    bufferStack.push(ascStack.pop());
                }
                ascStack.push(bufferTop);

//                注释掉更简洁，加上效率稍高。
//                int pushNum = bufferStack.size() - oldSize;
//                for (int i = 0; i < pushNum; i++) {
//                    ascStack.push(bufferStack.pop());
//                }
            }

        }
        for (int i = 0; i < length; i++) {
            resultList.add(ascStack.pop());
        }
        return resultList;
    }

}

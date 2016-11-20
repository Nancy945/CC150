/*
请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，
当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
给定一个操作序列int[][2] ope，每个操作的第一个数代表操作类型,
若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
请返回一个int[][]，为完成所有操作后的SetOfStacks，顺序应为从下到上，
默认初始的SetOfStacks为空。保证数据合法。
*/
import java.util.*;
 
public class EX3_3 {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        if (ope.length == 0)
            return null;
        ArrayList<ArrayList<Integer>> stacks = new ArrayList<>();
        ArrayList<Integer> array = new ArrayList<>(size);
        stacks.add(array);
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) { //进行push操作
                if (array.size() != size) {
                    array.add(ope[i][1]);
                } else {
                    array = new ArrayList<>(size);
                    stacks.add(array);
                    array.add(ope[i][1]);
                }
            } else if (ope[i][0] == 2) {//进行pop操作
                if (array.size() != 0) {
                    array.remove(array.size() - 1);
                } else {
                    stacks.remove(stacks.size() - 1);
                    array = stacks.get(stacks.size() - 1);
                    array.remove(array.size() - 1);
                }
            }
        }
        return stacks.size() == 0 ? null : stacks;
    }
}
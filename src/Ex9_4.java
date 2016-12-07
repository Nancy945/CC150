import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
 * 测试样例：
 * [123,456,789]
 * 返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 */

/**
 * 解题思路：
 * 递归
 * 假设集合S={a1,a2,...,an}，尝试从终止条件开始入手：
 * N=1
 * 集合{a1}有1个子集：{a1}
 * N=2
 * 集合{a1,a2}有3个子集：{a1}、{a2}、{a1,a2}
 * N=3
 * 集合{a1,a2,a3}有7个子集：{a1}、{a2}、{a3}、{a1,a2}、{a1,a3}、{a2,a3}、{a1,a2,a3}
 * 分析N=2与N=3时的情况，用N=3减去N=2得到{a3}、{a1,a3}、{a2,a3}、{a1,a2,a3}，得到的结果是新增的元素和N=2的情况每一个子集中添加了一个元素a3
 * 可以发现N=3的集合是N=2的集合加上新增元素自身以及N=2的集合每一个中添加一个新增元素
 */
public class Ex9_4 {
    private static ArrayList<ArrayList<Integer>> res;

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        getSubsets(a, 3);
        System.out.println();
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        if (A.length == 0) {
            return null;
        } else {
            Arrays.sort(A);//保证数组有序
            Collections.reverse(func(A, n - 1));//对结果进行翻转，满足题意
            return res;
        }
    }

    private static ArrayList<ArrayList<Integer>> func(int[] arr, int i) {
        if (0 == i) {//递归终止的条件，到达数组中第一个元素的时候，此时只有一个子集（即元素本身）
            res = new ArrayList<>();
            ArrayList<Integer> t = new ArrayList<>();
            t.add(arr[i]);
            res.add(t);
            return res;
        } else {
            res = func(arr, --i);
            int item = arr[i + 1];//获取当前集合中最大元素的下一个元素
            ArrayList<Integer> single = new ArrayList<>();
            single.add(item);
            ArrayList<ArrayList<Integer>> moreSub = new ArrayList<>();//创建一个临时集合
            moreSub.add(single);//将此元素添加到临时集合的第一个
            for (ArrayList<Integer> subs : res) {
                ArrayList<Integer> newSub = new ArrayList<>();//复制一份
                newSub.add(item);//首先添加当前集合中最大元素的下一个元素
                newSub.addAll(subs);//然后添加复制的元素
                moreSub.add(newSub);//将赋值的集合添加到临时集合
            }
            res.addAll(moreSub);//将临时集合添加到结果集合中
        }
        return res;
    }
}

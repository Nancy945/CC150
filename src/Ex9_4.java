import java.util.ArrayList;
import java.util.Arrays;

/**
 * 请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
 *  测试样例：
 *   [123,456,789]
 *    返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 */
public class Ex9_4 {
    public static void main(String[] srgs) {
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subRes = new ArrayList<>();
        Arrays.sort(A);

        return res;
    }

}

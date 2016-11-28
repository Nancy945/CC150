/**
 * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，使得一次操作无法取得数组number里某个整数的完整内容。唯一的可用操作是询问数组中第i个元素的二进制的第j位(最低位为第0位)，该操作的时间复杂度为常数，请设计算法，在O(n)的时间内找到这个数。
 * 给定一个数组number，即所有剩下的数按从小到大排列的二进制各位的值，如A[0][1]表示剩下的第二个数二进制从低到高的第二位。同时给定一个int n，意义如题。请返回缺失的数。
 * 测试样例：
 * [[0],[0,1]]
 * 返回：1
 * Created by Nancy on 2016/11/28.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex5_7 {
    public int findMissing(int[][] numbers, int n) {


        //必须奇偶相连，且从偶数开始，哪位不符合就是缺少对应位的数字
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i][0] != (i % 2)) {
                return i;
            }
        }

        return n;//如果前面全是奇偶相连，那么说明少了最后一个

    }
}


/**
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
 * 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 * 测试样例：
 * [1,2,3,-6,1]
 * 返回：6
 */
public class Ex17_8 {
    public static void main(String[] args) {
        int[] test = new int[]{-79,41,11,-141,39,137};
        System.out.println(getMaxSum01(test, 6));
    }

    private static int getMaxSum01(int[] A, int n) {
        int dp0 = A[0], max = A[0];
        for(int i = 1; i < n; i++){
            if(dp0 + A[i] > A[i])
                dp0 = dp0 + A[i];
            else
                dp0 = A[i];//更换序列
            if(dp0 > max)//更新序列和的最大值
                max = dp0;
        }
        return max;
    }

}

import java.util.Arrays;
import java.util.HashMap;

/**
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定两个string A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。
 * 测试样例：
 * "RGBY","GGRR"
 * 返回：[1,1]
 * Created by Nancy on 2016/12/16.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex17_5 {
    public int[] calcResult(String A, String guess) {
        if (A.length() != guess.length()) return null;

        int right = 0;
        int halfRight = 0;
        HashMap<Character, Integer> restMap = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {

            if (A.charAt(i) == guess.charAt(i)) {
                right++;
            } else {
//                restMap.compute(A.charAt(i), (k, v) -> v == null ? 1 : v + 1);
                if (restMap.get(A.charAt(i)) == null) {
                    restMap.put(A.charAt(i), 1);
                } else {
                    restMap.put(A.charAt(i), restMap.get(A.charAt(i)) + 1);
                }
            }
        }

        for (int i = 0; i < guess.length(); i++) {
//            if (restMap.getOrDefault(guess.charAt(i), 0) > 0 && A.charAt(i) != guess.charAt(i)) {
            if (restMap.get(guess.charAt(i)) != null
                    && restMap.get(guess.charAt(i)) > 0
                    && A.charAt(i) != guess.charAt(i)) {
                halfRight++;
                restMap.put(guess.charAt(i), restMap.get(guess.charAt(i)) - 1);
            }
        }

        return new int[]{right, halfRight};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Ex17_5().calcResult("YBBG", "RYGB")));
    }
}

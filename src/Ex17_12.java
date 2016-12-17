import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 * 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 * 测试样例：
 * [1,2,3,4,5],5,6
 * 返回：2
 * Created by Nancy on 2016/12/17.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex17_12 {
    public int countPairs(int[] A, int n, int sum) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }

        for (int i : A) {
            int neededNum = sum - i;
            if (map.get(neededNum) != null) {
                if (neededNum != i) {
                    count += map.get(neededNum);
                } else {
                    count += map.get(neededNum) - 1;

                }

            }
        }

        return count / 2;
    }

    int countPairs1(int[] A, int n, int sum) {
        if (A.length == 0 || n <= 0) {
            return 0;
        }
        // 排序
        Arrays.sort(A);

        int count = 0;
        int first = 0;
        int last = A.length - 1;

//        for(int i = 0,j = n - 1;i < j;){
//            int s = A[i] + A[j];
//            if(s == sum){
//                // 3 3 3这种情况
//                if(A[i] == A[j]){
//                    int x = j-i+1;
//                    count += x*(x-1)/2;
//                    break;
//                }//if
//                // 2 2 3 4 4 4这种情况
//                else{
//                    int k = i+1;
//                    while(k <= j && A[i] == A[k]){
//                        ++k;
//                    }//while
//                    int k2 = j-1;
//                    while(k2 >= i && A[j] == A[k2]){
//                        --k2;
//                    }//while
//                    count += (k-i)*(j-k2);
//                    i = k;
//                    j = k2;
//                }//else
//            }//if
//            else if(s < sum){
//                ++i;
//            }//else
//            else{
//                --j;
//            }//else
//        }//for

        while (first < last) {
            int s = A[first] + A[last];
            if (s > sum) last--;
            else if (s < sum) first++;
            else {
                if (A[first] == A[last]) {//例如 3 3 3
                    int x = last - first + 1;
                    count += (x * (x - 1)) / 2;
                    break;//这种情况之后就没有了，因为马上就要first>last了
                } else {
                    int k1 = first + 1;
                    while (k1 <= last && A[first] == A[k1]) k1++;
                    int k2 = last - 1;
                    while (k2 >= first && A[last] == A[k2]) k2--;
                    count += (k1 - first) * (last - k2);
                    first = k1;
                    last = k2;//从下一个数字开始
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Ex17_12().countPairs(new int[]{11, 7, 7, 6, 14, 2, 14, 15, 2, 1, 2, 12, 13, 9, 8, 15, 13, 8, 10, 11, 14, 10, 2, 9, 4, 9, 3, 7, 6, 10, 15, 4, 7, 6, 15, 3, 9, 13, 5, 2, 6, 10, 10, 1, 12, 4, 3, 3, 8, 8, 1, 4, 7, 11, 13, 5, 13, 15, 4, 3, 1, 11, 6, 11, 9, 9, 11, 15, 12, 10, 13, 3, 11, 4, 8, 9, 7, 3, 13, 9, 11, 3, 2, 11, 10, 1, 4, 2, 3, 3, 14, 11, 5, 10, 1, 14, 8, 1, 11, 3, 1, 9, 14, 6, 1, 7, 15, 10, 14, 6, 4, 12, 11}, 5, 16));
    }
}

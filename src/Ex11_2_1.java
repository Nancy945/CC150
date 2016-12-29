/**
 * 题目描述
 * 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，
 * 例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即变成了[6,1,2,3,4,5],现在
 * 对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算
 * 法完成这个任务。
 * 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，
 * 请返回x的位置(位置从零开始)。保证数组中元素互异。
 * 测试样例：
 * [6,1,2,3,4,5],6,6
 * 返回：0
 */

public class Ex11_2_1 {
    //在二分法的基础上，针对特殊情况的限制条件
    public static int findElement(int[] A, int n, int x) {
        int start = 0;
        int end = A.length - 1;
        int mid = -1;
        //由于移位了，但移位之后，中间元素的左右两边必定有一边是升序的
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == x)
                return mid;


            else if (x > A[mid]) {
                //右边有序，一定在左边
                if (A[mid] < A[start] && x > A[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                //左边有序，一定在右边
                if (A[mid] > A[start] && x < A[start])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 6, 1, 2, 3};
        int x = 5;
        System.out.println(x + ": " + findElement(A, 6, x));
    }
}

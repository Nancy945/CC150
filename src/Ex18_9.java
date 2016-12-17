import java.util.*;

/**
 * 现有一些随机生成的数字要将其依次传入，请设计一个高效算法，对于每次传入一个数字后，算出当前所有传入数字的中位数。(若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。
 * 给定一个int数组A，为传入的数字序列，同时给定序列大小n，请返回一个int数组，代表每次传入后的中位数。保证n小于等于1000。
 * 测试样例：
 * [1,2,3,4,5,6],6
 * 返回：[1,1,2,2,3,3]
 * Created by Nancy on 2016/12/17.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex18_9 {
    public int[] getMiddle(int[] A, int n) {
        //最大堆 与 最小堆 （最大堆：堆顶最大 最小堆：堆顶最小）
        //优先队列的头（就是出队的地方） 默认是最小的

        //不加参数n的是jdk1.8才有的！
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[A.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //maxHeap的size一定是 >= minHeap的size,而且最多只差一个
        for (int i = 0; i < A.length; i++) {
            addNumberToHeap(A[i], maxHeap, minHeap);
            result[i] = maxHeap.peek();
        }

        return result;

    }

    private void addNumberToHeap(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.size() == 0) {
                //如果都是空
                maxHeap.offer(number);
            } else if (number > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(number);
            } else {
                maxHeap.offer(number);
            }
        } else {
            if (number < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(number);
            } else {
                minHeap.offer(number);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Ex18_9().getMiddle(new int[]{1, 2, 3, 4, 5, 6}, 6)));

    }
}

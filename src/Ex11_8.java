import java.util.*;

/**
 * 现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
 * 请设计一个高效的数据结构和算法来实现这个功能。
 * 给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
 * 测试样例：[1,2,3,4,5,6,7],7
 * 返回：[0,1,2,3,4,5,6]
 */
public class Ex11_8 {

    class Node {
        int leftSize = 0;
        Node left, right;
        int val;

        public Node(int v) {
            val = v;
        }

        public void insert(int v) {
            if (v <= val) {
                if (left != null)
                    left.insert(v);
                else
                    left = new Node(v);
                leftSize++;
            } else {
                if (right != null)
                    right.insert(v);
                else
                    right = new Node(v);
            }
        }

        public int getRank(int v) {
            if (v == val)
                return leftSize;
            if (v < val)
                return left.getRank(v);
            if (v > val)
                return leftSize + 1 + right.getRank(v);
            return 0;
        }
    }

    private static int[] getRankOfNumber01(int[] A, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Iterator<Integer> it = list.iterator();
            int j = 0;
            while (it.hasNext()) {
                if (it.next() > A[i]) {
                    continue;
                }
                j++;
            }
            res[i] = j;
            list.add(j, A[i]);
        }
        return res;
    }

    Node root = null;

    private int[] getRankOfNumber(int[] A, int n) {
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = helper(A[i]);
        }
        return res;
    }

    private int helper(int a) {
        if (root == null) {
            root = new Node(a);
        } else {
            root.insert(a);
        }
        return root.getRank(a);
    }

}



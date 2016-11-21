import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by Nancy on 2016/11/21.
 */
public class Ex4_9 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            FindPath(root, target, list);
        }
        return resultList;

    }


    void FindPath(TreeNode root, int target, ArrayList<Integer> list) {

        list.add(root.val);

        //如果当前值已经符合给定要求，同时又是子节点(这个要求是题目的要求，必须是到叶子节点，不能到中间停止)
        if (target == root.val && root.left == null && root.right == null) {

//             拓展：如果用下面这个if语句，则可以在不到叶子节点也给出答案
//             if (target == root.val ) {


            resultList.add(list);
            return;
        } else if (target < root.val) {
            //如果下一层已经不可能满足值的要求，直接return
            return;
        }
        //else 如果下一层还有可能满足值的要求（target > root.val），则继续遍历

        ArrayList<Integer> list1 = new ArrayList<>(list);
        ArrayList<Integer> list2 = new ArrayList<>(list);

        if (root.left != null) {
            FindPath(root.left, target - root.val, list1);
        }

        if (root.right != null) {
            FindPath(root.right, target - root.val, list2);
        }

    }

    /**
     * 方法2 非常简洁
     */

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);//相当于这一层的入栈

        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            //将副本添加进去
            listAll.add(new ArrayList<>(list));
        }
        FindPath2(root.left, target);
        FindPath2(root.right, target);
        list.remove(list.size() - 1);//相当于这一层的出栈,由于之前添加的是副本，所以出栈对于listAll没有影响

        return listAll;
    }

    /**
     * 方法3：带记忆的DFS典型解法
     */
    ArrayList<ArrayList<Integer>> FindPath3(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> trace = new ArrayList<>();
        if (root != null) {
            dfs(root, target, ret, trace);
        }
        return ret;

    }

    void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> trace) {
        trace.add(root.val);//模拟入栈
        if (root.left == null && root.right == null) {
            if (target == root.val)
                ret.add(new ArrayList<>(trace));
        }
        if (root.left != null)
            dfs(root.left, target - root.val, ret, trace);
        if (root.right != null)
            dfs(root.right, target - root.val, ret, trace);
        trace.remove(trace.size() - 1);//模拟出栈


    }

    /**
     * 方法4：方法3的另外一个版本（不知道应不应该叫做改进），本层不对下一层进行判断。本层判断本层的
     */

    void dfs1(TreeNode root, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> trace) {
        if (root == null) return;

        trace.add(root.val);//模拟入栈
        if (root.left == null && root.right == null) {
            if (target == root.val)
                ret.add(new ArrayList<>(trace));
        }
        dfs(root.left, target - root.val, ret, trace);
        dfs(root.right, target - root.val, ret, trace);
        trace.remove(trace.size() - 1);//模拟出栈
    }


    public static void main(String[] args) {
        Ex4_9 obj = new Ex4_9();
        TreeNode node1 = obj.new TreeNode(10);
        TreeNode node2 = obj.new TreeNode(5);
        TreeNode node3 = obj.new TreeNode(12);
        TreeNode node4 = obj.new TreeNode(4);
        TreeNode node5 = obj.new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(obj.FindPath(node1, 15));
    }
}

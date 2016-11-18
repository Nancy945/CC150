/**
 * Created by 余屌丝 on 2016/11/18.
 * 题目描述
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Ex4_1 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //递归
    public static int height(TreeNode root) {
        if (root == null)
            return 0;

        int hl = height(root.left);
        int hr = height(root.right);
        int height = hl > hr ? hl : hr;
        return height + 1;
    }

    public boolean isBalance(TreeNode root) {
        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1)
            return false;

        return true;

    }

}

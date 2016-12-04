import java.util.*;

/**
 * Created by Administrator on 2016/11/27.
 */
public class Ex4_6 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一
     * @param root
     * @param p
     * @return
     */
    Stack<Integer> s;
    public int findSucc1(TreeNode root,int p){
        if (root == null) {
            return -1;
        }
        s = new Stack<>();
        PreOrderTraverse(root);
        int temp = 0;
        if (s.peek() == p)
            return -1;
        while (!s.isEmpty()) {
            temp = s.pop();
            if (s.peek() == p) {
                return temp;
            }
        }
        return -1;
    }
    private void PreOrderTraverse(TreeNode node){
        if (node != null) {
            PreOrderTraverse(node.left);
            s.push(node.val);
            PreOrderTraverse(node.right);
        }
    }


    public int findSucc(TreeNode root,int p){
        Stack<TreeNode> ss = new Stack<>();
        TreeNode node = root;
        boolean flag = false;
        while (node != null || !ss.isEmpty()) {
            while(node != null){
                ss.push(node);
                node = node.left;
            }
            if (!ss.isEmpty()) {
                TreeNode t = ss.pop();
                if (flag)
                    return node.val;
                else if (t.val == p)
                    flag = true;
                node = t.right;
            }
        }
        return -1;
    }
}

package 代码随想录.二叉树理论;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 对称二叉树101 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1left=new TreeNode(2);
        TreeNode node1right=new TreeNode(2);
        TreeNode node2right=new TreeNode(3);
        TreeNode node2rightright=new TreeNode(3);
        root.left=node1left;
        root.right=node1right;
        node1left.right=node2right;
        node1right.right=node2rightright;
        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(root));
    }
}
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        //使用层序遍历
        Deque<TreeNode> deque=new LinkedList<>();
        if (root!=null) deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            List<Integer> levelCount=new ArrayList<>();
            for (int i=0;i<count;i++){
                TreeNode tmp = deque.removeFirst();
                levelCount.add(tmp.val);
                if (tmp.left!=null)deque.addLast(tmp.left);
                if(tmp.right!=null) deque.addLast(tmp.right);
            }
            if (!isTrue(levelCount)) return false;
        }
        return true;
    }
    public boolean isTrue(List<Integer> list){
        int i=0,j=list.size()-1;
        while (i<j){
            if (list.get(i)!=list.get(j)) return false;
            i++;j--;
        }
        return true;
    }

}
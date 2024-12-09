package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图199 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if (root==null) return res;
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                if (i==count-1) res.add(node.val);
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);

            }
        }
        return res;
    }
}

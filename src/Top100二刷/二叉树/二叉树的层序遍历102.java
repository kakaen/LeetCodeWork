package Top100二刷.二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int levelCount=deque.size(); //记录当前行的总个数
            List<Integer> levelList=new ArrayList<>();
            for (int i=0;i<levelCount;i++){
                TreeNode node = deque.poll();
                levelList.add(node.val);
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            res.add(levelList);
        }
        return res;
    }
}

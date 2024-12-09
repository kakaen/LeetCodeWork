package Top100.链表.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        //队列的方式，先进先出
        Deque<TreeNode> deque=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int count=deque.size(); //计算上一层的节点个数
            List<Integer> levelList=new ArrayList<>();
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                levelList.add(node.val);
                if (node.left!=null) deque.offerLast(node.left);
                if (node.right!=null) deque.offerLast(node.right);
            }
            res.add(levelList);
        }
        return res;
    }
}

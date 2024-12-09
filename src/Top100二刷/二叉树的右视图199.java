package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树的右视图199 {
    public List<Integer> rightSideView(TreeNode root){
        //采用层序遍历
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        queue.addLast(root);
        while (!queue.isEmpty()){
            int count=queue.size(); //获取当前层的所有元素
            //将队列的队尾元素加入到答案中
            res.add(queue.peekLast().val);
            for (int i=0;i<count;i++){
                TreeNode node = queue.pollFirst();
                if (node.left!=null)queue.addLast(node.left);
                if (node.right!=null) queue.addLast(node.right);
            }
        }
        return res;
    }
    //dfs深度优先遍历来实现,我们先遍历右子树，再遍历左子树，当某个层级第一次出现时
    //
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    public void dfs(TreeNode root,int level,List<Integer> res){
        if (root==null) return;
        //这个层级首次遇到
        if (level==res.size()){
            res.add(root.val);
        }
        dfs(root.right,level+1,res);
        dfs(root.left,level+1,res);
    }
}

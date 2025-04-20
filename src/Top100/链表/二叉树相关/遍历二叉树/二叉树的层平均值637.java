package Top100.链表.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;

import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层平均值637 {
    public List<Double> averageOfLevels(TreeNode root){

        List<Double> res=new ArrayList<>();
        if (root==null) return res;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            double sum=0;
            TreeNode node;
            for (int i=0;i<count;i++){
                node=deque.pollFirst();
                sum+= node.val;
                if (root.left!=null) deque.addLast(root.left);
                if (root.right!=null) deque.addLast(root.right);
            }
            res.add(sum/count);
        }
        return res;
    }
}

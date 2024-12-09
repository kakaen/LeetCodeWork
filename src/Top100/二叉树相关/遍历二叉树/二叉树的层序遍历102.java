package Top100.二叉树相关.遍历二叉树;

import netscape.security.UserTarget;
import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历102 {
    public static void main(String[] args) {

    }
}
class Solution102{
    public List<List<Integer>> levelOrder(TreeNode root){
        //使用队列辅助
        Deque<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        queue.offerLast(root);
        while (!queue.isEmpty()){
            //获取该层的节点个数
            int count=queue.size();
            List<Integer> levelRes=new ArrayList<>();
            while (count>0){
                root = queue.pollFirst();
                levelRes.add(root.val);
                if (root.left!=null) queue.offerLast(root.left);
                if (root.right!=null) queue.offerLast(root.right);
                count--;
            }
            result.add(levelRes);
        }
        return result;
    }
    //方法二DFS实现
}
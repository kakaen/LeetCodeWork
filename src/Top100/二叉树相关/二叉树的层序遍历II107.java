package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 二叉树的层序遍历II107 {
    public static void main(String[] args) {

    }
}
class Solution107{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        //创建一个队列保存
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> path=new ArrayList<>();
            while (count>0){
                root=queue.pollFirst();
                path.add(root.val);
                if (root.left!=null) queue.offerLast(root.left);
                if (root.right!=null) queue.offerLast(root.right);
                count--;
            }
            result.add(path);
        }
        Collections.reverse(result);
        return result;
    }
}
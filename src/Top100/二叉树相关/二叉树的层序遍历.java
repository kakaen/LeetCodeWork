package Top100.二叉树相关;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        new ConcurrentHashMap<>();
    }
}
class Solution102 {
    //广度优先遍历，BFS，使用队列进行广度优先遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int count=queue.size(); //记录当前层的总元素
            List<Integer> path=new ArrayList<>();
            while (count>0){
                root=queue.pollFirst();
                path.add(root.val);
                if (root.left!=null) queue.add(root.left);
                if (root.right!=null) queue.add(root.right);
                count--;
            }
            result.add(new ArrayList<>(path));
        }
        return result;
    }

}

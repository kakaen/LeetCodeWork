package Top100.二叉树相关.遍历二叉树;

import netscape.security.UserTarget;
import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 左叶子之和404 {
    public static void main(String[] args) {

    }
}
class Solution404{
    public int sumOfLeftLeaves(TreeNode root){
       //遍历所有的树节点
        int count=0;
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                if (root.left!=null&&root.left.left==null&&root.left.right==null){
                    count+=root.left.val;
                }
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            root=root.right;
        }
        return count;
    }

}

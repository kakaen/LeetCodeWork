package Top100.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;
import 代码随想录.链表.ListNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class 二叉树的后续遍历 {
    public static void main(String[] args) {

    }
}
class Solution145{
    //使用递归方式实现
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> result){
        if (root==null) return;
        dfs(root.left,result);
        dfs(root.right,result);
        result.add(root.val);
    }
    //迭代的后续遍历
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode pre=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //从栈顶弹出的元素，一定是左子树已经访问
            root=stack.pop();
            //现在需要确认
            if (root.right==null||root.right==pre){
                result.add(root.val);
                pre=root;
                root=null;
            }else{
                stack.push(root);
                root=root.right;
            }
        }
        return result;
    }
    //后序遍历，左右根， 前序遍历：根右左
    public List<Integer> postorderTraversal3(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                result.add(root.val);
                stack.push(root.left);
            }
            root = stack.pop();
            stack.push(root.left);
            stack.pop();
        }
        Collections.reverse(result);
        return result;
    }
}

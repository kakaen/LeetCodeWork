package Top100.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 开幕式之火LCP44 {
    public static void main(String[] args) {

    }
}
class SolutionLCP44{
    public Set<Integer> set=new HashSet<>();
    public int numColor(TreeNode root){
        //直接遍历不就可以了
        preorderTraversal(root);
        return set.size();
    }
    public void preorderTraversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                set.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
    }
}

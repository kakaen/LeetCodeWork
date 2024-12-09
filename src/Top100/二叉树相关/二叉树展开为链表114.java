package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树展开为链表114 {
    public static void main(String[] args) {

    }
}
class Solution114 {
    //使用非O(1)的空间实现
    public void flatten(TreeNode root) {
       //使用递归实现
        Deque<TreeNode> stack=new LinkedList<>();
    }
    public void dfs(TreeNode node){
        if (node==null) return;
        if (node.left==null) return;

    }
}
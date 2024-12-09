package Top100.链表;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 翻转二叉树226 {
    public static void main(String[] args) {

    }
}
class Solution226{
    public TreeNode invertTree(TreeNode root){
        //前序遍历
        preOrder(root);
        return root;
    }
    //DFS的做法，
    public void preOrder(TreeNode node){
        if (node==null) return;
        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=node.left;
        preOrder(node.left);
        preOrder(node.right);
    }
    //迭代法的实现方式,使用栈，使用层序遍历
    public TreeNode inverTree2(TreeNode root){
       //创建一个队列进行
        Deque<TreeNode> deque=new LinkedList<>();
        if (root!=null) deque.offerLast(root);
        while (!deque.isEmpty()){
            int count=deque.size(); //计算该层的总个数
            for (int i=0;i<count;i++){
                //出队头元素
                TreeNode node = deque.pollFirst();
                //交换该节点的两个左右节点
                swap(node);
                if (node.left!=null) deque.offerLast(node.left);
                if (node.right!=null) deque.offerLast(node.right);
            }
        }
        return root;
    }
    public void swap(TreeNode node){
        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=tmp;
    }
}

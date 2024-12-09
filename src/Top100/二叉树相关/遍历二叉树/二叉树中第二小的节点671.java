package Top100.二叉树相关.遍历二叉树;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树中第二小的节点671 {
    public static void main(String[] args) {

    }
}
class Soution671{
    public int findSecondMinimumValue(TreeNode root){
        //使用层序遍历
        Deque<TreeNode> deque=new LinkedList<>();
        if (root==null) return -1;
        int firstMin=root.val;
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            int min=Integer.MAX_VALUE; //找到该层的最小元素，应该是第二小的元素，
            // 因为第一小的元素一定和上一层一样
            for (int i=0;i<count;i++){
                TreeNode node = deque.pollFirst();
                //说明有两个节点
                int nodeMax=0;
                if (node.left!=null&&node.right!=null){
                    //两个节点中取最大的才是第二小的元素
                    nodeMax=Math.max(node.left.val,node.right.val);
                }
                min=Math.min(min,nodeMax);
                if (min!=firstMin&&min!=Integer.MAX_VALUE) return min;
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
        }
        return -1;
    }
    //通过遍历
    public int findSecondMinimumValue2(TreeNode root){
        if (root==null) return -1;
        int min=root.val;
        long ans=Long.MAX_VALUE; //更新大于ans的最小
        Deque<TreeNode> stack=new LinkedList<>();
        //遍历树的所有节点
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                if (root.val>min) ans=Math.min(ans,root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        return ans==Long.MAX_VALUE?-1:(int)ans;
    }
}

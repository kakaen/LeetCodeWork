package Top100.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.*;

public class 二叉树的锯齿形层序遍历103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        //创建存储答案的
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        //创建队列来辅助层序遍历
        Deque<TreeNode> deque=new LinkedList<>();
        //创建一个flag来记录是从左往右还是从右往左进行遍历
        boolean flag=true; //为true，则是从左往右，为false则是从右往左
        deque.addLast(root);
        while (!deque.isEmpty()){
            int count=deque.size();
            List<Integer> list=new ArrayList<>();
            TreeNode node=null;
            for (int i=0;i<count;i++){
                node=deque.pollFirst();
                list.add(node.val);
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
            }
            if (flag==false){
                Collections.reverse(list);
            }
            flag=!flag;
            res.add(list);
        }
        return res;
    }
}

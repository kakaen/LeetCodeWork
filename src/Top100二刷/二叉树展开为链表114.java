package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 二叉树展开为链表114 {
    //采用前序遍历的方式来实现
    public void flatten(TreeNode root) {
        //对于一个节点来说，他的左自助节点一定插入到右子树中第一个访问的元素
        List<TreeNode> list=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        //先前序遍历
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                list.add(root);
                stack.push(root);
                root=root.left;
            }
            root=stack.poll().right;
        }
        //组装链表
        TreeNode pre,cur;
        for (int i=1;i<list.size();i++){
            pre=list.get(i-1);
            cur=list.get(i);
            pre.left=null;
            pre.right=cur;
        }
        return;
    }
    //寻找前驱节点的方式来实现,在访问到当前节点时，如果左子树存在，则寻找左子树的最右节点
    //将当前节点的右子树链接到左子树最右节点
    public void flatten2(TreeNode root){
        TreeNode cur=root;
       while (cur!=null){
           if (cur.left!=null){
               //准备查找左子树的最右节点
               TreeNode predessor=cur.left;
               while (predessor.right!=null){
                   predessor=predessor.right;
               }
               predessor.right=cur.right;
               cur.right=cur.left;
               cur.left=null;
           }
           cur=cur.right;
       }
    }
}

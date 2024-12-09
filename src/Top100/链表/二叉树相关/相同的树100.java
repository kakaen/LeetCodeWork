package Top100.链表.二叉树相关;

import 代码随想录.二叉树理论.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 相同的树100 {
    public boolean isSmaeTree(TreeNode p,TreeNode q){
        //如何判断两个数一样呢。我相同的方式遍历
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;
        //使用前序遍历的方式
        Deque<TreeNode> deque1=new LinkedList<>();
        Deque<TreeNode> deque2=new LinkedList<>();
        while ((p!=null||!deque1.isEmpty())&&(q!=null||!deque2.isEmpty())){
            while (p!=null&&q!=null){
                if (p.val!=q.val) return false;
                p=p.left;
                q=q.left;
                deque1.push(p);
                deque2.push(q);
            }
            p=deque1.pop().right;
            q=deque2.pop().right;
        }
        return true;
    }
    public boolean dfs(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null){
            return true;
        } else if (root1==null||root2==null) {
            return false;
        } else if (root1.val!=root2.val) {
            return false;
        }
        return  dfs(root1.left,root2.left)&&dfs(root1.right,root2.right);
    }
}

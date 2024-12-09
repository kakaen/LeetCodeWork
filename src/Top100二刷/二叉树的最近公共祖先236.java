package Top100二刷;

import 代码随想录.二叉树理论.TreeNode;

public class 二叉树的最近公共祖先236 {
    private TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
       dfs(root,p,q);
        return ans;
    }
    //fx表示x节点的子树是否包含p节点或q节点，
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root==null) return false;
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);
        if ((lson&&rson)||((root.val==p.val)||(root.val==q.val)&&(lson||rson))){
            ans=root;
        }
        return lson||rson||(root.val==p.val)||(root.val==q.val);
    }
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        dfs2(root,p,q);
        return ans;
    }
    //判断x节点是否为p或q的父节点
    public boolean dfs2(TreeNode root,TreeNode p,TreeNode q){
        if (root==null) return false;
        boolean lson=dfs2(root.left,p,q);
        boolean rson=dfs2(root.right,p,q);
        if ((lson&&rson)||(root.val==p.val||root.val==q.val)&&(lson||rson)){
            ans=root;
        }
        return lson||rson||root.val==p.val||root.val==q.val;

    }

}

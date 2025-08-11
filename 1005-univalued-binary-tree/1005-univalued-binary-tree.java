/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashSet<Integer>set=new HashSet<>();
    private void preorder(TreeNode root){
        if(root==null){
            return;
        }
        set.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public boolean isUnivalTree(TreeNode root) {
       
        preorder(root);
        if(set.size()==1){
            return true;
        }
        return false;


    }
}
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
    private void inorder(List<Integer>lis,TreeNode root){
        if(root==null){
            return;
        }
        inorder(lis,root.left);
        lis.add(root.val);
        inorder(lis,root.right);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>lis=new ArrayList<>();
        inorder(lis,root);
        return lis;
    }
}
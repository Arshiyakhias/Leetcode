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
    public void inorder(TreeNode root,List<Integer>lis){
        if(root==null){
            return;
        }
        inorder(root.left,lis);
        lis.add(root.val);
        inorder(root.right,lis);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>lis=new ArrayList<>();
        inorder(root1,lis);
        inorder(root2,lis);
        Collections.sort(lis);
        return lis;
    }
}
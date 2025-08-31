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
    public void preorder(TreeNode root,List<Integer>lis){
        if(root==null){
            return;
        }
        if(!lis.contains(root.val)){
            lis.add(root.val);
        }
        preorder(root.left,lis);
        preorder(root.right,lis);
    }
    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer>lis=new ArrayList<>();
        preorder(root,lis);
        Collections.sort(lis);
        if(lis.size()<2){
            return -1;
        }
        return lis.get(1);
    }
}
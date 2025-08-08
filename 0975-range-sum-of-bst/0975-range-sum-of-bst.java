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
    lis.add(root.val);
    preorder(root.left,lis);
    preorder(root.right,lis);
 }
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer>lis=new ArrayList<>();
        preorder(root,lis);
        int sum=0;
        for(int i=0;i<lis.size();i++){
            if(lis.get(i)>=low && lis.get(i)<=high){
                sum=sum+lis.get(i);
            }
        }
        
        return sum;
    }
}
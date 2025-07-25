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
    private void preorder(List<Integer>lis,TreeNode root){
        if(root==null){
            lis.add(null);
            return;
        }
        lis.add(root.val);
        preorder(lis,root.left);
        preorder(lis,root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer>first=new ArrayList<>();
        List<Integer>second=new ArrayList<>();
        preorder(first,p);
        preorder(second,q);
        for(int i=0;i<first.size();i++){
            if(!Objects.equals(first.get(i), second.get(i))){
                return false;
            }

        }
        return true;
       
    }
}
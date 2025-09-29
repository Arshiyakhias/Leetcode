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
    int index=0;
    private int indexcal(int[]inorder,int val){
        for(int i=0;i<inorder.length;i++){
            if(val==inorder[i]){
                return i;
            }


        }
        return -1;
    }

    private TreeNode solve(int[]preorder,int[]inorder,int inorderStart,int inorderEnd){
        if(index>=preorder.length || inorderStart>inorderEnd){
            return null;
        }

        TreeNode root=new TreeNode(preorder[index]);
        index++;
        int pos=indexcal(inorder,root.val);
        root.left=solve(preorder,inorder,inorderStart,pos-1);
        root.right=solve(preorder,inorder,pos+1,inorderEnd);
        return root;

    

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=solve(preorder,inorder,0,inorder.length-1);
        return root;
    }
}
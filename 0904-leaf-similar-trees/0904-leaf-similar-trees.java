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
    private void preorder(TreeNode root,List<Integer>lis,List<Integer>leaf){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leaf.add(root.val);
        }
        lis.add(root.val);
        preorder(root.left,lis,leaf);
        preorder(root.right,lis,leaf);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer>lis1=new ArrayList<>();
        ArrayList<Integer>leaf1=new ArrayList<>();
        ArrayList<Integer>lis2=new ArrayList<>();
        ArrayList<Integer>leaf2=new ArrayList<>();
        preorder(root1,lis1,leaf1);
        preorder(root2,lis2,leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        for(int i=0;i<leaf1.size();i++){
            if(!Objects.equals(leaf1.get(i),leaf2.get(i))){
                return false;
            }
        }
        return true;

        
    }
}
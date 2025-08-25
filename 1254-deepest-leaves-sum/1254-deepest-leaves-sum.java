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
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public void inorder(TreeNode root,int maximum,List<Integer>lis,int current_depth){
        if(root==null){
            return;
        }
        inorder(root.left,maximum,lis,current_depth+1);
        if(root.left==null && root.right==null && current_depth==maximum){
            lis.add(root.val);
        }
        inorder(root.right,maximum,lis,current_depth+1);

    }
    public int deepestLeavesSum(TreeNode root) {
        int maximum=maxDepth(root);
        int count=0;
        List<Integer>lis=new ArrayList<>();
        int current_depth=1;
        inorder(root,maximum,lis,current_depth);
        int sum=0;
        for(int i=0;i<lis.size();i++){
            sum=sum+lis.get(i);
        }
        return sum;
    }
}
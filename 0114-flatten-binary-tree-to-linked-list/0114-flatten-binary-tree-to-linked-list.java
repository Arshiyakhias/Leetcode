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
            return;
        }
        lis.add(root.val);
        preorder(lis,root.left);
        preorder(lis,root.right);

    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        List<Integer>lis=new ArrayList<>();
        preorder(lis,root);
        System.out.println(lis);
        int count=lis.size();
        int index=1;

        root.right=null;
        root.left=null;

        while(count!=1){
            TreeNode adds=new TreeNode(lis.get(index));
            index++;
            count--;
            root.right=adds;
            root=root.right;

        }

        
    }
}
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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer>lis=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            while(vals>0){
                TreeNode curr=q.poll();
                if(curr.left!=null && curr.right==null){
                    lis.add(curr.left.val);
                }
                else if(curr.left==null && curr.right!=null){
                    lis.add(curr.right.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                vals--;
            }
        }
        return lis;
    }
}
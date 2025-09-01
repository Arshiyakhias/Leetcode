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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int count=0;
        List<List<Integer>>lis=new ArrayList<>();
        if(root==null){
            return lis;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();
            while(vals!=0){
                TreeNode check=q.poll();
                if(check.left!=null){
                    q.add(check.left);
                }
                if(check.right!=null){
                    q.add(check.right);
                }
                addon.add(check.val);
                
                vals--;
            }
            if(count%2!=0){
                List<Integer>adds=new ArrayList<>();
                for(int i=addon.size()-1;i>=0;i--){
                    adds.add(addon.get(i));
                }
                lis.add(adds);

            }
            else{
                lis.add(addon);
            }
            count++;
        }
        return lis;
    }
}
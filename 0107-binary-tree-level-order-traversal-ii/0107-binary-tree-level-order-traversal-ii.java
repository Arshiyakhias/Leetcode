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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>>lis=new ArrayList<>();
        if(root==null){
            return lis;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        Stack<List<Integer>>st=new Stack<>();
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
            st.push(addon);
        }
        while(!st.isEmpty()){
            List<Integer>adds=st.pop();
            lis.add(adds);
        }
        return lis;
    }
}
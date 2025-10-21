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
    public int sumRootToLeaf(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        HashMap<TreeNode,String>map=new HashMap<>();
        q.add(root);
        String adds=new String();
        adds=adds+root.val;
        map.put(root,adds);
        int ans=0;
        while(!q.isEmpty()){
            int vals=q.size();
            while(vals!=0){
                TreeNode check=q.poll();
                String addson=map.get(check);
                if(check.left!=null){
                    String put=addson+check.left.val;
                    q.add(check.left);
                    map.put(check.left,put);

                }
                if(check.right!=null){
                    String will_put=addson+check.right.val;
                    q.add(check.right);
                    map.put(check.right,will_put);
                }
                if(check.left==null && check.right==null){
                    String value=map.get(check);
                    System.out.println(check.val+" "+value);
                    ans=ans+Integer.parseInt(value,2);

                }
                vals--;
            }

        }
        return ans;
    }
}
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans=new ArrayList<>();
        List<List<Integer>>lis=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            ArrayList<Integer>addon=new ArrayList<>();
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
            lis.add(addon);
            
        }
        for(List<Integer>small:lis){
            double sum=0;
            for(int i=0;i<small.size();i++){
                sum=sum+small.get(i);


            }
            ans.add(sum/small.size());
        }


        return ans;


    }
}
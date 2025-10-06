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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<List<Integer>>lis=new ArrayList<>();
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
            lis.add(addon);
        }
        List<Long>fin=new ArrayList<>();
        
        for(List<Integer>sing:lis){
            long sum=0;
            for(int i=0;i<sing.size();i++){
                sum=sum+sing.get(i);

            }
           fin.add(sum);
        }
        Collections.sort(fin,(a,b)->
        Long.compare(b,a));
        
        if(fin.size()<k){
            return -1;
        }

        return fin.get(k-1);

    }
}
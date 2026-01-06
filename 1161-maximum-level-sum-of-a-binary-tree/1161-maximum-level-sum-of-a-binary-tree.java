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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>>lis=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           
            List<Integer>addon=new ArrayList<>();
       
            int vals=q.size();
            while(vals!=0){
                TreeNode check=q.poll();
            
                addon.add(check.val);
                if(check.left!=null){
                    q.add(check.left);
                }
                if(check.right!=null){
                    q.add(check.right);
                }
                
                vals--;
                
            }
            
            lis.add(addon);
        }

        
        int max=Integer.MIN_VALUE;
        for(List<Integer>sing:lis){
            int sum=0;
            for(int i=0;i<sing.size();i++){
                sum=sum+sing.get(i);
            }
            max=Math.max(max,sum);
         

        }
        int count=0;
        for(List<Integer>sing:lis){
            count++;
            int sums=0;
            for(int i=0;i<sing.size();i++){
                sums=sums+sing.get(i);
            }
            if(sums==max){
                return count;
            }
            

        }
        return -1;

    }
}
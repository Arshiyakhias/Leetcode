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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Boolean flag=false;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int count=-1;
        List<List<Integer>>lis=new ArrayList<>();
        
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();
            while(vals!=0){
                TreeNode check=q.poll();
                if(check==u){
                    flag=true;
                }
            
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
            count++;
            if(flag==true){
                break;
            }
        }
        int val=0;

        for(int i=0;i<lis.get(count).size();i++){
            if(lis.get(count).get(i)==u.val){
                val=i;
                break;
            }

        }

        if(val==lis.get(count).size()-1){
            return null;
        }
        TreeNode ans=new TreeNode(lis.get(count).get(val+1));
        return ans;


        
    }
}
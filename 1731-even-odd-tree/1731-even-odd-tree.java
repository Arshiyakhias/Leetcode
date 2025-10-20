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
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>>lis=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();

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
        int index=0;

        for(List<Integer>sing:lis){
            for(int i=0;i<sing.size();i++){
                if(sing.get(i)%2==0 && index%2==0){
                  
                    return false;
                }

                if(sing.get(i)%2!=0 && index%2!=0){
                 
                    return false;
                }
                

            }

            if(index%2==0){
                for(int i=1;i<sing.size();i++){
                    if(sing.get(i)<=sing.get(i-1)){
                        return false;
                    }
                }
            }
            else{
                for(int i=1;i<sing.size();i++){
                    if(sing.get(i)>=sing.get(i-1)){
                        return false;
                    }
                }

            }
            index++;
        }
        return true;
        
    }
}
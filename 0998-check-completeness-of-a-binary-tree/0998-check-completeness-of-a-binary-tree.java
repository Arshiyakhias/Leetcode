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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>>lis=new ArrayList<>();
        q.add(root);
        Boolean flag=true;
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();
            while(vals!=0){
                TreeNode check=q.poll();
                addon.add(check.val);
                if(check.left!=null){
                    if(flag==true){
                        q.add(check.left);
                        
                    }
                    else{
                        return false;
                    }
                    
                    
                }
                else{
                    flag=false;

                }
                
                if(check.right!=null){
                    if(flag==true){
                        q.add(check.right);
                        
                    }
                    else{
                        return false;
                    }
             
                }
                else{
                    flag=false;
                }
                
                
                vals--;
            }
            lis.add(addon);
        }
        

    for(List<Integer>sing:lis){
        for(int i=0;i<sing.size();i++){
            System.out.println(sing.get(i));
        }
        System.out.println(" ");
    }

    return true;
        
    }
}
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
    int ans=0;
    HashMap<TreeNode,Integer>map=new HashMap<>();
    public void postorder(TreeNode root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        if(root.left==null && root.right==null){
            map.put(root,root.val);
            System.out.println(root.val+" "+root.val);
            
        
        }
        else if(root.left==null && root.right!=null){
            int val=map.get(root.right);
       
            int addon=root.val+val;
            map.put(root,addon);
            System.out.println(root.val+" "+addon);
          
        }
        else if(root.left!=null && root.right==null){
            int vals=map.get(root.left);
     
            int adds=vals+root.val;
            map.put(root,adds);
            System.out.println(root.val+" "+adds);
         


        }
        else{
            int value1=map.get(root.left);
            int value2=map.get(root.right);
      
      
            int addson=root.val+value1+value2;
            map.put(root,addson);
            System.out.println(root.val+" "+addson);
          
        }

    }
    public void postorder_calc(TreeNode root){
        if(root==null){
            return;
        }
        postorder_calc(root.left);
        postorder_calc(root.right);
        if(root.left==null && root.right==null){
            ans=ans+0;
        }
        else if(root.left!=null && root.right==null){
            int vals=map.get(root.left);
            ans=ans+Math.abs(0-vals);
        }
        else if(root.left==null && root.right!=null){
            int value=map.get(root.right);
            ans=ans+Math.abs(0-value);
        }
        else{
            int value1=map.get(root.left);
            int value2=map.get(root.right);
            ans=ans+Math.abs(value1-value2);
        }
    }
    public int findTilt(TreeNode root) {
        
        postorder(root);
        postorder_calc(root);
        return ans;
    }
}
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
    private void parent_cal(TreeNode root,HashMap<TreeNode,TreeNode>parent){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parent.put(root.left,root);
        }
        if(root.right!=null){
            parent.put(root.right,root);
        }
        parent_cal(root.left,parent);
        parent_cal(root.right,parent);
    }
    private void root_to_leaf(TreeNode root,HashMap<TreeNode,TreeNode>parent,HashMap<TreeNode,String>map){
        if(root==null){
            return;
        }

        if(!parent.containsKey(root)){
            String addon=new String();
            addon=addon+root.val;
            map.put(root,addon);
        }
        else{
            TreeNode par=parent.get(root);
            String path=map.get(par);
            //path=path+"->";
            path=path+root.val;
            map.put(root,path);
        }
        root_to_leaf(root.left,parent,map);
        root_to_leaf(root.right,parent,map);
    }

    private void final_ans(TreeNode root,List<String>ans,HashMap<TreeNode,String>map){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            String adds=map.get(root);
            ans.add(adds);
        }
        final_ans(root.left,ans,map);
        final_ans(root.right,ans,map);
    }
    public int sumNumbers(TreeNode root) {

        HashMap<TreeNode,TreeNode>parent=new HashMap<>();
        HashMap<TreeNode,String>map=new HashMap<>();

        parent_cal(root,parent);

        

        root_to_leaf(root,parent,map);

        List<String>ans=new ArrayList<>();

        final_ans(root,ans,map);
        int final_value=0;

        for(int i=0;i<ans.size();i++){
            int value=Integer.parseInt(ans.get(i));
            final_value=final_value+value;

        }


        return final_value;
        
    }
}
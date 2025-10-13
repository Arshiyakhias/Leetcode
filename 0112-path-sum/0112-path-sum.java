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


    private void path_sum(TreeNode root,HashMap<TreeNode,Integer>map,HashMap<TreeNode,TreeNode>parent){
        if(root==null){
            return;
        }
        if(!parent.containsKey(root)){
            map.put(root,root.val);

        }
        else{
            TreeNode check=parent.get(root);
            int value=map.get(check);
            value=value+root.val;
            map.put(root,value);

        }
        path_sum(root.left,map,parent);
        path_sum(root.right,map,parent);
    }


    private void final_find(TreeNode root,List<Integer>checking,HashMap<TreeNode,Integer>map){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            checking.add(map.get(root));
        }
        final_find(root.left,checking,map);
        final_find(root.right,checking,map);
    }

    



    public boolean hasPathSum(TreeNode root, int targetSum) {
        HashMap<TreeNode,TreeNode>parent=new HashMap<>();
        parent_cal(root,parent);

        HashMap<TreeNode,Integer>map=new HashMap<>();
        path_sum(root,map,parent);


        List<Integer>checking=new ArrayList<>();
        final_find(root,checking,map);

        //for(int i=0;i<checking.size();i++){
        //    System.out.println(checking.get(i));
        //}

        if(checking.contains(targetSum)){
            return true;
        }
        return false;






    }
}
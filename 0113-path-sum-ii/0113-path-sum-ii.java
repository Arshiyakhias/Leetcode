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


    private void path_sum(TreeNode root,HashMap<TreeNode,Integer>map,HashMap<TreeNode,TreeNode>parent,HashMap<TreeNode,List<Integer>>path){
        if(root==null){
            return;
        }
        if(!parent.containsKey(root)){
            map.put(root,root.val);
            List<Integer>addon=new ArrayList<>();
            addon.add(root.val);
            path.put(root,addon);

        }
        else{
            TreeNode check=parent.get(root);
            int value=map.get(check);
            value=value+root.val;
            map.put(root,value);

            List<Integer>new_path=new ArrayList<>(path.get(check));
            new_path.add(root.val);
            path.put(root,new_path);

        }
        path_sum(root.left,map,parent,path);
        path_sum(root.right,map,parent,path);
    }


    private void final_find(TreeNode root,HashMap<TreeNode,Integer>map,HashMap<TreeNode,List<Integer>>path,int targetSum,List<List<Integer>>lis){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null && (map.get(root)==targetSum)){
            lis.add(path.get(root));

        }
        final_find(root.left,map,path,targetSum,lis);
        final_find(root.right,map,path,targetSum,lis);
    }

    



    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        HashMap<TreeNode,TreeNode>parent=new HashMap<>();
        parent_cal(root,parent);

        HashMap<TreeNode,Integer>map=new HashMap<>();
        HashMap<TreeNode,List<Integer>>path=new HashMap<>();
        path_sum(root,map,parent,path);


        List<Integer>checking=new ArrayList<>();
        List<List<Integer>>lis=new ArrayList<>();
        final_find(root,map,path,targetSum,lis);

        //for(int i=0;i<checking.size();i++){
        //    System.out.println(checking.get(i));
        //}
        return lis;

        
    }
}
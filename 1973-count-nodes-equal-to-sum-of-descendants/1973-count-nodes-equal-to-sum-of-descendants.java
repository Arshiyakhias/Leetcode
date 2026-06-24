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
    public HashMap<TreeNode,Integer>map=new HashMap<>();
    public void preorder(TreeNode root,HashMap<TreeNode,Integer>map){
        if(root==null){
            return;
        }
        preorder(root.left,map);
        preorder(root.right,map);
        int lef=0;
        int righ=0;
        if(map.containsKey(root.left)){
            lef=lef+map.get(root.left);
        }
        if(map.containsKey(root.right)){
            righ=righ+map.get(root.right);
        }
        int vals=lef+righ+root.val;
        map.put(root,vals);
    }

    public int equalToDescendants(TreeNode root) {
        preorder(root,map);
        List<TreeNode>lis=new ArrayList<>(map.keySet());
        int count=0;
        for(int i=0;i<lis.size();i++){
           int check=map.get(lis.get(i))-lis.get(i).val;
           if(check==lis.get(i).val){
            count++;
           }
        }
        return count;
    }
}
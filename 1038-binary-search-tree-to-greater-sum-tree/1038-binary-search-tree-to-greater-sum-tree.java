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
    public void preorder(TreeNode root,List<Integer>lis){
        if(root==null){
            return;
        }
        lis.add(root.val);
        preorder(root.left,lis);
        preorder(root.right,lis);
    }

    public void fin(TreeNode root){
        if(root==null){
            return;
        }
        int vals=map.get(root.val);
        root.val=vals;
     
        fin(root.left);
        fin(root.right);
    }
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode bstToGst(TreeNode root) {
        List<Integer>lis=new ArrayList<>();
        preorder(root,lis);
        Collections.sort(lis);
        List<Integer>sum=new ArrayList<>();
        sum.add(lis.get(lis.size()-1));
        int index=0;
     
        map.put(lis.get(lis.size()-1),lis.get(lis.size()-1));
        
        for(int i=lis.size()-2;i>=0;i--){
            int val=sum.get(index)+lis.get(i);
            sum.add(val);
            index++;
            map.put(lis.get(i),val);

        }
        fin(root);
        System.out.println(map);
        return root;
        
    }
}
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
    public int levelMedian(TreeNode root, int level) {
        List<List<Integer>>lis=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int vals=q.size();
            List<Integer>addon=new ArrayList<>();
            while(vals>0){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                vals--;
                addon.add(curr.val);
            }
            lis.add(addon);
        }
        int sz=lis.size()-1;
        
        if(lis.isEmpty()){
            return -1;
        }
        else if(level>sz){
            return -1;
        }
        else if(lis.get(level).size()<1){
            return -1;
        }
        else if(lis.get(level).size()==1){
            return lis.get(level).get(0);
        }

        List<Integer>liss=lis.get(level);
        Collections.sort(liss);
        return liss.get(liss.size()/2);
    }
}
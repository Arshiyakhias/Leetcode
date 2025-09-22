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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>>lis=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer>addon=new ArrayList<>();
            int vals=q.size();
            while(vals!=0){
                TreeNode check=q.poll();
                if(check.left!=null){
                    q.add(check.left);

                }
                if(check.right!=null){
                    q.add(check.right);
                }
                if(check.left!=null && check.right!=null){
                    if(check.left.val==x && check.right.val==y){
                        return false;
                    }
                    if(check.left.val==y && check.right.val==x){
                        return false;
                    }
                }
                vals--;
                addon.add(check.val);


            }
            lis.add(addon);
        }
        int i=0;

        for(List<Integer>sing:lis){
            i++;
            if(sing.contains(x) && sing.contains(y) && i>2){
                return true;
            }
        }
        return false;

    }
}
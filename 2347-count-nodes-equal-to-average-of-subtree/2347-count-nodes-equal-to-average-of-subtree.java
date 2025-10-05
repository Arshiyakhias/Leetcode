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
    int count=0;
    private void postorder(TreeNode root,HashMap<TreeNode,Integer>num,HashMap<TreeNode,Integer>sum){
        if(root==null){
            return;
        }
        postorder(root.left,num,sum);
        postorder(root.right,num,sum);
        if(root.left==null && root.right==null){
            num.put(root,1);
            sum.put(root,root.val);
            count++;
        }
        else{
            int numadds=1;
            int sumadds=root.val;
            if(root.left!=null){
                numadds=numadds+num.get(root.left);
                sumadds=sumadds+sum.get(root.left);

            }
            if(root.right!=null){
                numadds=numadds+num.get(root.right);
                sumadds=sumadds+sum.get(root.right);

            }
            
            num.put(root,numadds);
            sum.put(root,sumadds);
            int avg=sumadds/numadds;
            if(avg==root.val){
                count++;
            }

        }
    }
    public int averageOfSubtree(TreeNode root) {
       HashMap<TreeNode,Integer>num=new HashMap<>();
       HashMap<TreeNode,Integer>sum=new HashMap<>();
       postorder(root,num,sum);
       return count; 
    }
}
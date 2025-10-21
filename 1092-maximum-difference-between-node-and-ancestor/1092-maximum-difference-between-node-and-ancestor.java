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
    public int maxAncestorDiff(TreeNode root) {
       Queue<TreeNode>q=new LinkedList<>();
       HashMap<TreeNode,List<Integer>>map=new HashMap<>();
       q.add(root);
       int max=Integer.MIN_VALUE;

       List<Integer>lis=new ArrayList<>();
       lis.add(root.val);
       map.put(root,lis);

       while(!q.isEmpty()){

        int vals=q.size();
        while(vals!=0){
            TreeNode check=q.poll();
            
            if(check.left!=null){
                ArrayList<Integer>list=new ArrayList<>(map.get(check));
                for(int i=0;i<list.size();i++){
                    int sub=Math.abs(check.left.val-list.get(i));
                    max=Math.max(max,sub);
                }
                list.add(check.left.val);
                map.put(check.left,list);

                q.add(check.left);
            }
            if(check.right!=null){
                ArrayList<Integer>list1=new ArrayList<>(map.get(check));
                for(int i=0;i<list1.size();i++){
                    int sub=Math.abs(check.right.val-list1.get(i));
                    max=Math.max(max,sub);
                }
                list1.add(check.right.val);
                map.put(check.right,list1);
       
                q.add(check.right);
            }
            vals--;
        }


       }
       return max;
       
    }
}
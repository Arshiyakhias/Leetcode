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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        HashSet<Integer>childs=new HashSet<>();
        
        for(int[]descript:descriptions){
            childs.add(descript[1]);

        }
        int roots=0;
        for(int[]descript:descriptions){
            if(!childs.contains(descript[0])){
                roots=descript[0];


            }
          
        }
        
        HashMap<Integer,TreeNode>maps=new HashMap<>();
        for(int[]descript:descriptions){
            if(!maps.containsKey(descript[0])){
                TreeNode sing=new TreeNode(descript[0]);
                maps.put(descript[0],sing);



            }
            if(!maps.containsKey(descript[1])){
                TreeNode sings=new TreeNode(descript[1]);
                maps.put(descript[1],sings);



            }

        }
        for(int[]descript:descriptions){
            TreeNode par=maps.get(descript[0]);
            TreeNode chi=maps.get(descript[1]);
            if(descript[2]==0){
                par.right=chi;
            }
            if(descript[2]==1){
                par.left=chi;
            }

        }

        TreeNode fin=maps.get(roots);
        return fin;
    }
}
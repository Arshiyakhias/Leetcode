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
    public List<List<Integer>> verticalOrder(TreeNode root) {
         List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        HashMap<Integer,List<TreeNode>>map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
  
        Queue<TreeNode>q=new LinkedList<>();
        HashMap<TreeNode,Integer>index=new HashMap<>();
        index.put(root,0);
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int vals=q.size();
            while(vals>0){
                TreeNode curr=q.poll();
                int ind=index.get(curr);
                System.out.println(ind);
                if(curr.left!=null){
                    int lef=ind-1;
                 
                    index.put(curr.left,lef);
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    int righ=ind+1;
        
                    index.put(curr.right,righ);
                    q.add(curr.right);
                }
                
              
                if(map.containsKey(ind)){
                    
                    List<TreeNode>addon=map.get(ind);
                    if(!addon.contains(curr)){
                        addon.add(curr);
                        map.put(ind,addon);

                    }
                    
                }
                else{
                    List<TreeNode>adds=new ArrayList<>();
                    adds.add(curr);
                    map.put(ind,adds);
                }
                min=Math.min(min,ind);
                max=Math.max(max,ind);
                vals--;
            }
            count++;
        }
        System.out.println(max+" hey"+min);
       

        for(int i=min;i<=max;i++){
            System.out.println();
            List<TreeNode>addss=map.get(i);
            List<Integer>ad=new ArrayList<>();
            for(int j=0;j<addss.size();j++){
           
                ad.add(addss.get(j).val);
                System.out.print(" ");
            }
            ans.add(ad);
            System.out.println();
        }
        
        return ans;
    }
}
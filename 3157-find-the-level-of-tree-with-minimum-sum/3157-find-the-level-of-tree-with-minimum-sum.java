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
    public int minimumLevel(TreeNode root) {
        
        long sum=Long.MAX_VALUE;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        HashMap<Integer,Long>map=new HashMap<>();
        map.put(1,(long)root.val);
        int count=0;
        while(!q.isEmpty()){
            int vals=q.size();
            long sum_level=0;
            while(vals>0){
                TreeNode curr=q.poll();
                sum_level=sum_level+curr.val;
                if(curr.left!=null){
                    q.add(curr.left);

                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

                vals--;

            }
            count++;
            map.put(count,sum_level);
            sum=Math.min(sum,sum_level);


        }
        System.out.println(map);
        List<Integer>kys=new ArrayList<>(map.keySet());
        Collections.sort(kys);
        System.out.println(kys);
        for(int i=0;i<kys.size();i++){
            long value=map.get(kys.get(i));
            if(value==sum){
                return (int)kys.get(i);
            }
        }
        return -1;

        



    }
}
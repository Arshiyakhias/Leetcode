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
    private void postorder(TreeNode root,HashMap<TreeNode,Integer>sumnode,HashMap<Integer,Integer>sum){
        if(root==null){
            return;
        }
        postorder(root.left,sumnode,sum);
        postorder(root.right,sumnode,sum);
        int sums=root.val;
        if(root.left!=null){
            sums=sums+sumnode.get(root.left);


        }
        if(root.right!=null){
            sums=sums+sumnode.get(root.right);
        }
        sumnode.put(root,sums);
        if(sum.containsKey(sums)){
            int val=sum.get(sums);
            val++;
            sum.put(sums,val);
        }
        else{
            sum.put(sums,1);
        }
    }


    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<TreeNode,Integer>sumnode=new HashMap<>();
        HashMap<Integer,Integer>sum=new HashMap<>();
        
        postorder(root,sumnode,sum);

        List<Integer>lis=new ArrayList<>(sum.keySet());
        Collections.sort(lis,(a,b)->
        Integer.compare(sum.get(b),sum.get(a))
        );
        int max=sum.get(lis.get(0));
        System.out.print(max);

        int count=0;
        for(int i=0;i<lis.size();i++){
            if(max==sum.get(lis.get(i))){
                count++;
            }
        }
        int[]ans;
        ans=new int[count];


        int index=0;

        for(int i=0;i<lis.size();i++){
            if(max==sum.get(lis.get(i))){
                ans[index]=lis.get(i);
                index++;
            }
        }
        





        



        
        return ans;
    }
}
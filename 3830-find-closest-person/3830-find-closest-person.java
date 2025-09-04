class Solution {
    public int findClosest(int x, int y, int z) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(x,1);
        map.put(y,2);
       



        ArrayList<Integer>lis=new ArrayList<Integer>();
        lis.add(x);
        lis.add(y);
        Boolean[]flag;
        flag=new Boolean[1];
        flag[0]=false;
        Collections.sort(lis,(a,b)->{
        int val=Integer.compare(Math.abs(a-z),Math.abs(b-z));
        {
            if(val==0){
                flag[0]=true;
                return 0;
            }
        }
        return val;
       
        });

        // when you have a conditional statement in the lambda expression then wrap it with {}
        //flag like above cannot be called from outside hence using array to define it
        if(flag[0]==true){
            return 0;
        }
        return map.get(lis.get(0));
        
        
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<score.length;i++){
            p.add(score[i]);
        }

        HashMap<Integer,String>map=new HashMap<>();
        map.put(1,"Gold Medal");
        map.put(2,"Silver Medal");
        map.put(3,"Bronze Medal");

        String[]ans;
        ans=new String[score.length];
        int index=1;
        HashMap<Integer,String>fin=new HashMap<>();


        while(!p.isEmpty()){
            int val=p.peek();
            p.poll();
            if(index<=3){
                String addon=map.get(index);
                fin.put(val,addon);
                System.out.println(val+" "+addon);

            }
            else{
                String adds=new String();
                adds=adds+index;
                fin.put(val,adds);
                System.out.println(val+" "+adds);

            }
            index++;
        }
        for(int i=0;i<score.length;i++){
            String puts=fin.get(score[i]);
            ans[i]=puts;
        }
        return ans;
    }
}
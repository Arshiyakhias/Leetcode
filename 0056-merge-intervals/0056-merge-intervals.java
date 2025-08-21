class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>lis=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->
        Integer.compare(a[0],b[0]));
        int[]current=intervals[0];
        lis.add(current);
        for(int[]interval:intervals){
            int current_end=current[1];
            int next_start=interval[0];
            int next_end=interval[1];
            if(current_end>=next_start){
                current[1]=Math.max(current_end,next_end);
              
            }
            else{
              
                current=interval;
                lis.add(interval);
                
            }
            
        }
        return lis.toArray(new int[lis.size()][]);
    }
}
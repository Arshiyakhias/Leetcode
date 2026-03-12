class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Float>pq=new PriorityQueue<>();
        HashMap<Float,List<Integer>>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                Float val=(float)arr[i]/arr[j];
                pq.add(val);
                List<Integer>lis=new ArrayList<>();
                lis.add(arr[i]);
                lis.add(arr[j]);
                map.put(val,lis);
            }
        }
        for(int i=0;i<k-1;i++){
            pq.poll();

        }
        List<Integer>liss=map.get(pq.peek());
        int[]ans;
        ans=new int[2];
        ans[0]=liss.get(0);
        ans[1]=liss.get(1);

        return ans;
    }
}
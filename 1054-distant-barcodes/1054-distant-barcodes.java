class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
    (a, b) -> {
        if (map.get(a).equals(map.get(b))) {
            return Integer.compare(b, a);
        }
        return Integer.compare(map.get(b), map.get(a));
    }
);

        for(int i=0;i<barcodes.length;i++){
            if(map.containsKey(barcodes[i])){
                int val=map.get(barcodes[i]);
                val++;
                map.put(barcodes[i],val);
            }
            else{
                map.put(barcodes[i],1);
            }
            
        }

        for(int i=0;i<barcodes.length;i++){
            if(!pq.contains(barcodes[i])){
                pq.add(barcodes[i]);
            }
        }
        
        int[]ans;
        ans=new int[barcodes.length];
        int index=0;
        while(!pq.isEmpty()){
            if(index==0){
                int val=pq.poll();
                ans[index]=val;
                int count=map.get(val);
                count--;
                if(count==0){
                    map.remove(val);
                    pq.remove(val);
                }
                else{
                    map.put(val,count);
                    pq.add(val);
                }
             
            }
           
            else{
                
                int adds=pq.poll();
                if(adds==ans[index-1]){
                    int fin=pq.poll();
                    ans[index]=fin;
                    int gets=map.get(fin);
                    gets--;
                    if(gets==0){
                        map.remove(fin);
                        pq.remove(fin);
                    }
                    else{
                        map.put(fin,gets);
                        pq.add(fin);
                    }
                    pq.add(adds);
                }
                else{
                    ans[index]=adds;
                    int rem=map.get(adds);
                    rem--;
                    if(rem==0){
                        map.remove(adds);
                        pq.remove(adds);
                    }
                    else{
                        map.put(adds,rem);
                        pq.add(adds);
                    }
                }
                
            }
            //System.out.println(map);
            index++;

        }
        return ans;

        
        
    }
}
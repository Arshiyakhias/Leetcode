class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        HashMap<Integer,Integer>map1=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int val=map.get(arr[i]);
                val++;
                map.put(arr[i],val);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for(int i=0;i<arr.length;i++){
            int puts=map.get(arr[i]);
            map1.put(puts,arr[i]);
        }
        int half=arr.length/2;
        List<Integer>keys=new ArrayList<>(map.values());
    
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<keys.size();i++){
            pq.add(keys.get(i));
        }
    
        List<Integer>fin=new ArrayList<>();
        int count=0;
        while(!pq.isEmpty()){
            int find=pq.peek();
            count=count+find;
           
            fin.add(map1.get(find));
            pq.poll();
            
            if(count>=half){
                break;

            }


        }
        return fin.size();
       
    }
}
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>lis=new ArrayList<>();

        //int[]ans;
        //ans=new int[12];
        int[]ans={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=0;i<ans.length;i++){
            if(i==0){
                lis.add(ans[i]);
                map.put(i+1,ans[i]);
            }
            else{
                lis.add(lis.get(i-1)+ans[i]);
                map.put(i+1,ans[i]);
            }
        }

        System.out.println(map);
        System.out.println(lis);
        

       
        String[] Alice_arrive=arriveAlice.split("-");
        String[] Alice_leave=leaveAlice.split("-");

        String[] Bob_arrive=arriveBob.split("-");
        String[] Bob_leave=leaveBob.split("-");

        int Alice_arrive_num= lis.get(Integer.parseInt(Alice_arrive[0])-1)-(map.get(Integer.parseInt(Alice_arrive[0]))-Integer.parseInt(Alice_arrive[1]));
        
        int Alice_leave_num= lis.get(Integer.parseInt(Alice_leave[0])-1)-(map.get(Integer.parseInt(Alice_leave[0]))-Integer.parseInt(Alice_leave[1]));
        System.out.println(lis.get(Integer.parseInt(Alice_leave[0])-1)+","+map.get(Integer.parseInt(Alice_leave[0]))+" "+Integer.parseInt(Alice_leave[1]));

        int Bob_arrive_num= lis.get(Integer.parseInt(Bob_arrive[0])-1)-(map.get(Integer.parseInt(Bob_arrive[0]))-Integer.parseInt(Bob_arrive[1]));
        
        int Bob_leave_num= lis.get(Integer.parseInt(Bob_leave[0])-1)-(map.get(Integer.parseInt(Bob_leave[0]))-Integer.parseInt(Bob_leave[1]));

        System.out.println("Alice_arrive_num"+ Alice_arrive_num);
        System.out.println("Alice_leave_num"+ Alice_leave_num);

        System.out.println("Bob_arrive_num"+ Bob_arrive_num);
        System.out.println("Bob_leave_num"+ Bob_leave_num);


        if((Alice_leave_num<Bob_arrive_num) || (Bob_leave_num<Alice_arrive_num)){
            return 0;
        }
        
        if(Alice_arrive_num<=Bob_arrive_num){
            int sum=0;
            for(int i=Alice_arrive_num;i<=Bob_leave_num;i++){
                if(i>=Alice_arrive_num && i<=Alice_leave_num && i>=Bob_arrive_num && i<=Bob_leave_num){
                    sum++;
                }
            }
            return sum;


        }

       
            int sum=0;
            for(int i=Bob_arrive_num;i<=Alice_leave_num;i++){
                if(i>=Bob_arrive_num && i<=Bob_leave_num && i>=Alice_arrive_num && i<=Alice_leave_num){
                    sum++;
                }
            }
            return sum;


        


        
    }
}
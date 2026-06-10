class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        List<Integer>player=new ArrayList<Integer>();
        List<Integer>trainer=new ArrayList<>();
        for(int i=0;i<players.length;i++){
            player.add(players[i]);
        }
        for(int i=0;i<trainers.length;i++){
            trainer.add(trainers[i]);

        }
        Collections.sort(player);
        Collections.sort(trainer);
        int left_player=0;
        int left_trainer=0;
        int count=0;
        while(left_player<player.size() && left_trainer<trainer.size()){
            if(player.get(left_player)<=trainer.get(left_trainer)){
                count++;
                left_player++;
                left_trainer++;

            }
            else{
                
               
                left_trainer++;

            }
        }
        return count;

    }
}
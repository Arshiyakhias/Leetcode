class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>row=new HashSet<>();
        HashMap<String,HashSet<Character>>map=new HashMap<>();
        HashSet<Character>col=new HashSet<>();
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                else if(row.contains(board[i][j])){
                    return false;
                }
                else{
                    row.add(board[i][j]);
                }

            }
            row.clear();
        }

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[i].length;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                else if(col.contains(board[j][i])){
                    return false;
                }
                else{
                    col.add(board[j][i]);
                }

            }
            col.clear();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                String check=new String();
                int val=i/3;
                int val1=j/3;
                check=check+val;
                check=check+val1;
                if(board[i][j]=='.'){
                    continue;
                }
                else if(map.containsKey(check) && map.get(check).contains(board[i][j])){
                    return false;
                }
                else{
                    map.putIfAbsent(check,new HashSet<>());
                    map.get(check).add(board[i][j]);

                }
                

            }
        }
        return true;
    }
}
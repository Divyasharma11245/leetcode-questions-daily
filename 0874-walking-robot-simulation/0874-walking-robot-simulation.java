class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for(int[] obstacle: obstacles){
            String key = obstacle[0]+ "_"+obstacle[1];
            set.add(key);      
        }

        int x = 0;
        int y = 0;
        int maxD = 0;

        int dir[] = {0,1};
        for(int i =0; i<commands.length; i++){
            if(commands[i]==-2) {
                dir = new int[]{-dir[1], dir[0]};
            }else if(commands[i]==-1){
                dir = new int[]{dir[1], -dir[0]};
            }else{
                for(int j =0; j<commands[i]; j++){
                int new_x = x+dir[0];
                int new_y = y+dir[1];

                String nextKey = new_x+ "_" + new_y;
                if(set.contains(nextKey)){
                    break;
                }

                x = new_x;
                y = new_y;
                }
                
            }
            maxD = Math.max(maxD, x*x+y*y);
        }
        return maxD;
    }
}
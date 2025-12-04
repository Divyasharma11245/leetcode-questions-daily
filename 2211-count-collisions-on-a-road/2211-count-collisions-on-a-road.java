class Solution {
    public int countCollisions(String directions) {
        int l = 0;
        int r = directions.length()-1;
        int n = directions.length();
        int count = 0;

        while(l<n&&directions.charAt(l)=='L'){
             l++;
        }

        while(r>=0&&directions.charAt(r)=='R'){
        r--;}

        for(int i = l; i<=r; i++){
            if(directions.charAt(i)=='R'||directions.charAt(i)=='L'){
                count++;
            }
        }
        return count;
    }
}
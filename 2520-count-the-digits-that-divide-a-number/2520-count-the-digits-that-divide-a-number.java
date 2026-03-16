class Solution {
    public int countDigits(int num) {
        int number = num;
        ArrayList<Integer> arr = new ArrayList<>();
        while(num!=0){
            int lastd = num%10;
            arr.add(lastd);
            num = num/10;
        }
        
        int count = 0;
        for(int i =0; i<arr.size(); i++){
            if(number%arr.get(i)==0){
                count++;
            }
        }
        return count;
    }
}
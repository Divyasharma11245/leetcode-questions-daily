class Solution {
    private ArrayList<Integer> findnextGreater(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> nextGreater = new ArrayList<>();
        for(int j = 0; j<n; j++) nextGreater.add(0);
        for(int i = n-1; i>=0; i--){
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            
            if(s.isEmpty()){
                nextGreater.set(i, -1);
            }else{
                nextGreater.set(i, arr[s.peek()]);
            }
            
            s.push(i);
        }
        return nextGreater;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       //phle saare next greater ko index ke sath hashmap me store krle
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> nextGreater = findnextGreater(nums2);
        for(int i = 0; i<nextGreater.size(); i++){
            map.put(i, nextGreater.get(i));
        }

        int n = nums1.length;
        int m = nums2.length;
        int ans[] = new int[n];
        for(int i = 0; i<n; i++){
            int greater = 0;
            for(int j =0; j<m; j++){
                if(nums1[i]==nums2[j]){
                     greater = map.get(j);
                     ans[i] = greater;
                }
            }
        }
        return ans;
    }
}
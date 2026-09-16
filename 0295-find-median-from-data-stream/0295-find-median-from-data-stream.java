class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMax.isEmpty()||(num<=leftMax.peek())){
            leftMax.add(num);
        }else{
            rightMin.add(num);
        }

        if(leftMax.size()-rightMin.size()>1){
            rightMin.add(leftMax.peek());
            leftMax.remove();
        }else if(leftMax.size()<rightMin.size()){
            leftMax.add(rightMin.peek());
            rightMin.remove();
        }
    }
    
    public double findMedian() {
        if(leftMax.size()==rightMin.size()){
            double ans = (leftMax.peek()+rightMin.peek())/2.0;
            return ans;
        }
        return leftMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
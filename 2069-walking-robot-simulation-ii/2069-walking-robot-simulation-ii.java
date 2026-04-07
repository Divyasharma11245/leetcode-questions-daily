class Robot {

    int idx;
    int pos[][];
    boolean moved = false;
    public Robot(int width, int height) {
        int perimeter = 2 * (width + height) - 4;
        pos = new int[perimeter][3];
        int k = 0;

        for(int x =0; x<width; x++){  //bottom row
            pos[k++] = new int[]{x, 0, 0};
        }
        for(int y = 1; y<height; y++){ //right col
            pos[k++] = new int[]{width-1, y, 1};
        }
        for(int x = width-2; x>=0; x--){ //upper row
            pos[k++] = new int[]{x, height-1, 2};
        }
        for(int y = height-2; y>0; y--){ //left col
            pos[k++] = new int[]{0, y, 3};
        }
        pos[0][2] = 3;
    }
    
    public void step(int num) {
        moved = true;
        idx = (idx+num)%pos.length;
    }
    
    public int[] getPos() {
        return new int[]{pos[idx][0], pos[idx][1]};
    }
    
    public String getDir() {
        if(moved==false){
            return "East";
        }
        if(pos[idx][2]==0) return "East";
        else if(pos[idx][2]==1) return "North";
        else if(pos[idx][2]==2) return "West";
        else return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
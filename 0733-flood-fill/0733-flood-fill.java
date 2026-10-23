class Solution {
    private void dfs(int[][] image, int sr, int sc, int color){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]==color) return;
        int main = image[sr][sc];
        image[sr][sc] = color;
        int dir[][] = new int[][]{{0,-1}, {-1, 0}, {1,0},{0,1}};
        for(int i = 0; i<dir.length; i++){
            int x=sr+dir[i][0];
            int y= sc+dir[i][1];
            if(x>=0&&y>=0&&x<image.length&&y<image[0].length&&image[x][y]==main)dfs(image, x, y, color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int main = image[sr][sc];
        // for(int i = 0; i<image.length; i++){
        //     for(int j = 0; j<image[0].length; j++){
        //         if(image[sr][sc]==1){
        //             dfs(image, sr, sc, color);
        //         }
        //     }
        // }
        dfs(image, sr, sc, color);
        return image;     
    }
}
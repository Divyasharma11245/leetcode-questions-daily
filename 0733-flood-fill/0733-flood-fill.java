class Solution {
    private void dfs(int[][] image, int i, int j, int newColor, int currColor){
        if(i<0||j<0||i>=image.length||j>=image[0].length||image[i][j]==newColor||image[i][j]!=currColor) return;
        image[i][j] = newColor;
        dfs(image, i-1, j, newColor, currColor);
        dfs(image, i, j+1, newColor, currColor);
        dfs(image, i+1, j, newColor, currColor);
        dfs(image, i, j-1, newColor, currColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}
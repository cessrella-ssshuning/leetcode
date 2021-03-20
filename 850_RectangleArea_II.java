class Solution {
    public int rectangleArea(int[][] rectangles) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        //add x and y coordinates to x sets and y sets to remove duplicates
        for(int[] rec:rectangles){
            setX.add(rec[0]);
            setX.add(rec[2]);
            setY.add(rec[1]);
            setY.add(rec[3]);
        }
        //sort x and y in arrays
        Integer[] arrX = new Integer[setX.size()];
        int xIdx = 0;
        for(Integer x:setX){
            arrX[xIdx++] = x;
        }
        Arrays.sort(arrX);
        Integer[] arrY = new Integer[setY.size()];
        int yIdx = 0;
        for(Integer y:setY){
            arrY[yIdx++] = y;
        }
        Arrays.sort(arrY);
        //map x and y to index
        Map<Integer,Integer> mapX = new HashMap<>();
        for(int i = 0;i<arrX.length;i++){
            mapX.put(arrX[i],i);
        }
        Map<Integer,Integer> mapY = new HashMap<>();
        for(int i = 0;i<arrY.length;i++){
            mapY.put(arrY[i],i);
        }
        //create a boolean grid for recording the covered area 左开右闭 
        //judge grid by grid
        boolean[][] grid = new boolean[arrX.length][arrY.length];
        for(int[] rec:rectangles){
            for(int i = mapX.get(rec[0]);i<mapX.get(rec[2]);i++){
                for(int j = mapY.get(rec[1]);j<mapY.get(rec[3]);j++){
                    grid[i][j] = true;
                }
            }
        }
        long res = 0;
      //  long mod = 10^9+7;
        for(int x = 0;x<grid.length;x++){
            for(int y = 0;y<grid[x].length;y++){
                if(grid[x][y]){
                    res += (long)(arrX[x+1]-arrX[x])*(arrY[y+1]-arrY[y]);;
                }
            }
        }
        res %= 1000000007;
        return (int)res;
    }
}
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        //add x and y coordinates to x sets and y sets to remove duplicates
        
        //sort x and y in arrays
        
        Map<int[],Integer> pntApprence = new HashMap<>();
        long area = 0;
        for(int[] rec:rectangles){
            setX.add(rec[0]);
            setX.add(rec[2]);
            setY.add(rec[1]);
            setY.add(rec[3]);
            System.out.println(rec[0]+","+rec[1]);
            System.out.println(rec[2]+","+rec[3]);
            int[] pnt1 = {rec[0],rec[1]};
            int[] pnt2 = {rec[2],rec[3]};
            if(pntApprence.containsKey(pnt1)){
                pntApprence.put(pnt1,pntApprence.get(pnt1)+1);
            }else{
                pntApprence.put(pnt1,1);
            }
            if(pntApprence.containsKey(pnt2)){
                pntApprence.put(pnt2,pntApprence.get(pnt2)+1);
            }else{
                pntApprence.put(pnt2,1);
            } 
            area += (rec[2]-rec[0])*(rec[3]-rec[1]);
        }
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
        
        for(Map.Entry<int[],Integer> entry : pntApprence.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
            if(entry.getValue()%2==0){
                pntApprence.remove(entry.getKey());
            }
        }
        if(pntApprence.size()!=4) return false;
        return area==(long)(arrX[arrX.length-1]-arrX[0])*(arrY[arrY.length-1]-arrY[0]);
        
    }
}
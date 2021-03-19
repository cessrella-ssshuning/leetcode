class Solution {
    /*
    5
        [10, 2]
   stIdx    ^               
 
    */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1,(x,y)->x[0]-y[0]);
        Arrays.sort(slots2,(x,y)->x[0]-y[0]);
        
        int stIdx1 = 0,stIdx2 = 0;
        while(stIdx1<slots1.length&&stIdx2<slots2.length){
            int pairSt = Math.max(slots1[stIdx1][0],slots2[stIdx2][0]);
            int pairEnd = Math.min(slots1[stIdx1][1],slots2[stIdx2][1]);
            if(pairEnd-pairSt>=duration){
                res.add(pairSt);
                res.add(pairSt+duration);
                return res;
            }
            if(slots1[stIdx1][1]<slots2[stIdx2][1]){
                stIdx1++;
            }else{
                stIdx2++;
            }
        }
        return res;
        
    }
}
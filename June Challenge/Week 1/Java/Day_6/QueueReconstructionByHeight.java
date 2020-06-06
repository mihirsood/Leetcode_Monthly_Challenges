class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return b[0]-a[0];
                }
            }
        });
        
        ArrayList<int[]> temp=new ArrayList<>();
        
        for(int i=0;i<people.length;i++){
            temp.add(people[i][1],people[i]);
        }
        
        return temp.toArray(new int[people.length][2]);
    }
}

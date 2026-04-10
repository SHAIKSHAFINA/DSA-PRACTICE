class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> sc=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        sum(0,arr,target,sc,0,a);
        return sc;

    }

    void sum(int i , int []arr,int target,List<List<Integer>> sc,int sum,List<Integer>a){
        if(sum==target){
            sc.add(new ArrayList<>(a));
            return;
        }
        if(sum>target || i==arr.length){
           return;
        }

        a.add(arr[i]);
        sum(i+1,arr,target,sc,sum+arr[i],a);
        a.remove(a.size()-1);

        int j=i;
        while(j<arr.length && arr[j]==arr[i]){
            j++;
        }
        sum(j,arr,target,sc,sum,a);
        return;
    }
}
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer> sc=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> m=new ArrayList<>();

        for(int num:nums){
            if(num<pivot){
                sc.add(num);
            }
            else if(num==pivot){
                l.add(num);
            }
            else{
                m.add(num);
            }
        }

        ArrayList<Integer> s=new ArrayList<>();

        for(int num:sc){
            s.add(num);
        }

        for(int num:l){
            s.add(num);
        }
        for(int num:m){
            s.add(num);
        }

        int a[]=new int[s.size()];

        for(int i=0;i<s.size();i++){
            a[i]=s.get(i);
        }

        return a;


    }
}
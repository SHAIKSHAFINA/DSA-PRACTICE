class Solution {
    public int reversePairs(int[] arr) {
        // Code Here
        int n=arr.length;
        return mergeSort(arr,0,n-1);
        
    }

    int count(int arr[],int low,int mid,int high){
        int right=mid+1;
        int c=0;

        for(int i=low;i<=mid;i++){
            while(right<=high && (long) arr[i]>2L * arr[right]){
                right++;
            }

            c+=(right-(mid+1));
        }

        return c;
    }
    
    int mergeSort(int arr[],int low,int high){
        if(low>=high){
            return 0;
        }
        
        int mid=low+(high-low)/2;
        int c=0;
        
        c+=mergeSort(arr,low,mid);
        c+=mergeSort(arr,mid+1,high);
        c+=count(arr,low,mid,high);
        merge(arr,low,mid,high);

        return c;
    }
    
    void merge(int arr[],int low,int mid,int high){
        ArrayList<Integer> sc=new ArrayList<>();
        int left=low,right=mid+1;
        
        while(left<=mid && right<=high){
            if(arr[left]<= arr[right]){
                sc.add(arr[left]);
                left++;
            }
            else{
                sc.add(arr[right]);
                right++;
            }
            
        }
        
        while(left<=mid){
            sc.add(arr[left]);
            left++;
        }
        
        while(right<=high){
            sc.add(arr[right]);
            right++;
        }
        
        for(int i=low;i<=high;i++){
            arr[i]=sc.get(i-low);
        }
    }
}
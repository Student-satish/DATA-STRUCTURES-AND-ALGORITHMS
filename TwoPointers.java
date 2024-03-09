class TwoPointers{
    public static int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                return nums1[p1];
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }

        }
        return -1;
    }
    public static void main(String[] args){
        // find the first common value between two arrays
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,3};
        System.out.println(getCommon(nums1,nums2));
    }
}
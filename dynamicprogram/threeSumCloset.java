class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum;
        int ans = nums[0] + nums[1] + nums[2];
        int start, end;
        int n = nums.length;
        
        for (int i=0;i<n; i++){
            start = i+1;
            end = n-1;
            while (start<end){
                sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) <Math.abs(target -ans))ans = sum;
                if (sum==target)return sum;
                else if (sum<target){
                    start ++;
                }
                else if (sum > target){
                    end --;
                }
            }
        }
        return ans;
    }

}
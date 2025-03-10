package leetcode;

import java.util.Arrays;

public class Leet33_find_index_rotated {
    /**
     * Another->dummy
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int l = 0;
        int r = nums.length - 1;

        if(nums[l] < nums[r]) {
            return returnValue(Arrays.binarySearch(nums, target));
        }
        int key = -1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                key = mid; break;
            }
            if(mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                key = mid + 1;
                break;
            }

            if(nums[mid] < nums[l]) {
                r = mid - 1;
            }
            else if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
        }

        int indexOne = returnValue(Arrays.binarySearch(nums, 0, key,  target));
        int indexTwo = returnValue(Arrays.binarySearch(nums, key, nums.length, target));
        if(indexOne >= 0) return indexOne;
        if(indexTwo >= 0) return indexTwo;
        return -1;
    }

    private static int returnValue(int value) {
        if(value < 0) return -1;
        return value;
    }

    public static void main(String[] args) {
        search(new int[]{7,8,1,2,3,4,5,6}, 0);
    }
}

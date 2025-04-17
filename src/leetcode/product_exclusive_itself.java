package leetcode;

public class product_exclusive_itself {
    public int[] productExceptSelf(int[] nums) {
        int prefix[] = new int[nums.length];
        int suffix [] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            prefix[i] = 1;
            suffix[i] = 1;
        }
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length - 1; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[nums.length - (i + 1)] = suffix[nums.length - (i + 1) +1] *  nums[nums.length - (i + 1)];
        }

        int products[] = new int[nums.length];
        products[0] = suffix[1];
        products[nums.length - 1] = prefix[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i++) {
            products[i] = prefix[i - 1] * suffix[i + 1];
        }
        return products;
    }

    public static void main(String[] args) {
        new product_exclusive_itself().productExceptSelf(new int[]{
                1,2,3,4
        });
    }
}

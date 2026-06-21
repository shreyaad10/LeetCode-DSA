class Solution:
    def maxProduct(self, nums):
        cur_max = cur_min = result = nums[0]

        for num in nums[1:]:

            if num < 0:
                cur_max, cur_min = cur_min, cur_max

            cur_max = max(num, cur_max * num)
            cur_min = min(num, cur_min * num)

            result = max(result, cur_max)

        return result
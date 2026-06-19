class Solution:
    def singleNumber(self, nums):
        result = 0

        for i in range(32):
            bit_count = 0

            for num in nums:
                if (num >> i) & 1:
                    bit_count += 1

            if bit_count % 3:
                result |= (1 << i)

        # Handle negative numbers
        if result >= 2**31:
            result -= 2**32

        return result
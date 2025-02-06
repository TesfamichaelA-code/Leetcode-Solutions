class Solution:
    def tupleSameProduct(self, nums):
        product_count = defaultdict(int)
        result = 0
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                product = nums[i] * nums[j]
                product_count[product] += 1
        for count in product_count.values():
            if count > 1:
                result += (count * (count - 1)) // 2 * 8  
        return result

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        zero = 0
        for i in range(len(nums)):
            if zero in nums:
                nums.remove(zero)
                nums.append(zero)
        print(nums)

        



        """
        Do not return anything, modify nums in-place instead.
        """
        
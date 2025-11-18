class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
      k = {}
      for i, num in enumerate(nums):
        ans = target - num
        if ans in k:
            return [k[ans], i]
        k[num] = i
            

        
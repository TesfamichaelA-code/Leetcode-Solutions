class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        res = list(dict.fromkeys(nums))
        nums[:len(res)] = res
        return len(res)
         
        

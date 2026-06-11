class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        candidates.sort()
        result = []
        
        def backtrack(start, path, remaining):
            
            if remaining == 0:
                result.append(path[:])
                return
            
            if remaining < 0:
                return
            
            for i in range(start, len(candidates)):
                
                # Skip duplicates
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                
                path.append(candidates[i])
                
                # i+1 because element can only be used once
                backtrack(
                    i + 1,
                    path,
                    remaining - candidates[i]
                )
                
                path.pop()
        
        backtrack(0, [], target)
        
        return result
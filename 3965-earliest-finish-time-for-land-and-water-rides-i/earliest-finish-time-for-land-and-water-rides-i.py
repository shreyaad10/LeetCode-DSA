class Solution(object):
    def earliestFinishTime(self, landStartTime, landDuration, waterStartTime, waterDuration):
        """
        :type landStartTime: List[int]
        :type landDuration: List[int]
        :type waterStartTime: List[int]
        :type waterDuration: List[int]
        :rtype: int
        """
        
        ans = float('inf')

        for i in range(len(landStartTime)):
            for j in range(len(waterStartTime)):

                # Land -> Water
                land_finish = landStartTime[i] + landDuration[i]
                water_start = max(land_finish, waterStartTime[j])
                finish_time = water_start + waterDuration[j]
                ans = min(ans, finish_time)

                # Water -> Land
                water_finish = waterStartTime[j] + waterDuration[j]
                land_start = max(water_finish, landStartTime[i])
                finish_time = land_start + landDuration[i]
                ans = min(ans, finish_time)

        return ans
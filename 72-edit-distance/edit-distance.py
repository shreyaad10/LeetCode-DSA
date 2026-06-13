class Solution:
    def minDistance(self, word1, word2):
        m, n = len(word1), len(word2)

        prev = list(range(n + 1))

        for i in range(1, m + 1):
            curr = [i] + [0] * n

            for j in range(1, n + 1):

                if word1[i - 1] == word2[j - 1]:
                    curr[j] = prev[j - 1]
                else:
                    curr[j] = 1 + min(
                        prev[j],      # delete
                        curr[j - 1],  # insert
                        prev[j - 1]   # replace
                    )

            prev = curr

        return prev[n]
class Solution:
    def maxIceCream(self, costs, coins):
        max_cost = max(costs)

        freq = [0] * (max_cost + 1)

        for cost in costs:
            freq[cost] += 1

        bars = 0

        for cost in range(1, max_cost + 1):

            if freq[cost] == 0:
                continue

            can_buy = min(freq[cost], coins // cost)

            bars += can_buy
            coins -= can_buy * cost

            if coins < cost:
                break

        return bars
        
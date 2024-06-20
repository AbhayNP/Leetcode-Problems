class Solution:
    def canPlaceBalls(self, gap: int, positions: List[int], m: int) -> bool:
        last_position = positions[0]
        balls_remaining = m - 1
        for i in range(1, len(positions)):
            if positions[i] - last_position >= gap:
                balls_remaining -= 1
                last_position = positions[i]
                if balls_remaining == 0:
                    return True
        return balls_remaining == 0
    def maxDistance(self, positions: List[int], m: int) -> int:
        positions.sort()
        left = 1
        right = positions[-1] - positions[0]
        max_min_distance = -1

        while left <= right:
            mid = (left + right) // 2
            if self.canPlaceBalls(mid, positions, m):
                max_min_distance = mid
                left = mid + 1
            else:
                right = mid - 1 
        return max_min_distance 
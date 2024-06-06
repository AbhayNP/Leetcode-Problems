class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        if (hand.length % groupSize != 0) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int h = entry.getKey();
            int freq = entry.getValue();
            if (freq == 0) {
                continue;
            }
            while (freq-- > 0) {
                for (int cur = h; cur < h + groupSize; cur++) {
                    if (map.getOrDefault(cur, 0) == 0) {
                        return false;
                    }
                    map.put(cur, map.get(cur) - 1);
                }
            }
        }
        return true;
    }
}
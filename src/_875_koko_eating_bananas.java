/**
 * @author yangchen
 * @date 2020/3/28 18:51
 */
public class _875_koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = getMax(piles) + 1;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += timeOf(pile, speed);
        }
        return totalTime <= h;
    }

    private int timeOf(int pile, int speed) {
        return (pile / speed) + ((pile % speed) > 0 ? 1 : 0);
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        return max;
    }


}

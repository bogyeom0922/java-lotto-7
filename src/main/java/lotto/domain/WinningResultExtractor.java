package lotto.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class WinningResultExtractor {

    private final Map<Integer, Integer> matchCounts = new HashMap<>();
    private int bonusCount = 0;

    private enum WinningAmount {
        THREE(5000),
        FOUR(50000),
        FIVE(1500000),
        SIX(2000000000),
        BONUS(30000000);

        private final int amount;

        WinningAmount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    public void getWinningResult(List<Set<Integer>> totalLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        initializeMatchCounts();

        for (Set<Integer> lottoNumber : totalLottoNumbers) {
            countMatchingNumbers(lottoNumber, winningNumbers, bonusNumber);
        }
        matchCounts.put(5, matchCounts.get(5) - bonusCount);
    }

    private void initializeMatchCounts() {
        matchCounts.clear();
        for (int i = 1; i <= 7; i++) {
            matchCounts.put(i, 0);
        }
    }

    private void countMatchingNumbers(Set<Integer> lottoNumber, List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = (int) lottoNumber.stream()
                .filter(winningNumbers::contains)
                .count();
        matchCounts.put(matchingCount, matchCounts.getOrDefault(matchingCount, 0) + 1);
        if (matchingCount == 5 && lottoNumber.contains(bonusNumber)) {
            bonusCount++;
        }
    }

    private int getWinningAmount() {
        return WinningAmount.THREE.getAmount() * matchCounts.get(3)
                + WinningAmount.FOUR.getAmount() * matchCounts.get(4)
                + WinningAmount.FIVE.getAmount() * matchCounts.get(5)
                + WinningAmount.SIX.getAmount() * matchCounts.get(6)
                + WinningAmount.BONUS.getAmount() * bonusCount;
    }

    public String getWinningRate(int purchaseAmount) {
        double winningRate = (double) getWinningAmount() / purchaseAmount * 100;
        return String.format("%.1f", winningRate);
    }
}

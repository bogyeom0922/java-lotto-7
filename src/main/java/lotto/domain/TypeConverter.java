package lotto.domain;

import lotto.validator.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {
    private final WinningNumbers winningNumbers = new WinningNumbers();

    public List<Integer> convertToList(String inputWinningNumbers) {
        winningNumbers.validateEmptyString(inputWinningNumbers);
        List<Integer> inputWinningNumbersList = new ArrayList<>();
        for (String number : inputWinningNumbers.split(",")) {
            String num = number.trim();
            winningNumbers.validateNumberIsInteger(num);
            int winningNumber = Integer.parseInt(num);
            inputWinningNumbersList.add(winningNumber);
        }
        return inputWinningNumbersList;
    }
}

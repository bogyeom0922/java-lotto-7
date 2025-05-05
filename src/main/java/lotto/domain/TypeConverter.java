package lotto.domain;

import lotto.validator.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {

    public List<Integer> convertToList(String inputWinningNumbers) {
        WinningNumbers winningNumbers = new WinningNumbers();

        winningNumbers.validateEmptyString(inputWinningNumbers);

        List<Integer> inputWinningNumbersList = new ArrayList<>();

        for (String number : inputWinningNumbers.split(",")) {
            String num = number.trim();
            winningNumbers.validateNumberIsInteger(num);
            int winningNumber = Integer.parseInt(number.trim());
            inputWinningNumbersList.add(winningNumber);
        }

        return inputWinningNumbersList;
    }


}

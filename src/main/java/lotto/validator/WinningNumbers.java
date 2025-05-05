package lotto.validator;

public class WinningNumbers {

    public void validateEmptyString(String inputWinningNumbers) {
        if (inputWinningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");
        }
    }

    public void validateNumberIsInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 유효하지 않은 값이 포함되어 있습니다.");
        }
    }
}

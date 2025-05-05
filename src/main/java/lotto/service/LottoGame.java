package lotto.service;

import lotto.domain.LottoNumberProvider;
import lotto.domain.TypeConverter;
import lotto.domain.WinningResultExtractor;
import lotto.validator.BonusNumber;
import lotto.Lotto;
import lotto.validator.PurchaseAmount;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private List<Set<Integer>> totalLottoNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int purchaseAmount;

    private final PurchaseAmount purchaseAmountValidator;
    private final LottoNumberProvider lottoNumberProvider;
    private final TypeConverter typeConverter;
    private final BonusNumber bonusNumberValidator;
    private final WinningResultExtractor winningResultExtractor;

    public LottoGame(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.purchaseAmountValidator = new PurchaseAmount();
        this.lottoNumberProvider = new LottoNumberProvider();
        this.typeConverter = new TypeConverter();
        this.bonusNumberValidator = new BonusNumber();
        this.winningResultExtractor = new WinningResultExtractor();
    }

    public void issueLottoNumbers() {
        String purchaseInput = inputReader.inputPurchaseAmount();
        purchaseAmountValidator.validatePurchaseAmount(purchaseInput);
        purchaseAmount = Integer.parseInt(purchaseInput);

        int lottoCount = purchaseAmount / 1000;
        totalLottoNumbers = lottoNumberProvider.generateAndStoreLottoNumbers(lottoCount);

        outputWriter.printLottoNumbers(lottoCount, totalLottoNumbers);
    }

    public void convertAndValidateWinningNumbers() {
        String inputWinningNumbers = inputReader.inputWinningNumbers();
        String inputBonusNumber = inputReader.inputBonusNumber();

        Lotto lottoValidator = new Lotto(typeConverter.convertToList(inputWinningNumbers));
        winningNumbers = lottoValidator.getWinningNumbers();

        bonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumbers);
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public void calculateWinningRate() {
        winningResultExtractor.getWinningResult(totalLottoNumbers, winningNumbers, bonusNumber);
        String winningRate = winningResultExtractor.getWinningRate(purchaseAmount);

        outputWriter.printWinningStatistics(
            winningRate,
            winningResultExtractor.totalMatchCounts,
            winningResultExtractor.bonusCount
        );
    }

}

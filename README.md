# woowacourse-Week3 **[로또]**

## 📌 프로젝트 소개  
이 프로젝트는 **로또**를 구현합니다.  
사용자가 입력한 **당첨 번호**와 시스템이 생성한 **당첨 번호**를 비교하며 로또 게임을 진행합니다.  

- 로또 번호는 1~45 사이의 중복하지 않는 7개의 무작위 값을 통해 당첨 여부를 결정합니다.  
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 합니다.  
- 당첨 내역 및 수익률을 출력하고 로또 게임을 종료합니다.  
- 잘못된 입력이 들어올 경우 **`IllegalArgumentException`**이 발생하며 애플리케이션이 종료됩니다.  

<br>

## 🎯 기능 요구 사항  
1. **로또 번호**
   - 발행 횟수만큼 1~45 사이의 중복하지 않는 6개의 무작위 값을 뽑아 출력합니다. 

2. **번호 비교**
   - 구매한 로또 번호와 당첨 번호를 비교하여 당첨 개수를 기록합니다.

3. **당첨 결과**
   - 당첨 내역 및 수익률을 출력합니다.

4. **예외 처리**
   - 입력 값이 유효하지 않을 경우 **`IllegalArgumentException`**을 발생시키고 애플리케이션을 종료합니다.  

<br>

## 📝 입출력 요구 사항  
**입력**  
1. 로또 구입 금액(1,000원 단위)
2. 당첨 번호(,로 구분된 6개의 중복되지 않는 1-45사이의 정수)
3. 보너스 번호(당첨 번호와 중복되지 않는 1-45 사이의 정수)

**출력**  
- 구매한 개수 만큼의 6개의 로또 번호
- 당첨 통계(내역 및 수익률)

<br><br>

## 📌 패키지 구조 & 구현할 기능
| **Package**   | **Class**            | **Description**                                      | 
|---------------|----------------------|------------------------------------------------------|
| `controller`  | `LottoController`    | 사용자의 요청에 따라 필요한 비즈니스 로직을 실행을 담당하는 컨트롤러  |
| `domain`      | `LottoNumberProvider`| 구매한 금액에 따라 필요한 개수 만큼의 로또 번호를 발행하는 클래스 |
|               | `TypeConverter`      | 입력받은 로또 번호를 숫자로 변환하는 클래스  |
|               | `WinningResultExtractor`| 로또 당첨 결과를 추출하는 클래스  |
| `validator`   | `BonusNumber`| 입력한 보너스 번호에 대해 예외를 처리하는 클래스                          |  
|               | `Lotto`| 입력한 로또 번호에 대해 예외를 처리하는 클래스                          |  
|               | `PurchaseAmount`| 입력한 구매 금액에 대해 예외를 처리하는 클래스                          |  
| `service`     | `LottoGame`          | 전반적인 로또 게임을 처리하는 클래스                         |  
| `util`        | `RandomNumber`       | 랜덤 숫자를 추출하는 클래스                                |  
| `view`        | `InputReader`        | 사용자 입력값을 처리하는 클래스                            |  
|               | `OutputWriter`       | 결과값을 출력하는 클래스                                 |  
      
<br>

## 📌 구현할 기능 목록  
- 시작 메서드 생성  
- 사용자 입력을 처리하는 함수 생성  
- 입력 값의 유효성을 검사하는 함수 생성 
- 쉼표(`,`)로 로또 당첨 번호 분리 및 저장  
- 1-45 사이의 중복되지 않는 무작위 값을 생성하는 함수 생성
- 로또 번호가 당첨인지를 판단하는 로직 구현  
- 당첨 결과를 판단하고 통계를 출력하는 함수 생성
  
<br>

## 📌 예외 처리
- 로또 구입 금액을 입력받지 못한 경우 ("로또 구입 금액을 입력해주세요.")
- 로또 구입 금액이 유효하지 않은 경우
  - 정수 값이 아닌 경우 (입력값 + ": 정수가 아닙니다.")
  - 1,000원으로 나누어 떨어지지 않는 경우 ("로또 구입 금액은 1,000원 단위로 입력해 주세요.")
  - 너무 큰 정수 값이 포함된 경우(처리가 불가능한) (입력값 + ": 너무 큰 값을 입력하였습니다.")
- 당첨 번호를 입력받지 못한 경우 ("당첨 번호를 입력해주세요.")
- 당첨 번호에 공백이 포함된 경우 | 6개 미만의 값을 입력한 경우 ("6개의 당첨 번호를 입력해주세요.")
- 당첨 번호에 정수가 아닌 값이 포함된 경우 ("당첨 번호에 유효하지 않은 값이 포함되어 있습니다.")
- 당첨 번호가 6개가 아닌 경우 ("로또 번호는 6개여야 합니다.")
- 당첨 번호가 1-45사이의 값이 아닌 경우 (입력값 + ": 1과 45사이의 숫자가 아닙니다.")
- 당첨 번호에 중복되는 수가 포함된 경우 ("중복되지 않는 6개의 당첨 번호를 입력해 주세요.")
- 보너스 번호를 입력받지 못한 경우 ("보너스 번호를 입력해주세요.")
- 보너스 번호가 1-45사이의 정수값이 아닌 경우 (입력값 + ": 1과 45사이의 숫자가 아닙니다.")
- 보너스 번호에 정수가 아닌 값이 포함된 경우 ("유효하지 않은 값이 포함되어 있습니다.")
- 보너스 번호가 당첨 번호와 중복되는 경우 (입력값 + "당첨 번호와 중복되지 않는 숫자를 입력해주세요.")

<br>

## 📌 테스트할 입력 값

### 올바른 입력값의 경우  
| 입력값  | 기대값                     |  
|---------|---------------------------|  
| 8000 | 8개를 구매했습니다. <br> [8, 21, 23, 41, 42, 43]  <br> [3, 5, 11, 16, 32, 38]  <br> [7, 11, 16, 35, 36, 44]  <br> [1, 8, 11, 31, 41, 42]  <br> [13, 14, 16, 38, 42, 45]  <br> [7, 11, 30, 40, 42, 43]  <br> [2, 13, 22, 32, 38, 45]  <br> [1, 3, 5, 14, 22, 45] |  
| 1,2,3,4,5,6 <br><br> 7| 당첨 통계 <br> --- <br> 3개 일치 (5,000원) - 1개 <br> 4개 일치 (50,000원) - 0개 <br> 5개 일치 (1,500,000원) - 0개 <br> 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개 <br> 6개 일치 (2,000,000,000원) - 0개 <br> 총 수익률은 62.5%입니다. |  

### 예외 처리를 하는 경우  
| 입력값           | 기대값                                           |  
|---------------|--------------------------------------------------|  
| `(빈 문자열)`   | `[ERROR] 로또 구입 금액을 입력해주세요.`                |  
| `2@#$!`       | `[ERROR] 2@#$!: 정수가 아닙니다.`       |  
| `2340`        | `[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.`  |  
| `388372749302`| `[ERROR] 388372749302: 너무 큰 값을 입력하였습니다.`   |  
| `(빈 문자열)`   | `[ERROR] 당첨 번호를 입력해주세요.`                    |
| `1,2,3,,,6`   | `[ERROR] 6개의 당첨 번호를 입력해주세요.`               |
| `1,2,3,4,5`   | `[ERROR] 로또 번호는 6개여야 합니다.`                  |
| `1,2,98,!@,3` | `[ERROR] 당첨 번호에 유효하지 않은 값이 포함되어 있습니다.`  |
| `1,2,3,4,5,80`   | `[ERROR] 80: 1과 45사이의 숫자가 아닙니다.`         |
| `1,2,3,4,5,5`   | `[ERROR] 중복되지 않는 6개의 당첨 번호를 입력해 주세요.` |
| `(빈 문자열)`   | `[ERROR] 보너스 번호를 입력해주세요.`                   |
| `268`       | `[ERROR] 268: 1과 45사이의 숫자가 아닙니다.`       |
| `2@#$!`       | `[ERROR] 유효하지 않은 값이 포함되어 있습니다.`       |
| `2`       | `[ERROR] 2: 당첨 번호와 중복되지 않는 숫자를 입력해주세요.`       |

<br>

## 📌 3주차 미션 진행시 개선할 점
이번 구현에서 코드 리뷰와 공통 피드백을 통해 개선해야겠다고 느낀 부분:

- 계층형 아키텍처에 대해 학습
- 단위테스트하기
- 도메인에서 뷰를 직접적으로 참조하지 않도록 하기
- 매직넘버는 상수로 빼기

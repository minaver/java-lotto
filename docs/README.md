# 요구 사항 분석

## 🚀 기능 요구사항 리스트
### Logic
1. 사용자용 로또 - 중복되지 않는 6개의 숫자(로또) 발행 (구입 금액 단위로 발행)
2. 당첨용 로또 - 중복되지 않는 숫자 6개와 보너스 번호 1개 (입력 받음)
3. 당첨 내역 판단한다
4. 수익률 계산한다

### I/O
1. 로또 구입 금액 In
2. 당첨 번호 In
3. 보너스 번호 In
4. 발행 로또 수량 및 번호 Out
5. 당첨 내역 Out
6. 수익률 Out

### Validation

## 구조화(MVC)
InputView : 입력 담당<br>
OutputView : 출력 담당<br>
Controller : 요청 수행<br>
Model(Service) : Lotto , Shop , LottoGenerator , LottoCompany<br>
DTO : <br>
VO : WinLotto<br>
Enum : Grade<br>

### InputView
```
int getPayedMoney()
List<Integer> getWinLottoNumber()
int getBonusNumber()
```

### OutputView
```
void printPayedLotto(List<Lotto> payedLottos)
void printWinStats(Map<Grade,Integer> winStats)
void printEarningRate(Double earningRate)
```

### Controller
```
// field
final InputView inputView
final OuputView outputView
final Shop shop
final LottoCompany lottoCompany
List<Lottos> payedLottos
WinLotto winLotto

// constructor
this.

// 요청 수행 method
getLottos()
    - inputView.getPayedMoney()
    - shop.getPayedLotto()
    - output.printPayedLotto()

setWinLotto()
    - inputView.getWinLottoNumber()
    - inputView.getBonusNumber()
    - shop.getWinLotto()
    
getStats()
    - lottoCompany.getWinStats()
    - lottoCompany.getEarningRate()
    - output.printWinStats()
    - output.printEarningRate()

```

### Lotto 
```
[field]<br>
List<Integer> numbers : 중복되지 않는 6개의 숫자 리스트

[constructor]<br>
validate(numbers)
this.

[method]<br>
private void validate(List<Integer> numbers) : List 요소 수가 6개인지 확인
```


### Shop : 로또를 발급해주는 상점. 원하는 수만큼의 로또를 발급하고 당첨 로또 또한 발급한다.
```
[field]<br>
LottoGenerator lottoGenerator

[constructor]<br>
this.

[method]<br>
public List<Lotto> getPayedLotto(int money) : 제공 받은 돈 만큼 로또를 발급해 제공 (Logic.1)
    - lottoGenerator.generateLottoRandom()
public WinLotto getWinLotto(List<Integer> targetNumber, int bonusNumber) : 원하는 당첨 로또를 제공 (Logic.2)
    - lottoGenerator.generateLotto(targetNumber,bonusNumber)

private void moneySizeValidate() : 돈이 1000으로 나뉘어 지는지 확인
private void moneyTypeValidate() : 돈이 숫자인지 확인
private void bonusNumValidate() : 보너스 숫자가 유효한지
```

### LottoGenerator : 로또를 만드는 기계
```
[field]<br>

[constructor]<br>

[method]<br>
public Lotto generateLottoRandom() : 로또를 랜덤하게 생성
public Lotto generateLotto(List<Integer> targetNumber) : 로또를 원하는 숫자로 생성

```

### LottoCompany : 로또 당첨 여부 및 수익률을 계산해주는 회사
```
[field]<br>
WinLotto winLotto

[constructor]<br>
this.

[method]<br>
public Map<Grade,Integer> getWinStats(List<Lotto> payedLotto) : 당첨 통계 파악 (Logic.3)
public Double getEarningRate(int money, Map<Grade,Integer> winStats) : 수익률 파악 (Logic.4)

private int calcTotalEarningMoney(Map<Grade,Integer> winStats)
private int calcEarningRate(int money, int earningMoney)

```


### WinLotto : 당첨 로또 VO
```
[field]<br>
Lotto winLotto
int bonusNumber
[constructor]<br>

```

### Grade
```
[field]<br>
first(2000000000)
second(30000000)
third(1500000)
forth(50000)
fifth(5000)

[constructor]<br>

[method]<br>

```
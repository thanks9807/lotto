
//import camp.nextstep.edu.missionutils.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        int size = 6;
        int price = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        // TODO: 프로그램 구현

        // 로또를 산다.
        System.out.println("구입금액을 입력해 주세요.");
        try {
            while (true) {

                price = sc.nextInt();
                if (price % 1000 == 0) break;
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 1000의 배수를 입력해주세요.");

        }
        count = price / 1000;
        System.out.println(count+"개를 구매했습니다.");
        // 로또를 몇 장 사는지 count가 나온다.

        //count 만큼 로또를 만든다.
        Lotto[] lottos = new Lotto[count];
        LottoFactory lottoFactory = new LottoFactory();

        for(int i = 0 ;i<count ;i++){
            lottos[i] = lottoFactory.buyLotto();
        }

        for(int i = 0 ;i < count ;i++){
            lottos[i].printLotto();
        }

        //당첨 번호 생성
        List<Integer> numbers = new ArrayList<>();
        try {
            System.out.println("당첨 번호를 입력해주세요.");
            String str = sc.next();
            String[] array = str.split(",");

            for (int i = 0; i < array.length; i++) {
                int n = Integer.parseInt(array[i]);
                if (n > 45 || n < 1) {
                    throw new IllegalArgumentException();
                }
                numbers.add(n);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        //[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

        Lotto winningNumbers = lottoFactory.buyLotto(numbers);

        //winningNumbers.printLotto();

        //보너스 번호
        System.out.println("보너스 번호를 입력해주세요.");
        int bonus = sc.nextInt();



        //당첨 여부 확인
        Lotto_result result = new Lotto_result(winningNumbers,bonus,lottos);
        result.print();
        float prizeRate = 0.0f;
        prizeRate = result.totalPrize / price;
        System.out.println("총 수익률은 "+prizeRate+"%입니다.");


    }
}

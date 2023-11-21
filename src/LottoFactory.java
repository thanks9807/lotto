
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import static camp.nextstep.edu.missionutils.*;
public class LottoFactory {
    Random random;

    public LottoFactory() {
        random = new Random(); // 랜덤 객체 생성
        random.setSeed(System.currentTimeMillis());
    }


    public Lotto buyLotto(){
        //System.out.println("6개의 숫자를 생성합니다.");

        List<Integer> numberlist = new ArrayList<>();
        Lotto lotto = null;

        while (numberlist.size() < 6) {
            int randomNumber = random.nextInt(45);
            if (randomNumber != 0 && !numberlist.contains(randomNumber)) { // 0이랑 숫자 중복 막음.
                numberlist.add(randomNumber);
            }
        }
        //System.out.println("숫자를 정했습니다.");

        return lotto = new Lotto(numberlist);

    }


    public Lotto buyLotto(List<Integer> numbers) {
        Lotto lotto= new Lotto(numbers);
        return lotto;
    }
}

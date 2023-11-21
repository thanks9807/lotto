import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void printLotto(){
        numbers.sort(Comparator.naturalOrder());
        System.out.print("[");
        for(int i = 0 ; i < 6 ;i++) {
            System.out.print(numbers.get(i));
            if (i < 5) System.out.print(",");
            else System.out.print("]\n");
        }
    }
    // TODO: 추가 기능 구현

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public int get(int i){
        return numbers.get(i);
    }
}

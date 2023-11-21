
public class Lotto_result {

    int totalPrize = 0;
    Integer[] ranks = {0,0,0,0,0};
    Integer[] prizes = {5000,50000,1500000,30000000,2000000000};
    String[] prizesStr = {"5,000","50,000","1,500,000","30,000,000","2,000,000,000"};
    public Lotto_result(Lotto winningNumber, int bonus, Lotto[] lottos) {

        for(int i = 0;i<lottos.length;i++){
            int rank = getRank(winningNumber,bonus,lottos[i]);
            if(rank == 10) continue;
            ranks[rank]++;
        }
        totalPrize = 0;
        for(int i = 0; i<5 ;i++){
            totalPrize += ranks[i] * prizes[i];
        }
    }

    public int getRank(Lotto winning_number, int bonus, Lotto lotto){
        int c = 0;
        int prize = 10;

        for(int j = 0 ;j < 6 ;j++){
            if(winning_number.contains(lotto.get(j))){
                c++;
            }
        }

        //System.out.println("총 "+ c +"개의 숫자가 일치합니다.");
        if (c == 3){
            //System.out.println("5등입니다.");
            prize = 0;
        }
        else if(c == 4){
            //System.out.println("4등입니다.");
            prize = 1;
        }
        else if(c == 5){
            if(!lotto.contains(bonus)){
                //System.out.println("3등입니다.");
                prize = 2;
            }
            else{
                //System.out.println("보너스가 일치합니다. 2등입니다.");
                prize = 3;
            }
        }
        else if (c == 6){
            //System.out.println("1등입니다.");
            prize = 4;
        }

        return prize;
    }


    public void print() {
        System.out.println("당첨 통계\n---");

        System.out.println("3개 일치 ("+prizesStr[0]+"원) - "+ranks[0]+"개");
        System.out.println("4개 일치 ("+prizesStr[1]+"원) - "+ranks[1]+"개");
        System.out.println("5개 일치 ("+prizesStr[2]+"원) - "+ranks[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+prizesStr[3]+"원) - "+ranks[3]+"개");
        System.out.println("6개 일치 ("+prizesStr[4]+"원) - "+ranks[4]+"개");

    }
}

import java.util.Random;
public class diceroll {
	public int roll(){
			Random rand = new Random();
			int dice1 = rand.nextInt(6)+1;
			int dice2 = rand.nextInt(6)+1;
			return dice1+dice2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diceroll twodice = new diceroll();
		int[] counter = new int[13];
		for (int i =0; i < 10000; i++){
			int rollresult = twodice.roll();
			counter[rollresult] +=1;
		}
		for (int i =2; i<13; i++){
			System.out.println(i + "\t" + counter[i]);
		}

	}

}

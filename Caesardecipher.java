import edu.duke.*;
public class Caesardecipher {
	private String alphabet;
	private int inverseshift;
	public Caesardecipher(){
		alphabet = "abcdefghijklmnopqrstuvwxyz"; //lower case alphabet
	}

	public int[] lettercount(String currmessage){
		int[] counter = new int[26];
		for (int i = 0; i<currmessage.length(); i++){
			char currchar = currmessage.charAt(i);
			int charidx = matchchar(currchar);
			if (charidx != -1){
				counter[charidx]++;
			}
		}
		return counter;
	}
	public int matchchar(char input){
		input = Character.toLowerCase(input);
		for (int i = 0; i<alphabet.length(); i++){
			if (input == alphabet.charAt(i)){
				return i;
			}
		}
		return -1;
	}
	public int maxletter(int[] lettercount){
		int tempindex = 0;
		int tempstor = 0;
		for (int i = 0; i<lettercount.length; i++){
			if (lettercount[i] > tempstor){
				tempstor = lettercount[i];
				tempindex = i;
			}
		}
		return tempindex;
	}
	public String breakcipher(String input){
		int [] lettercountresult = lettercount(input);
		int maxidx = maxletter(lettercountresult);
		if (maxidx >= 4){
			inverseshift = 26-(maxidx-4);
		}
		else{
			inverseshift = 4-maxidx;
		}
		Caesarcipher cc = new Caesarcipher(inverseshift);
		String output = cc.encrypt(input);
		return output;
	}
	public static void main(String[] args) {
		Caesardecipher cc = new Caesardecipher();
		FileResource resource = new FileResource("data/wordsLotsOfEsEncrypted2.txt");
		String strresource = resource.asString().toLowerCase();
		System.out.println(strresource + "\n");
		System.out.println(cc.breakcipher(strresource) + "\n");
	}

}

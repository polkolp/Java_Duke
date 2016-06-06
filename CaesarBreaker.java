import edu.duke.*;
public class CaesarBreaker {
	private String alphabet;
	private int mainkey;
	public CaesarBreaker(){
		alphabet = "abcdefghijklmnopqrstuvwxyz"; //lower case alphabet
	}
	public String halfOfString(String input, int start){
		StringBuilder half = new StringBuilder();
		for (int i = start; i<input.length(); i+=2){
			half.append(input.charAt(i));
		}
		return half.toString();
	}
	private int[] lettercount(String currmessage){
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
	private int matchchar(char input){
		input = Character.toLowerCase(input);
		for (int i = 0; i<alphabet.length(); i++){
			if (input == alphabet.charAt(i)){
				return i;
			}
		}
		return -1;
	}
	private int maxletter(int[] lettercount){
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
	public int getkey(String input){
		int [] lettercountresult = lettercount(input);
		int maxidx = maxletter(lettercountresult);
		int inverseshift;
		if (maxidx >= 4){
			inverseshift = 26-(maxidx-4);
		}
		else{
			inverseshift = 4-maxidx;
		}
		mainkey = inverseshift;
		return inverseshift;
	}
	
	public static void main(String[] args) {
		CaesarBreaker code = new CaesarBreaker();
		FileResource resource = new FileResource("D:/eclipse/workspace/Caesar/data/mysteryTwoKeysQuiz.txt");
		String source = resource.asString();
		
/*		String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
		String source = message;*/
		
		String s1 = code.halfOfString(source.toLowerCase(),0);
		String s2 = code.halfOfString(source.toLowerCase(),1);
		int key1 = code.getkey(s1);
		int key2 = code.getkey(s2);
		
		encryptTwoKeys dcph = new encryptTwoKeys(key1, key2);
		String output = dcph.encrypt(source);
		
		System.out.println(output + "\n" + "key1 = " + (26-key1) + "\n" + "key2 = " + (26-key2));
	}

}

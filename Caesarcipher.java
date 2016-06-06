public class Caesarcipher {
	private String lcalphabet;
	private String shiftedlcalphabet;
	private String ucalphabet;
	private String shifteducalphabet;
	private int mainkey;
	public Caesarcipher(int key){
		lcalphabet = "abcdefghijklmnopqrstuvwxyz"; //lower case alphabet
		shiftedlcalphabet = lcalphabet.substring(key) + lcalphabet.substring(0, key);
		ucalphabet = lcalphabet.toUpperCase();
		shifteducalphabet = shiftedlcalphabet.toUpperCase();
		mainkey = key;
	}
	
	public String encrypt(String message){
		StringBuilder output = new StringBuilder(message);
		
		for (int i =0; i<message.length(); i++){
			char shiftedchar = ' ';
			char currchar = message.charAt(i);
			if (lcalphabet.indexOf(currchar) == -1 || ucalphabet.indexOf(currchar) == -1){
				shiftedchar = currchar;
			}
			
			if (Character.isLowerCase(currchar) == true){
				int idx = lcalphabet.indexOf(currchar);
				shiftedchar = shiftedlcalphabet.charAt(idx);					
			}

			if (Character.isUpperCase(currchar) == true){
				int idx = ucalphabet.indexOf(currchar);
				shiftedchar = shifteducalphabet.charAt(idx);
			}
			output.setCharAt(i, shiftedchar);
		}
		return output.toString();
	}
	public String decrypt(String input){
		Caesarcipher cc = new Caesarcipher(26-mainkey);
		String output = cc.encrypt(input);
		return output;
	}
		
	


}

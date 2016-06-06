
public class encryptTwoKeys {
	private String lcalphabet;
	private String shiftedlcalphabet1;
	private String shiftedlcalphabet2;
	private String ucalphabet;
	private String shifteducalphabet1;
	private String shifteducalphabet2;
	private int mainkey1;
	private int mainkey2;
	
	public encryptTwoKeys(int key1, int key2){
		lcalphabet = "abcdefghijklmnopqrstuvwxyz"; //lower case alphabet
		shiftedlcalphabet1 = lcalphabet.substring(key1) + lcalphabet.substring(0, key1);
		shiftedlcalphabet2 = lcalphabet.substring(key2) + lcalphabet.substring(0, key2);
		ucalphabet = lcalphabet.toUpperCase();
		shifteducalphabet1 = shiftedlcalphabet1.toUpperCase();
		shifteducalphabet2 = shiftedlcalphabet2.toUpperCase();
		mainkey1 = key1;
		mainkey2 = key2;
	}
	public String encrypt(String message){
		StringBuilder output = new StringBuilder(message);
		Caesarcipher cc1 = new Caesarcipher(mainkey1);
		Caesarcipher cc2 = new Caesarcipher(mainkey2);
		
		for (int i =0; i<message.length(); i++){
			String currchar = Character.toString(message.charAt(i));
			char encryptedchar;
			if (i%2 == 0){
				encryptedchar = cc1.encrypt(currchar).charAt(0);
			}
			else{
				encryptedchar = cc2.encrypt(currchar).charAt(0);
			}
			output.setCharAt(i, encryptedchar);
		}
		return output.toString();
	}
	public String decrypt(String input){
		encryptTwoKeys et = new encryptTwoKeys(26-mainkey1, 26-mainkey2);
		String decrypted = et.encrypt(input);
		return decrypted;
	}
	public static void main(String[] args) {
		encryptTwoKeys cipher = new encryptTwoKeys(14,24);
		// TODO Auto-generated method stub
		
		String encryptedmessage = cipher.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println(encryptedmessage);
		System.out.println(cipher.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
		
	}

}

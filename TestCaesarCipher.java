import edu.duke.*;
public class TestCaesarCipher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FileResource file = new FileResource("data/wordsLotsOfEs.txt");
		String s = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
		Caesarcipher cc = new Caesarcipher(15);
		String encryptedmessage = cc.encrypt(s);
		System.out.println(encryptedmessage + "\n");
		System.out.println(cc.decrypt(encryptedmessage) + "\n");
		
/*		Caesardecipher cd = new Caesardecipher();
		String output = cd.breakcipher(encryptedmessage);
		System.out.println(output);*/
	}

}

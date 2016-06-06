public class simplecaesar {
	public static String encrypt(String message, int key){
		if (key >= 26){
			throw new IllegalArgumentException("key must be less than 26");
		}

//		message = message.toUpperCase();
		StringBuilder encryptedmessage = new StringBuilder(message);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
//		alphabet = alphabet.toUpperCase();
		String encryptedalphabet = alphabet.substring(key) + alphabet.substring(0, key);

		for (int i = 0; i < message.length(); i++){
			char currChar = message.charAt(i);
			if (Character.isUpperCase(currChar) == true){
				currChar = Character.toLowerCase(currChar);
				int idx = alphabet.indexOf(currChar);
				if (idx != -1){
					char newchar = encryptedalphabet.charAt(idx);
					encryptedmessage.setCharAt(i, Character.toUpperCase(newchar));
				}
			}
			else{
				int idx = alphabet.indexOf(currChar);
				if (idx != -1){
					char newchar = encryptedalphabet.charAt(idx);
					encryptedmessage.setCharAt(i, newchar);
				}
			}	
		}
		return encryptedmessage.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String msg = args[0];
		int key = Integer.parseInt(args[1]);
		String encodedmsg = encrypt(msg, key);
		System.out.println(encodedmsg);
	}

}

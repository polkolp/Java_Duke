public class isVowel {
	public static boolean isVowel(char ch){
		ch = Character.toLowerCase(ch);
		String Vowel = "aeiou";
		for (int i = 0; i <Vowel.length(); i++){
			char currchar = Vowel.charAt(i);
			if (ch == currchar){
				return true;
			}
		}
		return false;
	}
	public static StringBuilder replaceVowels(String phrase, char ch){
		StringBuilder outputstring = new StringBuilder(phrase);
		for (int i = 0; i < phrase.length(); i++){
			char currchar = phrase.charAt(i);
			if (isVowel(currchar) == true){
				outputstring.setCharAt(i, ch);
			}
		}
		return outputstring;
	}
	public static StringBuilder emphasize(String phrase, char ch){
		StringBuilder output = new StringBuilder(phrase);
		for (int i = 0; i < phrase.length(); i++){
			char currchar = phrase.charAt(i);
			if (ch == currchar){
				if (i%2==0){
					output.setCharAt(i, '*');
				}
				else{
					output.setCharAt(i, '+');
				}
			}
			else{
				throw new IllegalArgumentException("no corresponding characters found");
			}
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceVowels("Oello World", '*'));
		System.out.println(emphasize("AAAAAA",'a'));
	}

}

import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
	private ArrayList<String> characters;
	private ArrayList<Integer> counts;
	public CharactersInPlay(){
		characters = new ArrayList<String>();
		counts = new ArrayList<Integer>();
	}
	private void update(String person){
		person = person.toUpperCase();
		if (characters.contains(person)){
			int idx = characters.indexOf(person);
			int value = counts.get(idx);
			counts.set(idx, value+1);
		}
		else{
			characters.add(person);
			counts.add(1);
		}
	}
	public void findAllCharacters(FileResource txt){
		for (String s:txt.lines()){
			int counter = 0;
			for (int i = 0; i < s.length(); i++){
				if (s.charAt(i) == '.' && counter == 0 ){
					update(s.substring(0, i));
					counter++;
				}
			}
		}
	}
	public void charactersWithNumParts(int num1, int num2){
		if (num1 > num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		for (int i = 0; i<counts.size(); i++){
			if (counts.get(i)<= num2 && counts.get(i)>=num1){
				System.out.println(characters.get(i) + "\t" + counts.get(i));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharactersInPlay cip = new CharactersInPlay();
		FileResource txt = new FileResource("D:/eclipse/workspace/Caesar/data/likeit.txt");
		cip.findAllCharacters(txt);
/*		for (int i = 0; i<cip.counts.size(); i++){
				System.out.println(cip.characters.get(i) + "\t" + cip.counts.get(i));
		}*/
		cip.charactersWithNumParts(10, 15);
	}
}

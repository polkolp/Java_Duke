import edu.duke.*;
public class WordLength {
public int[] countWordLengths(FileResource resource, int[] counts){
	for (String s:resource.words()){
		int wordlength = s.length();
		if (wordlength>=counts.length){
			counts[counts.length-1]++;
		}
		if (Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(s.length()-1))){
			counts[wordlength]++;
		}
		else{
			counts[wordlength-1]++;
		}
	}
	return counts;
}
public int indexOfMax(int[] value){
	int tempindex = 0;
	int tempstor = 0;
	for (int i = 0; i<value.length; i++){
		if (value[i] > tempstor){
			tempstor = value[i];
			tempindex = i;
		}
	}
	return tempindex;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLength test = new WordLength();
		FileResource resource = new FileResource("D:/eclipse/workspace/Caesar/data/manywords.txt");
		int[] counts = new int[31];
		int[] countresult = test.countWordLengths(resource, counts);
		for (int i = 1; i< countresult.length; i++){
			System.out.println(countresult[i]+"words of length"+i);
		}
		System.out.println("Most common length is " + test.indexOfMax(countresult));
	}

}

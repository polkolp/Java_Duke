import edu.duke.*;
import java.util.*;
public class WordFrequencies {
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	public WordFrequencies(){
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}
	public void findUnique(FileResource txt){
		myWords.clear();
		myFreqs.clear();
		for (String s: txt.words()){
			s = s.toLowerCase();
			if (myWords.contains(s)){
				int idx = myWords.indexOf(s);
				int value = myFreqs.get(idx);
				myFreqs.set(idx, value+1);
			}
			else{
				myWords.add(s);
				myFreqs.add(1);
			}
		}
	}
	public int findIndexOfMax(){
		int count = 0;
		int targetidx = 0;
		for (int i = 0; i< myFreqs.size(); i++){
			if (myFreqs.get(i)>count){
				targetidx = i;
				count = myFreqs.get(i);
			}
		}
		return targetidx;
	}
	public int numOfUniqueWords(){
		return myWords.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileResource txt = new FileResource();
		WordFrequencies wf = new WordFrequencies();
		wf.findUnique(txt);
/*		for (int i = 0; i< wf.myFreqs.size(); i++){
		System.out.println(wf.myWords.get(i) + "\t" + wf.myFreqs.get(i));
		}*/
		System.out.println(wf.numOfUniqueWords());
		int maxidx = wf.findIndexOfMax();
		System.out.println("Most often words = " + wf.myWords.get(maxidx) + "\n" + "Most often Freqs = " + wf.myFreqs.get(maxidx));
	}

}

import edu.duke.*;
import java.io.File;
import java.util.*;
public class WordsInFiles {
	private HashMap<String, ArrayList<String>> map;
	
	public WordsInFiles(){
		map = new HashMap<String, ArrayList<String>>();
	}
	private void addWordsFromFile(String fl){
		FileResource f = new FileResource("D:/eclipse/workspace/Caesar/data/" + fl);
		for (String s: f.words()){
			if (map.containsKey(s)){
				if (!map.get(s).contains(fl)){
					map.get(s).add(fl);
				}
			}
			else{
				ArrayList<String> al = new ArrayList<String>();
				al.add(fl);
				map.put(s, al);
			}
		}
	}
	public void buildWordFileMap(){
		map.clear();
		 DirectoryResource dr = new DirectoryResource();
		 for (File f : dr.selectedFiles()) {
			 String fl = f.getName();
			 addWordsFromFile(fl);
		 } 
	}
	
	public int maxNumber(){
		int counts = 0;
		for (String s: map.keySet()){
			if (map.get(s).size() > counts){
				counts = map.get(s).size();
			}
		}
		return counts;
	}
	public ArrayList<String> wordsInNumFiles(int num){
		ArrayList<String> words = new ArrayList<String>();
		for (String s: map.keySet()){
			if (map.get(s).size() == num){
				words.add(s);
			}
		}
		return words;
	}
/*	public int wordsInNumFiles(int num){
		int counts = 0;
	for (String s: map.keySet()){
		if (map.get(s).size() == num){
			System.out.println(s);
			counts++;
		}
	}
	return counts;
	}*/
	public void printFilesIn(String word){
		ArrayList<String> al = new ArrayList<String>();
		al = map.get(word);
		for (int i = 0; i< al.size(); i++){
			System.out.println(al.get(i));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordsInFiles sf = new WordsInFiles();
		sf.buildWordFileMap();
//		System.out.println(sf.maxNumber());
		System.out.println(sf.wordsInNumFiles(4).size());
/*		System.out.println(sf.wordsInNumFiles(4));*/
		sf.printFilesIn("red");
	}

}

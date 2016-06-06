import edu.duke.*;

import java.lang.reflect.Array;
import java.util.*;

public class GladLibMap {
	private HashMap<String, ArrayList<String>> map;
	private ArrayList<String> wordCount;
	private String[] wordList = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
	private Random myRandom;
	private int counts;
	private HashMap<String, Integer> categoryConsidered;
	
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";
	
	public GladLibMap(){
		map = new HashMap<String, ArrayList<String>>();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		counts = 0;
	}
	
	public GladLibMap(String source){
		map = new HashMap<String, ArrayList<String>>();
		initializeFromSource(source);
		myRandom = new Random();
		counts = 0;
	}
	
	private void initializeFromSource(String source) {
		for (String s: wordList){
			ArrayList<String> wordtxt = readIt(source+"/" + s + ".txt");
			map.put(s, wordtxt);
		}
		wordCount = new ArrayList<String>();
		categoryConsidered = new HashMap<String, Integer>();
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		if (!categoryConsidered.containsKey(label)){
			categoryConsidered.put(label, 1);
		}
		if (label.equals("number")){
			return ""+myRandom.nextInt(50)+5;
		}
		return randomFrom(map.get(label));
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
		while (wordCount.contains(sub)){
			sub = getSubstitute(w.substring(first+1,last));
		}
		wordCount.add(sub);
		counts++;
		
		return prefix+sub+suffix;
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	private int numReplaced(){
		return counts;
	}
	private int totalWordsInMap(){
		int counts = 0;
		for (String s: map.keySet()){
			counts = counts+map.get(s).size();
		}
		return counts;
	}
	private int totalWordsConsidered(){
		int counts = 0;
		for (String s: categoryConsidered.keySet()){
			counts = counts + map.get(s).size();
		}
		return counts;
	}
	
	public static void main(String[] args){
		GladLibMap gl = new GladLibMap();
	    System.out.println("\n");
		String story = gl.fromTemplate("data/madtemplate2.txt");
		gl.printOut(story, 60);
		System.out.println("\n" + "Total words replaced = " + gl.numReplaced());
	}
	


}


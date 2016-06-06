import edu.duke.*;
import java.util.*;
public class condonCount {
	private HashMap<String, Integer> map;
	public condonCount(){
		map = new HashMap<String, Integer>();
	}
	private void buildCodonMap(int start, String dna){
		map.clear();
		for (int i = start; i+3 <= dna.length(); i+=3){
			String condon = dna.substring(i, i+3);
			if (map.containsKey(condon)){
				map.put(condon, map.get(condon)+1);
			}
			else{
				map.put(condon, 1);
			}
		}
		System.out.println("Starting from " + start + ", Number of unique codons is " + map.size());
	}
	public String getMostCommonCodon(){
		String mostcommon = "";
		int vl = 0;
		for (String k: map.keySet()){
			if(map.get(k)> vl){
				vl =map.get(k);
				mostcommon = k;
			}
		}
		return mostcommon;
	}
	public void printCodonCounts(int start, int end){
		for (String k: map.keySet()){
			if(map.get(k) >= start && map.get(k) <= end){
				System.out.println(k + "\t" + map.get(k));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		condonCount cc = new condonCount();
		String dna = "ATTAATACTTTGTTTAACAGTAATTATTCAACTATTAAATATTTAAATAATTAAGTTATTAAACTATTAAGTACAGGGCCTGTATCTCTGATGCTGAACTATGATGTGTGACTTAAGCCCCCAAATACATCATGTTATTTGGATCCAAGGTGCTGCACAGAACGCTGACCCTCTCTAAGAGCTGGGTATTACT";
		for (int i = 0; i<3; i++){
			cc.buildCodonMap(i, dna);
			System.out.println("Most common Condon is " + cc.getMostCommonCodon());
			cc.printCodonCounts(6, 6);
		}

	}

}

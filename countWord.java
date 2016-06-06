import edu.duke.*;
public class countWord {
	public String[] getcommon(){
		FileResource resource = new FileResource("data/common.txt");
		String [] common = new String[20];
		int idx = 0;
		for (String s: resource.words()){
			common[idx] = s;
			idx++;
		}
		return common;
	}
	public int findwords(String s, String[] common){
		s = s.toLowerCase();
		for (int i = 0; i<20; i++){
			if (common[i].equals(s)){
				return i;
			}
		}
		return -1;
	}
	public int [] countwords(FileResource fname, String[] common, int[] count){
		for (String s: fname.words()){
			int index = findwords(s,common);
			if (index != -1){
				count[index] ++;
			}		
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countWord Shakespear = new countWord();
		String[] common = Shakespear.getcommon();
		String[] play = {"caesar.txt", "hamlet.txt", "macbeth.txt", "romeo.txt", "likeit.txt", "errors.txt"};
		int [] count = new int[20];
		for (int i= 0; i<6; i++){
			FileResource resource = new FileResource("data/"+play[i]);
			count = Shakespear.countwords(resource, common, count);
			System.out.println("done with " + play[i]);
		}
		for (int j = 0; j<20; j++){
			System.out.println(common[j] + "\t" + count[j]);
		}

	}

}

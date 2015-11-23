import java.util.LinkedList;
import java.util.List;

public class Sentence {

	private List<String> words;
	
	public Sentence(String s) {
		
		this.words = new LinkedList<String>();
		int index = 0;
		int LIMIT = s.length();
		// assuming: no double blanks
		
		if(s.contains(" ")) {
			while (index <= LIMIT) {
				int end = s.indexOf(" ", index);
				if (end < index) {
					words.add(s.substring(index, LIMIT));
					break;
				}
				words.add(s.substring(index, end));
				index = end + 1;
				if (index == -1 || index > LIMIT) {
					break;
				}
			}
		} else {
			words.add(s);
		}
		
	}
	
	public List<String> getWords() {
		return this.words;
	}
	
	@Override
	public String toString() {
		
		StringBuilder output = new StringBuilder("");
		
		for (String str : this.words)
			output.append(str + ", ");
		
		if ( output.length() > 5)
			output.replace(output.length() - 2, output.length(), "");
		
		return output.toString();
	}
	
	public void print() {
		
		System.out.println("[" + this + "]");
	}
}

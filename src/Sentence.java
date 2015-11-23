import java.util.Iterator;
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
	
	@Override
	public String toString() {
		
		Iterator<String> iter = this.words.listIterator();
		
		StringBuilder output = new StringBuilder("");

		while (iter.hasNext()) {		
			output.append(iter.next() + ", ");
		}
		
		if ( output.length() > 5) {
			output.replace(output.length() - 2, output.length(), "");
		}
		
		return output.toString();
	}
	
	public void print() {
		
		System.out.println("[" + this + "]");
	}
}

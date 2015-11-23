import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BilingualCorpus extends HashSet<SentencePair>{
	
	private static final long serialVersionUID = 5350889547031290519L;

	public void print() {
		Iterator<SentencePair> iter = this.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public WordSet getWordSet1() {
		
		WordSet set = new WordSet();
		Iterator<SentencePair> iter = this.iterator();
		
		while (iter.hasNext()) {
			Sentence sentence = iter.next().getE();
			List<String> words = sentence.getWords();
			Iterator<String> iter2 = words.iterator();
			
			while (iter2.hasNext()) {	
				set.add(iter2.next());				
			}
		}
		return set;
	}
	
	public WordSet getWordSet2() {
		
		WordSet set = new WordSet();
		Iterator<SentencePair> iter = this.iterator();
		
		while (iter.hasNext()) {
			Sentence sentence = iter.next().getF();
			List<String> words = sentence.getWords();
			Iterator<String> iter2 = words.iterator();
			
			while (iter2.hasNext()) {	
				set.add(iter2.next());				
			}
		}
		return set;
	}
}

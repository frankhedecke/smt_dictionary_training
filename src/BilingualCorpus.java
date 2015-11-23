import java.util.HashSet;
import java.util.Iterator;

public class BilingualCorpus extends HashSet<SentencePair>{
	
	private static final long serialVersionUID = 5350889547031290519L;

	public void print() {
		Iterator<SentencePair> iter = this.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}

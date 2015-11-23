import java.util.HashSet;

public class BilingualCorpus extends HashSet<SentencePair>{
	
	private static final long serialVersionUID = 5350889547031290519L;
	
	public WordSet getWordSet1() {
		
		WordSet set = new WordSet();
		for (SentencePair senPair : this)
			for (String str : senPair.getE().getWords())
				set.add(str);
		
		return set;
	}
	
	public WordSet getWordSet2() {
		
		WordSet set = new WordSet();
		for (SentencePair senPair : this)
			for (String str : senPair.getF().getWords())
				set.add(str);
		
		return set;
	}
}

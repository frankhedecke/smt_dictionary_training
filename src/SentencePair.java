
public class SentencePair {
	private Sentence e;
	private Sentence f;
	
	public SentencePair(Sentence e, Sentence f) {
		
		this.e = e;
		this.f = f;
	}
	
	//TODO
	@Override
	public String toString() {
		return "[" + e + " - " + f + "]";
	}
}


public class SentencePair {
	private Sentence e;
	private Sentence f;
	
	public SentencePair(Sentence e, Sentence f) {
		
		this.e = e;
		this.f = f;
	}
	
	public Sentence getE() {
		return this.e;
	}
	
	public Sentence getF() {
		return this.f;
	}
	
	//TODO
	@Override
	public String toString() {
		return "[" + e + " - " + f + "]";
	}
}

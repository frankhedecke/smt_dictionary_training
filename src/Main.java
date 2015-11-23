
public class Main {

	public static void main(String[] args) {
		
		BilingualCorpus d = new BilingualCorpus();
		
		Sentence se1 = new Sentence("anok sub jifd");
		Sentence sf1 = new Sentence("rem blub pippat");
		Sentence se2 = new Sentence("anok");
		Sentence sf2 = new Sentence("pippat");
		Sentence se3 = new Sentence("anok sub blib");
		Sentence sf3 = new Sentence("pippat rem brum");
		
		SentencePair p1 = new SentencePair(se1, sf1);
		SentencePair p2 = new SentencePair(se2, sf2);
		SentencePair p3 = new SentencePair(se3, sf3);
		
		d.add(p1);
		d.add(p2);
		d.add(p3);
		
		System.out.println(d);

		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("vE = " + d.getWordSet1());
		System.out.println("vF = " + d.getWordSet2());
	}
}


public class Main {

	public static void main(String[] args) {
		
		BilingualCorpus d = new BilingualCorpus();
		
		Sentence se1 = new Sentence("anok sub jifd");
		Sentence sf1 = new Sentence("rem blub pippat");
		Sentence se2 = new Sentence("anok");
		Sentence sf2 = new Sentence("pippat");
		
		SentencePair p1 = new SentencePair(se1, sf1);
		SentencePair p2 = new SentencePair(se2, sf2);
		
		d.add(p1);
		d.add(p2);

		System.out.println(d);

		System.out.println(p1);
		System.out.println(p2);
		
		
	}
}


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
		
		// algorithm setup
		int u_MAX = d.getWordSet1().size();
		int v_MAX = d.getWordSet2().size();
		Float[][] counts = new Float[u_MAX][v_MAX];
		Float[][] t = new Float[u_MAX][v_MAX];
		boolean tConverged = false;
		for (int u = 0; u < u_MAX; u++) {
			for (int v = 0; v < v_MAX; v++) {
				t[u][v] = 0.5f;	// TODO check init
			}
		}
		
		// algorithm
		for (int times = 0; times < 3; times ++) { // TODO
			for (int u = 0; u < u_MAX; u++) {
				for (int v = 0; v < v_MAX; v++) {
					counts[u][v] = 0f;
				}
			}
			
			for (SentencePair ef : d) {
				for (int i = 0; i < ef.getE().getLength(); i++) {
					float s = 0;
					for (int j = 0; j < ef.getF().getLength(); j++) {
						s += t[i][j];
					}
					for (int j = 0; j < ef.getF().getLength(); j++) {
						counts[i][j] += t[i][j] / s;
					}
				}
			}

			for (int u = 0; u < u_MAX; u++) {
				for (int v = 0; v < v_MAX; v++) {
					float sumUV = 0f;
					for (int ub = 0; ub < u_MAX; ub++)
						sumUV += counts[ub][v];
					
					t[u][v] = counts[u][v] / sumUV;
				}
			}
			
			// TODO check for conversion of t
			tConverged = true;
		}
	}
}

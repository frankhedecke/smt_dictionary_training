import java.util.*;

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
		Map<String, Map<String, Float>> counts = new HashMap<String, Map<String, Float>>();
		Map<String, Map<String, Float>> t = new HashMap<String, Map<String, Float>>();
		
		// TODO
		boolean tConverged = false; 
		for (String u : d.getWordSet1()) {
			t.put(u, new HashMap<String, Float>());
			counts.put(u, new HashMap<String, Float>());
			for (String v : d.getWordSet2()) {
				t.get(u).put(v, 0.5f);
				counts.get(u).put(v, 0f);
			}
		}
		
		// algorithm
		for (int times = 0; times < 3; times ++) {
			for (String u : d.getWordSet1()) {
				for (String v : d.getWordSet2()) {
					counts.get(u).put(v, 0f);
				}
			}
			
			for (SentencePair ef : d) {
				BilingualCorpus temp = new BilingualCorpus();
				temp.add(ef);
				
				for (String i : temp.getWordSet1()) {
					float s = 0;
					for (String j : temp.getWordSet2()) { 
						s += t.get(i).get(j);
					}
					for (String j : temp.getWordSet2()) {
						float count_temp = counts.get(i).get(j) + t.get(i).get(j) / s;
						counts.get(i).put(j, count_temp);
					}
				}
			}

			for (String u : d.getWordSet1()) {
				for (String v : d.getWordSet2()) {
					float sumUV = 0f;
					for (String ub : d.getWordSet1())
						sumUV += counts.get(ub).get(v);
					float value = counts.get(u).get(v) / sumUV;
					// t.get(u).remove(v);
					t.get(u).put(v, value);
				}
			}
			
			// TODO check for conversion of t
			tConverged = true;
		}
		
		// print overview
		System.out.println();
		System.out.print("     ");
		for (String str : d.getWordSet1()) {
			System.out.print("       " + str);
		}
		System.out.println();
		
		for (String str : d.getWordSet2()) {
			System.out.print(str);
			for (int i = str.length(); i < 11; i++)
				System.out.print(" ");
			for (String j : d.getWordSet1()) {
				String value = t.get(j).get(str).toString();
				if (value.length() > 4)
					value = value.substring(0, 4);
				else
					value = value + " ";
				
				System.out.print(value + "       ");
			}
			System.out.println();
		}
	}
}
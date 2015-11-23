import java.util.HashSet;
import java.util.Iterator;


public class WordSet extends HashSet<String> {

	private static final long serialVersionUID = -9002503143641334840L;

	@Override
	public String toString() {
		
		Iterator<String> iter = this.iterator();
		
		StringBuilder output = new StringBuilder("");

		while (iter.hasNext()) {		
			output.append(iter.next() + ", ");
		}
		
		if ( output.length() > 5) {
			output.replace(output.length() - 2, output.length(), "");
		}
		
		return output.toString();
	}
}

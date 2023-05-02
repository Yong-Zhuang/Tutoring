
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{

	@Override
	public int compare(FSElement fe1, FSElement fe2) {
		return fe1.getName().toLowerCase().compareTo(fe2.getName().toLowerCase());
	}

}

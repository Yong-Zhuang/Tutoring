
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement>{

	@Override
	public int compare(FSElement fe1, FSElement fe2) {
		return fe2.getName().toLowerCase().compareTo(fe1.getName().toLowerCase());
	}

}

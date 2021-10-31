import java.nio.file.*;
import java.lang.Integer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

public class FileCacheLFU extends FileCache {
	public FileCacheLFU(int threshold, AccessCounter counter, ReentrantLock lock) {
		super(threshold, counter, lock);
	}

	@Override
	protected void replace(Path path) {
		List<Map.Entry<Path, Integer>> list = new ArrayList<Map.Entry<Path, Integer>>(map_counter.accessCounterTable.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Path, Integer>>() {
			public int compare(Map.Entry<Path, Integer> o1, Map.Entry<Path, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		map_content.remove(list.get(0));
		map_tstamp.remove(list.get(0));
		map_counter.accessCounterTable.remove(list.get(0));
	}	
}

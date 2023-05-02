import java.nio.file.*;
import java.lang.Integer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.*;

public class FileCacheLFU extends FileCache {
	public FileCacheLFU(int threshold, AccessCounter counter, ReentrantReadWriteLock lock) {
		super(threshold, counter, lock);
	}

	@Override
	protected void replace(String fileName) {
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map_counter.accessCounterTable.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		map_content.remove(list.get(0));
		map_tstamp.remove(list.get(0));
		map_counter.accessCounterTable.remove(list.get(0));
	}	
}

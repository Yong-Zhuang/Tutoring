import java.nio.file.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.Date;
import java.util.*;

public class FileCacheLRU extends FileCache {
	public FileCacheLRU(int threshold, AccessCounter counter, ReentrantReadWriteLock lock) {
		super(threshold, counter, lock);
	}

	@Override
	protected void replace(String fileName) {
		List<Map.Entry<String, Date>> list = new ArrayList<Map.Entry<String, Date>>(map_tstamp.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Date>>() {
			public int compare(Map.Entry<String, Date> o1, Map.Entry<String, Date> o2) {
				boolean flag = o2.getValue().before(o1.getValue());
				if (flag) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		map_content.remove(list.get(0));
		map_tstamp.remove(list.get(0));
		map_counter.accessCounterTable.remove(list.get(0));
	}
}

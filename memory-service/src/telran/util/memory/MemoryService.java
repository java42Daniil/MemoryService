package telran.util.memory;

// V. R. All is OK

public class MemoryService {
public static int getMaxAvailableMemory() {
	long maxMemory = Runtime.getRuntime().maxMemory();
	int right = maxMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) maxMemory;
	int left = 0;
	int middle = 0;
	int maxSizeMemory = 0;
	byte ar[] = null;

	while (left <= right) {
		/* V.R.
		 *  The other way to do the same is following
		 *  middle = (int) ((left + (long)right) / 2);
		 */
		middle = left/2 + right/2;
		try {
			ar = new byte[middle];
			maxSizeMemory = middle;
			left = middle + 1;
			ar = null;

		} catch (OutOfMemoryError e) {
			right = middle - 1;
		}
			}
	return maxSizeMemory;
}
}
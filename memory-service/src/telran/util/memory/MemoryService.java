package telran.util.memory;



public class MemoryService {
public static int getMaxAvailableMemory() {
	long maxMemory = Runtime.getRuntime().maxMemory();
	int right = maxMemory > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) maxMemory;
	int left = 0;
	int middle = 0;
	int maxSizeMemory = 0;
	byte ar[] = null;

	while (left <= right) {
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
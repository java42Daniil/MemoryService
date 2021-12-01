package telran.util.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemoryServiceTest {
byte ar[];
final long MG = 1024 * 1024;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
	int maxSize = MemoryService.getMaxAvailableMemory();
	ar = new byte[maxSize]; //normal allocation
	ar = null;
	boolean gotException = false;
	try {
		ar = new byte[maxSize + 1]; //exception	
		ar = null;
	} catch (Throwable e) {
		gotException = true;
	}
	assertTrue(gotException);		
	System.out.printf(" Max size=%dM", maxSize/MG);
	}
}
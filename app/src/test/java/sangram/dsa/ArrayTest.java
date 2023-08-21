package sangram.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayTest {
	Array<String> arr;

	@BeforeEach
	void init() {
		arr = new Array<String>(2);
		arr.set(0, "val1");
		arr.set(1, "val2");
	}

	@Test
	void emptyInitializationShouldBeZeroSize() {
		Array<String> tstArray = new Array<>(4);
		assertEquals(0, tstArray.size(), "array size initial should be zero");
	}

	@Test
	void newInitializationShouldBeValid() {
		assertEquals(2, arr.size(), "array size should be two");
		assertEquals("val1", arr.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> {
			arr.get(5);
		});
	}

	@Test
	void addNewElementShouldIncreaseArrayCapacityIfExceeding() {
		arr.add("new val");
		assertEquals(3, arr.size(), "array size should be three");
		assertEquals("new val", arr.get(2));
	}

	@Test
	void removeIdxShouldRemoveElementAtIndex() {
		arr.removeAt(1);
		assertEquals(1, arr.size(), "array size should be three");
		assertEquals("val2", arr.get(1));
		assertThrows(IllegalArgumentException.class, () -> {
			arr.removeAt(8);
		});
	}

	@Test
	void removeShouldRemoveSpecificObj(){
		assertFalse(arr.remove("not present value"));
		assertTrue(arr.remove("val1"));
		assertEquals(1, arr.size());
	}

	@Test
	void failingTest() {
		assertFalse(true);
	}
}

package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;

import static com.thealgorithms.datastructures.stacks.BalancedBrackets.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

public class BalancedBracketsTest {
	@AfterAll
	static void printResults() {
		System.out.println(BranchCoverage.getResults());
	}

	@BeforeEach
	void before(TestInfo testInfo) {
		BranchCoverage.startNewPath(testInfo.getDisplayName());
	}

	@Test
	void emptyString() {
		assertTrue(isBalanced(""));
	}

	@Test
	void singleBrackets() {
		assertTrue(isBalanced("()"));
		assertTrue(isBalanced("[]"));
		assertTrue(isBalanced("{}"));
	}

	@Test
	void missingOpeningBracket() {
		assertFalse(isBalanced("[])"));
	}

	@Test
	void missingClosingBracket() {
		assertFalse(isBalanced("([]"));
	}

	@Test
	void nullInput() {
		assertThrows(IllegalArgumentException.class,
				() -> isBalanced(null),
				"Expected to throw IllegalArgumentException for input null.");
	}

	@Test
	void nonBracketCharacter() {
		assertFalse(isBalanced("(a)"));
	}

	@Test
	void deeplyNested() {
		assertTrue(isBalanced("({[[]]})"));
	}

	@Test
	void subsequentBrackets() {
		assertTrue(isBalanced("()[]{}"));
	}
}

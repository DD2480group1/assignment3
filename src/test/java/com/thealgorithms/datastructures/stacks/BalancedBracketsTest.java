package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;

import static com.thealgorithms.datastructures.stacks.BalancedBrackets.isBalanced;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}

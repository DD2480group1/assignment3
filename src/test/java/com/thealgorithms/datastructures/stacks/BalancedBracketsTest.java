package com.thealgorithms.datastructures.stacks;

import org.junit.jupiter.api.*;

import static com.thealgorithms.datastructures.stacks.BalancedBrackets.isBalanced;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBracketsTest {
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

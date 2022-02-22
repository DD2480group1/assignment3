package com.thealgorithms.datastructures.stacks;

import java.util.HashMap;
import java.util.Map;

class BranchCoverage {
	private static Map<String, Integer> visitCount = new HashMap<>();

	static void visit(String id) {
		int count = visitCount.getOrDefault(id, 0) + 1;
		visitCount.put(id, count);
	}

	static int visitCount(String id) {
		return visitCount.getOrDefault(id, 0);
	}

	static String getResults() {
		return visitCount.toString();
	}
}

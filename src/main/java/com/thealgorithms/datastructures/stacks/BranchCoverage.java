package com.thealgorithms.datastructures.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BranchCoverage {
	private static Map<String, Integer> visitCount = new HashMap<>();
	private static List<List<String>> paths = new ArrayList<>(new ArrayList<>());

	static void incrementCount(String id) {
		int count = visitCount.getOrDefault(id, 0) + 1;
		visitCount.put(id, count);
	}

	static void appendPath(String id) {
		List<String> last = paths.get(paths.size()-1);
		last.add(id);
	}

	static void visit(String id) {
		incrementCount(id);
		appendPath(id);
	}

	static void startNewPath() {
		paths.add(new ArrayList<>());
	}

	static int visitCount(String id) {
		return visitCount.getOrDefault(id, 0);
	}

	static String getResults() {
		return visitCount.toString();
	}
}

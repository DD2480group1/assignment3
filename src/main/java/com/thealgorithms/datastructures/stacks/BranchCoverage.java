package com.thealgorithms.datastructures.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BranchCoverage {
	private static Map<String, Integer> visitCount = new HashMap<>();
	private static List<List<String>> paths = new ArrayList<>();

	static void incrementCount(String id) {
		int count = visitCount.getOrDefault(id, 0) + 1;
		visitCount.put(id, count);
	}

	static void appendPath(String id) {
		if (paths.isEmpty()) { paths.add(new ArrayList<>()); }
		List<String> last = paths.get(paths.size()-1);
		last.add(id);
	}

	static void visit(String id) {
		incrementCount(id);
		appendPath(id);
	}

	// Allows making branch coverage for boolean expressions such as (a && (b || c))
	// by writing (visitIf(a, "a") && (visitIf(b, "b") || visitIf(c, "c")))
	static boolean visitIf(boolean b, String id) {
		if (b) { visit(id); }
		return b;
	}

	static void startNewPath() {
		paths.add(new ArrayList<>());
	}

	static int visitCount(String id) {
		return visitCount.getOrDefault(id, 0);
	}

	static String getResults() {
		return "Visit counts:\n" +
				visitCount.toString() + "\n\n" +
				"Paths:\n" +
				paths.toString();
	}
}

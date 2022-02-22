package com.thealgorithms.datastructures.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class BranchCoverage {
	private static Map<Branch, Integer> visitCount = new HashMap<Branch, Integer>();
	private static List<Path> paths = new ArrayList<>();

	static void incrementCount(Branch id) {
		int count = visitCount.getOrDefault(id, 0) + 1;
		visitCount.put(id, count);
	}

	static void appendPath(Branch id) {
		Path last = paths.get(paths.size()-1);
		last.path.add(id);
	}

	static void visit(Branch id) {
		incrementCount(id);
		appendPath(id);
	}

	// Allows making branch coverage for boolean expressions such as (a && (b || c))
	// by writing (visitIf(a, "a") && (visitIf(b, "b") || visitIf(c, "c")))
	static boolean visitIf(boolean b, Branch id) {
		if (b) { visit(id); }
		return b;
	}

	static void startNewPath(String name) {
		paths.add(new Path(name));
	}

	static int visitCount(String id) {
		return visitCount.getOrDefault(id, 0);
	}

	static String getResults() {
		return visitCountString() + "\n\n" +
				pathsString();
	}

	private static String visitCountString() {
		return "Visit counts:\n" + visitCount;
	}

	private static String pathsString() {
		return "Paths: \n\t" +
				paths.stream().map(Record::toString).collect(Collectors.joining("\n\t"));
	}


	public enum Branch {
		L55, L57, L59, L60,	L61, L62, L63, L66,
		L67, L68, L69_1, L69_2, L71, L72, L73, L76;
	}

	public record Path(String name, List<Branch> path) {
		public Path(String name) {
			this(name, new ArrayList<>());
		}
	}
}

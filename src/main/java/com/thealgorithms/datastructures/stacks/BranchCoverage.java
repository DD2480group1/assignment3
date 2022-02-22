package com.thealgorithms.datastructures.stacks;

import java.util.*;
import java.util.stream.Collectors;

class BranchCoverage {
	private static SortedMap<Branch, Integer> visitCount = new TreeMap<>();
	private static List<Path> paths = new ArrayList<>();

	static void incrementCount(Branch id) {
		int count = visitCount.getOrDefault(id, 0) + 1;
		visitCount.put(id, count);
	}

	static void appendPath(Branch id) {
		if (paths.isEmpty()) { paths.add(new Path("")); }
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

	static int visitCount(Branch id) {
		return visitCount.getOrDefault(id, 0);
	}

	static String getResults() {
		return visitCountString() + "\n\n" +
				pathsString() + "\n\n" +
				visitedByString();
	}

	private static String visitCountString() {
		// Ensure that every branch is shown even if it has not been visited.
		for (Branch b: Branch.values()) {
			if (!visitCount.containsKey(b)) {
				visitCount.put(b, 0);
			}
		}
		return "Visit counts:\n" + visitCount;
	}

	private static String pathsString() {
		return "Paths: \n\t" +
				paths.stream().map(Record::toString).collect(Collectors.joining("\n\t"));
	}

	public static Map<String, Integer> visitedBy(Branch b) {
		SortedMap<String, Integer> visits = new TreeMap<>();
		paths.forEach(path -> {
			path.path.forEach(step -> {
				if (step.equals(b)) {
					int count = visits.getOrDefault(path.name, 0) + 1;
					visits.put(path.name, count);
				}
			});
		});

		return visits;
	}

	public static String visitedByString() {
		StringBuilder s = new StringBuilder("Visits for each branch:");
		for (Branch b : Branch.values()) {
			s.append("\n\t" + b +
					"\t\t count: " + visitCount(b) +
					",\t\tvisits: " + visitedBy(b));
		}

		return s.toString();
	}


	public enum Branch {
		L55, L57, L59, L60,	L61, L62, L63, L66,
		L67, L68, L69_1, L69_2, L71, L73, L77;
	}

	public record Path(String name, List<Branch> path) {
		public Path(String name) {
			this(name, new ArrayList<>());
		}
	}
}

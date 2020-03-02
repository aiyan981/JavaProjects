import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Created a recursive method arithmeticArrayHelper.
		 */
		
		if(n == 0)
		{
			int[] arr = new int[0];
			return arr;
		}
		else if(n == 1)
		{
			int[] arr = new int[start];
			return arr;
		}
		else
		{
			int[] arr = new int[n];
			arr[0] = start;
			arithmeticArrayHelper(1, diff, arr);
			return arr;
		}
		
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		
		if(i < seq.length)
		{
			seq[i] = seq[i-1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Created a recursive method arithmeticArrayHelper.
		 */
		if(n == 0)
		{
			List<Integer> list = new ArrayList();
			return list;
		}
		else if (n == 1)
		{
			List<Integer> list = new ArrayList();
			list.add(start);
			return list;
		}
		else
		{
			List<Integer> list = new ArrayList();
			list.add(start);
			arithmeticListHelper(1, diff, list, n);
			return list;
		}
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
		if(i < n)
		{
			seq.add(seq.get(i-1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Created a recursive method helper
		 */
		if(a.length <= 2)
		{
			return true;
		}
		else
		{
			return isArithmeticArrayHelper(2, a[1]- a[0], a);
		}
		

	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		if(i <  a.length)
		{
			return (a[i] - a[i-1] == diff) && isArithmeticArrayHelper(i + 1, diff, a);
		}
		else
		{
			return true;
		}
	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Created a recursive method helper
		 */
		if(l.size() <= 2)
		{
			return true;
		}
		else
		{
			return isArithmeticListHelper(2, l.get(1) - l.get(0), l);
		}
		
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * 
		 */
		if(i < l.size())
		{
			return (l.get(i) - l.get(i-1) == diff) && isArithmeticListHelper(i +1, diff, l);
		}
		else
		{
			return true;
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Created a recursive method helper
		 */
		int[] arr = new int[a.length + 1];
		insert(arr, a, i, 0, false);
		return arr;
	}

	public static void insert(int[] arr, int[] a, int i, int index, boolean found) {

		if (index == arr.length - 1) {
			if (found) {
				return;
			} else {
				arr[index] = i;
				return;
			}
		}
		int newValue = index;
		if (i <= a[index] && !found) {
			arr[index] = i;
			found = true;
		} else {
			if (found) {
				arr[index + 1] = a[index];
			} else {
				arr[index] = a[index];
			}
			newValue++;
		}
		insert(arr, a, i, newValue, found);
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Created a recursive method helper
		 */
		List<Integer> newList = new ArrayList<Integer>();
		insert(newList, list, i, 0, false);
		return newList;
	}

	public static void insert(List<Integer> newList, List<Integer> list, int i, int index, boolean found) {
		if (index == list.size()) {
			if (found) {
				return;
			} else {
				newList.add(index, i);
				return;
			}
		}
		int newValue = index;
		if (i <= list.get(index) && !found) {
			newList.add(index, i);
			found = true;
		} else {
			if (found) {
				newList.add(index + 1, list.get(index));
			} else {
				newList.add(index, list.get(index));
			}
			newValue++;
		}
		insert(newList, list, i, newValue, found);
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Created a recursive method helper.
		 */
		int[] mergedArr = new int[left.length + right.length];
		if (left.length == 0 && right.length == 0) {
			return mergedArr;
		}
		Arrays.sort(left);
		Arrays.sort(right);
		mergeSortedArraysHelper(left, right, 0, 0, mergedArr, 0);
		return mergedArr;

	}

	void mergeSortedArraysHelper(int[] left, int[] right, int lef, int rig, int[] mergedArr, int i) {
		if (lef >= left.length && rig >= right.length) {
			return;
		} else {
			if (lef >= left.length) {
				mergedArr[i] = right[rig];
				rig++;
			} else if (rig >= right.length) {
				mergedArr[i] = left[lef];
				lef++;
			} else {
				if (left[lef] < right[rig]) {
					mergedArr[i] = left[lef];
					lef++;
				} else {
					mergedArr[i] = right[rig];
					rig++;
				}
			}
			i++;
			mergeSortedArraysHelper(left, right, lef, rig, mergedArr, i);
		}
	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Created a recursive method helper.
		 */

		List<Integer> merged = new ArrayList<Integer>();
		if (left.size() == 0 && right.size() == 0) {
			return merged;
		}

		Collections.sort(right);
		Collections.sort(left);

		mergeSortedListsHelper(left, right, 0, 0, merged);
		return merged;
	}

	void mergeSortedListsHelper(List<Integer> left, List<Integer> right, int lef, int rig, List<Integer> merge) {
		if (lef >= left.size() && rig >= right.size()) {
			return;
		} else {
			if (lef >= left.size()) {
				merge.add(right.get(rig));
				rig++;
			} else if (rig >= right.size()) {
				merge.add(left.get(lef));
				lef++;
			} else {
				if (left.get(lef) < right.get(rig)) {
					merge.add(left.get(lef));
					lef++;
				} else {
					merge.add(right.get(rig));
					rig++;
				}
			}
			mergeSortedListsHelper(left, right, lef, rig, merge);
		}
	}

}

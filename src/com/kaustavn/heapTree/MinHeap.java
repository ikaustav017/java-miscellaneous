package com.kaustavn.heapTree;

import java.util.Arrays;

public class MinHeap {

	private int capacity;
	private int size = 0;
	int[] items = new int[capacity];

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;

	}

	private boolean hasParent(int index) {
		return getParentIndex(index) > 0;
	}

	private int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int getRightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int getParent(int index) {
		return items[getParentIndex(index)];

	}

	private void swap(int indexOne, int indexTwo) {

		int swap = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = swap;
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	// returns the first element in the array (root of the heap)
	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	// remove the root element and adjust
	public int poll() {
		if (size == 0)
			throw new IllegalStateException();

		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;

	}

	// add an elemment
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();

	}

	private void heapifyDown() {
		int index = 0;

		// no left child means certainly no right child
		while (hasLeftChild(index)) {

			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if (items[index] < items[smallerChildIndex])
				return;

			else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}

	}

	public void heapifyUp() {

		int index = size - 1;

		while (hasParent(index) && getParent(getParentIndex(index)) > items[index]) {
			// things are out of order
			swap(items[index], items[getParentIndex(index)]);
			index = getParentIndex(index);
		}

	}

}

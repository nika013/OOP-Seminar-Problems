package org.example;

import java.util.Arrays;

import static java.util.Collections.binarySearch;

public class SortedFilter implements Filter{
    public Integer[] positions;
    private int logLength;
    public SortedFilter() {
        positions = new Integer[4];
        logLength = 0;
    }
    @Override
    public int size() {
        return logLength;
    }

    @Override
    public boolean isPresent(int index) {
        int currentIndex = binarySearch(0, logLength, index);
        return currentIndex != -1;
    }

    @Override
    public void add(int index) {
        int insertIdx = 0;
        grow();

        if (logLength > 0 && index > positions[logLength-1]) {
            positions[logLength] = index;
            logLength++;
            return;
        }

        for (int i = 0; i < logLength; i++) {
            if (index == positions[i]) {
                return;
            }
            insertIdx = i;
            if (index < positions[i]) {
                break;
            }
        }

        shiftByOne(insertIdx, 1, 0);
        positions[insertIdx] = index;
        logLength++;
        Arrays.toString(positions);
    }

    @Override
    public void remove(int index) {
        Integer currentIndex = -1;
        currentIndex = binarySearch(0, logLength, index);
        if (currentIndex != -1) {
            shiftByOne(currentIndex, 0, 1);
        }
        logLength--;
    }

    private void shiftByOne(int idx, int x, int y) {
        for (int i = idx; i < logLength; i++) {
            positions[i+x] = positions[i+y];
        }
    }

    private void grow() {
        if (logLength == positions.length) {
            Integer[] newArr = new Integer[logLength];
            for (int i = 0; i < logLength; i++) {
                newArr[i] = positions[i];
            }
            positions = newArr;
            logLength *= 2;
        }
    }

    private int binarySearch(int start, int end, int elem) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (positions[mid] == elem) {
            return mid;
        } else if (positions[mid] > elem) {
            return binarySearch(start, mid-1, elem);
        } else {
            return binarySearch(start + 1, end, elem);
        }
    }
}

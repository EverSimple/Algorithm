package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class State {
    private int[] values;
    private int hashCode = 0;
    private int zeroIndex = 0;
    public State(int[] values) { // use an int array to represent board state
        hashCode = 0;
        this.values = values;
        for (int i = 0; i < 8; i++) { // if a = {1,2,4,5,0,3,7,6}
            hashCode = 10 * hashCode + values[i]; // hashCode = 12450376
            if (values[i] == 0) { // get the index of 0
                zeroIndex = i;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; } // same object
        if (o.getClass() != this.getClass()) { return false; } // not same class
        State s = (State) o;
        return this.hashCode == s.hashCode;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    public static List<State> generateNewStates(State s) {
        List<State> newStates = new ArrayList<>();
        //int[][] DIRS = {{1, 0}, {-1, 0},  {0,-1}, {0, 1}}; //上下左右移动坐标
        int[] DX = new int[] {1, -1, 0, 0};
        int[] DY = new int[] {0, 0, -1, 1};
        int x = s.zeroIndex / 4; // get 0's coordinate (x,y)
        int y = s.zeroIndex % 4;
        for (int i = 0; i < 4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];
                if (nx >= 0 && nx < 2 && ny >= 0 && ny < 4) { // (nx, ny) is within bound
                    int[] newValues = s.values.clone();
                    swap(newValues, s.zeroIndex, nx * 4 + ny);
                    newStates.add(new State(newValues));
                }
        }
        return newStates;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

public class SevenBoard {
    public int numOfSteps(int[] values) {
        State start = new State(values);
        State end = new State(new int[] {0, 1, 2, 3, 4, 5, 6, 7});
        int step = 0; // record num of steps so far
        Set<State> set = new HashSet<>(); // record all set been generated
        set.add(start); // add starting state to set
        List<State> curList = new ArrayList<>(); // get all states to be visited
        curList.add(start); // add starting state to list
        while (!curList.isEmpty()) {
            List<State> next = new ArrayList<>(); // next set of list to visit
            for (State s : curList) {
                if (s.equals(end)) { // compare to end state
                    return step;
                }
                for (State newState : State.generateNewStates(s)) {
                    if (set.add(newState)) { // if set doesn't contains newState
                        next.add(newState);
                    }
                }
            }
            curList = next;
            step += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        SevenBoard test = new SevenBoard();
        int[] v1 = new int[] {2, 0, 1, 5, 7, 8, 3, 4};
        int[] v2 = new int[] {1, 0, 2, 3, 4, 5, 6, 7};
        System.out.println(test.numOfSteps(v1));
    }
}

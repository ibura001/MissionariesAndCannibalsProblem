package missionaries.cannibals.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DFS {

    int nodeN;
    State[] stateArray;
    State initialState;

    public DFS(State initialState) {
        this.initialState = initialState;
        stateArray = new State[1000005];
        nodeN = 0;
    }

    public State getFinalState() {

        if (initialState.isItTheGoalState()) {
            return initialState;
        }

        nodeN = 0;

        Stack<State> stack = new Stack<>();

        HashMap<State, Integer> map = new HashMap<>();

        map.put(initialState, nodeN);

        initialState.setParentState(-1);

        stateArray[nodeN] = initialState;

        stack.push(initialState);

        while (!stack.isEmpty()) {

            State u = stack.pop();
            int indexU = map.get(u);

            List<State> successors = u.getSuccessors();

            for (State v : successors) {

                if (!map.containsKey(v)) {
                    nodeN++;
                    v.setParentState(indexU);
                    stateArray[nodeN] = v;

                    if (v.isItTheGoalState()) {
                        return v;
                    }

                    map.put(v, nodeN);
                    stack.push(v);
                }
            }
        }

        return null;
    }

    public void printPath() {
        int t = 0;
        State s = getFinalState();
        System.out.println("Number of generated nodes: " + nodeN);
        if (s == null) {
            System.out.println("No solution found.");
            return;
        }

        String[] str = new String[100005];

        while (!s.equals(initialState)) {
            str[t] = s.toString();
            t++;
            s = stateArray[s.getParentState()];
        }
        str[t] = s.toString();

        System.out.println("DFS takes " + t + " steps.\n");

        for (int i = t; i >= 0; i--) {
            System.out.print(str[i]);
            if (i != 0) {
                System.out.print(" --> \n");
            }
        }
    }
}

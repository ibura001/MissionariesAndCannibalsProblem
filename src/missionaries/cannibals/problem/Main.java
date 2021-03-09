package missionaries.cannibals.problem;

public class Main {

    public static void main(String[] args) {

        System.out.println("In the missionaries and cannibals problem, 3 missionaries and 3 cannibals must cross a river using a boat which can carry at most 2 people.");

        System.out.println("Finding a solution using DFS algorithm.\n");

        State initialState = new State(Constants.initialMissionaryOnLeft, Constants.initialCannibalOnLeft, 0, 0, Constants.boatCapacity, Constants.LEFT);
        initialState.setParentState(-1);

        DFS dfs = new DFS(initialState);
        dfs.printPath();

    }
}

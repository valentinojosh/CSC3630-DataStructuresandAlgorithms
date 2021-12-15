public class NodeMT {
    public String team;
    public int wins;
    public int loss;
    public NodeMT next = null;

    NodeMT(String team, int wins, int loss) {
        this.team = team;
        this.wins = wins;
        this.loss = loss;
    }

}

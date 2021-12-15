public class BaseballObject {
    private int StartingOrder;
    private String Player;
    private double BatAvg;

    public BaseballObject(int order, String player, double batAvg) {
        StartingOrder = order;
        Player = player;
        BatAvg = batAvg;
    }

    public int getStartingOrder() {
        return StartingOrder;
    }

    public String getPlayer() {
        return Player;
    }

    public double getBatAvg() {
        return BatAvg;
    }

    public void setStartingOrder(int startingOrder) {
        StartingOrder = startingOrder;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public void setBatAvg(double batAvg) {
        BatAvg = batAvg;
    }

}

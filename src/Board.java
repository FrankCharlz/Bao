/**
 * Created by Frank on 10-Feb-17.
 */
public class Board {

    private Pool top, bottom;

    public Board() {
        top = new Pool(1, this);
        bottom = new Pool(0, this);
    }

    public void show() {
        System.out.print("\n\nTOP --"+top.countTotal()+"--");
        System.out.print("\n--------------------------------------------------------------\n");
        top.showOff();
        bottom.showOff();
        System.out.print("BOTTOM --"+bottom.countTotal()+"--\n");

    }

    public int kula(int side, int position) {
        int opposite = Pool.PITS_COUNT/2 - position - 1; //other side position
        if (side == top.getSideId()) return bottom.nikule(opposite);
        else return top.nikule(opposite);


    }

    public void play(int side, int pos) {
        if (side == bottom.getSideId()) bottom.zungusha(pos);
        else top.zungusha(pos);
    }

    public Pool getBottom() {
        return bottom;
    }

    public Pool getSide(int side) {
        return side == 0 ? bottom : top;
    }
}

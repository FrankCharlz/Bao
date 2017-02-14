/**
 * Created by Frank on 10-Feb-17.
 */
public class Board {


    public static final int BOTTOM_SIDE = 0x0;
    public static final int TOP_SIDE = 0x0001;
    private Pool top, bottom;

    public Board() {
        top = new Pool(1, this);
        bottom = new Pool(0, this);

        bottom.clear();
        top.clear();

        bottom.put(0, 2);
        bottom.put(2, 1);
        top.put(5, 1);
        top.put(10, 1);

        show();

        bottom.zungusha(0);


    }

    public void show() {
        System.out.print("TOP --"+top.countTotal()+"--");
        System.out.print("\n--------------------------------------------------------------\n");
        top.showOff();
        bottom.showOff();
        System.out.print("BOTTOM --"+bottom.countTotal()+"--");

    }

    public int kula(int side, int position) {
        int opposite = Pool.PITS_COUNT/2 - position - 1; //other side position
        if (side == top.getSide()) return bottom.nikule(opposite);
        else return top.nikule(opposite);


    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Frank on 10-Feb-17.
 */
public class Board {

    private Pool top, bottom;
    private Queue<Integer> queue = new LinkedList<Integer>();

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


    public Pool getSide(int side) {
        return side == 0 ? bottom : top;
    }

    public void save() {
        for (int n : getSide(0).getPits()) {
            queue.add(n);
        }
        for (int n : getSide(1).getPits()) {
            queue.add(n);
        }
    }

    public void restore() {
        getSide(0).addFromQueeu(queue);
        getSide(1).addFromQueeu(queue);

    }
}

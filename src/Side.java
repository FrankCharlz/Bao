/**
 * Created by Frank on 10-Feb-17.
 */
public class Side {

    int sideId;
    int[] sequence;

    public Side(int sideId) {
        this.sideId = sideId;
        if (sideId == Board.TOP_SIDE)
            sequence = new int[] {7,6,5,4,0,1,2,3};
        else
            sequence = new int[] {8,9,10,11,15,14,13,12};

    }



    public int[] getSequence() {
        return this.sequence;
    }
}

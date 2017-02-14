/**
 * Created by Frank on 10-Feb-17.
 */
public class Board {


    public static final int BOTTOM_SIDE = 0x0;
    public static final int TOP_SIDE = 0x0001;
    private Side top, bottom;
    Pit[] pits = new Pit[16];

    public Board() {
        top = new Side(TOP_SIDE);
        bottom = new Side(BOTTOM_SIDE);

        for (int i = 0; i < 16; i++) {
            pits[i] = new Pit(i/4, i%4, (i/8 == 0) ? TOP_SIDE : BOTTOM_SIDE);
        }



    }

    public void show() {
        System.out.println("\t\t\t\t\tTOP");
        for (int i = 0; i < pits.length; i++) {
            pits[i].show();
            System.out.print("\t");
            if ((i+1)%4 == 0) System.out.print("\n");
            if (i == 7) System.out.print("----------------------------------------------------------------\n");
        }
        System.out.println("\t\t\t\t\tBOTTOM\n\n\n");




    }


    private int getStartIndex(int pos, int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == pos) return i;
        }
        return -1;
    }

    public void start(int row, int col) {
        int sequence[] = (row > 1) ? bottom.getSequence() : top.getSequence(); //if row 0 or 1 top side else buttom side
        int pos = row * 4 + col;
        int start_index = getStartIndex(pos, sequence);
        System.out.println("pos = "+pos+" seq_index = "+start_index);


    }
}

/**
 * Created by Frank on 14-Feb-17.
 */
public class Pool {

    public static final int PITS_COUNT = 0b10000;
    private static final int TYPE_TOP = 0x000feed;
    private static final int TYPE_BOTTOM = 0xceed;
    private final int sideId;
    private Board board;
    int pits[] = new int[PITS_COUNT];


    public Pool(int side, Board board) {
        this.sideId = (side == 1) ? TYPE_TOP : TYPE_BOTTOM;
        this.board = board;
        init();
    }

    private void init() {
        for (int i = 0; i < PITS_COUNT; i++) {
            pits[i] = 1;
        }
    }


    public void zungusha(int position) {
        // okota kete
        int kete_number = pits[position];
        pits[position] = 0;

        while (kete_number > 0) {
            position = (position + 1) % PITS_COUNT; // go to next position
            pits[position]++; // drop one kete
            kete_number--;
        }


        //kama 1 kafa
        if (pits[position] > 1) {
            System.out.println("Dondoka at : "+position);
            // if in first row then kula
            if (position < PITS_COUNT/2) {
                pits[position] += getBoard().kula(sideId, position);
            }
            zungusha(position);
        } else {
            System.out.println("Kafa at : "+position);
        }

    }



    public void showOff() {
        if (sideId == TYPE_TOP) {showOffTop(); return;}
        for (int i = 0; i < PITS_COUNT/2; i++) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
        System.out.print("\n");
        for (int i = PITS_COUNT - 1; i >= PITS_COUNT/2; i--) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
        System.out.print("\n--------------------------------------------------------------\n");
    }

    private void showOffTop() {
        for (int i = PITS_COUNT/2; i < PITS_COUNT; i++) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
        System.out.print("\n");
        for (int i = PITS_COUNT/2 - 1; i >= 0; i--) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
        System.out.print("\n--------------------------------------------------------------\n");
    }

    public int countFront() {
        // first half of the pits will be considered front row, gui itajua tuu
        int sum = 0;
        for (int i = 0; i < PITS_COUNT/2; i++) {
            sum += pits[i];
        }
        return sum;
    }

    public int countTotal() {
        int sum = 0;
        for (int i = 0; i < PITS_COUNT; i++) {
            sum += pits[i];
        }
        return sum;
    }

    public void refill(int kete_number) {
        for (int i = 0; i < PITS_COUNT; i++) {
            pits[i] = kete_number;
        }
    }

    public void clear() {
        for (int i = 0; i < PITS_COUNT; i++) {
            pits[i] = 0;
        }
    }

    public void put(int pos, int kete_number) {
       pits[pos] = kete_number;
    }

    public Board getBoard() {
        return board;
    }

    public int getSide() {
        return sideId;
    }

    public int nikule(int position) {
        //sets kete count to zero for a given pit/back row pit
        //gives the kete to Board which gives them to the other side
        if (countFront() == 0) {
            position = PITS_COUNT - position - 1;
        }

        System.out.print("Naliwa at "+position+"\n");
        int k = pits[position];
        pits[position] = 0;
        return k;
    }
}

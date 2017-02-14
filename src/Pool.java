/**
 * Created by Frank on 14-Feb-17.
 */
public class Pool {

    private static final int PITS_COUNT = 8;
    int pits[] = new int[PITS_COUNT];


    public Pool() {
        for (int i = 0; i < PITS_COUNT; i++) {
            pits[i] = 4;
        }
    }


    public void zungusha(int position) {
        // okota kete
        int kete_number = pits[position];
        pits[position] = 0;

        while (kete_number > 0) {
            position = (position + 1) % PITS_COUNT; // go to next position
            pits[position] = pits[position] + 1; // drop one kete
            kete_number--;
        }
    }

    public void showOff() {
        for (int i = 0; i < PITS_COUNT/2; i++) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
        System.out.print("\n");
        for (int i = PITS_COUNT - 1; i >= PITS_COUNT/2; i--) {
            System.out.print("p"+i+"_"+pits[i]);
            System.out.print("\t");
        }
    }
}

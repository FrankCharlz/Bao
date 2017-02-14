/**
 * Created by Frank on 10-Feb-17.
 */
public class Pit {

    private final int sideId;
    private int row, column, id;
    private int keteCount;


    public Pit(int row, int col, int sideId) {
        this.row = row;
        this.column = col;
        this.sideId = sideId;
        this.keteCount = 4;
    }


    public int getRow() {
        return row;
    }

    public int getId() {
        return id;
    }

    public int getColumn() {
        return column;
    }

    public int getKeteCount() {
        return keteCount;
    }

    public boolean isEmpty() {
        return (keteCount == 0);
    }

    public void dropKete(int n) {
        keteCount+=4;
    }

    public void show() {
        //char side = (sideId == Board.BOTTOM_SIDE) ? 'B' : 'T';
        //System.out.print(side+"_r"+row+"_c"+column+"_k"+keteCount+"_id"+id);
    }
}

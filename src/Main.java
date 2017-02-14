import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Frank on 10-Feb-17.
 */
public class Main {


    public static void main(String args[]) {

        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        while (
                (board.getSide(0).countTotal() != 0 )&&
                        (board.getSide(1).countTotal() != 0)) {

            //user play
            System.out.print("Please select start pos: ");
            int pos = scanner.nextInt();
            board.getSide(0).zungusha(pos);
            board.show();

            //system play
            ArrayList<Integer> fpits = board.getSide(1).getFullPits();
            board.getSide(1).zungusha(fpits.get(0));
            board.show();

        }


    }

}

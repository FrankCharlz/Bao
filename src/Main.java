import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Frank on 10-Feb-17.
 *
 */
public class Main {


    public static void main(String args[]) {

        play();

        //test();




    }

    private static void test() {
        Board board = new Board();
        board.getSide(1).randomize();
        board.show();

        int op = board.getSide(1).solve();
        System.out.println("Optimum : "+op);
        board.show();

    }

    private static void play() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (
                (board.getSide(0).countTotal() != 0 )&&
                        (board.getSide(1).countTotal() != 0)) {

            count++;

            //user play
            System.out.print("Please select start pos: ");
            int pos = scanner.nextInt();
            board.getSide(0).zungusha(pos);
            board.show();


            //system play
            int opt = board.getSide(1).solve();
            System.out.print("\nPC turn ");
            scanner.next();

            board.getSide(1).zungusha(opt);
            board.show();

        }

        System.out.print("Games : "+count);
    }

}

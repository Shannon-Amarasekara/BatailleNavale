
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BoatPlacementService {

    private Scanner scanner = new Scanner(System.in);
    private BoardDisplayService boardDisplayService = new BoardDisplayService();
    private UserInputValidationService userInputValidationService = new UserInputValidationService();

    public int placeOneToThreeBoats(Board board) {
        ArrayList<String> listOfBoatsPlaced = new ArrayList<>();
        placeBoat(board, listOfBoatsPlaced);
        System.out.println("You have placed " + listOfBoatsPlaced.size() + " boat in the following positions: " + listOfBoatsPlaced);

        while (listOfBoatsPlaced.size() < 3) {
            System.out.println("Would you like to place another boat? (yes/no)");
            String answer = scanner.next();

            while ((!answer.equals("yes")) && (!answer.equals("no"))) {
                System.out.println("Answer not recognised.");
                System.out.println("Would you like to place another boat? (yes/no)");
                answer = scanner.next();
            }

            if (answer.equals("yes")) {
                placeBoat(board, listOfBoatsPlaced);
                Collections.sort(listOfBoatsPlaced);
                System.out.println("You have placed " + listOfBoatsPlaced.size() + " boats in the following positions: " + listOfBoatsPlaced);
            } else {
                break;
            }
        }
        boardDisplayService.displayBoard(board);
        System.out.println("Here is your board");
        return listOfBoatsPlaced.size();
    }

    private void placeBoat(Board board, ArrayList<String> listOfBoatsPlaced) {
        Scanner scanner = new Scanner(System.in);
        List<String> columnsAToJ = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        int column = playerChoosesColumnToPlaceBoat(board, columnsAToJ, scanner);
        int row = playerChoosesRowToPlaceBoat(board, scanner);
        String position = columnsAToJ.get(column) + row;

        if (!listOfBoatsPlaced.contains(position)) {
            board.placeABoatOnTheBoard(column, row);
            listOfBoatsPlaced.add(position);
        } else {
            System.out.println("You already placed a boat in this position.");
        }
    }

    public int playerChoosesColumnToPlaceBoat(Board board, List<String> columnsAtoJ, Scanner scanner) {
        int column = -1;
        while (column == -1) {
            System.out.println("Choose which column you want to place your boat. (A - J)");
            column = userInputValidationService.validatePlayerColumnInput(scanner, board, columnsAtoJ);
        }
        return column;
    }

    public int playerChoosesRowToPlaceBoat(Board board, Scanner scanner) {
        int row = -1;
        while (row == -1) {
            System.out.println("Choose which row you want to place your boat. (1-10)");
            row = userInputValidationService.validatePlayerRowInput(scanner, board);
        }
        return row;
    }

}

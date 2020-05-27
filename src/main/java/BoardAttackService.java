import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class BoardAttackService {

    private PlayerAttackService playerAttackService = new PlayerAttackService();
    private EnemyAttackService enemyAttackService = new EnemyAttackService();

    public void playerAndEnemyAttackEachOther(Board playerBoard, Board enemyBoard) {
        ArrayList<Integer> positionsAlreadyAttackedByEnemy = createListOfBoardPositions();
        List<String> positionsAlreadyAttackedByPlayer = new CopyOnWriteArrayList<>();

        while (true) {
            playerAttackService.attackTheEnemyBoard(enemyBoard, positionsAlreadyAttackedByPlayer);
            if (enemyBoard.boardContainsNoBoats()) {
                playerWins();
            }

            enemyAttackService.enemyAttacksThePlayerBoard(playerBoard, positionsAlreadyAttackedByEnemy);
            if (playerBoard.boardContainsNoBoats()) {
                playerLoses();
            }
        }
    }

    public ArrayList<Integer> createListOfBoardPositions() {
        ArrayList<Integer> listOf99Positions = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOf99Positions.add(i);
        }
        return listOf99Positions;
    }


    public void playerWins() {
        System.out.println("YOU WIN !");
        System.exit(0);
    }

    public void playerLoses() {
        System.out.println("YOU LOSE");
        System.exit(0);
    }
}

package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void boardCreation1() {
        //Board board = new Board().withTitle("QA35");
        Board board = Board.builder().title("QA35").build();
        logger.info("Test board creation 1"+ board.getTitle());

        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();


      int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created---");

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }
}

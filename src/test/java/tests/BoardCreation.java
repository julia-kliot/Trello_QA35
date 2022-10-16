package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void boardCreation1() {
        //Board board = new Board().withTitle("QA35");
        Board board = Board.builder().title("QA35").build();
        logger.info("Test board creation 1" + board.getTitle());

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

    @Test
    public void boardCreation2() {
        Board board = Board.builder().title("testQa34").build();
        logger.info("Test board creation 1" + board.getTitle());
        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        ;
        app.getBoard().scrolldownTheForm();
        ;
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created---");

        Assert.assertTrue(app.getBoard().isCreated());
    }

    @Test
    public void boardcreation3() {
        Board board = Board.builder().title("testQa34").build();
        logger.info("Test board creation 3" + board.getTitle());
        app.getBoard().statrBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created---");

        Assert.assertTrue(app.getBoard().isCreated());
    }
    @Test
    public void boardCreationWithBackGround() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        Board board = Board.builder().title("testQa34").build();
        app.getBoard().initBoardCreation();
        app.getBoard().chooseBackground();
        app.getBoard().pause(2000);
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }


    @Test
    public void refuseBoardCreation1() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().statrBoardCreation();
        app.getBoard().closecreationWindow();
        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);
    }


    @Test
    public void refuseboardCreation2() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().createBoard();
        app.getBoard().closecreationWindow2();

        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);

    }

    @Test
    public void refuseboardCreation3() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreation();
        app.getBoard().retutnToCreationPage();
        app.getBoard().closecreationWindow2();

        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);


    }
}

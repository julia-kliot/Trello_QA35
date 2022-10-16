package tests;

import model.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase {

    @Test
    public void cardCreation() {
        Card card = Card.builder().cardName("test1").color("green").build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("test11");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCardCreation();
    }
}

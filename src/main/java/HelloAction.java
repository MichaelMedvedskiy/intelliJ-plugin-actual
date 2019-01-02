import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.julienvey.trello.NotAuthorizedException;
import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

import java.util.List;

public class HelloAction extends AnAction {
    public HelloAction() {
        super("Hello!!!");
        kostil = new TrelloProjectKostil();
    }
    TrelloProjectKostil kostil;

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        //Messages.showMessageDialog(project, "Hello world!!!", "Greeting!!!", Messages.getInformationIcon());
//        String listId =  Messages.showInputDialog(project,"Please input the listId",
//                "You can get it via trello adding .json to the Card link",Messages.getInformationIcon());
//        //System.out.println("The inputted listId: "+listId);
//        String newCardMessage = Messages.showInputDialog(project,"What do you want to write to that list?",
//                "This message will be the card name",Messages.getInformationIcon());
//
//

        String listId  = kostil.getListId();
        String trelloKey = kostil.getTrelloKey();
        String trelloToken = kostil.getTrelloAccessToken();
        if(listId.length()<5 || trelloKey.length()<5 || trelloToken.length()<5) {
            Messages.showMessageDialog(project, "You didn't initialize properly",
                    "Do it now, so you could post some Cards!", Messages.getInformationIcon());
            return;
        }

    try{
            System.out.println("The data to login: "+trelloKey+ " "+ trelloToken + " "+ listId);
            Trello trello = new TrelloImpl(trelloKey, trelloToken,new ApacheHttpClient());
            System.out.println("LOGGED SUCCESFULLY");
            //A check for login info
            List<Card> cards = trello.getListCards(listId);


            Card cardToAdd = new Card();
            cardToAdd.setName(Messages.showInputDialog(project,"What do you want to write to that list?",
               "This message will be the card name",Messages.getInformationIcon()));
            //Card card = cards.get(0);
            trello.createCard(listId,cardToAdd);
            Messages.showMessageDialog(project, "Added successfully",
                    "You can add another one right from the last window.", Messages.getInformationIcon());

        }catch (Exception e ){
            String message = "Wrong listId";
            String title = "Data error.";
            if(e instanceof NotAuthorizedException){
                message = "Wrong Key/token data";
                title = "Input correct ones.";
            }

            Messages.showMessageDialog(project, message,
                    title, Messages.getInformationIcon());
        }





    }
}
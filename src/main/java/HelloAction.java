import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class HelloAction extends AnAction {
    public HelloAction() {
        super("Hello!!!");
    }

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

        TrelloProjectKostil kostil = new TrelloProjectKostil();
        String listId  = kostil.getListId();
        if(listId.length()<5) {
            Messages.showMessageDialog(project, "You didn't initialize",
                    "Do it now, so you could post some Cards!", Messages.getInformationIcon());
            return;
        }
        Messages.showMessageDialog(project, "RIGHT!!!!!",
                "your list id is "+listId, Messages.getInformationIcon());



    }
}
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class SetAuthDataAndListId extends AnAction {

    public SetAuthDataAndListId(){
        super("Set!");
    }

    public static String getStringViaDialog(Project project, String title, String message){
        return Messages.showInputDialog(project,message,
                title,Messages.getInformationIcon());
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();
        TrelloPluginForm form = new TrelloPluginForm();
        String[] args = new String[0];
        form.main(args);
//        TrelloProjectKostil kostil = new TrelloProjectKostil();
//        String listId  = kostil.getListId();
//        if(listId == "") {
//            Messages.showMessageDialog(project, "You didn't initialize",
//                    "Do it now, so you could post some Cards!", Messages.getInformationIcon());
//        return;
//        }
//        Messages.showMessageDialog(project, "RIGHT!!!!!",
//                "your list id is "+listId, Messages.getInformationIcon());

//        TrelloProjectKostil kostil = new TrelloProjectKostil();
//        kostil.setListId(getStringViaDialog(project,
//                "You can get it via trello adding .json to the Card link",
//                "Please input the listId"));


//        kostil.setListId(Messages.showInputDialog(project,"Please input the listId",
//               "You can get it via trello adding .json to the Card link",Messages.getInformationIcon()));

    }
}

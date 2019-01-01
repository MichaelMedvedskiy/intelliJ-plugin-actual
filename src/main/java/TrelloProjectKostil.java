public class TrelloProjectKostil {

    private static String listId="";
    private static String trelloKey="";
    private static String trelloAccessToken="";

    public static String getTrelloKey() {
        return trelloKey;
    }

    public static void setTrelloKey(String trelloKey) {
        TrelloProjectKostil.trelloKey = trelloKey;
    }

    public static String getTrelloAccessToken() {
        return trelloAccessToken;
    }

    public static void setTrelloAccessToken(String trelloAccessToken) {
        TrelloProjectKostil.trelloAccessToken = trelloAccessToken;
    }

    public static void setListId(String Id){
        listId = Id;
    }

    public static String getListId(){
        return listId;
    }
}

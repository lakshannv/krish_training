import java.util.ArrayList;

public class NoticeBoard {

    private static volatile NoticeBoard noticeBoard;
    private final ArrayList<String> noticeList = new ArrayList();

    private NoticeBoard() {
        if (noticeBoard != null) {
            throw new RuntimeException("Please use getInstance() method");
        }
    }

    public static NoticeBoard getInstance() {
        if (noticeBoard == null) {
            synchronized (NoticeBoard.class) {
                if (noticeBoard == null) {
                    noticeBoard = new NoticeBoard();
                }
            }
        }
        return noticeBoard;
    }

    public ArrayList<String> getNoticeList() {
        return noticeList;
    }

    public void addNotice(String notice) {
        noticeList.add(notice);
    }
}

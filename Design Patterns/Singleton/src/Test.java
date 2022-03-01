public class Test {
    public static void main(String[] args) {

        NoticeBoard noticeBoard1 = NoticeBoard.getInstance();
        noticeBoard1.addNotice("Notice 1");
        noticeBoard1.addNotice("Notice 2");
        System.out.println(noticeBoard1.getNoticeList());

        new Thread(){
            @Override
            public void run() {
                NoticeBoard noticeBoard2 = NoticeBoard.getInstance();
                System.out.println(noticeBoard1 == noticeBoard2); //checks whether it's the same object
                NoticeBoard.getInstance().addNotice("Notice 3");
                System.out.println(noticeBoard2.getNoticeList());
            }
        }.start();

    }
}

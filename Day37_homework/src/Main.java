import dao.BookDao;

public class Main {
    public static void main(String[] args) {
        for (int j = 0; j < 50; j++) {
            for (int i = 0; i < 20; i++) {
                new BookDao().insert("西游记" + i+1, "吴承恩" + i, i + 0.0, "名著" + i+1);
            }
        }


    }
}

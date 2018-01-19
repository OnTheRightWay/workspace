package proxy;

public class Button implements IFunction {
    private String btnName;

    public String getBtnName() {
        return btnName;
    }

    public Button(String btnName) {
        this.btnName = btnName;
    }

    @Override
    public void click() {
        System.out.println(btnName+"被点击了");
    }
}

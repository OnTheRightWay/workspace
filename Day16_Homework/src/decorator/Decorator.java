package decorator;

import componet.饮品;

public abstract class Decorator extends 饮品 {

    protected 饮品 yp;

    public Decorator(饮品 yp) {
        this.yp = yp;
    }

}

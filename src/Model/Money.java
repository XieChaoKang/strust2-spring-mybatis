package Model;

/**
 * @author 谢朝康
 * @date 2019/12/14 18:09
 */
public class Money {
    private int average; //平均金额
    private int max; //最多
    private int min; //最少
    private int chao; //超过平均值

    public Money() {
    }

    public Money(int average, int max, int min, int chao) {
        this.average = average;
        this.max = max;
        this.min = min;
        this.chao = chao;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getChao() {
        return chao;
    }

    public void setChao(int chao) {
        this.chao = chao;
    }


}

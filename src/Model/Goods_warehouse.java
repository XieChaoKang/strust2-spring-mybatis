package Model;

import java.util.stream.Stream;

//物品入库
public class Goods_warehouse {
    private int number;//物品入库单编号
    private String data;//入库日期
    private int warehouse_number;//仓库编号
    private int item_number;//物品编号
    private int quantity;//数量

    public Goods_warehouse() {
    }

    public Goods_warehouse(int number) {
        this.number = number;
    }

    public Goods_warehouse(int number, String data, int warehouse_number, int item_number, int quantity) {
        this.number = number;
        this.data = data;
        this.warehouse_number = warehouse_number;
        this.item_number = item_number;
        this.quantity = quantity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getWarehouse_number() {
        return warehouse_number;
    }

    public void setWarehouse_number(int warehouse_number) {
        this.warehouse_number = warehouse_number;
    }

    public int getItem_number() {
        return item_number;
    }

    public void setItem_number(int item_number) {
        this.item_number = item_number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Goods_warehouse{" +
                "number=" + number +
                ", data='" + data + '\'' +
                ", warehouse_number='" + warehouse_number + '\'' +
                ", item_number='" + item_number + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}

package Model;

//物品
public class Item {
    private int id;
    private String name;
    private String measurement;//计量单位
    private int warehouse_number;//仓库编号
    private int quantity;//数量
    private int price;//单价

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int getWarehouse_number() {
        return warehouse_number;
    }

    public void setWarehouse_number(int warehouse_number) {
        this.warehouse_number = warehouse_number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurement='" + measurement + '\'' +
                ", warehouse_number=" + warehouse_number +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

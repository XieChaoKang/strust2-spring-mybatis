package Model;

import java.util.List;

//仓库
public class Warehouse {
    private int id;
    private String name;

    //仓库类型
    private String type;

    // 库存金额
    private String inventory_amount;

    //物品 一对一关联查询
    private Item item;

    //一对多关联查询
    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Warehouse() {
    }

    public Warehouse(int id) {
        this.id = id;
    }


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInventory_amount() {
        return inventory_amount;
    }

    public void setInventory_amount(String inventory_amount) {
        this.inventory_amount = inventory_amount;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", inventory_amount='" + inventory_amount + '\'' +
                ",item='"+item+'\''+
                ",itemList='"+itemList+'\''+
                '}';
    }

}

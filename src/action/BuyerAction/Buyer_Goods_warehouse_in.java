package action.BuyerAction;

import Model.Goods_warehouse;
import Model.Item;
import Model.Warehouse;
import Service.BuyerService.BuyerServiceImpl.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//采购物品入库 物品本身在仓库就有
@Controller
public class Buyer_Goods_warehouse_in extends ActionSupport implements ModelDriven<Goods_warehouse> {

    //返回json数据的映射
    private JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    Item item = new Item();

    Goods_warehouse goodsWarehouse = new Goods_warehouse();

    @Override
    public Goods_warehouse getModel() {
        return goodsWarehouse;
    }

    @Autowired
    Buyer_Goods_warehouseImpl buyerGoodsWarehouse;

    public Buyer_Goods_warehouseImpl getBuyerGoodsWarehouse() {
        return buyerGoodsWarehouse;
    }

    public void setBuyerGoodsWarehouse(Buyer_Goods_warehouseImpl buyerGoodsWarehouse) {
        this.buyerGoodsWarehouse = buyerGoodsWarehouse;
    }

    @Autowired
    QueryItemByidImpl query;

    public QueryItemByidImpl getQuery() {
        return query;
    }

    public void setQuery(QueryItemByidImpl query) {
        this.query = query;
    }

    @Autowired
    UpdateItemByidImpl updateItemByidImpl;

    public UpdateItemByidImpl getUpdateItemByidImpl() {
        return updateItemByidImpl;
    }

    public void setUpdateItemByidImpl(UpdateItemByidImpl updateItemByidImpl) {
        this.updateItemByidImpl = updateItemByidImpl;
    }

    @Autowired
    Se_WarehouseByidImpl se_warehouseByid11;

    public Se_WarehouseByidImpl getSe_warehouseByid() {
        return se_warehouseByid11;
    }

    public void setSe_warehouseByid(Se_WarehouseByidImpl se_warehouseByid) {
        this.se_warehouseByid11 = se_warehouseByid;
    }

    @Autowired
    Up_WarehouseByidImpl up11;

    public Up_WarehouseByidImpl getUp() {
        return up11;
    }

    public void setUp(Up_WarehouseByidImpl up) {
        this.up11 = up;
    }

    @Override
    public String execute() throws Exception {

        int count;

        //实时获取时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = simpleDateFormat.format(new Date());

        Integer money = se_warehouseByid11.Se_WarehouseByid(goodsWarehouse.getWarehouse_number());

        if (money >= 1000) {

            goodsWarehouse = new Goods_warehouse(goodsWarehouse.getNumber(), date, goodsWarehouse.getWarehouse_number(), goodsWarehouse.getItem_number(), goodsWarehouse.getQuantity());

            count = buyerGoodsWarehouse.insert(goodsWarehouse);

            System.out.println(goodsWarehouse);

            try {
                item = query.QueryItemByitem_id(goodsWarehouse.getItem_number());
                System.out.println(item.getQuantity());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (item != null) {
                int quantity = item.getQuantity() + goodsWarehouse.getQuantity();
                System.out.println(quantity);
                Item item1 = new Item(item.getId(), quantity);
                int i = updateItemByidImpl.UpdateItem(item1);
                count = count + i;
            } else {
                count = 0;
            }

            if (count > 0) {
                money = money - (goodsWarehouse.getQuantity() * item.getPrice());
                System.out.println(money);
                Warehouse warehouse = new Warehouse(goodsWarehouse.getWarehouse_number(),money);
                up11.Up_WarehouseByid(warehouse);
            }
        }
        else {
            count = 0;
        }

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);

        return SUCCESS;
    }

}

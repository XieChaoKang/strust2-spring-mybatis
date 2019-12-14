/**
 * @author 谢朝康
 * @date 2019/10/26 23:45
 */
package action.BuyerAction;

import Model.Goods_warehouse;
import Model.Item;
import Model.Warehouse;
import Service.BuyerService.BuyerServiceImpl.Buyer_Goods_warehouseImpl;
import Service.BuyerService.BuyerServiceImpl.Insert_New_ItemImpl;
import Service.BuyerService.BuyerServiceImpl.Se_WarehouseByidImpl;
import Service.BuyerService.BuyerServiceImpl.Up_WarehouseByidImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Insert_newItem extends ActionSupport {

    //返回json数据的映射
    private JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    Goods_warehouse goodsWarehouse = new Goods_warehouse();

    public Goods_warehouse getGoodsWarehouse() {
        return goodsWarehouse;
    }

    public void setGoodsWarehouse(Goods_warehouse goodsWarehouse) {
        this.goodsWarehouse = goodsWarehouse;
    }

    Item item = new Item();

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Autowired
    Insert_New_ItemImpl insert_new_itemImpl;

    public Insert_New_ItemImpl getInsert_new_itemImpl() {
        return insert_new_itemImpl;
    }

    public void setInsert_new_itemImpl(Insert_New_ItemImpl insert_new_itemImpl) {
        this.insert_new_itemImpl = insert_new_itemImpl;
    }

    @Autowired
    Buyer_Goods_warehouseImpl buyerGoodsWarehouseImpl;

    public Buyer_Goods_warehouseImpl getBuyerGoodsWarehouseImpl() {
        return buyerGoodsWarehouseImpl;
    }

    public void setBuyerGoodsWarehouseImpl(Buyer_Goods_warehouseImpl buyerGoodsWarehouseImpl) {
        this.buyerGoodsWarehouseImpl = buyerGoodsWarehouseImpl;
    }

    @Autowired
    Se_WarehouseByidImpl se_warehouseByid;

    public Se_WarehouseByidImpl getSe_warehouseByid() {
        return se_warehouseByid;
    }

    public void setSe_warehouseByid(Se_WarehouseByidImpl se_warehouseByid) {
        this.se_warehouseByid = se_warehouseByid;
    }

    @Autowired
    Up_WarehouseByidImpl up;

    public Up_WarehouseByidImpl getUp() {
        return up;
    }

    public void setUp(Up_WarehouseByidImpl up) {
        this.up = up;
    }

    @Override
    public String execute() throws Exception {
        int count;
        System.out.println("goods:"+goodsWarehouse);
        System.out.println("item:"+item);

        //实时获取时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = simpleDateFormat.format(new Date());

        Integer money = se_warehouseByid.Se_WarehouseByid(goodsWarehouse.getWarehouse_number());

        if (money >= 1000) {

            //将该订单信息存入订单信息表
            goodsWarehouse = new Goods_warehouse(goodsWarehouse.getNumber(), date, goodsWarehouse.getWarehouse_number(), goodsWarehouse.getItem_number(), goodsWarehouse.getQuantity());
            int i = buyerGoodsWarehouseImpl.insert(goodsWarehouse);

            item = new Item(goodsWarehouse.getItem_number(), item.getName(), item.getMeasurement(), goodsWarehouse.getWarehouse_number(), goodsWarehouse.getQuantity(), item.getPrice());
            System.out.println("new item:" + item);

            int j = 0;
            if (i > 0) {
                //将物品信息写入物品信息表
                j = insert_new_itemImpl.Insert_new_Item(item);
            }

            if (i >0 && j>0) {
                count = 1;
                money = money - (goodsWarehouse.getQuantity() * item.getPrice());
                System.out.println(money);
                Warehouse warehouse = new Warehouse(goodsWarehouse.getWarehouse_number(),money);
                up.Up_WarehouseByid(warehouse);
            }
            else {
                count = 0;
            }

        }
        else {
            count = 0;
        }

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        json = new JSONObject(map);
        System.out.println(json);

        return SUCCESS;
    }
}

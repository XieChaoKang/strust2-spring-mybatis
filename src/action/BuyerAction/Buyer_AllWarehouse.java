package action.BuyerAction;

import Model.Warehouse;
import Service.BuyerService.BuyerServiceImpl.Buyer_QueryAllWarehouseImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13/013.
 */
@Controller
public class Buyer_AllWarehouse extends ActionSupport {
    private int page;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }
    @Autowired
    private Buyer_QueryAllWarehouseImpl buyer_queryAllWarehouse;

    public Buyer_QueryAllWarehouseImpl getBuyer_queryAllWarehouse() {
        return buyer_queryAllWarehouse;
    }

    public void setBuyer_queryAllWarehouse(Buyer_QueryAllWarehouseImpl buyer_queryAllWarehouse) {
        this.buyer_queryAllWarehouse = buyer_queryAllWarehouse;
    }
    @Override
    public String execute() throws Exception {

        System.out.println("Warehouse");

        List<Warehouse> list = buyer_queryAllWarehouse.buyer_selectAllWarehouse();

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(list);

        return SUCCESS;
    }

}

package action.BuyerAction;

import Model.Item;
import Service.AdminService.AdminServiceImp.QueryAllItemImpl;
import Service.BuyerService.BuyerServiceImpl.Buyer_QueryAllItemImpl;
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
public class Buyer_AllItem  extends ActionSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    @Autowired
    private Buyer_QueryAllItemImpl buyer_queryAllItem;

    public Buyer_QueryAllItemImpl getBuyer_queryAllItem() {
        return buyer_queryAllItem;
    }

    public void setBuyer_queryAllItem(Buyer_QueryAllItemImpl buyer_queryAllItem) {
        this.buyer_queryAllItem = buyer_queryAllItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    QueryAllItemImpl queryAllItem;

    public QueryAllItemImpl getQueryAllItemImpl() {
        return queryAllItem;
    }

    public void setQueryAllItemImpl(QueryAllItemImpl queryAllItemImpl) {
        this.queryAllItem = queryAllItemImpl;
    }

    public String test(){
        System.out.println("test");

        List<Item> list;

        if (name == null) {
            list = buyer_queryAllItem.buyer_QueryAllItem();
        }
        else {
            Item item = new Item(name);
            list = queryAllItem.QueryItemByName(item);
        }

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(list);

        return SUCCESS;
    }

}

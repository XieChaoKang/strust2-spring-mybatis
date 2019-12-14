package action.AdminAction;

import Model.Item;
import Service.AdminService.AdminServiceImp.QueryAllItemImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

//查询所有物品信息 数据接口
@Controller
public class AllItem extends ActionSupport{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;

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
    QueryAllItemImpl queryAllItemImpl;

    public QueryAllItemImpl getQueryAllItemImpl() {
        return queryAllItemImpl;
    }

    public void setQueryAllItemImpl(QueryAllItemImpl queryAllItemImpl) {
        this.queryAllItemImpl = queryAllItemImpl;
    }

    public String test(){
       // System.out.println(name);
        List<Item> list;
        if (name == null) {
            list = queryAllItemImpl.QueryAllItem();

            System.out.println(list);
        }
        else {
            Item item = new Item(name);
            list = queryAllItemImpl.QueryItemByName(item);
        }

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(list);
        return SUCCESS;
    }

}

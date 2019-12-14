package action.AdminAction;

import Model.Goods_warehouse;
import Service.AdminService.AdminServiceImp.QueryAllGWImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

//查询订单信息 后台数据接口
@Controller
public class AllIGW extends ActionSupport{
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
    QueryAllGWImpl queryAllGWImpl;

    public QueryAllGWImpl getQueryAllGWImpl() {
        return queryAllGWImpl;
    }

    public void setQueryAllGWImpl(QueryAllGWImpl queryAllGWImpl) {
        this.queryAllGWImpl = queryAllGWImpl;
    }

    public String test() {

        List<Goods_warehouse> list = queryAllGWImpl.QueryAllGW();

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(list);

        return SUCCESS;
    }

}

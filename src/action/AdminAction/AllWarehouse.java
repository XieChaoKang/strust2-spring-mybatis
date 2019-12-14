package action.AdminAction;

import Model.Warehouse;
import Service.AdminService.AdminServiceImp.QueryAllWarehouseImpl;
import Util.LayerResult;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

//查询所有仓库信息 数据接口
@Controller
public class AllWarehouse extends ActionSupport {
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
    QueryAllWarehouseImpl queryAllWarehouseImpl;

    public QueryAllWarehouseImpl getQueryAllWarehouseImpl() {
        return queryAllWarehouseImpl;
    }

    public void setQueryAllWarehouseImpl(QueryAllWarehouseImpl queryAllWarehouseImpl) {
        this.queryAllWarehouseImpl = queryAllWarehouseImpl;
    }

    @Override
    public String execute() throws Exception {

        List<Warehouse> list = queryAllWarehouseImpl.selectAllWarehouse();

        // 通过该类解析成 Layer 表格能识别的Json数据
        json = LayerResult.getJson(list);

        return SUCCESS;
    }
}

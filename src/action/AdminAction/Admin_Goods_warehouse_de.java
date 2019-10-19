package action.AdminAction;

import Model.Goods_warehouse;
import Service.AdminService.AdminServiceImp.Admin_Goods_warehouseImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//删除仓库内的物品信息（根据入库单编号）
@Controller
public class Admin_Goods_warehouse_de extends ActionSupport{

    public Goods_warehouse getGoodsWarehouse() {
        return goodsWarehouse;
    }

    public void setGoodsWarehouse(Goods_warehouse goodsWarehouse) {
        this.goodsWarehouse = goodsWarehouse;
    }

    Goods_warehouse goodsWarehouse = new Goods_warehouse();

    public Admin_Goods_warehouseImpl getAdminGoodsWarehouse() {
        return adminGoodsWarehouse;
    }

    public void setAdminGoodsWarehouse(Admin_Goods_warehouseImpl adminGoodsWarehouse) {
        this.adminGoodsWarehouse = adminGoodsWarehouse;
    }

    @Autowired
    Admin_Goods_warehouseImpl adminGoodsWarehouse;

    @Override
    public String execute() throws Exception {
        String result;
        int count = adminGoodsWarehouse.delete(goodsWarehouse);
        if (count != 0 )
        {
            result = SUCCESS;
            ServletActionContext.getRequest().getSession().setAttribute("count",count);
        }

        else
        {
            result = ERROR;
        }

        return result;
    }
}

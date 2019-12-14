package action.AdminAction;

import Mapper.AdminMapper.AdminMapper;
import Model.Admin;
import Service.AdminService.AdminServiceImp.AdminLoginImp;
import Service.AdminService.AdminServiceImp.AdminRegistImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

//管理员注册 数据接口
@Controller
public class AdminRegister extends ActionSupport{

    //返回JSON数据
    private JSON json;

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

    Admin admin = new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Autowired
    AdminRegistImpl adminRegistImpl;

    public AdminRegistImpl getAdminRegistImpl() {
        return adminRegistImpl;
    }

    public void setAdminRegistImpl(AdminRegistImpl adminRegistImpl) {
        this.adminRegistImpl = adminRegistImpl;
    }

    @Autowired
    AdminLoginImp adminLoginImp;

    public AdminLoginImp getAdminLoginImp() {
        return adminLoginImp;
    }

    public void setAdminLoginImp(AdminLoginImp adminLoginImp) {
        this.adminLoginImp = adminLoginImp;
    }

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public String execute() throws Exception {
        int count;
        //admin = adminLoginImp.AdminLogin(admin);
        System.out.println("admin:"+admin);
        if (adminMapper.Se_AdByid(admin.getId()) == null ) {
            count = adminRegistImpl.AdminRegist(admin);
        }
        else {
            count = 0;
        }

        System.out.println("a: "+admin);
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);
        json = new JSONObject(map);

        return SUCCESS;
    }
}

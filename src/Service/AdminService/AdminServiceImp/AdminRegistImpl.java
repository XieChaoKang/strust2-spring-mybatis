package Service.AdminService.AdminServiceImp;

import Mapper.AdminMapper.AdminMapper;
import Model.Admin;
import Service.AdminService.AdminRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//service层 管理员注册
@Service
public class AdminRegistImpl implements AdminRegister {

    @Autowired
    AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int AdminRegist(Admin admin) {
        return adminMapper.AdminRegister(admin);
    }
}

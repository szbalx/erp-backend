package com.jukusoft.erp.core.module.base;

import com.jukusoft.data.repository.GroupRepository;
import com.jukusoft.data.repository.MenuRepository;
import com.jukusoft.data.repository.PermissionRepository;
import com.jukusoft.data.repository.UserRepository;
import com.jukusoft.erp.core.module.base.service.group.GroupService;
import com.jukusoft.erp.core.module.base.service.login.LoginService;
import com.jukusoft.erp.core.module.base.service.loginform.LoginFormService;
import com.jukusoft.erp.core.module.base.service.menu.MenuService;
import com.jukusoft.erp.core.module.base.service.permission.PermissionService;
import com.jukusoft.erp.core.permission.PermissionManagerImpl;
import com.jukusoft.erp.lib.module.AbstractModule;

public class BaseModule extends AbstractModule {

    @Override
    public void start() throws Exception {
        //add repositories
        addRepository(new UserRepository(), UserRepository.class);
        addRepository(new GroupRepository(), GroupRepository.class);
        addRepository(new PermissionRepository(), PermissionRepository.class);
        addRepository(new MenuRepository(), MenuRepository.class);

        //set permission manager
        context.setPermissionManager(new PermissionManagerImpl(getRepository(GroupRepository.class), getRepository(PermissionRepository.class)));

        //add services
        addService(new LoginFormService());
        addService(new LoginService());
        addService(new GroupService());
        addService(new MenuService());
        addService(new PermissionService());
    }

    @Override
    public void stop() throws Exception {

    }

}

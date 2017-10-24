package com.jukusoft.erp.app.server;

import com.jukusoft.erp.app.server.impl.DefaultAppServer;
import com.jukusoft.erp.core.service.TestService;

public class Main {

    public static void main (String[] args) {
        //create new app server
        AppServer server = new DefaultAppServer();

        //start app server
        server.start((AppServer server1, boolean success) -> {
            if (success) {
                //add modules
                server.deployModule(new TestService(), TestService.class);
            } else {
                System.err.println("Couldnt start app server.");

                System.exit(1);
            }
        });
    }

}

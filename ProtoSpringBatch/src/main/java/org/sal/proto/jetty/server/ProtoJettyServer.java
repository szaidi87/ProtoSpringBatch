package org.sal.proto.jetty.server;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;

/**
 * Created by zaidis on 15/04/2015.
 */
@Slf4j
public class ProtoJettyServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloWorldHandler());
        server.start();
        server.join();
        log.info("Started Jetty server on port 8080");
    }
}

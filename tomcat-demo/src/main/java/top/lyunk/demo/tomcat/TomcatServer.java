package top.lyunk.demo.tomcat;

import jakarta.servlet.ServletException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

@Log4j2
public class TomcatServer {
    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();

        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        log.info("tomcat端口18888");
        connector.setPort(18888);
        tomcat.setConnector(connector);
        tomcat.getHost().setAutoDeploy(false);

        tomcat.addContext("", "/");

        log.info("tomcat启动");
        tomcat.start();

        Wrapper wrapper = tomcat.addServlet("", "myServlet", "top.lyunk.demo.tomcat.MyServlet");
        // wrapper.addMapping("");
        wrapper.addMapping("/");

        wrapper.load();
    }
}

package top.lyunk.demo.tomcat;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("初始化Servlet：[{}]", config);
    }

    @Override
    public ServletConfig getServletConfig() {
        log.info("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse res) throws ServletException, IOException {
        RequestFacade req = (RequestFacade) request;
        log.info("调用Servlet：req[{}][{}]", req.getMethod(), req.getServletPath());
        PrintWriter writer = res.getWriter();
        writer.println("1111");
        writer.flush();
        res.flushBuffer();
        log.info("调用Servlet：res[{}]", res);
    }

    @Override
    public String getServletInfo() {
        log.info("getServletInfo");
        return "";
    }

    @Override
    public void destroy() {
        log.info("销毁Servlet");
    }
}

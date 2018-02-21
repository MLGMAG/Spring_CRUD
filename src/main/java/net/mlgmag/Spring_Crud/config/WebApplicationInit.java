package net.mlgmag.Spring_Crud.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebApplicationInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();

        webApplicationContext.register(WebConfig.class);

        webApplicationContext.setServletContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}

package com.z9devs.springmvccrud;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Spring MVC ha una DispatcherServlet, una Servlet centrale, che fa da front
// controller e instrada le request ai vari controller

// WebApplicationInitializer è un'interfaccia di Spring MVC che fa sì che 
// il codice sia visto e usato per inizializzare qualsiasi Servlet 3 container
// C'è la possibilità di estendere AbstractAnnotationConfigDispatcherServletInitializer
// cosa che permette di registrare la dispatcher servlet ancora più semplicemente
// sovrascrivendo i metodi specifici del servlet mapping, ottenendo una cosa
// del genere:
/*
 * public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MyWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
 */
public class WebAppInitializer implements WebApplicationInitializer 
{

	public void onStartup(ServletContext context) throws ServletException 
	{
		// Queste due righe servono a caricare le configurazioni dell'applicazione
		// La DispatcherServlet si aspetta un WebApplicationContext per essere
		// configurata
		// Il webapplicationcontext è linkato al ServletContext e alla Servlet associata
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		
		// Così creo e registro la DispatcherServlet (che eredita da HttpServlet
		ServletRegistration.Dynamic dispatcher = context.addServlet(
				"SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		// / -> vuol dire default servlet
		// /* -> vuol dire sena un prefisso
		// Solitamente si usa il primo
		dispatcher.addMapping("/");
		
		/*
		ServletRegistration.Dynamic dispatcher2 = context.addServlet(
				"prova", new DispatcherServlet(appContext));
		dispatcher2.setLoadOnStartup(1);
		dispatcher2.addMapping("/prova/*");
		*/
		
		
		// In alternativa a questa cosa potrei configurare da xml, da web.xml così:
		
		/*
		 * 
		 * 
		 * <web-app>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/app-context.xml</param-value>
    </context-param>

    <servlet>
        <servlet-name>app</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value></param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>

</web-app>
		 */
		
	}

}

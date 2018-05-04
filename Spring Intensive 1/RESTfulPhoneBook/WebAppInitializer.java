/* Created by Vince Chang */

package com.di.phonebook.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  // Points to JavaConfig.class
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { JavaConfig.class };
  }

  // Returns a new array of class objects
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { MVCConfig.class };
  }

  protected String[] getServletMappings() {
    return new String[] { "*.do" };
  }

  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
  }
}
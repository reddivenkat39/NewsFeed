package mangi.PosteMe.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherConfig  extends
	AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[]{ServiceBeanConfigurations.class};
}

@Override
protected Class<?>[] getServletConfigClasses() {
	return new Class[] { ComponentScanConfig.class };
}

@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}

}



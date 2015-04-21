package org.fenixedu.bennu;

import org.fenixedu.bennu.spring.BennuSpringModule;
import org.fenixedu.commons.configuration.ConfigurationInvocationHandler;
import org.fenixedu.commons.configuration.ConfigurationManager;

@BennuSpringModule(basePackages = "org.fenixedu", bundles = "CoursesResources")
public class CoursesSpringConfiguration {

    @ConfigurationManager(description = "FenixEdu Courses Configuration")
    public interface ConfigurationProperties {

    }

    public static ConfigurationProperties getConfiguration() {
        return ConfigurationInvocationHandler.getConfiguration(ConfigurationProperties.class);
    }

    public static final String BUNDLE = "resources/CoursesResources";

}
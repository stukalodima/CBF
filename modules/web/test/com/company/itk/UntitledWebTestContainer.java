package com.company.itk;

import com.haulmont.cuba.web.testsupport.TestContainer;

import java.util.Arrays;

public class UntitledWebTestContainer extends TestContainer {

    public UntitledWebTestContainer() {
        appComponents = Arrays.asList(
                "com.haulmont.cuba",
                "de.diedavids.cuba.userinbox",
                "com.haulmont.charts",
                "com.haulmont.addon.helium");
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the web module
                "com/company/untitled/web-app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "com/haulmont/cuba/web/testsupport/test-web-app.properties"
        );
    }

    public static class Common extends UntitledWebTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
        public static final UntitledWebTestContainer.Common INSTANCE = new UntitledWebTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}
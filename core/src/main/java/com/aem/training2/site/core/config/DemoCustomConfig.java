package com.aem.training2.site.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

    @ObjectClassDefinition(name = "Demo OSGi Configuration",
            description = "OSGi Configuration demo.")
    public @interface DemoCustomConfig {

        @AttributeDefinition(
                name = "Service Name",
                description = "Enter service name.",
                type = AttributeType.STRING)
        public String serviceName() default "Demo Service";

        @AttributeDefinition(
                name = "Countries",
                description = "Add countries locales for which you want to run this service.",
                type = AttributeType.STRING
        )
        String[] getCountries() default {"de", "in"};

        @AttributeDefinition(
                name = "Run Modes",
                description = "Select Run Mode.",
                options = {
                        @Option(label = "Author", value = "author"),
                        @Option(label = "Publish", value = "publish"),
                        @Option(label = "Both", value = "both")
                },
                type = AttributeType.STRING)
        String getRunMode() default "both";
    }



package de.ustutt.iaas.cc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SimpleTextProcessorApplication extends Application<SimpleTextProcessorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SimpleTextProcessorApplication().run(args);
    }

    @Override
    public String getName() {
        return "SimpleTextProcessor";
    }

    @Override
    public void initialize(final Bootstrap<SimpleTextProcessorConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final SimpleTextProcessorConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}

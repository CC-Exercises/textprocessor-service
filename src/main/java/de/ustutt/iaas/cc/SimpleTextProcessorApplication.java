package de.ustutt.iaas.cc;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.ustutt.iaas.cc.resources.TextProcessorResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class SimpleTextProcessorApplication extends Application<SimpleTextProcessorConfiguration> {

    private final static Logger logger = LoggerFactory.getLogger(SimpleTextProcessorApplication.class);

    public static void main(final String[] args) throws Exception {
	new SimpleTextProcessorApplication().run(args);
    }

    private String myID;

    @Override
    public String getName() {
	return "SimpleTextProcessor";
    }

    @Override
    public void initialize(final Bootstrap<SimpleTextProcessorConfiguration> bootstrap) {
	// swagger UI
	bootstrap.addBundle(new SwaggerBundle<SimpleTextProcessorConfiguration>() {
	    protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
		    SimpleTextProcessorConfiguration configuration) {
		return configuration.swaggerBundleConfiguration;
	    }
	});
    }

    @Override
    public void run(final SimpleTextProcessorConfiguration configuration, final Environment environment) {
	// get service instance ID from config file
	myID = configuration.getServiceInstanceID();
	// if not set, generate random service instance ID
	if (StringUtils.isBlank(myID)) {
	    logger.debug("setting random service instance ID");
	    myID = UUID.randomUUID().toString();
	}
	logger.info("Service Instance ID is: " + myID);
	// create and register resource class
	final TextProcessorResource root = new TextProcessorResource(myID);
	environment.jersey().register(root);
    }

}

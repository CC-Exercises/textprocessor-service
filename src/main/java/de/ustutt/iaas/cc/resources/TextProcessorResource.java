package de.ustutt.iaas.cc.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;

/**
 * The resource class providing all methods offered by the REST API.
 * 
 * @author hauptfn
 *
 */
@Path("")
@Api(value = "TextProcessor")
public class TextProcessorResource {

    private final String id;

    public TextProcessorResource(String id) {
	super();
	this.id = id;
    }

    @POST
    @Consumes({ MediaType.TEXT_PLAIN })
    @Produces({ MediaType.TEXT_PLAIN })
    @Timed
    public String processText(String text) {
	return "[processed by " + id + "] - " + text;
    }

}

package cn.com.itjh.api.resource;

import com.google.common.base.Joiner;
import com.google.common.net.HttpHeaders;
import com.wordnik.swagger.annotations.*;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * REST endpoint for user manipulation.
 */
@Api(value = "users", description = "Endpoint for user management")
@Path("/users")
public class UsersEndpoint {



    @OPTIONS
    @ApiOperation(
            value = "Returns resource options",
            notes = "This method allows the client to determine the options and/or requirements associated with a resource, or the capabilities of a server, without implying a resource action or initiating a resource retrieval.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful retrieval of resource options"), @ApiResponse(code = 500, message = "Internal server error") })
    public Response getUsersOptions() {
        final String header = HttpHeaders.ALLOW;
        final String value = Joiner.on(", ").join(RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS).toString();

        return Response.noContent().header(header, value).build();
    }


}

package org.mckillop;

import org.apache.camel.builder.RouteBuilder;

public class RestTest1 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/resttest1")
            .get()
            .to("direct:get")

            .post()
            .to("direct:post");

        from("direct:get")
            .setBody(constant("Lorem"));

        from("direct:post")
            .setBody(simple("You said ${body}"));
    }
}
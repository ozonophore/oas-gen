package com.example.routes;

import io.github.fomin.oasgen.SpringMvcClient;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

public class SimpleClient {
    private final SpringMvcClient springMvcClient;
    private final String baseUrl;

    public SimpleClient(@Nonnull SpringMvcClient springMvcClient, @Nonnull String baseUrl) {
        this.springMvcClient = springMvcClient;
        this.baseUrl = baseUrl;
    }

    @Nonnull
    public java.lang.String simplePost(
            @Nonnull com.example.dto.Dto dto
    ) {
        return simplePost$0(
                dto
        );
    }

    private java.lang.String simplePost$0(
            com.example.dto.Dto bodyArg
    ) {
        Map<String, Object> uriVariables = Collections.emptyMap();
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl + "/path1")

                .build(uriVariables);
        return springMvcClient.doRequest(
                uri,
                HttpMethod.POST,
                bodyArg,
                (jsonGenerator, value) -> com.example.routes.DtoConverter.write(jsonGenerator, value),
                jsonNode -> io.github.fomin.oasgen.StringConverter.parse(jsonNode)
        );
    }

    @Nonnull
    public com.example.dto.Dto simpleGet(
            @Nonnull java.lang.String id,
            @Nonnull java.lang.String param1,
            @Nullable com.example.dto.Param2OfSimpleGet param2
    ) {
        return simpleGet$0(
                id,
                param1,
                param2
        );
    }

    private com.example.dto.Dto simpleGet$0(
            java.lang.String param0,
            java.lang.String param1,
            com.example.dto.Param2OfSimpleGet param2
    ) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", param0 != null ? param0 : null);
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl + "/path2/{id}")
                .queryParam("param1", param1 != null ? param1 : null)
                .queryParam("param2", param2 != null ? com.example.routes.Param2OfSimpleGetConverter.writeString(param2) : null)
                .build(uriVariables);
        return springMvcClient.doRequest(
                uri,
                HttpMethod.GET,
                null,
                null,
                jsonNode -> com.example.routes.DtoConverter.parse(jsonNode)
        );
    }

}

package com.hoaxify.hoaxify.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.io.IOException;

@Configuration
public class SerializationConfiguration {
    @Bean
    public Module springDataPageModule(){
        JsonSerializer<Page> pageSerializer  = new JsonSerializer<Page>() {
            @Override
            public void serialize(Page value, JsonGenerator generator, SerializerProvider serializer) throws IOException {
            generator.writeStartObject();
            generator.writeNumberField("numberOfElements", value.getNumberOfElements());
            generator.writeNumberField("totalElements", value.getTotalElements());
            generator.writeNumberField("totalPages", value.getTotalPages());
            generator.writeNumberField("number", value.getNumber());
            generator.writeNumberField("size", value.getSize());
            generator.writeBooleanField("first", value.isFirst());
            generator.writeBooleanField("last", value.isLast());
            generator.writeBooleanField("next", value.hasNext());
            generator.writeBooleanField("previous", value.hasPrevious());

            generator.writeFieldName("content");

            serializer.defaultSerializeValue(value.getContent(), generator);
            generator.writeEndObject();
            }
        };
        return new SimpleModule().addSerializer(Page.class, pageSerializer);
    }
}

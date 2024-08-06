package com.manish.bookmyshow;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.manish.bookmyshow.DTO.bookingDTO.SlCategoryDTO;

import java.io.IOException;

public class SlCategoryDTOSerializer extends JsonSerializer<SlCategoryDTO> {

    @Override
    public void serialize(SlCategoryDTO value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("categoryId", value.getCategoryId());
        gen.writeStringField("categoryName", value.getCategoryName());
        gen.writeNumberField("price", value.getPrice());
        gen.writeEndObject();
    }
}

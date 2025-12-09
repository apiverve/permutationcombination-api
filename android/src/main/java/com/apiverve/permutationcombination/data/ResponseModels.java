// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     PermutationCombinationCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.permutationcombination.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static PermutationCombinationCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(PermutationCombinationCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(PermutationCombinationCalculatorData.class);
        writer = mapper.writerFor(PermutationCombinationCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// PermutationCombinationCalculatorData.java

package com.apiverve.permutationcombination.data;

import com.fasterxml.jackson.annotation.*;

public class PermutationCombinationCalculatorData {
    private long n;
    private long r;
    private long permutation;
    private long combination;
    private Formulas formulas;

    @JsonProperty("n")
    public long getN() { return n; }
    @JsonProperty("n")
    public void setN(long value) { this.n = value; }

    @JsonProperty("r")
    public long getR() { return r; }
    @JsonProperty("r")
    public void setR(long value) { this.r = value; }

    @JsonProperty("permutation")
    public long getPermutation() { return permutation; }
    @JsonProperty("permutation")
    public void setPermutation(long value) { this.permutation = value; }

    @JsonProperty("combination")
    public long getCombination() { return combination; }
    @JsonProperty("combination")
    public void setCombination(long value) { this.combination = value; }

    @JsonProperty("formulas")
    public Formulas getFormulas() { return formulas; }
    @JsonProperty("formulas")
    public void setFormulas(Formulas value) { this.formulas = value; }
}

// Formulas.java

package com.apiverve.permutationcombination.data;

import com.fasterxml.jackson.annotation.*;

public class Formulas {
    private String permutation;
    private String combination;

    @JsonProperty("permutation")
    public String getPermutation() { return permutation; }
    @JsonProperty("permutation")
    public void setPermutation(String value) { this.permutation = value; }

    @JsonProperty("combination")
    public String getCombination() { return combination; }
    @JsonProperty("combination")
    public void setCombination(String value) { this.combination = value; }
}
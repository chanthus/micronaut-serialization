/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.serde.processor.jackson;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.context.annotation.Executable;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.inject.visitor.VisitorContext;
import io.micronaut.serde.config.annotation.SerdeConfig;

/**
 * Support for JsonValue.
 */
public class JsonValueTransformer extends ValidatingAnnotationTransformer<JsonValue> {
    @Override
    protected List<AnnotationValue<?>> transformValid(AnnotationValue<JsonValue> annotation, VisitorContext visitorContext) {
        return Arrays.asList(
                AnnotationValue.builder(Executable.class).build(),
                AnnotationValue.builder(SerdeConfig.SerValue.class)
                        .build()
        );
    }

    @Override
    public Class<JsonValue> annotationType() {
        return JsonValue.class;
    }
}

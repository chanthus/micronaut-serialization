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

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import io.micronaut.core.annotation.AnnotationMetadata;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.util.ArrayUtils;
import io.micronaut.inject.annotation.TypedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;
import io.micronaut.serde.config.annotation.SerdeConfig;

/**
 * Support for JsonIncludeProperties.
 */
public class JsonIncludePropertiesMapper implements TypedAnnotationMapper<JsonIncludeProperties> {
    @Override
    public Class<JsonIncludeProperties> annotationType() {
        return JsonIncludeProperties.class;
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<JsonIncludeProperties> annotation, VisitorContext visitorContext) {
        final String[] values = annotation.stringValues();
        if (ArrayUtils.isNotEmpty(values)) {
            return Collections.singletonList(
                    AnnotationValue.builder(SerdeConfig.Included.class)
                            .member(AnnotationMetadata.VALUE_MEMBER, values)
                            .build()
            );
        }
        return Collections.emptyList();
    }
}

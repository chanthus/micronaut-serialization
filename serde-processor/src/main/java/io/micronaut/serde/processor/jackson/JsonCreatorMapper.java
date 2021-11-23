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

import com.fasterxml.jackson.annotation.JsonCreator;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.AnnotationValueBuilder;
import io.micronaut.core.annotation.Creator;
import io.micronaut.inject.annotation.TypedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;
import io.micronaut.serde.config.annotation.SerdeConfig;

/**
 * Maps the {@link com.fasterxml.jackson.annotation.JsonCreator} annotation to {@link io.micronaut.core.annotation.Creator}.
 */
public final class JsonCreatorMapper implements TypedAnnotationMapper<JsonCreator> {

    @Override
    public Class<JsonCreator> annotationType() {
        return JsonCreator.class;
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<JsonCreator> annotation, VisitorContext visitorContext) {
        final AnnotationValueBuilder<Creator> builder = AnnotationValue.builder(Creator.class);
        annotation.enumValue("mode", SerdeConfig.CreatorMode.class)
                .ifPresent(e -> builder.member("mode", e));
        return Collections.singletonList(builder.build());
    }
}

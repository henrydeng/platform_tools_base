/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.internal.model;

import com.android.annotations.NonNull;
import com.android.builder.model.BaseConfig;
import com.android.builder.model.ClassField;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * An implementation of BaseConfig specifically for sending as part of the Android model
 * through the Gradle tooling API.
 */
abstract class BaseConfigImpl implements BaseConfig, Serializable {
    private static final long serialVersionUID = 1L;

    @NonNull
    private final Map<String, String> mManifestPlaceholders;
    @NonNull
    private final Map<String, ClassField> mBuildConfigFields;
    @NonNull
    private final Map<String, ClassField> mResValues;

    protected BaseConfigImpl(@NonNull BaseConfig baseConfig) {
        mManifestPlaceholders = ImmutableMap.copyOf(baseConfig.getManifestPlaceholders());
        mBuildConfigFields = ImmutableMap.copyOf(baseConfig.getBuildConfigFields());
        mResValues = ImmutableMap.copyOf(baseConfig.getResValues());
    }

    @NonNull
    @Override
    public Map<String, ClassField> getBuildConfigFields() {
        return mBuildConfigFields;
    }

    @NonNull
    @Override
    public Map<String, ClassField> getResValues() {
        return mResValues;
    }

    @NonNull
    @Override
    public List<File> getProguardFiles() {
        return Collections.emptyList();
    }

    @NonNull
    @Override
    public List<File> getConsumerProguardFiles() {
        return Collections.emptyList();
    }

    @Override
    @NonNull
    public Map<String, String> getManifestPlaceholders() {
        return mManifestPlaceholders;
    }

    @Override
    public String toString() {
        return "BaseConfigImpl{" +
                "mManifestPlaceholders=" + mManifestPlaceholders +
                ", mBuildConfigFields=" + mBuildConfigFields +
                ", mResValues=" + mResValues +
                '}';
    }
}

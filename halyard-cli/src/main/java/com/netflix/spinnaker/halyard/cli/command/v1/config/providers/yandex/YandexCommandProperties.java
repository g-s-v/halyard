/*
 * Copyright 2020 YANDEX LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

public class YandexCommandProperties {
  static final String ACCOUNT_TYPE_DESCRIPTION = "The type of account.";
  static final String ENDPOINT_DESCRIPTION = "YandexCloud api endpoint";
  static final String FOLDER_ID_DESCRIPTION = "The ID of the folder to use.";
  static final String JSON_PATH_DESCRIPTION =
      "The path to a JSON service account that Spinnaker will use as credentials. ";
  static final String SOURCE_IMAGE_DESCRIPTION =
      "The source image. If both source image and source image family are set, source image will take precedence.";
  static final String SOURCE_IMAGE_FAMILY_DESCRIPTION =
      "The source image family to create the image from. The newest, non-deprecated image is used.";
}

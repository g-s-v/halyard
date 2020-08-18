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

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractAddBaseImageCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudBaseImage;

@Parameters(separators = "=")
public class YandexAddBaseImageCommand extends AbstractAddBaseImageCommand {
  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Parameter(
      names = "--source-image-name",
      description = YandexCommandProperties.SOURCE_IMAGE_DESCRIPTION)
  private String sourceImageName;

  @Parameter(
      names = "--source-image-family",
      description = YandexCommandProperties.SOURCE_IMAGE_FAMILY_DESCRIPTION)
  private String sourceImageFamily;

  @Parameter(names = "--image-family", description = "No desc")
  private Boolean imageFamily;

  @Override
  protected BaseImage buildBaseImage(String baseImageId) {
    YandexCloudBaseImage baseImage = new YandexCloudBaseImage();
    YandexCloudBaseImage.YandexImageSettings imageSettings =
        new YandexCloudBaseImage.YandexImageSettings();
    imageSettings.setImageFamily(imageFamily);
    baseImage.setBaseImage(imageSettings);

    YandexCloudBaseImage.YandexVirtualizationSettings virtualizationSettings =
        new YandexCloudBaseImage.YandexVirtualizationSettings();
    virtualizationSettings.setSourceImageName(sourceImageName);
    virtualizationSettings.setSourceImageFamily(sourceImageFamily);
    baseImage.setVirtualizationSettings(virtualizationSettings);
    return baseImage;
  }
}

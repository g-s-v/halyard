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
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractEditBakeryDefaultsCommand;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.BakeryCommandProperties;
import com.netflix.spinnaker.halyard.config.model.v1.node.BakeryDefaults;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudBakeryDefaults;

@Parameters(separators = "=")
public class YandexEditBakeryDefaultsCommand
    extends AbstractEditBakeryDefaultsCommand<YandexCloudBakeryDefaults> {
  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Parameter(
      names = "--template-file",
      description = BakeryCommandProperties.TEMPLATE_FILE_DESCRIPTION)
  private String templateFile;

  @Parameter(names = "--zone", description = "Set the default zone your images will be baked in.")
  private String zone;

  @Override
  protected BakeryDefaults editBakeryDefaults(YandexCloudBakeryDefaults bakeryDefaults) {
    bakeryDefaults.setZone(isSet(zone) ? zone : bakeryDefaults.getZone());
    bakeryDefaults.setTemplateFile(
        isSet(templateFile) ? templateFile : bakeryDefaults.getTemplateFile());
    return bakeryDefaults;
  }
}

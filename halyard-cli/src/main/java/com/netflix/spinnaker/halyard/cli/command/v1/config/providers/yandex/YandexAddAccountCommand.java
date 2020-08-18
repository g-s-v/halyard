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
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.account.AbstractAddAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Account;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudAccount;

@Parameters(separators = "=")
public class YandexAddAccountCommand extends AbstractAddAccountCommand {
  @Parameter(
      names = "--account-type",
      description = YandexCommandProperties.ACCOUNT_TYPE_DESCRIPTION)
  private String accountType;

  @Parameter(names = "--json-path", description = YandexCommandProperties.JSON_PATH_DESCRIPTION)
  private String jsonPath;

  @Parameter(
      names = "--folder-id",
      description = YandexCommandProperties.FOLDER_ID_DESCRIPTION,
      required = true)
  private String folder;

  @Parameter(
      names = "--endpoint",
      description = YandexCommandProperties.ENDPOINT_DESCRIPTION,
      required = true)
  private String endpoint;

  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Override
  protected Account buildAccount(String accountName) {
    YandexCloudAccount account = (YandexCloudAccount) new YandexCloudAccount().setName(accountName);
    account.setFolder(folder).setJsonPath(jsonPath).setAccountType(accountType).setEndpoint(endpoint);
    return account;
  }

  @Override
  protected Account emptyAccount() {
    return new YandexCloudAccount();
  }
}

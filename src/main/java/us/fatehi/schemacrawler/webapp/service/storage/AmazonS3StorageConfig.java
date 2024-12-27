/*
========================================================================
SchemaCrawler
http://www.schemacrawler.com
Copyright (c) 2000-2025, Sualeh Fatehi <sualeh@hotmail.com>.
All rights reserved.
------------------------------------------------------------------------

SchemaCrawler is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

SchemaCrawler and the accompanying materials are made available under
the terms of the Eclipse Public License v1.0, GNU General Public License
v3 or GNU Lesser General Public License v3.

You may elect to redistribute this code under any of these licenses.

The Eclipse Public License is available at:
http://www.eclipse.org/legal/epl-v10.html

The GNU General Public License v3 and the GNU Lesser General Public
License v3 are available at:
http://www.gnu.org/licenses/

========================================================================
*/
package us.fatehi.schemacrawler.webapp.service.storage;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import jakarta.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import schemacrawler.schemacrawler.exceptions.InternalRuntimeException;
import com.azure.storage.common.StorageSharedKeyCredential;

@Configuration
@Profile("production")
public class AmazonS3StorageConfig {

  @Value("${CONTAINER_NAME}")
  @NotNull(message = "CONTAINER_NAME not provided")
  private String containerName;

  @Bean(name = "containerName")
  public String containerName() {
    if (StringUtils.isAnyBlank(containerName)) {
      throw new InternalRuntimeException("No Azure storage blob container name provided");
    }
    return containerName;
  }

  @Bean(name = "blobServiceClient")
  public BlobServiceClient blobServiceClient(
          @Qualifier("azureCredentials") StorageSharedKeyCredential azureCredentials,
          @Qualifier("endpoint") String endpoint
  ) {
    return new BlobServiceClientBuilder()
            .endpoint(endpoint)
            .credential(azureCredentials)
            .buildClient();
  }
}

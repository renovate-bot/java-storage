/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage.object;

// [START storage_list_soft_deleted_object_versions]
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class ListSoftDeletedVersionsOfObject {

  public static void listSoftDeletedVersionOfObject(
      String projectId, String bucketName, String objectName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The name of your GCS object
    // String objectName = "your-object-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Page<Blob> blobs =
        storage.list(
            bucketName,
            Storage.BlobListOption.softDeleted(true),
            // See https://cloud.google.com/storage/docs/json_api/v1/objects/list#matchGlob
            Storage.BlobListOption.matchGlob(objectName));

    for (Blob blob : blobs.iterateAll()) {
      System.out.println(blob.getName());
    }
  }
}
// [END storage_list_soft_deleted_object_versions]

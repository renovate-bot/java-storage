/*
 * Copyright 2020 Google LLC
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

package com.example.storage.bucket;

// [START storage_set_bucket_public_iam]
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.StorageRoles;

public class MakeBucketPublic {
  public static void makeBucketPublic(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Policy originalPolicy = storage.getIamPolicy(bucketName);
    storage.setIamPolicy(
        bucketName,
        originalPolicy.toBuilder()
            .addIdentity(StorageRoles.objectViewer(), Identity.allUsers()) // All users can view
            .build());

    System.out.println("Bucket " + bucketName + " is now publicly readable");
  }
}
// [END storage_set_bucket_public_iam]

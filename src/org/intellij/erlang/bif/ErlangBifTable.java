/*
 * Copyright 2012-2015 Sergey Ignatov
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

package org.intellij.erlang.bif;

import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.MultiMap;
import org.intellij.erlang.sdk.ErlangSdkRelease;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ErlangBifTable {

  public static final String MODULE_INFO = "module_info";

  private ErlangBifTable() {
  }

  @NotNull
  public static Collection<ErlangBifDescriptor> getBifs(@Nullable ErlangSdkRelease release, @NotNull String moduleName) {
    return getBifTableForRelease(release).get(moduleName);
  }

  @NotNull
  public static Collection<ErlangBifDescriptor> getAutoimportedBifs(@Nullable ErlangSdkRelease release, @NotNull String moduleName) {
    return ContainerUtil.filter(getBifTableForRelease(release).get(moduleName), ErlangBifDescriptor::isAutoImported);
  }

  @NotNull
  public static List<ErlangBifDescriptor> getBifs(@Nullable ErlangSdkRelease release, @NotNull String moduleName, @NotNull String functionName) {
    List<ErlangBifDescriptor> bifDescriptors = new ArrayList<>();
    for (ErlangBifDescriptor bifDescriptor : getBifTableForRelease(release).get(moduleName)) {
      if (functionName.equals(bifDescriptor.getName())) {
        bifDescriptors.add(bifDescriptor);
      }
    }
    return bifDescriptors;
  }

  @Nullable
  public static ErlangBifDescriptor getBif(@Nullable ErlangSdkRelease release, @NotNull String moduleName, @NotNull String functionName, int arity) {
    for (ErlangBifDescriptor bifDescriptor : getBifs(release, moduleName, functionName)) {
      if (arity == bifDescriptor.getArity()) {
        return bifDescriptor;
      }
    }
    return null;
  }


  public static boolean isBif(@Nullable ErlangSdkRelease release, @NotNull String moduleName, @NotNull String functionName, int arity) {
    Collection<ErlangBifDescriptor> erlangBifDescriptors = getBifTableForRelease(release).get(moduleName);
    for (ErlangBifDescriptor bifDescriptor : erlangBifDescriptors) {
      if (bifDescriptor.getModule().equals(moduleName) && bifDescriptor.getName().equals(functionName) &&
        bifDescriptor.getArity() == arity) {
        return true;
      }
    }
    return false;
  }

  private static MultiMap<String, ErlangBifDescriptor> getBifTableForRelease(@Nullable ErlangSdkRelease release) {
    if (release != null) {
      if (release.isNewerThan(ErlangSdkRelease.V_21_0))
        return Erlang22BifTable.getBif();
      if (release.isNewerThan(ErlangSdkRelease.V_20_0))
        return Erlang21BifTable.getBif();
      if (release.isNewerThan(ErlangSdkRelease.V_19_0))
        return Erlang20BifTable.getBif();
      }
    return Erlang19BifTable.getBif();
  }

}

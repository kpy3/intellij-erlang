/*
 * Copyright 2019 Serey Yelin
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

import com.intellij.util.containers.MultiMap;

public class Erlang22BifTable {
  private static final MultiMap<String, ErlangBifDescriptor> bifMap = Erlang21BifTable.getBif().copy();

  static {
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "is_map_key", 2, "Key, Map", true));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "is_map_key", 2, "Key, Map", true));
  }

  private Erlang22BifTable() {
  }

  public static MultiMap<String, ErlangBifDescriptor> getBif() {
    return bifMap;
  }

}

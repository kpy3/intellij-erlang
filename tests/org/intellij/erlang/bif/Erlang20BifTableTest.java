/*
 * Copyright 2019 Sergey Yelin
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

import com.intellij.testFramework.PlatformTestCase;
import com.intellij.util.containers.MultiMap;

public class Erlang20BifTableTest extends PlatformTestCase {

  public void testNoRemovedMethodsInBifTable()  {
    MultiMap<String, ErlangBifDescriptor> bif = Erlang20BifTable.getBif();
    assertDoesntContain(bif.get("erlang"), new ErlangBifDescriptor("erlang", "garbage_collect", 1, "Pid"));
    assertDoesntContain(bif.get("erts_internal"), new ErlangBifDescriptor("erts_internal", "check_process_code", 2, "Module, Flags", true));
    assertDoesntContain(bif.get("ets"), new ErlangBifDescriptor("ets", "internal_request_all", 0, ""));
  }

  public void testAddedMethodsExistInBifTable() {
    MultiMap<String, ErlangBifDescriptor> bif = Erlang20BifTable.getBif();
    assertContainsElements(bif.get("erlang"), new ErlangBifDescriptor("erlang", "list_to_port", 1, "String"));
    assertContainsElements(bif.get("erlang"), new ErlangBifDescriptor("erlang", "list_to_ref", 1, "String"));
    assertContainsElements(bif.get("ets"), new ErlangBifDescriptor("ets", "all", 0, ""));
  }

}

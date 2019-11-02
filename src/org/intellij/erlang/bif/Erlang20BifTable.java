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

public class Erlang20BifTable {
  private static final MultiMap<String, ErlangBifDescriptor> bifMap = Erlang19BifTable.getBif().copy();

  static {
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "garbage_collect", 1, "Pid"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "garbage_collect", 1, "Pid"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "list_to_port", 1, "String"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "list_to_ref", 1, "String"));
    bifMap.remove("erts_internal", new ErlangBifDescriptor("erts_internal", "check_process_code", 2, "Module, Flags", true));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "check_process_code", 1, "Module"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "request_system_task", 4, "RequesterPid, TargetPid, Prio, Request"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "release_literal_area_switch", 0, ""));
    bifMap.putValue("ets", new ErlangBifDescriptor("ets", "all", 0, ""));
    bifMap.remove("ets", new ErlangBifDescriptor("ets", "internal_request_all", 0, ""));
    bifMap.putValue("ets", new ErlangBifDescriptor("ets", "select_replace", 2, "Tab, MatchSpec"));
    bifMap.putValue("re", new ErlangBifDescriptor("re", "version", 0, ""));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "dirty_cpu", 2, "Term1, Term2"));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "dirty_io", 2, "Term1, Term2"));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "dirty", 3, "Term1, Term2, Term3"));
    bifMap.remove("string", new ErlangBifDescriptor("string", "to_integer", 1, "String"));
    bifMap.remove("string", new ErlangBifDescriptor("string", "to_float", 1, "String"));
    bifMap.putValue("string", new ErlangBifDescriptor("string", "list_to_integer", 1, "String"));
    bifMap.putValue("string", new ErlangBifDescriptor("string", "list_to_float", 1, "String"));
    bifMap.remove("erts_internal", new ErlangBifDescriptor("erts_internal", "purge_module", 2, "Module, Op"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "purge_module", 1, "Module"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "is_process_executing_dirty", 1, "Pid"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "check_dirty_process_code", 2, "Pid, Module"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "hash", 2, "Term, Range"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "floor", 1, "Number"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "ceil", 1, "Number"));
    bifMap.remove("math", new ErlangBifDescriptor("math", "floor", 1, "Number"));
    bifMap.remove("math", new ErlangBifDescriptor("math", "ceil", 1, "Number"));
    bifMap.remove("math", new ErlangBifDescriptor("math", "fmod", 2, "X, Y"));
    bifMap.remove("os", new ErlangBifDescriptor("os", "set_signal", 2, "Signal, Option"));
    bifMap.remove("erts_internal", new ErlangBifDescriptor("erts_internal", "maps_to_list", 2, "M, N"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "iolist_to_iovec", 1, "IOList"));
  }

  private Erlang20BifTable() {
  }

  public static MultiMap<String, ErlangBifDescriptor> getBif() {
    return bifMap;
  }

}

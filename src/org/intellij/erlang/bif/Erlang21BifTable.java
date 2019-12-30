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

public class Erlang21BifTable {
  private static final MultiMap<String, ErlangBifDescriptor> bifMap = Erlang20BifTable.getBif().copy();

  static {
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "exit_signal", 2, "Pid, Reason"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "group_leader", 2, "GroupLeader, Pid"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "group_leader", 3, "GroupLeader, Pid, Reference"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "group_leader", 2, "GroupLeader, Pid"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "group_leader", 3, "GroupLeader, Pid, Reference"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "process_flag", 3, "Pid, Flag, Value", true));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "process_flag", 3, "Pid, Flag, Value", true));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "setnode", 2, "P1, P2"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "dist_exit", 3, "P1, P2, P3"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "dist_get_stat", 1, "DHandle"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "dist_ctrl_input_handler", 2, "DHandle, InputHandler"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "dist_ctrl_put_data", 2, "DHandle, Data"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "dist_ctrl_get_data", 1, "DHandle"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "dist_ctrl_get_data", 1, "DHandle"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "scheduler_wall_time", 1, "Enable"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "dirty_process_handle_signals", 1, "Pid"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "create_dist_channel", 4, "Node, DistCtrlr, Flags, Ver"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "suspend_process", 2, "Suspendee, OptList"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "suspend_process", 2, "Suspendee, OptList"));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "process_display", 2, "Pid, Type"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "process_display", 2, "Pid, Type"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "is_process_alive", 2, "Pid, Ref"));
    bifMap.remove("ets", new ErlangBifDescriptor("ets", "delete_all_objects", 1, "Tab"));
    bifMap.remove("ets", new ErlangBifDescriptor("ets", "select_delete", 2, "Tab, MatchSpec"));
    bifMap.remove("os", new ErlangBifDescriptor("os", "putenv", 2, "VarName, Value"));
    bifMap.remove("os", new ErlangBifDescriptor("os", "getenv", 0, ""));
    bifMap.remove("os", new ErlangBifDescriptor("os", "getenv", 1, "VarName"));
    bifMap.putValue("os", new ErlangBifDescriptor("os", "get_env_var", 1, "VarName"));
    bifMap.putValue("os", new ErlangBifDescriptor("os", "set_env_var", 2, "VarName, Value"));
    bifMap.putValue("os", new ErlangBifDescriptor("os", "unset_env_var", 1, "VarName"));
    bifMap.putValue("os", new ErlangBifDescriptor("os", "list_env_vars", 0, ""));
    bifMap.remove("erts_debug", new ErlangBifDescriptor("erts_debug", "lock_counters", 1, "P1"));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "lcnt_control", 2, "Option, Value"));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "lcnt_control", 1, "Option"));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "lcnt_collect", 0, ""));
    bifMap.putValue("erts_debug", new ErlangBifDescriptor("erts_debug", "lcnt_clear", 0, ""));
    bifMap.remove("binary", new ErlangBifDescriptor("binary", "bin_to_list", 1, "Subject"));
    bifMap.remove("binary", new ErlangBifDescriptor("binary", "bin_to_list", 2, "Subject, PosLen"));
    bifMap.remove("binary", new ErlangBifDescriptor("binary", "bin_to_list", 3, "Subject, Pos, Len"));
    bifMap.remove("os", new ErlangBifDescriptor("os", "unsetenv", 1, "VarName"));
    bifMap.remove("maps", new ErlangBifDescriptor("maps", "to_list", 1, "Map"));
    // Since 21

    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "get_dflags", 0, ""));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "new_connection", 1, "Node"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "abort_connection", 2, "Node, ConnId"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "map_next", 3, "I, M, A"));

    bifMap.putValue("ets", new ErlangBifDescriptor("ets", "whereis", 1, "TableName"));

    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "gather_alloc_histograms", 1, "{Type, SchedId, HistWidth, HistStart, Ref}"));
    bifMap.putValue("erts_internal", new ErlangBifDescriptor("erts_internal", "gather_carrier_info", 1, "{Type, SchedId, HistWidth, HistStart, Ref}"));

    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "map_get", 2, "Key, Map"));
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "is_map_key", 2, "Key, Map"));
    bifMap.putValue("ets", new ErlangBifDescriptor("ets", "internal_delete_all", 2, "Tab, undefined"));
    bifMap.putValue("ets", new ErlangBifDescriptor("ets", "internal_select_delete", 2, "Tab, MatchSpec"));

  }

  private Erlang21BifTable() {
  }

  public static MultiMap<String, ErlangBifDescriptor> getBif() {
    return bifMap;
  }

}

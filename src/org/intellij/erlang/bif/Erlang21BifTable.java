package org.intellij.erlang.bif;

import com.intellij.util.containers.MultiMap;

public class Erlang21BifTable {
  private static final MultiMap<String, ErlangBifDescriptor> bifMap = Erlang20BifTable.getBif().copy();

  static {
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "is_map_key", 2, "Key, Map", true));
    bifMap.remove("erlang", new ErlangBifDescriptor("erlang", "is_map_key", 2, "Key, Map", true));
  }

  private Erlang21BifTable() {
  }

  public static MultiMap<String, ErlangBifDescriptor> getBif() {
    return bifMap;
  }

}

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

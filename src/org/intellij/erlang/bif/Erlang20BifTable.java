package org.intellij.erlang.bif;

import com.intellij.util.containers.MultiMap;

public class Erlang20BifTable {
  private static final MultiMap<String, ErlangBifDescriptor> bifMap = Erlang19BifTable.getBif().copy();

  static {
    bifMap.putValue("erlang", new ErlangBifDescriptor("erlang", "floor", 1, "Number", true));

  }

  private Erlang20BifTable() {
  }

  public static MultiMap<String, ErlangBifDescriptor> getBif() {
    return bifMap;
  }

}

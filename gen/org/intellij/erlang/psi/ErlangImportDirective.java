// This is a generated file. Not intended for manual editing.
package org.intellij.erlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ErlangImportDirective extends ErlangMetaAttribute {

  @Nullable
  ErlangImportFunctions getImportFunctions();

  @Nullable
  ErlangModuleRef getModuleRef();

  @Nullable
  PsiElement getComma();

  @Nullable
  PsiElement getParLeft();

  @Nullable
  PsiElement getParRight();

}

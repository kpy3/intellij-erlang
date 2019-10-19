/*
 * Copyright 2012-2014 Sergey Ignatov
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

package org.intellij.erlang.inspection;

import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import org.intellij.erlang.bif.ErlangBifDescriptor;
import org.intellij.erlang.bif.ErlangBifTable;
import org.intellij.erlang.psi.ErlangFile;
import org.intellij.erlang.psi.ErlangFunctionCallExpression;
import org.intellij.erlang.psi.ErlangGlobalFunctionCallExpression;
import org.intellij.erlang.psi.ErlangVisitor;
import org.intellij.erlang.quickfixes.ErlangSpecifyModulePrefixFix;
import org.intellij.erlang.sdk.ErlangSdkRelease;
import org.intellij.erlang.sdk.ErlangSdkType;
import org.jetbrains.annotations.NotNull;

public class ErlangAmbiguousCallOfAutoImportedFunctionInspection extends ErlangInspectionBase {
  @Override
  protected boolean canRunOn(@NotNull ErlangFile file) {
    if (file.isNoAutoImportAll()) return false;
    ErlangSdkRelease release = ErlangSdkType.getRelease(file);
    return release == null || release.isNewerThan(ErlangSdkRelease.V_R14A);
  }

  @NotNull
  protected ErlangVisitor buildErlangVisitor(@NotNull final ProblemsHolder holder,
                                             @NotNull LocalInspectionToolSession session) {
    return new ErlangVisitor() {
      @Override
      public void visitFunctionCallExpression(@NotNull ErlangFunctionCallExpression o) {
        if (o.getParent() instanceof ErlangGlobalFunctionCallExpression) return;
        if (o.getQAtom().getMacros() != null) return;
        String name = o.getName();
        int arity = o.getArgumentList().getExpressionList().size();
        ErlangFile containingFile = (ErlangFile) o.getContainingFile();
        ErlangSdkRelease release = ErlangSdkType.getRelease(containingFile);
        ErlangBifDescriptor bifDescriptor = ErlangBifTable.getBif(release, "erlang", name, arity);
        if (bifDescriptor == null
          || !bifDescriptor.isAutoImported()
          || containingFile.isNoAutoImport(name, arity)
          || containingFile.getFunction(name, arity) == null) {
          return;
        }
        holder.registerProblem(o.getNameIdentifier(),
          "Ambiguous call of overridden pre R14 auto-imported BIF " + "'" + name + "/" + arity + "'",
          ProblemHighlightType.GENERIC_ERROR_OR_WARNING,
          new ErlangSpecifyModulePrefixFix("erlang"));
      }
    };
  }
}


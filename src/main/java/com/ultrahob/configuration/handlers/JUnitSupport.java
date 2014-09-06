package com.ultrahob.configuration.handlers;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

/**
 * @author Victor Rosenberg, 10.05.2014 18:30
 */
@SuppressWarnings("ComponentNotRegistered")
public class JUnitSupport extends com.ultrahob.configuration.handlers.BaseConfigurationHelper {

    @NotNull
    public String getComponentName() {
        return "com.ultrahob.configuration.handlers.JUnitSupport";
    }

    @Override
    public boolean canHandle(RunConfiguration configuration, Project project) {
        if (!(configuration instanceof JUnitConfiguration)) {
            return false;
        } else {
            JUnitConfiguration.Data data = ((JUnitConfiguration) configuration).getPersistentData();

            String mainClassName = data.getMainClassName();
            String methodName = data.getMethodName();

            JavaPsiFacade psiFacade = JavaPsiFacade.getInstance(project);
            PsiClass referencedClass = psiFacade.findClass(mainClassName, GlobalSearchScope.allScope(project));
            PsiFile containingFile = referencedClass.getContainingFile();

            FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
            if (methodName == null) {
                fileEditorManager.openFile(containingFile.getVirtualFile(), true);
            } else {
                PsiMethod[] methodsByName = referencedClass.findMethodsByName(methodName, false);

                fileEditorManager.openEditor(new OpenFileDescriptor(project, containingFile.getVirtualFile(), methodsByName[0].getTextOffset()), true);
            }
            return true;
        }
    }
}

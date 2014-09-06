package com.ultrahob.configuration;

import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.SingleClassConfiguration;
import com.intellij.execution.configurations.ModuleBasedConfiguration;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.execution.junit.JUnitConfiguration;
import com.intellij.execution.junit.JUnitUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;

/**
 * @author Victor Rosenberg, 10.05.2014 13:35
 */
public class JumpToConfigurationAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {

        Project project = e.getProject();
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);

        RunnerAndConfigurationSettings selectedConfiguration = RunManager.getInstance(project).getSelectedConfiguration();
        if (selectedConfiguration != null) {
            RunConfiguration configuration = selectedConfiguration.getConfiguration();

            if (ConfigurationManager.getInstance().tryHandling(configuration, project)) {
                return;
            }

            if (configuration instanceof SingleClassConfiguration) {
                PsiClass mainClass = ((SingleClassConfiguration) configuration).getMainClass();
                fileEditorManager.openFile(mainClass.getContainingFile().getVirtualFile(), true);
            }
        }

    }
}

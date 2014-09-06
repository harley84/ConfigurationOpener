package com.ultrahob.configuration.handlers;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.execution.MavenRunConfiguration;

import java.io.File;

/**
 * @author Victor Rosenberg, 11.05.2014 21:39
 */
@SuppressWarnings("ComponentNotRegistered")
public class MavenSupport extends BaseConfigurationHelper {
    @Override
    public boolean canHandle(RunConfiguration configuration, Project project) {
        if (!(configuration instanceof org.jetbrains.idea.maven.execution.MavenRunConfiguration)) {
            return false;
        } else {
//            VirtualFile file = LocalFileFinder.findFile(new File(workingDirFile, "pom.xml").getPath());
//            PsiFile psiFile = PsiManager.getInstance(project).findFile(pomVirtualFile);
            File workingDirFile = ((MavenRunConfiguration) configuration).getRunnerParameters().getWorkingDirFile();
            VirtualFile pomVirtualFile = LocalFileSystem.getInstance().findFileByPath(new File(workingDirFile, "pom.xml").getPath().replace(File.separatorChar, '/'));
            FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
            fileEditorManager.openFile(pomVirtualFile, true);
            return true;
        }
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "com.ultrahob.configuration.handlers.MavenSupport";
    }
}

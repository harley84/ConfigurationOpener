package com.ultrahob.configuration;

import com.intellij.ide.SelectInContext;
import com.intellij.ide.SelectInTarget;
import org.jetbrains.annotations.Nullable;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 9/6/14
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectInTargetImpl implements SelectInTarget {
    @Override
    public boolean canSelect(SelectInContext selectInContext) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void selectIn(SelectInContext selectInContext, boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Nullable
    @Override
    public String getToolWindowId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Nullable
    @Override
    public String getMinorViewId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public float getWeight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

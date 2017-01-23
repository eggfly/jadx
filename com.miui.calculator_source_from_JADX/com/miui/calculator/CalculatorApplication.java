package com.miui.calculator;

import android.content.Context;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.support.external.Application;
import com.miui.support.external.ApplicationDelegate;

public class CalculatorApplication extends Application {
    private static volatile Context f1300a;

    private class CalculatorAppDelegate extends ApplicationDelegate {
        final /* synthetic */ CalculatorApplication f1297a;

        private CalculatorAppDelegate(CalculatorApplication calculatorApplication) {
            this.f1297a = calculatorApplication;
        }

        public void m2547a() {
            super.m2544a();
            StatisticUtils.m2888a(this.f1297a);
        }
    }

    public ApplicationDelegate m2560a() {
        f1300a = this;
        return new CalculatorAppDelegate();
    }

    public static Context m2559b() {
        return f1300a;
    }
}

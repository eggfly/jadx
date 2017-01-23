package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import com.mob.tools.FakeActivity;

/* renamed from: cn.sharesdk.framework.authorize.a */
public class C0936a extends FakeActivity {
    protected AuthorizeHelper f3194a;

    public AuthorizeHelper m4117a() {
        return this.f3194a;
    }

    public void m4118a(AuthorizeHelper authorizeHelper) {
        this.f3194a = authorizeHelper;
        super.show(authorizeHelper.getPlatform().getContext(), null);
    }

    public void show(Context context, Intent intent) {
        throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
    }
}

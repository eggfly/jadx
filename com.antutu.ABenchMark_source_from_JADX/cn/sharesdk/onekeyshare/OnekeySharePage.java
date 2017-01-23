package cn.sharesdk.onekeyshare;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.FakeActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class OnekeySharePage extends FakeActivity {
    private OnekeyShareThemeImpl impl;

    public OnekeySharePage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.impl = onekeyShareThemeImpl;
    }

    protected final ShareParams formateShareData(Platform platform) {
        return this.impl.formateShareData(platform) ? this.impl.shareDataToShareParams(platform) : null;
    }

    protected final PlatformActionListener getCallback() {
        return this.impl.callback;
    }

    protected final ArrayList<CustomerLogo> getCustomerLogos() {
        return this.impl.customerLogos;
    }

    protected final ShareContentCustomizeCallback getCustomizeCallback() {
        return this.impl.customizeCallback;
    }

    protected final HashMap<String, String> getHiddenPlatforms() {
        return this.impl.hiddenPlatforms;
    }

    protected final HashMap<String, Object> getShareParamsMap() {
        return this.impl.shareParamsMap;
    }

    protected final boolean isDialogMode() {
        return this.impl.dialogMode;
    }

    protected final boolean isDisableSSO() {
        return this.impl.disableSSO;
    }

    protected final boolean isSilent() {
        return this.impl.silent;
    }

    protected final boolean isUseClientToShare(Platform platform) {
        return this.impl.isUseClientToShare(platform);
    }

    protected final void shareSilently(Platform platform) {
        this.impl.shareSilently(platform);
    }
}

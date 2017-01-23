package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand;
import cn.sharesdk.onekeyshare.themes.classic.land.PlatformPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.EditPagePort;
import cn.sharesdk.onekeyshare.themes.classic.port.PlatformPagePort;

public class ClassicTheme extends OnekeyShareThemeImpl {
    protected void showEditPage(Context context, Platform platform, ShareParams shareParams) {
        EditPage editPagePort = context.getResources().getConfiguration().orientation == 1 ? new EditPagePort(this) : new EditPageLand(this);
        editPagePort.setPlatform(platform);
        editPagePort.setShareParams(shareParams);
        editPagePort.show(context, null);
    }

    protected void showPlatformPage(Context context) {
        (context.getResources().getConfiguration().orientation == 1 ? new PlatformPagePort(this) : new PlatformPageLand(this)).show(context, null);
    }
}

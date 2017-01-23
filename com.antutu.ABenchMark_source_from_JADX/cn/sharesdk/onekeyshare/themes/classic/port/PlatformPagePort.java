package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import java.util.ArrayList;

public class PlatformPagePort extends PlatformPage {
    public PlatformPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    protected PlatformPageAdapter newAdapter(ArrayList<Object> arrayList) {
        return new PlatformPageAdapterPort(this, arrayList);
    }

    public void onCreate() {
        requestPortraitOrientation();
        super.onCreate();
    }
}

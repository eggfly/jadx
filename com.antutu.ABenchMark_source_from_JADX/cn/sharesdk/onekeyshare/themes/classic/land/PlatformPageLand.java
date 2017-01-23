package cn.sharesdk.onekeyshare.themes.classic.land;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import java.util.ArrayList;

public class PlatformPageLand extends PlatformPage {
    public PlatformPageLand(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    protected PlatformPageAdapter newAdapter(ArrayList<Object> arrayList) {
        return new PlatformPageAdapterLand(this, arrayList);
    }

    public void onCreate() {
        requestLandscapeOrientation();
        super.onCreate();
    }
}

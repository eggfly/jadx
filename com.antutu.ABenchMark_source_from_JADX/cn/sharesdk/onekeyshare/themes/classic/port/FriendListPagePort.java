package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.C4021R;

public class FriendListPagePort extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_TITLE_HEIGHT = 96;

    public FriendListPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    protected int getDesignTitleHeight() {
        return DESIGN_TITLE_HEIGHT;
    }

    protected float getRatio() {
        return ((float) C4021R.getScreenWidth(this.activity)) / 720.0f;
    }
}

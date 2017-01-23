package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.igexin.download.Downloads;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;

public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    private FriendListPage activity;
    private int curPage;
    private ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount;
    private Platform platform;
    private float ratio;

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.1 */
    class C09851 implements Callback {
        C09851() {
        }

        public boolean handleMessage(Message message) {
            FriendAdapter.this.notifyDataSetChanged();
            return false;
        }
    }

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.2 */
    class C09862 implements Callback {
        final /* synthetic */ FollowersResult val$followersResult;

        C09862(FollowersResult followersResult) {
            this.val$followersResult = followersResult;
        }

        public boolean handleMessage(Message message) {
            if (FriendAdapter.this.curPage <= 0) {
                FriendAdapter.this.follows.clear();
            }
            FriendAdapter.this.follows.addAll(this.val$followersResult.list);
            FriendAdapter.this.notifyDataSetChanged();
            return false;
        }
    }

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.3 */
    class C09873 implements Callback {
        C09873() {
        }

        public boolean handleMessage(Message message) {
            FriendAdapter.this.activity.finish();
            return false;
        }
    }

    private static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.pageCount = 15;
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap();
        this.follows = new ArrayList();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, null);
        }
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> hashMap, HashMap<String, Boolean> hashMap2) {
        boolean z = false;
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it;
        HashMap hashMap3;
        String valueOf;
        Following following;
        if ("SinaWeibo".equals(str)) {
            it = ((ArrayList) hashMap.get("users")).iterator();
            while (it.hasNext()) {
                hashMap3 = (HashMap) it.next();
                valueOf = String.valueOf(hashMap3.get(AgooConstants.MESSAGE_ID));
                if (!hashMap2.containsKey(valueOf)) {
                    following = new Following();
                    following.uid = valueOf;
                    following.screenName = String.valueOf(hashMap3.get("name"));
                    following.description = String.valueOf(hashMap3.get(Downloads.COLUMN_DESCRIPTION));
                    following.icon = String.valueOf(hashMap3.get("profile_image_url"));
                    following.atName = following.screenName;
                    hashMap2.put(following.uid, Boolean.valueOf(true));
                    arrayList.add(following);
                }
            }
            z = ((Integer) hashMap.get("total_number")).intValue() > hashMap2.size();
        } else if ("TencentWeibo".equals(str)) {
            boolean z2 = ((Integer) hashMap.get("hasnext")).intValue() == 0;
            Iterator it2 = ((ArrayList) hashMap.get("info")).iterator();
            while (it2.hasNext()) {
                hashMap3 = (HashMap) it2.next();
                String valueOf2 = String.valueOf(hashMap3.get("name"));
                if (!hashMap2.containsKey(valueOf2)) {
                    following = new Following();
                    following.screenName = String.valueOf(hashMap3.get("nick"));
                    following.uid = valueOf2;
                    following.atName = valueOf2;
                    r1 = ((ArrayList) hashMap3.get("tweet")).iterator();
                    if (r1.hasNext()) {
                        following.description = String.valueOf(((HashMap) r1.next()).get("text"));
                    }
                    following.icon = String.valueOf(hashMap3.get("head")) + "/100";
                    hashMap2.put(following.uid, Boolean.valueOf(true));
                    arrayList.add(following);
                }
            }
            z = z2;
        } else if ("Facebook".equals(str)) {
            r1 = ((ArrayList) hashMap.get(Constants.KEY_DATA)).iterator();
            while (r1.hasNext()) {
                hashMap3 = (HashMap) r1.next();
                String valueOf3 = String.valueOf(hashMap3.get(AgooConstants.MESSAGE_ID));
                if (!hashMap2.containsKey(valueOf3)) {
                    Following following2 = new Following();
                    following2.uid = valueOf3;
                    following2.atName = "[" + valueOf3 + "]";
                    following2.screenName = String.valueOf(hashMap3.get("name"));
                    hashMap3 = (HashMap) hashMap3.get("picture");
                    if (hashMap3 != null) {
                        following2.icon = String.valueOf(((HashMap) hashMap3.get(Constants.KEY_DATA)).get("url"));
                    }
                    hashMap2.put(following2.uid, Boolean.valueOf(true));
                    arrayList.add(following2);
                }
            }
            z = ((HashMap) hashMap.get("paging")).containsKey("next");
        } else if ("Twitter".equals(str)) {
            it = ((ArrayList) hashMap.get("users")).iterator();
            while (it.hasNext()) {
                hashMap3 = (HashMap) it.next();
                valueOf = String.valueOf(hashMap3.get("screen_name"));
                if (!hashMap2.containsKey(valueOf)) {
                    following = new Following();
                    following.uid = valueOf;
                    following.atName = valueOf;
                    following.screenName = String.valueOf(hashMap3.get("name"));
                    following.description = String.valueOf(hashMap3.get(Downloads.COLUMN_DESCRIPTION));
                    following.icon = String.valueOf(hashMap3.get("profile_image_url"));
                    hashMap2.put(following.uid, Boolean.valueOf(true));
                    arrayList.add(following);
                }
            }
        }
        FollowersResult followersResult = new FollowersResult();
        followersResult.list = arrayList;
        followersResult.hasNextPage = z;
        return followersResult;
    }

    public int getCount() {
        return this.follows == null ? 0 : this.follows.size();
    }

    public View getFooterView() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }

    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    public Following getItem(int i) {
        return (Following) this.follows.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View friendListItem = view == null ? new FriendListItem(viewGroup.getContext(), this.ratio) : view;
        ((FriendListItem) friendListItem).update(getItem(i), isFling());
        if (i == getCount() - 1) {
            next();
        }
        return friendListItem;
    }

    public void onCancel(Platform platform, int i) {
        UIHandler.sendEmptyMessage(0, new C09873());
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        FollowersResult parseFollowers = parseFollowers(this.platform.getName(), hashMap, this.map);
        if (parseFollowers == null) {
            UIHandler.sendEmptyMessage(0, new C09851());
            return;
        }
        this.hasNext = parseFollowers.hasNextPage;
        if (parseFollowers.list != null && parseFollowers.list.size() > 0) {
            this.curPage++;
            Message message = new Message();
            message.what = 1;
            message.obj = parseFollowers.list;
            UIHandler.sendMessage(message, new C09862(parseFollowers));
        }
    }

    public void onError(Platform platform, int i, Throwable th) {
        th.printStackTrace();
    }

    public void onPullDown(int i) {
        this.llHeader.onPullDown(i);
    }

    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    public void onReversed() {
        this.llHeader.reverse();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
        platform.setPlatformActionListener(this);
    }

    public void setRatio(float f) {
        this.ratio = f;
        ListView listView = getListView();
        if (f < 1.0f) {
            f = 1.0f;
        }
        listView.setDividerHeight((int) f);
    }
}

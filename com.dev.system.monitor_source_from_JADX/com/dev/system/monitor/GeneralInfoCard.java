package com.dev.system.monitor;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.prototypes.CardWithList;
import it.gmariotti.cardslib.library.prototypes.CardWithList.DefaultListObject;
import it.gmariotti.cardslib.library.prototypes.CardWithList.ListObject;
import java.util.ArrayList;
import java.util.List;

public class GeneralInfoCard extends CardWithList {
    private Context context;
    private ArrayList<String> info;
    private ArrayList<TextView> infoTextViews;
    private String title;
    private ArrayList<String> value;

    /* renamed from: com.dev.system.monitor.GeneralInfoCard.1 */
    class C01191 implements OnLongClickListener {
        final /* synthetic */ TextView val$valueText;

        C01191(TextView textView) {
            this.val$valueText = textView;
        }

        public boolean onLongClick(View v) {
            ((ClipboardManager) GeneralInfoCard.this.context.getSystemService("clipboard")).setText(this.val$valueText.getText().toString());
            Toast.makeText(GeneralInfoCard.this.context, "Copied to clipboard", 0).show();
            return false;
        }
    }

    public class InfoObject extends DefaultListObject {
        public String info;
        public String value;

        public InfoObject(Card parentCard) {
            super(parentCard);
            init();
        }

        private void init() {
        }
    }

    public GeneralInfoCard(Context context, ArrayList<String> info, ArrayList<String> value, String title) {
        super(context);
        this.info = info;
        this.value = value;
        this.title = title;
        this.context = context;
        this.infoTextViews = new ArrayList();
    }

    protected CardHeader initCardHeader() {
        CardHeader header = new CardHeader(getContext(), C0133R.layout.card_general_info_inner_header);
        header.setTitle(this.title);
        return header;
    }

    protected void initCard() {
    }

    protected List<ListObject> initChildren() {
        List<ListObject> mObjects = new ArrayList();
        for (int i = 0; i < this.info.size(); i++) {
            InfoObject infoObject = new InfoObject(this);
            infoObject.info = (String) this.info.get(i);
            infoObject.value = (String) this.value.get(i);
            mObjects.add(infoObject);
        }
        return mObjects;
    }

    public View setupChildView(int childPosition, ListObject object, View convertView, ViewGroup parent) {
        TextView valueText = (TextView) convertView.findViewById(C0133R.id.card_info_value);
        InfoObject infoObject = (InfoObject) object;
        ((TextView) convertView.findViewById(C0133R.id.card_info_title)).setText(infoObject.info);
        valueText.setText(infoObject.value);
        this.infoTextViews.add(valueText);
        convertView.setOnLongClickListener(new C01191(valueText));
        return convertView;
    }

    public int getChildLayoutId() {
        return C0133R.layout.card_general_info_inner_main;
    }

    ArrayList<String> getInfo() {
        return this.info;
    }

    ArrayList<String> getValue() {
        return this.value;
    }

    ArrayList<TextView> getTextViews() {
        return this.infoTextViews;
    }
}

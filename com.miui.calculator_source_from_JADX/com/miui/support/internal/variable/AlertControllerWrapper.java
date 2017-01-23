package com.miui.support.internal.variable;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.android.internal.app.AlertController;
import com.miui.support.internal.app.AlertControllerImpl;
import java.util.ArrayList;

public class AlertControllerWrapper extends AlertController {
    AlertControllerImpl mAlertControllerImpl;

    public static class AlertParams extends com.android.internal.app.AlertController.AlertParams {
        public ArrayList<ActionItem> mActionItems;
        public CharSequence mCheckBoxMessage;
        public boolean mEditMode;
        public boolean mIsChecked;
        public OnClickListener mOnActionItemClickListener;
        public OnDismissListener mOnDismissListener;
        public OnShowListener mOnShowListener;

        /* renamed from: com.miui.support.internal.variable.AlertControllerWrapper.AlertParams.1 */
        class C02911 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView val$listView;

            C02911(Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
                this.val$listView = listView;
                super(context, i, i2, charSequenceArr);
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (!(AlertParams.this.mEditMode || AlertParams.this.mCheckedItems == null || !AlertParams.this.mCheckedItems[i])) {
                    this.val$listView.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: com.miui.support.internal.variable.AlertControllerWrapper.AlertParams.2 */
        class C02922 extends CursorAdapter {
            private final int mIsCheckedIndex;
            private final int mLabelIndex;
            final /* synthetic */ int val$layout;
            final /* synthetic */ ListView val$listView;

            C02922(Context context, Cursor cursor, boolean z, ListView listView, int i) {
                this.val$listView = listView;
                this.val$layout = i;
                super(context, cursor, z);
                Cursor cursor2 = getCursor();
                this.mLabelIndex = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                this.mIsCheckedIndex = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.mLabelIndex));
                if (!AlertParams.this.mEditMode) {
                    this.val$listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
                }
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.mInflater.inflate(this.val$layout, null);
            }
        }

        /* renamed from: com.miui.support.internal.variable.AlertControllerWrapper.AlertParams.3 */
        class C02933 implements OnItemClickListener {
            final /* synthetic */ AlertControllerImpl val$impl;

            C02933(AlertControllerImpl alertControllerImpl) {
                this.val$impl = alertControllerImpl;
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AlertParams.this.mOnClickListener.onClick(this.val$impl.m3781k(), i);
                if (!AlertParams.this.mIsSingleChoice) {
                    this.val$impl.m3781k().dismiss();
                }
            }
        }

        /* renamed from: com.miui.support.internal.variable.AlertControllerWrapper.AlertParams.4 */
        class C02944 implements OnItemClickListener {
            final /* synthetic */ AlertControllerImpl val$impl;
            final /* synthetic */ ListView val$listView;

            C02944(ListView listView, AlertControllerImpl alertControllerImpl) {
                this.val$listView = listView;
                this.val$impl = alertControllerImpl;
            }

            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                if (AlertParams.this.mCheckedItems != null) {
                    AlertParams.this.mCheckedItems[i] = this.val$listView.isItemChecked(i);
                }
                AlertParams.this.mOnCheckboxClickListener.onClick(this.val$impl.m3781k(), i, this.val$listView.isItemChecked(i));
            }
        }

        public static class ActionItem {
            public int icon;
            public int id;
            public CharSequence label;

            public ActionItem(CharSequence charSequence, int i, int i2) {
                this.label = charSequence;
                this.icon = i;
                this.id = i2;
            }
        }

        public AlertParams(Context context) {
            super(context);
        }

        public void apply(AlertController alertController) {
            if (this.mCustomTitleView != null) {
                alertController.setCustomTitle(this.mCustomTitleView);
            } else if (this.mTitle != null) {
                alertController.setTitle(this.mTitle);
            }
            if (this.mIcon != null) {
                alertController.setIcon(this.mIcon);
            }
            if (this.mIconId != 0) {
                alertController.setIcon(this.mIconId);
            }
            if (this.mMessage != null) {
                alertController.setMessage(this.mMessage);
            }
            if (this.mCheckBoxMessage != null) {
                ((AlertControllerWrapper) alertController).getImpl().m3761a(this.mIsChecked, this.mCheckBoxMessage);
            }
            if (this.mPositiveButtonText != null) {
                alertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null);
            }
            if (this.mNegativeButtonText != null) {
                alertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null);
            }
            if (this.mNeutralButtonText != null) {
                alertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                createListView(alertController);
            }
            if (this.mView != null) {
                alertController.setView(this.mView);
            }
            if (this.mActionItems != null) {
                ((AlertControllerWrapper) alertController).getImpl().m3760a(this.mActionItems, this.mOnActionItemClickListener);
            }
        }

        private ListAdapter createMultiChoiceListAdapter(ListView listView, int i) {
            if (this.mCursor != null) {
                return new C02922(this.mContext, this.mCursor, false, listView, i);
            }
            if (this.mEditMode && this.mAdapter != null) {
                return this.mAdapter;
            }
            return new C02911(this.mContext, i, 16908308, this.mItems, listView);
        }

        private ListAdapter createListAdapter(int i) {
            if (this.mCursor == null) {
                return this.mAdapter != null ? this.mAdapter : new ArrayAdapter(this.mContext, i, 16908308, this.mItems);
            } else {
                return new SimpleCursorAdapter(this.mContext, i, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
            }
        }

        private void createListView(AlertController alertController) {
            AlertControllerImpl impl = ((AlertControllerWrapper) alertController).getImpl();
            ListView listView = (ListView) this.mInflater.inflate(impl.m3774d(), null);
            if (listView != null) {
                ListAdapter createMultiChoiceListAdapter;
                if (this.mIsMultiChoice) {
                    createMultiChoiceListAdapter = createMultiChoiceListAdapter(listView, impl.m3777g());
                } else {
                    int f;
                    if (this.mIsSingleChoice) {
                        f = impl.m3776f();
                    } else {
                        f = impl.m3775e();
                    }
                    createMultiChoiceListAdapter = createListAdapter(f);
                }
                impl.m3757a(createMultiChoiceListAdapter);
                impl.m3771c(this.mCheckedItem);
                impl.m3762a(this.mCheckedItems);
                if (this.mOnClickListener != null) {
                    listView.setOnItemClickListener(new C02933(impl));
                } else if (this.mOnCheckboxClickListener != null) {
                    listView.setOnItemClickListener(new C02944(listView, impl));
                }
                if (this.mOnItemSelectedListener != null) {
                    listView.setOnItemSelectedListener(this.mOnItemSelectedListener);
                }
                if (this.mIsSingleChoice) {
                    listView.setChoiceMode(1);
                } else if (this.mIsMultiChoice) {
                    listView.setChoiceMode(2);
                }
                impl.m3758a(listView);
            }
        }
    }

    public AlertControllerWrapper(Context context, DialogInterface dialogInterface, Window window) {
        super(context, dialogInterface, window);
        this.mAlertControllerImpl = new AlertControllerImpl(context, dialogInterface, window);
    }

    public AlertControllerImpl getImpl() {
        return this.mAlertControllerImpl;
    }

    public void installContent() {
        this.mAlertControllerImpl.m3753a();
    }

    public void setTitle(CharSequence charSequence) {
        this.mAlertControllerImpl.m3759a(charSequence);
    }

    public void setCustomTitle(View view) {
        this.mAlertControllerImpl.m3767b(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlertControllerImpl.m3768b(charSequence);
    }

    public TextView getMessageView() {
        return this.mAlertControllerImpl.m3778h();
    }

    public void setView(View view) {
        this.mAlertControllerImpl.m3772c(view);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener, Message message) {
        this.mAlertControllerImpl.m3755a(i, charSequence, onClickListener, message);
    }

    public void setIcon(Drawable drawable) {
        this.mAlertControllerImpl.m3756a(drawable);
    }

    public void setIcon(int i) {
        this.mAlertControllerImpl.m3754a(i);
    }

    public void setInverseBackgroundForced(boolean z) {
    }

    public ListView getListView() {
        return this.mAlertControllerImpl.m3770c();
    }

    public Button getButton(int i) {
        return this.mAlertControllerImpl.m3765b(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mAlertControllerImpl.m3763a(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mAlertControllerImpl.m3769b(i, keyEvent);
    }

    public boolean[] getCheckedItems() {
        return this.mAlertControllerImpl.m3779i();
    }

    public void setCheckBox(boolean z, CharSequence charSequence) {
        this.mAlertControllerImpl.m3761a(z, charSequence);
    }

    public boolean isChecked() {
        return this.mAlertControllerImpl.m3780j();
    }
}

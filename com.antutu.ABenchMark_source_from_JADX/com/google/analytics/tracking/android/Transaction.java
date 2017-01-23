package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Transaction {
    private final String mAffiliation;
    private final String mCurrencyCode;
    private final Map<String, Item> mItems;
    private final long mShippingCostInMicros;
    private final long mTotalCostInMicros;
    private final long mTotalTaxInMicros;
    private final String mTransactionId;

    public static final class Builder {
        private String mAffiliation;
        private String mCurrencyCode;
        private long mShippingCostInMicros;
        private final long mTotalCostInMicros;
        private long mTotalTaxInMicros;
        private final String mTransactionId;

        public Builder(String str, long j) {
            this.mAffiliation = null;
            this.mTotalTaxInMicros = 0;
            this.mShippingCostInMicros = 0;
            this.mCurrencyCode = null;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("orderId must not be empty or null");
            }
            this.mTransactionId = str;
            this.mTotalCostInMicros = j;
        }

        public Transaction build() {
            return new Transaction();
        }

        public Builder setAffiliation(String str) {
            this.mAffiliation = str;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            this.mCurrencyCode = str;
            return this;
        }

        public Builder setShippingCostInMicros(long j) {
            this.mShippingCostInMicros = j;
            return this;
        }

        public Builder setTotalTaxInMicros(long j) {
            this.mTotalTaxInMicros = j;
            return this;
        }
    }

    public static final class Item {
        private final String mCategory;
        private final String mName;
        private final long mPriceInMicros;
        private final long mQuantity;
        private final String mSKU;

        public static final class Builder {
            private String mCategory;
            private final String mName;
            private final long mPriceInMicros;
            private final long mQuantity;
            private final String mSKU;

            public Builder(String str, String str2, long j, long j2) {
                this.mCategory = null;
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("SKU must not be empty or null");
                } else if (TextUtils.isEmpty(str2)) {
                    throw new IllegalArgumentException("name must not be empty or null");
                } else {
                    this.mSKU = str;
                    this.mName = str2;
                    this.mPriceInMicros = j;
                    this.mQuantity = j2;
                }
            }

            public Item build() {
                return new Item();
            }

            public Builder setProductCategory(String str) {
                this.mCategory = str;
                return this;
            }
        }

        private Item(Builder builder) {
            this.mSKU = builder.mSKU;
            this.mPriceInMicros = builder.mPriceInMicros;
            this.mQuantity = builder.mQuantity;
            this.mName = builder.mName;
            this.mCategory = builder.mCategory;
        }

        public String getCategory() {
            return this.mCategory;
        }

        public String getName() {
            return this.mName;
        }

        public long getPriceInMicros() {
            return this.mPriceInMicros;
        }

        public long getQuantity() {
            return this.mQuantity;
        }

        public String getSKU() {
            return this.mSKU;
        }
    }

    private Transaction(Builder builder) {
        this.mTransactionId = builder.mTransactionId;
        this.mTotalCostInMicros = builder.mTotalCostInMicros;
        this.mAffiliation = builder.mAffiliation;
        this.mTotalTaxInMicros = builder.mTotalTaxInMicros;
        this.mShippingCostInMicros = builder.mShippingCostInMicros;
        this.mCurrencyCode = builder.mCurrencyCode;
        this.mItems = new HashMap();
    }

    public void addItem(Item item) {
        this.mItems.put(item.getSKU(), item);
    }

    public String getAffiliation() {
        return this.mAffiliation;
    }

    public String getCurrencyCode() {
        return this.mCurrencyCode;
    }

    public List<Item> getItems() {
        return new ArrayList(this.mItems.values());
    }

    public long getShippingCostInMicros() {
        return this.mShippingCostInMicros;
    }

    public long getTotalCostInMicros() {
        return this.mTotalCostInMicros;
    }

    public long getTotalTaxInMicros() {
        return this.mTotalTaxInMicros;
    }

    public String getTransactionId() {
        return this.mTransactionId;
    }
}

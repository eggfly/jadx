package com.google.analytics.tracking.android;

import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.analytics.tracking.android.MetaModel.Formatter;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import java.text.DecimalFormat;
import org.android.agoo.message.MessageService;

class MetaModelInitializer {
    private static final Formatter BOOLEAN_FORMATTER;
    private static final Formatter UP_TO_TWO_DIGIT_FLOAT_FORMATTER;

    /* renamed from: com.google.analytics.tracking.android.MetaModelInitializer.1 */
    static class C26801 implements Formatter {
        C26801() {
        }

        public String format(String str) {
            return Utils.safeParseBoolean(str) ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT;
        }
    }

    /* renamed from: com.google.analytics.tracking.android.MetaModelInitializer.2 */
    static class C26812 implements Formatter {
        private final DecimalFormat mFloatFormat;

        C26812() {
            this.mFloatFormat = new DecimalFormat("0.##");
        }

        public String format(String str) {
            return this.mFloatFormat.format(Utils.safeParseDouble(str));
        }
    }

    static {
        BOOLEAN_FORMATTER = new C26801();
        UP_TO_TWO_DIGIT_FLOAT_FORMATTER = new C26812();
    }

    MetaModelInitializer() {
    }

    public static void set(MetaModel metaModel) {
        metaModel.addField(ModelFields.API_VERSION, IXAdRequestInfo.f6909V, null, null);
        metaModel.addField("libraryVersion", "_v", null, null);
        metaModel.addField(ModelFields.ANONYMIZE_IP, "aip", MessageService.MSG_DB_READY_REPORT, BOOLEAN_FORMATTER);
        metaModel.addField(ModelFields.TRACKING_ID, "tid", null, null);
        metaModel.addField(ModelFields.HIT_TYPE, C0714a.TIMESTAMP, null, null);
        metaModel.addField(ModelFields.SESSION_CONTROL, "sc", null, null);
        metaModel.addField("adSenseAdMobHitId", "a", null, null);
        metaModel.addField("usage", "_u", null, null);
        metaModel.addField(Downloads.COLUMN_TITLE, "dt", null, null);
        metaModel.addField(ModelFields.REFERRER, "dr", null, null);
        metaModel.addField(ModelFields.LANGUAGE, "ul", null, null);
        metaModel.addField(ModelFields.ENCODING, "de", null, null);
        metaModel.addField(ModelFields.PAGE, "dp", null, null);
        metaModel.addField(ModelFields.SCREEN_COLORS, "sd", null, null);
        metaModel.addField(ModelFields.SCREEN_RESOLUTION, "sr", null, null);
        metaModel.addField(ModelFields.VIEWPORT_SIZE, "vp", null, null);
        metaModel.addField(ModelFields.JAVA_ENABLED, "je", MessageService.MSG_DB_NOTIFY_REACHED, BOOLEAN_FORMATTER);
        metaModel.addField(ModelFields.FLASH_VERSION, "fl", null, null);
        metaModel.addField(ModelFields.CLIENT_ID, IXAdRequestInfo.CELL_ID, null, null);
        metaModel.addField(ModelFields.CAMPAIGN_NAME, "cn", null, null);
        metaModel.addField(ModelFields.CAMPAIGN_SOURCE, IXAdRequestInfo.CS, null, null);
        metaModel.addField(ModelFields.CAMPAIGN_MEDIUM, IXAdRequestInfo.MAX_CONTENT_LENGTH, null, null);
        metaModel.addField(ModelFields.CAMPAIGN_KEYWORD, "ck", null, null);
        metaModel.addField(ModelFields.CAMPAIGN_CONTENT, "cc", null, null);
        metaModel.addField(ModelFields.CAMPAIGN_ID, "ci", null, null);
        metaModel.addField(ModelFields.GCLID, ModelFields.GCLID, null, null);
        metaModel.addField(ModelFields.DCLID, ModelFields.DCLID, null, null);
        metaModel.addField(ModelFields.GMOB_T, ModelFields.GMOB_T, null, null);
        metaModel.addField(ModelFields.EVENT_CATEGORY, "ec", null, null);
        metaModel.addField(ModelFields.EVENT_ACTION, "ea", null, null);
        metaModel.addField(ModelFields.EVENT_LABEL, "el", null, null);
        metaModel.addField(ModelFields.EVENT_VALUE, "ev", null, null);
        metaModel.addField(ModelFields.NON_INTERACTION, "ni", MessageService.MSG_DB_READY_REPORT, BOOLEAN_FORMATTER);
        metaModel.addField(ModelFields.SOCIAL_NETWORK, IXAdRequestInfo.SN, null, null);
        metaModel.addField(ModelFields.SOCIAL_ACTION, "sa", null, null);
        metaModel.addField(ModelFields.SOCIAL_TARGET, "st", null, null);
        metaModel.addField(ModelFields.APP_NAME, "an", null, null);
        metaModel.addField(Constants.KEY_APP_VERSION, "av", null, null);
        metaModel.addField(Downloads.COLUMN_DESCRIPTION, "cd", null, null);
        metaModel.addField(ModelFields.APP_ID, "aid", null, null);
        metaModel.addField(ModelFields.APP_INSTALLER_ID, "aiid", null, null);
        metaModel.addField(ModelFields.TRANSACTION_ID, "ti", null, null);
        metaModel.addField(ModelFields.TRANSACTION_AFFILIATION, "ta", null, null);
        metaModel.addField(ModelFields.TRANSACTION_SHIPPING, MsgConstant.KEY_TS, null, null);
        metaModel.addField(ModelFields.TRANSACTION_TOTAL, "tr", null, null);
        metaModel.addField(ModelFields.TRANSACTION_TAX, "tt", null, null);
        metaModel.addField("currencyCode", "cu", null, null);
        metaModel.addField(ModelFields.ITEM_PRICE, "ip", null, null);
        metaModel.addField(ModelFields.ITEM_CODE, "ic", null, null);
        metaModel.addField(ModelFields.ITEM_NAME, "in", null, null);
        metaModel.addField(ModelFields.ITEM_CATEGORY, "iv", null, null);
        metaModel.addField(ModelFields.ITEM_QUANTITY, "iq", null, null);
        metaModel.addField(ModelFields.EX_DESCRIPTION, "exd", null, null);
        metaModel.addField(ModelFields.EX_FATAL, "exf", MessageService.MSG_DB_NOTIFY_REACHED, BOOLEAN_FORMATTER);
        metaModel.addField(ModelFields.TIMING_VAR, "utv", null, null);
        metaModel.addField(ModelFields.TIMING_VALUE, "utt", null, null);
        metaModel.addField(ModelFields.TIMING_CATEGORY, "utc", null, null);
        metaModel.addField(ModelFields.TIMING_LABEL, "utl", null, null);
        metaModel.addField(ModelFields.SAMPLE_RATE, "sf", MessageService.MSG_DB_COMPLETE, UP_TO_TWO_DIGIT_FLOAT_FORMATTER);
        metaModel.addField("hitTime", "ht", null, null);
        metaModel.addField(ModelFields.CUSTOM_DIMENSION, "cd", null, null);
        metaModel.addField(ModelFields.CUSTOM_METRIC, IXAdRequestInfo.MAX_CONTENT_LENGTH, null, null);
        metaModel.addField(ModelFields.CONTENT_GROUPING, "cg", null, null);
    }
}

package com.baidu.mobads.interfaces;

import com.umeng.message.proguard.C4233j;

public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        
        private final String f6894a;

        private ActivityState(String str) {
            this.f6894a = str;
        }

        public static ActivityState parse(String str) {
            for (ActivityState activityState : values()) {
                if (activityState.f6894a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6894a;
        }
    }

    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        
        private final String f6896a;

        private ScreenSizeMode(String str) {
            this.f6896a = str;
        }

        public static ScreenSizeMode parse(String str) {
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.f6896a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6896a;
        }
    }

    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR(C4233j.f14375B);
        
        private final String f6898a;

        private SlotState(String str) {
            this.f6898a = str;
        }

        public static SlotState parse(String str) {
            for (SlotState slotState : values()) {
                if (slotState.f6898a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6898a;
        }
    }

    public enum SlotType {
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_SUSPENDED("suspended"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS("feed"),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll");
        
        private final String f6900a;

        private SlotType(String str) {
            this.f6900a = str;
        }

        public static SlotType parse(String str) {
            for (SlotType slotType : values()) {
                if (slotType.f6900a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6900a;
        }
    }

    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        
        private final String f6902a;

        private VideoAssetPlayMode(String str) {
            this.f6902a = str;
        }

        public static VideoAssetPlayMode parse(String str) {
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.f6902a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6902a;
        }
    }

    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        
        private final String f6904a;

        private VideoState(String str) {
            this.f6904a = str;
        }

        public static VideoState parse(String str) {
            for (VideoState videoState : values()) {
                if (videoState.f6904a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6904a;
        }
    }

    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        
        private final String f6906a;

        private VisitorAction(String str) {
            this.f6906a = str;
        }

        public static VisitorAction parse(String str) {
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.f6906a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f6906a;
        }
    }
}

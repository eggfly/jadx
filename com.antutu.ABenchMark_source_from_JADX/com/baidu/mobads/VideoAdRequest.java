package com.baidu.mobads;

import com.baidu.mobads.VideoAdView.VideoDuration;
import com.baidu.mobads.VideoAdView.VideoSize;

public class VideoAdRequest {
    private VideoDuration f6642a;
    private boolean f6643b;
    private VideoSize f6644c;

    public static class Builder {
        private VideoDuration f6639a;
        private boolean f6640b;
        private VideoSize f6641c;

        public Builder() {
            this.f6640b = false;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest();
        }

        public Builder isShowCountdown(boolean z) {
            this.f6640b = z;
            return this;
        }

        public Builder setVideoDuration(VideoDuration videoDuration) {
            this.f6639a = videoDuration;
            return this;
        }

        public Builder setVideoSize(VideoSize videoSize) {
            this.f6641c = videoSize;
            return this;
        }
    }

    private VideoAdRequest(Builder builder) {
        this.f6642a = builder.f6639a;
        this.f6643b = builder.f6640b;
        this.f6644c = builder.f6641c;
    }

    protected int getVideoDuration() {
        return this.f6642a == null ? VideoDuration.DURATION_15_SECONDS.getValue() : this.f6642a.getValue();
    }

    protected int getVideoHeight() {
        if (this.f6644c == null) {
            this.f6644c = VideoSize.SIZE_16x9;
        }
        return this.f6644c.getHeight();
    }

    protected int getVideoWidth() {
        if (this.f6644c == null) {
            this.f6644c = VideoSize.SIZE_16x9;
        }
        return this.f6644c.getWidth();
    }

    protected boolean isShowCountdown() {
        return this.f6643b;
    }
}

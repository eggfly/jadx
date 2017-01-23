package com.miui.support.media;

class LocalAMRRecorder extends LocalMediaRecorder {
    private boolean f3312a;

    LocalAMRRecorder() {
    }

    public boolean m5000a() {
        return true;
    }

    protected int m5001b() {
        return this.f3312a ? "#!AMR-WB\n".length() : "#!AMR\n".length();
    }
}

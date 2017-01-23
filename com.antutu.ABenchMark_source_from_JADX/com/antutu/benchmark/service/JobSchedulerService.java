package com.antutu.benchmark.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.antutu.utils.PushMessageUtil;

@TargetApi(21)
public class JobSchedulerService extends JobService {
    public void m6370a() {
        PushMessageUtil.openLiveService(this);
        startService(BenchmarkMainService.m6344a((Context) this));
    }

    public boolean onStartJob(JobParameters jobParameters) {
        m6370a();
        jobFinished(jobParameters, false);
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        m6370a();
        return false;
    }

    public void onTaskRemoved(Intent intent) {
        m6370a();
    }
}

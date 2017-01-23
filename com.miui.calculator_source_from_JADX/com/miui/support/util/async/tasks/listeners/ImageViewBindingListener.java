package com.miui.support.util.async.tasks.listeners;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.miui.support.util.AppConstants;
import com.miui.support.util.async.Task;
import com.miui.support.util.async.TaskManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ImageViewBindingListener extends BaseTaskListener {
    private static final LinkedHashSet<ImageViewBindingListener> f3822a;
    private final WeakReference<ImageView> f3823b;
    private WeakReference<Task<?>> f3824c;
    private Drawable f3825d;
    private Drawable f3826e;

    static {
        f3822a = new LinkedHashSet();
    }

    private boolean m5585a(ImageViewBindingListener imageViewBindingListener) {
        return this.f3823b.get() == imageViewBindingListener.f3823b.get();
    }

    public void m5587a(TaskManager taskManager, Task<?> task) {
        Task task2;
        if (this.f3824c != null) {
            task2 = (Task) this.f3824c.get();
            if (task2 != null) {
                task2.m5487e();
            }
        }
        this.f3824c = new WeakReference(task);
        Iterator it = f3822a.iterator();
        while (it.hasNext()) {
            ImageViewBindingListener imageViewBindingListener = (ImageViewBindingListener) it.next();
            if (imageViewBindingListener != this && m5585a(imageViewBindingListener)) {
                task2 = (Task) imageViewBindingListener.f3824c.get();
                break;
            }
        }
        task2 = null;
        if (task2 != null) {
            task2.m5487e();
        }
        f3822a.add(this);
        if (this.f3825d != null) {
            ImageView imageView = (ImageView) this.f3823b.get();
            if (imageView != null) {
                imageView.setImageDrawable(this.f3825d);
            }
        }
    }

    public Object m5586a(TaskManager taskManager, Task<?> task, Object obj) {
        ImageView imageView = (ImageView) this.f3823b.get();
        if (imageView != null) {
            Drawable[] drawableArr = new Drawable[]{imageView.getDrawable(), null};
            if (drawableArr[0] != null) {
                Resources resources = AppConstants.m4227a().getResources();
                if (obj instanceof Bitmap) {
                    drawableArr[1] = new BitmapDrawable(resources, (Bitmap) obj);
                } else {
                    drawableArr[1] = (Drawable) obj;
                }
                Drawable transitionDrawable = new TransitionDrawable(drawableArr);
                transitionDrawable.setCrossFadeEnabled(true);
                imageView.setImageDrawable(transitionDrawable);
                transitionDrawable.startTransition(resources.getInteger(17694720));
            } else if (obj instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) obj);
            } else {
                imageView.setImageDrawable((Drawable) obj);
            }
        }
        return obj;
    }

    public void m5588a(TaskManager taskManager, Task<?> task, Exception exception) {
        if (this.f3826e != null) {
            ImageView imageView = (ImageView) this.f3823b.get();
            if (imageView != null) {
                imageView.setImageDrawable(this.f3826e);
            }
        }
    }

    public void m5589c(TaskManager taskManager, Task<?> task) {
        f3822a.remove(this);
    }
}

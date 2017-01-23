package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ac extends t {
    private Future<String> DW;
    private volatile String j6;

    class 1 implements Callable<String> {
        final /* synthetic */ ac j6;

        1(ac acVar) {
            this.j6 = acVar;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public String j6() {
            return this.j6.Hw();
        }
    }

    class 2 implements Callable<String> {
        final /* synthetic */ ac j6;

        2(ac acVar) {
            this.j6 = acVar;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public String j6() {
            return this.j6.Zo();
        }
    }

    protected ac(v vVar) {
        super(vVar);
    }

    private String Zo() {
        String v5 = v5();
        try {
            return !j6(aM().FH(), v5) ? "0" : v5;
        } catch (Exception e) {
            v5("Error saving clientId file", e);
            return "0";
        }
    }

    private boolean j6(Context context, String str) {
        b.j6(str);
        b.FH("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            j6("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    v5("Failed to close clientId writing stream", e);
                }
            }
            return true;
        } catch (FileNotFoundException e2) {
            v5("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                v5("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e32) {
            v5("Error writing to clientId file", e32);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e322) {
                v5("Failed to close clientId writing stream", e322);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    v5("Failed to close clientId writing stream", e3222);
                }
            }
        }
    }

    public String DW() {
        String str;
        P8();
        synchronized (this) {
            if (this.j6 == null) {
                this.DW = aM().j6(new 1(this));
            }
            if (this.DW != null) {
                try {
                    this.j6 = (String) this.DW.get();
                } catch (InterruptedException e) {
                    Hw("ClientId loading or generation was interrupted", e);
                    this.j6 = "0";
                } catch (ExecutionException e2) {
                    v5("Failed to load or generate client id", e2);
                    this.j6 = "0";
                }
                if (this.j6 == null) {
                    this.j6 = "0";
                }
                j6("Loaded clientId", this.j6);
                this.DW = null;
            }
            str = this.j6;
        }
        return str;
    }

    String FH() {
        synchronized (this) {
            this.j6 = null;
            this.DW = aM().j6(new 2(this));
        }
        return DW();
    }

    String Hw() {
        String j6 = j6(aM().FH());
        return j6 == null ? Zo() : j6;
    }

    protected String j6(Context context) {
        FileInputStream openFileInput;
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        b.FH("ClientId should be loaded from worker thread");
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, 36);
                if (openFileInput.available() > 0) {
                    v5("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        v5("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    v5("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        v5("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    j6("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            v5("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    v5("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    v5("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        v5("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            v5("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            v5("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    protected void j6() {
    }

    protected String v5() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}

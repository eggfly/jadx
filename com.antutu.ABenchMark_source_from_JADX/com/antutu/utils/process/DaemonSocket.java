package com.antutu.utils.process;

import android.util.Log;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import org.android.agoo.message.MessageService;

class DaemonSocket {
    private static final int PORT = 33999;
    private static final byte[] RESPONSE_OK;
    private static final String TAG;
    private static final byte[] VERSION;

    public interface CmdHandler {
        void onExitReceived();

        void onNewPidReceived(String str);
    }

    private static class CMDLIST {
        private static final String check = "check";
        private static final String exit = "exit";
        private static final String uppid = "uppid:";

        private CMDLIST() {
        }
    }

    public static class Client {
        public static int cmd_check() {
            int i = -1;
            String sendCmd = sendCmd("check");
            Log.d(DaemonSocket.TAG, "check response: " + sendCmd);
            if (sendCmd != null) {
                try {
                    i = Integer.parseInt(sendCmd);
                } catch (Exception e) {
                }
            }
            return i;
        }

        public static void cmd_exit() {
            Log.d(DaemonSocket.TAG, "exit response: " + sendCmd("exit"));
        }

        public static boolean cmd_update_pid(int i) {
            String sendCmd = sendCmd(String.format("%s%d", new Object[]{"uppid:", Integer.valueOf(i)}));
            Log.d(DaemonSocket.TAG, "newpid response: " + sendCmd);
            return sendCmd != null;
        }

        private static String sendCmd(String str) {
            Socket socket;
            int i;
            IOException e;
            DataOutputStream dataOutputStream;
            Throwable th;
            Object obj = null;
            String str2 = null;
            Log.d(DaemonSocket.TAG, "sendCmd: " + str);
            try {
                socket = new Socket("localhost", DaemonSocket.PORT);
            } catch (UnknownHostException e2) {
                Log.w(DaemonSocket.TAG, e2.getMessage());
                i = 1;
                socket = null;
            } catch (IOException e3) {
                Log.w(DaemonSocket.TAG, e3.getMessage());
                i = 1;
                socket = null;
            }
            if (obj == null) {
                DataInputStream dataInputStream;
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    try {
                        dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        try {
                            dataOutputStream.write(str.getBytes());
                            dataOutputStream.flush();
                            byte[] bArr = new byte[socket.getReceiveBufferSize()];
                            int read = dataInputStream.read(bArr);
                            if (read >= 0) {
                                str2 = new String(bArr, 0, read);
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e32) {
                                    Log.w(DaemonSocket.TAG, e32.getMessage());
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e322) {
                                    Log.w(DaemonSocket.TAG, e322.getMessage());
                                }
                            }
                        } catch (IOException e4) {
                            e322 = e4;
                            try {
                                Log.w(DaemonSocket.TAG, e322.getMessage());
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (IOException e3222) {
                                        Log.w(DaemonSocket.TAG, e3222.getMessage());
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e32222) {
                                        Log.w(DaemonSocket.TAG, e32222.getMessage());
                                    }
                                }
                                if (socket != null) {
                                    try {
                                        socket.close();
                                    } catch (IOException e322222) {
                                        Log.w(DaemonSocket.TAG, e322222.getMessage());
                                    }
                                }
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                if (dataInputStream != null) {
                                    try {
                                        dataInputStream.close();
                                    } catch (IOException e5) {
                                        Log.w(DaemonSocket.TAG, e5.getMessage());
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e6) {
                                        Log.w(DaemonSocket.TAG, e6.getMessage());
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e7) {
                        e322222 = e7;
                        dataOutputStream = null;
                        Log.w(DaemonSocket.TAG, e322222.getMessage());
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (socket != null) {
                            socket.close();
                        }
                        return str2;
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream = null;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e322222 = e8;
                    dataOutputStream = null;
                    dataInputStream = null;
                    Log.w(DaemonSocket.TAG, e322222.getMessage());
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                    return str2;
                } catch (Throwable th4) {
                    th = th4;
                    dataOutputStream = null;
                    dataInputStream = null;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    throw th;
                }
            }
            if (socket != null) {
                socket.close();
            }
            return str2;
        }
    }

    public static class Server extends Thread {
        private CmdHandler mHandler;
        private ServerSocket mServerSocket;

        public Server(CmdHandler cmdHandler) {
            this.mHandler = cmdHandler;
            this.mServerSocket = new ServerSocket(DaemonSocket.PORT);
        }

        protected void finalize() {
            if (!(this.mServerSocket == null || this.mServerSocket.isClosed())) {
                this.mServerSocket.close();
            }
            this.mServerSocket = null;
            super.finalize();
        }

        public void interrupt() {
            if (this.mServerSocket != null) {
                try {
                    this.mServerSocket.close();
                } catch (IOException e) {
                    Log.e(DaemonSocket.TAG, e.getMessage());
                }
            }
            super.interrupt();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r9 = this;
            r0 = 0;
            r3 = r0;
            r2 = r0;
        L_0x0003:
            r1 = r9.isInterrupted();
            if (r1 != 0) goto L_0x0139;
        L_0x0009:
            r1 = r9.mServerSocket;
            r1 = r1.isClosed();
            if (r1 != 0) goto L_0x0139;
        L_0x0011:
            r1 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r4 = "wait for connect...";
            android.util.Log.d(r1, r4);	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r1 = r9.mServerSocket;	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r2 = r1.accept();	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r1 = new java.io.DataInputStream;	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r4 = r2.getInputStream();	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r1.<init>(r4);	 Catch:{ IOException -> 0x014c, Exception -> 0x0141, all -> 0x013a }
            r0 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x0153, Exception -> 0x0147, all -> 0x013f }
            r4 = r2.getOutputStream();	 Catch:{ IOException -> 0x0153, Exception -> 0x0147, all -> 0x013f }
            r0.<init>(r4);	 Catch:{ IOException -> 0x0153, Exception -> 0x0147, all -> 0x013f }
            r3 = r2.getReceiveBufferSize();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = new byte[r3];	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = r1.read(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r5 = new java.lang.String;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r6 = 0;
            r5.<init>(r3, r6, r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = "check";
            r3 = r3.equals(r5);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            if (r3 == 0) goto L_0x0069;
        L_0x004a:
            r3 = com.antutu.utils.process.DaemonSocket.VERSION;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r0.write(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = "receive check command!";
            android.util.Log.d(r3, r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
        L_0x005a:
            r0.flush();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            com.antutu.utils.process.DaemonSocket.closeSocket(r2);
            com.antutu.utils.process.DaemonSocket.closeStream(r1);
            com.antutu.utils.process.DaemonSocket.closeStream(r0);
        L_0x0066:
            r3 = r0;
            r0 = r1;
            goto L_0x0003;
        L_0x0069:
            r3 = "uppid:";
            r3 = r5.startsWith(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            if (r3 == 0) goto L_0x00be;
        L_0x0071:
            r3 = "uppid:";
            r3 = r3.length();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r5.substring(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r3.trim();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = r9.mHandler;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            if (r4 == 0) goto L_0x0088;
        L_0x0083:
            r4 = r9.mHandler;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4.onNewPidReceived(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
        L_0x0088:
            r4 = com.antutu.utils.process.DaemonSocket.RESPONSE_OK;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r0.write(r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r5.<init>();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r6 = "receive a new pid: ";
            r5 = r5.append(r6);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r5.append(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            android.util.Log.d(r4, r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            goto L_0x005a;
        L_0x00aa:
            r3 = move-exception;
        L_0x00ab:
            r4 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ all -> 0x012b }
            r5 = "accept: IOException";
            android.util.Log.e(r4, r5, r3);	 Catch:{ all -> 0x012b }
            com.antutu.utils.process.DaemonSocket.closeSocket(r2);
            com.antutu.utils.process.DaemonSocket.closeStream(r1);
            com.antutu.utils.process.DaemonSocket.closeStream(r0);
            goto L_0x0066;
        L_0x00be:
            r3 = "exit";
            r3 = r3.equals(r5);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            if (r3 == 0) goto L_0x00f6;
        L_0x00c6:
            r3 = r9.mHandler;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            if (r3 == 0) goto L_0x00cf;
        L_0x00ca:
            r3 = r9.mHandler;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3.onExitReceived();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
        L_0x00cf:
            r3 = com.antutu.utils.process.DaemonSocket.RESPONSE_OK;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r0.write(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = "receive exit command!";
            android.util.Log.w(r3, r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            goto L_0x005a;
        L_0x00e1:
            r3 = move-exception;
        L_0x00e2:
            r4 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ all -> 0x012b }
            r5 = "accept: Exception";
            android.util.Log.e(r4, r5, r3);	 Catch:{ all -> 0x012b }
            com.antutu.utils.process.DaemonSocket.closeSocket(r2);
            com.antutu.utils.process.DaemonSocket.closeStream(r1);
            com.antutu.utils.process.DaemonSocket.closeStream(r0);
            goto L_0x0066;
        L_0x00f6:
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3.<init>();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = "#not support: ";
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r3.append(r5);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = "$";
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = r3.getBytes();	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r0.write(r3);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r3 = com.antutu.utils.process.DaemonSocket.TAG;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = "command: %s not be support!";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r7 = 0;
            r6[r7] = r5;	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            r4 = java.lang.String.format(r4, r6);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            android.util.Log.w(r3, r4);	 Catch:{ IOException -> 0x00aa, Exception -> 0x00e1 }
            goto L_0x005a;
        L_0x012b:
            r3 = move-exception;
            r8 = r3;
            r3 = r0;
            r0 = r8;
        L_0x012f:
            com.antutu.utils.process.DaemonSocket.closeSocket(r2);
            com.antutu.utils.process.DaemonSocket.closeStream(r1);
            com.antutu.utils.process.DaemonSocket.closeStream(r3);
            throw r0;
        L_0x0139:
            return;
        L_0x013a:
            r1 = move-exception;
            r8 = r1;
            r1 = r0;
            r0 = r8;
            goto L_0x012f;
        L_0x013f:
            r0 = move-exception;
            goto L_0x012f;
        L_0x0141:
            r1 = move-exception;
            r8 = r1;
            r1 = r0;
            r0 = r3;
            r3 = r8;
            goto L_0x00e2;
        L_0x0147:
            r0 = move-exception;
            r8 = r0;
            r0 = r3;
            r3 = r8;
            goto L_0x00e2;
        L_0x014c:
            r1 = move-exception;
            r8 = r1;
            r1 = r0;
            r0 = r3;
            r3 = r8;
            goto L_0x00ab;
        L_0x0153:
            r0 = move-exception;
            r8 = r0;
            r0 = r3;
            r3 = r8;
            goto L_0x00ab;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.process.DaemonSocket.Server.run():void");
        }
    }

    static {
        TAG = DaemonSocket.class.getSimpleName();
        RESPONSE_OK = "OK".getBytes();
        VERSION = MessageService.MSG_DB_NOTIFY_CLICK.getBytes();
    }

    DaemonSocket() {
    }

    private static void closeSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable e) {
                Log.w(TAG, "closeSocket IOException", e);
            }
        }
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.w(TAG, "closeStream IOException", e);
            }
        }
    }
}

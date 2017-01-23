package com.miui.support.util;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class DirectIndexedFile {

    /* renamed from: com.miui.support.util.DirectIndexedFile.1 */
    /* synthetic */ class C04261 {
        static final /* synthetic */ int[] f3632a;

        static {
            f3632a = new int[Type.values().length];
            try {
                f3632a[Type.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3632a[Type.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3632a[Type.SHORT_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3632a[Type.INTEGER_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3632a[Type.LONG_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3632a[Type.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3632a[Type.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f3632a[Type.INTEGER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f3632a[Type.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static class Builder {

        private class DataItemHolder {
        }

        private static class IndexData {
        }

        private class Item implements Comparable<Item> {
            private int f3633a;

            public /* synthetic */ int compareTo(Object obj) {
                return m5327a((Item) obj);
            }

            public int hashCode() {
                return this.f3633a;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Item)) {
                    return false;
                }
                if (this.f3633a != ((Item) obj).f3633a) {
                    return false;
                }
                return true;
            }

            public int m5327a(Item item) {
                return this.f3633a - item.f3633a;
            }
        }
    }

    private interface InputFile extends DataInput {
        void m5328a();

        void m5329a(long j);

        long m5330b();
    }

    private static class DataInputRandom implements InputFile {
        private RandomAccessFile f3634a;

        DataInputRandom(RandomAccessFile randomAccessFile) {
            this.f3634a = randomAccessFile;
        }

        public boolean readBoolean() {
            return this.f3634a.readBoolean();
        }

        public byte readByte() {
            return this.f3634a.readByte();
        }

        public char readChar() {
            return this.f3634a.readChar();
        }

        public double readDouble() {
            return this.f3634a.readDouble();
        }

        public float readFloat() {
            return this.f3634a.readFloat();
        }

        public void readFully(byte[] bArr) {
            this.f3634a.readFully(bArr);
        }

        public void readFully(byte[] bArr, int i, int i2) {
            this.f3634a.readFully(bArr, i, i2);
        }

        public int readInt() {
            return this.f3634a.readInt();
        }

        public String readLine() {
            return this.f3634a.readLine();
        }

        public long readLong() {
            return this.f3634a.readLong();
        }

        public short readShort() {
            return this.f3634a.readShort();
        }

        public int readUnsignedByte() {
            return this.f3634a.readUnsignedByte();
        }

        public int readUnsignedShort() {
            return this.f3634a.readUnsignedShort();
        }

        public String readUTF() {
            return this.f3634a.readUTF();
        }

        public int skipBytes(int i) {
            return this.f3634a.skipBytes(i);
        }

        public void m5332a(long j) {
            this.f3634a.seek(j);
        }

        public void m5331a() {
            this.f3634a.close();
        }

        public long m5333b() {
            return this.f3634a.getFilePointer();
        }
    }

    private static class DataInputStream implements InputFile {
        private InputStream f3635a;
        private long f3636b;

        DataInputStream(InputStream inputStream) {
            this.f3635a = inputStream;
            this.f3635a.mark(0);
            this.f3636b = 0;
        }

        public boolean readBoolean() {
            this.f3636b++;
            return this.f3635a.read() != 0;
        }

        public byte readByte() {
            this.f3636b++;
            return (byte) this.f3635a.read();
        }

        public char readChar() {
            byte[] bArr = new byte[2];
            this.f3636b += 2;
            if (this.f3635a.read(bArr) != 2) {
                return '\u0000';
            }
            return (char) (((bArr[0] << 8) & 65280) | ((char) (bArr[1] & 255)));
        }

        public double readDouble() {
            throw new IOException();
        }

        public float readFloat() {
            throw new IOException();
        }

        public void readFully(byte[] bArr) {
            this.f3636b = ((long) this.f3635a.read(bArr)) + this.f3636b;
        }

        public void readFully(byte[] bArr, int i, int i2) {
            this.f3636b = ((long) this.f3635a.read(bArr, i, i2)) + this.f3636b;
        }

        public int readInt() {
            byte[] bArr = new byte[4];
            this.f3636b += 4;
            if (this.f3635a.read(bArr) != 4) {
                return 0;
            }
            return ((bArr[0] << 24) & -16777216) | (((bArr[3] & 255) | ((bArr[2] << 8) & 65280)) | ((bArr[1] << 16) & 16711680));
        }

        public String readLine() {
            throw new IOException();
        }

        public long readLong() {
            byte[] bArr = new byte[8];
            this.f3636b += 8;
            if (this.f3635a.read(bArr) == 8) {
                return ((((((((long) (bArr[7] & 255)) | (((long) (bArr[6] << 8)) & 65280)) | (((long) (bArr[5] << 16)) & 16711680)) | (((long) (bArr[4] << 24)) & 4278190080L)) | ((((long) bArr[3]) << 32) & 1095216660480L)) | ((((long) bArr[2]) << 40) & 280375465082880L)) | ((((long) bArr[1]) << 48) & 71776119061217280L)) | ((((long) bArr[0]) << 56) & -72057594037927936L);
            }
            return 0;
        }

        public short readShort() {
            byte[] bArr = new byte[2];
            this.f3636b += 2;
            if (this.f3635a.read(bArr) != 2) {
                return (short) 0;
            }
            return (short) (((bArr[0] << 8) & 65280) | ((short) (bArr[1] & 255)));
        }

        public int readUnsignedByte() {
            this.f3636b++;
            return (byte) this.f3635a.read();
        }

        public int readUnsignedShort() {
            byte[] bArr = new byte[2];
            this.f3636b += 2;
            if (this.f3635a.read(bArr) != 2) {
                return 0;
            }
            return (short) (((bArr[0] << 8) & 65280) | ((short) (bArr[1] & 255)));
        }

        public String readUTF() {
            throw new IOException();
        }

        public int skipBytes(int i) {
            int skip = (int) this.f3635a.skip((long) i);
            this.f3636b += (long) skip;
            return skip;
        }

        public void m5335a(long j) {
            this.f3635a.reset();
            if (this.f3635a.skip(j) == j) {
                this.f3636b = j;
                return;
            }
            throw new IOException("Skip failed");
        }

        public void m5334a() {
            this.f3635a.close();
        }

        public long m5336b() {
            return this.f3636b;
        }
    }

    private static class DataItemDescriptor {
        private static byte[] f3647a;
        private Type f3648b;
        private byte f3649c;
        private byte f3650d;
        private byte f3651e;
        private long f3652f;

        private enum Type {
            BYTE,
            SHORT,
            INTEGER,
            LONG,
            STRING,
            BYTE_ARRAY,
            SHORT_ARRAY,
            INTEGER_ARRAY,
            LONG_ARRAY
        }

        static {
            f3647a = new byte[1024];
        }

        private static byte[] m5342a(int i) {
            byte[] bArr;
            synchronized (DataItemDescriptor.class) {
                if (f3647a == null || f3647a.length < i) {
                    f3647a = new byte[i];
                }
                bArr = f3647a;
                f3647a = null;
            }
            return bArr;
        }

        private static void m5341a(byte[] bArr) {
            synchronized (DataItemDescriptor.class) {
                if (bArr != null) {
                    if (f3647a == null || f3647a.length < bArr.length) {
                        f3647a = bArr;
                    }
                }
            }
        }

        private DataItemDescriptor(Type type, byte b, byte b2, byte b3, long j) {
            this.f3648b = type;
            this.f3649c = b;
            this.f3650d = b2;
            this.f3651e = b3;
            this.f3652f = j;
        }

        private static DataItemDescriptor m5346b(DataInput dataInput) {
            return new DataItemDescriptor(Type.values()[dataInput.readByte()], dataInput.readByte(), dataInput.readByte(), dataInput.readByte(), dataInput.readLong());
        }

        private Object m5340a(InputFile inputFile, int i) {
            byte[] bArr;
            Object obj = null;
            int i2 = 0;
            long b = inputFile.m5330b();
            if (i != 0) {
                inputFile.m5329a(((long) (this.f3651e * i)) + b);
            }
            inputFile.m5329a(b + m5338a((DataInput) inputFile, this.f3651e));
            Object obj2;
            switch (C04261.f3632a[this.f3648b.ordinal()]) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    int a = (int) m5338a((DataInput) inputFile, this.f3650d);
                    byte[] a2 = m5342a(a);
                    inputFile.readFully(a2, 0, a);
                    bArr = a2;
                    String str = new String(a2, 0, a);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    Object obj3 = new byte[((int) m5338a((DataInput) inputFile, this.f3650d))];
                    inputFile.readFully(obj3);
                    obj = obj3;
                    obj3 = null;
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    obj2 = new short[((int) m5338a((DataInput) inputFile, this.f3650d))];
                    while (i2 < obj2.length) {
                        obj2[i2] = inputFile.readShort();
                        i2++;
                    }
                    bArr = null;
                    obj = obj2;
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    obj2 = new int[((int) m5338a((DataInput) inputFile, this.f3650d))];
                    while (i2 < obj2.length) {
                        obj2[i2] = inputFile.readInt();
                        i2++;
                    }
                    bArr = null;
                    obj = obj2;
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    obj2 = new long[((int) m5338a((DataInput) inputFile, this.f3650d))];
                    while (i2 < obj2.length) {
                        obj2[i2] = inputFile.readLong();
                        i2++;
                    }
                    bArr = null;
                    obj = obj2;
                    break;
                default:
                    bArr = null;
                    break;
            }
            m5341a(bArr);
            return obj;
        }

        private Object[] m5344a(InputFile inputFile) {
            switch (C04261.f3632a[this.f3648b.ordinal()]) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    Object[] objArr = new Object[inputFile.readInt()];
                    objArr[0] = m5340a(inputFile, 0);
                    return objArr;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    return new Object[]{Byte.valueOf(inputFile.readByte())};
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    return new Object[]{Short.valueOf(inputFile.readShort())};
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    return new Object[]{Integer.valueOf(inputFile.readInt())};
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    return new Object[]{Long.valueOf(inputFile.readLong())};
                default:
                    return null;
            }
        }

        private static long m5338a(DataInput dataInput, int i) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    return (long) dataInput.readByte();
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    return (long) dataInput.readShort();
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    return (long) dataInput.readInt();
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    return dataInput.readLong();
                default:
                    throw new IllegalArgumentException("Unsuppoert size " + i);
            }
        }
    }

    private static class DescriptionPair {
        private long f3653a;
        private long f3654b;

        private DescriptionPair(long j, long j2) {
            this.f3653a = j;
            this.f3654b = j2;
        }

        private static DescriptionPair m5350b(DataInput dataInput) {
            return new DescriptionPair(dataInput.readLong(), dataInput.readLong());
        }
    }

    private static class FileHeader {
        private static final byte[] f3655a;
        private DescriptionPair[] f3656b;
        private int f3657c;

        static {
            f3655a = new byte[]{(byte) 73, (byte) 68, (byte) 70, (byte) 32};
        }

        private FileHeader(int i, int i2) {
            this.f3656b = new DescriptionPair[i];
            this.f3657c = i2;
        }

        private static FileHeader m5354b(DataInput dataInput) {
            int i;
            int i2 = 0;
            byte[] bArr = new byte[f3655a.length];
            for (i = 0; i < bArr.length; i++) {
                bArr[i] = dataInput.readByte();
            }
            if (!Arrays.equals(bArr, f3655a)) {
                throw new IOException("File tag unmatched, file may be corrupt");
            } else if (dataInput.readInt() != 2) {
                throw new IOException("File version unmatched, please upgrade your reader");
            } else {
                i = dataInput.readInt();
                FileHeader fileHeader = new FileHeader(i, dataInput.readInt());
                while (i2 < i) {
                    fileHeader.f3656b[i2] = DescriptionPair.m5350b(dataInput);
                    i2++;
                }
                return fileHeader;
            }
        }
    }

    private static class IndexGroupDescriptor {
        int f3658a;
        int f3659b;
        long f3660c;

        private IndexGroupDescriptor(int i, int i2, long j) {
            this.f3658a = i;
            this.f3659b = i2;
            this.f3660c = j;
        }

        private static IndexGroupDescriptor m5356b(DataInput dataInput) {
            return new IndexGroupDescriptor(dataInput.readInt(), dataInput.readInt(), dataInput.readLong());
        }
    }

    public static class Reader {
        private InputFile f3665a;
        private FileHeader f3666b;
        private IndexData[] f3667c;

        private static class IndexData {
            private IndexGroupDescriptor[] f3661a;
            private DataItemDescriptor[] f3662b;
            private Object[][] f3663c;
            private int f3664d;

            private IndexData() {
            }
        }

        private Reader(InputStream inputStream) {
            this.f3665a = new DataInputStream(inputStream);
            m5365a("assets");
        }

        private Reader(String str) {
            this.f3665a = new DataInputRandom(new RandomAccessFile(str, "r"));
            m5365a(str);
        }

        private void m5365a(String str) {
            System.currentTimeMillis();
            try {
                this.f3665a.m5329a(0);
                this.f3666b = FileHeader.m5354b(this.f3665a);
                this.f3667c = new IndexData[this.f3666b.f3656b.length];
                for (int i = 0; i < this.f3666b.f3656b.length; i++) {
                    int i2;
                    this.f3667c[i] = new IndexData();
                    this.f3665a.m5329a(this.f3666b.f3656b[i].f3653a);
                    int readInt = this.f3665a.readInt();
                    this.f3667c[i].f3661a = new IndexGroupDescriptor[readInt];
                    for (i2 = 0; i2 < readInt; i2++) {
                        this.f3667c[i].f3661a[i2] = IndexGroupDescriptor.m5356b(this.f3665a);
                    }
                    this.f3665a.m5329a(this.f3666b.f3656b[i].f3654b);
                    readInt = this.f3665a.readInt();
                    this.f3667c[i].f3664d = 0;
                    this.f3667c[i].f3662b = new DataItemDescriptor[readInt];
                    for (i2 = 0; i2 < readInt; i2++) {
                        this.f3667c[i].f3662b[i2] = DataItemDescriptor.m5346b(this.f3665a);
                        IndexData indexData = this.f3667c[i];
                        indexData.f3664d = indexData.f3664d + this.f3667c[i].f3662b[i2].f3649c;
                    }
                    this.f3667c[i].f3663c = new Object[readInt][];
                    for (i2 = 0; i2 < readInt; i2++) {
                        this.f3665a.m5329a(this.f3667c[i].f3662b[i2].f3652f);
                        this.f3667c[i].f3663c[i2] = this.f3667c[i].f3662b[i2].m5344a(this.f3665a);
                    }
                }
            } catch (IOException e) {
                m5367b();
                throw e;
            }
        }

        public int m5366a() {
            if (this.f3666b == null) {
                return -1;
            }
            return this.f3666b.f3657c;
        }

        public synchronized void m5367b() {
            if (this.f3665a != null) {
                try {
                    this.f3665a.m5328a();
                } catch (IOException e) {
                }
            }
            this.f3665a = null;
            this.f3666b = null;
            this.f3667c = null;
        }
    }

    protected DirectIndexedFile() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static Reader m5369a(String str) {
        return new Reader(null);
    }

    public static Reader m5368a(InputStream inputStream) {
        return new Reader(null);
    }
}

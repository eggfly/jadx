package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private final FieldNamingStrategy fieldNamingStrategy;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final boolean lenient;
    private final boolean prettyPrinting;
    private final boolean serializeNulls;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    /* renamed from: com.google.gson.Gson.1 */
    static class C35621 extends TypeToken<Object> {
        C35621() {
        }
    }

    /* renamed from: com.google.gson.Gson.2 */
    class C35632 extends TypeAdapter<Number> {
        C35632() {
        }

        public Double read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            Gson.checkValidFloatingPoint(number.doubleValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.Gson.3 */
    class C35643 extends TypeAdapter<Number> {
        C35643() {
        }

        public Float read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            Gson.checkValidFloatingPoint((double) number.floatValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gson.Gson.4 */
    static class C35654 extends TypeAdapter<Number> {
        C35654() {
        }

        public Number read(JsonReader jsonReader) {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* renamed from: com.google.gson.Gson.5 */
    static class C35665 extends TypeAdapter<AtomicLong> {
        final /* synthetic */ TypeAdapter val$longAdapter;

        C35665(TypeAdapter typeAdapter) {
            this.val$longAdapter = typeAdapter;
        }

        public AtomicLong read(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.val$longAdapter.read(jsonReader)).longValue());
        }

        public void write(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.val$longAdapter.write(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: com.google.gson.Gson.6 */
    static class C35676 extends TypeAdapter<AtomicLongArray> {
        final /* synthetic */ TypeAdapter val$longAdapter;

        C35676(TypeAdapter typeAdapter) {
            this.val$longAdapter = typeAdapter;
        }

        public AtomicLongArray read(JsonReader jsonReader) {
            List arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.val$longAdapter.read(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }

        public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.val$longAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
            }
            jsonWriter.endArray();
        }
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        public T read(JsonReader jsonReader) {
            if (this.delegate != null) {
                return this.delegate.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        public void write(JsonWriter jsonWriter, T t) {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            this.delegate.write(jsonWriter, t);
        }
    }

    static {
        NULL_KEY_SURROGATE = new C35621();
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), DEFAULT_SPECIALIZE_FLOAT_VALUES, DEFAULT_SPECIALIZE_FLOAT_VALUES, DEFAULT_SPECIALIZE_FLOAT_VALUES, DEFAULT_ESCAPE_HTML, DEFAULT_SPECIALIZE_FLOAT_VALUES, DEFAULT_SPECIALIZE_FLOAT_VALUES, DEFAULT_SPECIALIZE_FLOAT_VALUES, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.calls = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.constructorConstructor = new ConstructorConstructor(map);
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.serializeNulls = z;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        List arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z7)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z7)));
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(TimeTypeAdapter.FACTORY);
        arrayList.add(SqlDateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(this.constructorConstructor, z2));
        this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        arrayList.add(this.jsonAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (Throwable e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(TypeAdapter<Number> typeAdapter) {
        return new C35665(typeAdapter).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(TypeAdapter<Number> typeAdapter) {
        return new C35676(typeAdapter).nullSafe();
    }

    static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        return z ? TypeAdapters.DOUBLE : new C35632();
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        return z ? TypeAdapters.FLOAT : new C35643();
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.LONG : new C35654();
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) {
        return Primitives.wrap(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) {
        return jsonElement == null ? null : fromJson(new JsonTreeReader(jsonElement), type);
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) {
        boolean z = DEFAULT_ESCAPE_HTML;
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(DEFAULT_ESCAPE_HTML);
        try {
            jsonReader.peek();
            z = DEFAULT_SPECIALIZE_FLOAT_VALUES;
            T read = getAdapter(TypeToken.get(type)).read(jsonReader);
            jsonReader.setLenient(isLenient);
            return read;
        } catch (Throwable e) {
            if (z) {
                jsonReader.setLenient(isLenient);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> T fromJson(Reader reader, Class<T> cls) {
        JsonReader newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, (Type) cls);
        assertFullConsumption(fromJson, newJsonReader);
        return Primitives.wrap(cls).cast(fromJson);
    }

    public <T> T fromJson(Reader reader, Type type) {
        JsonReader newJsonReader = newJsonReader(reader);
        T fromJson = fromJson(newJsonReader, type);
        assertFullConsumption(fromJson, newJsonReader);
        return fromJson;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        return Primitives.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> T fromJson(String str, Type type) {
        return str == null ? null : fromJson(new StringReader(str), type);
    }

    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        Object obj;
        Map map = this.typeTokenCache;
        if (typeToken == null) {
            obj = NULL_KEY_SURROGATE;
        } else {
            TypeToken<T> typeToken2 = typeToken;
        }
        TypeAdapter<T> typeAdapter = (TypeAdapter) map.get(obj);
        if (typeAdapter == null) {
            Map map2;
            Map map3 = (Map) this.calls.get();
            Object obj2 = null;
            if (map3 == null) {
                HashMap hashMap = new HashMap();
                this.calls.set(hashMap);
                map2 = hashMap;
                obj2 = 1;
            } else {
                map2 = map3;
            }
            FutureTypeAdapter futureTypeAdapter = (FutureTypeAdapter) map2.get(typeToken);
            if (futureTypeAdapter == null) {
                try {
                    FutureTypeAdapter futureTypeAdapter2 = new FutureTypeAdapter();
                    map2.put(typeToken, futureTypeAdapter2);
                    for (TypeAdapterFactory create : this.factories) {
                        typeAdapter = create.create(this, typeToken);
                        if (typeAdapter != null) {
                            futureTypeAdapter2.setDelegate(typeAdapter);
                            this.typeTokenCache.put(typeToken, typeAdapter);
                            map2.remove(typeToken);
                            if (obj2 != null) {
                                this.calls.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + typeToken);
                } catch (Throwable th) {
                    map2.remove(typeToken);
                    if (obj2 != null) {
                        this.calls.remove();
                    }
                }
            }
        }
        return typeAdapter;
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get((Class) cls));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        Object obj = null;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (obj != null) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(JsonElement jsonElement) {
        Appendable stringWriter = new StringWriter();
        toJson(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object obj) {
        return obj == null ? toJson(JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public String toJson(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(DEFAULT_ESCAPE_HTML);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(jsonElement, jsonWriter);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(Object obj, Appendable appendable) {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson(JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) {
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(DEFAULT_ESCAPE_HTML);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            adapter.write(jsonWriter, obj);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}

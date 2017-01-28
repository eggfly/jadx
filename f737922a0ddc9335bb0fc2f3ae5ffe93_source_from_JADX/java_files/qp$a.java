public enum qp$a {
    PURCHASED,
    CANCELED,
    REFUNDED;

    public static qp$a j6(int i) {
        qp$a[] values = values();
        if (i < 0 || i >= values.length) {
            return CANCELED;
        }
        return values[i];
    }
}

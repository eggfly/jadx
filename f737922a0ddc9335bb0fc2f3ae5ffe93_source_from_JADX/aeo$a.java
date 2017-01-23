public enum aeo$a {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    
    private final String v5;

    private aeo$a(String str) {
        this.v5 = str;
    }

    public String toString() {
        return this.v5;
    }
}

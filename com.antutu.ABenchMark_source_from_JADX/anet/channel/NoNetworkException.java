package anet.channel;

public class NoNetworkException extends Exception {
    private SessionRequest f2155a;

    public NoNetworkException(SessionRequest sessionRequest) {
        this.f2155a = sessionRequest;
    }

    public String toString() {
        return "NoNetwork " + super.toString();
    }
}

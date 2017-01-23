package anet.channel;

public class NoAvailStrategyException extends Exception {
    private SessionRequest f2154a;

    public NoAvailStrategyException(SessionRequest sessionRequest) {
        this.f2154a = sessionRequest;
    }

    public String toString() {
        return "No Available Strategy" + super.toString();
    }
}

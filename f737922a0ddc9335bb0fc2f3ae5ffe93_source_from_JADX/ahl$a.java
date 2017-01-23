import java.util.Observable;

public class ahl$a extends Observable {
    public void notifyObservers(Object obj) {
        super.setChanged();
        super.notifyObservers(obj);
    }
}

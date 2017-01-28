import org.eclipse.jgit.JGitText;

public abstract class auy extends ava {
    private aut Zo;
    private aux v5;

    protected auy(aoh aoh, avn avn) {
        super(aoh, avn);
        this.v5 = aux.j6();
    }

    public void j6(aux aux) {
        if (aux == null) {
            throw new NullPointerException(JGitText.j6().theFactoryMustNotBeNull);
        } else if (this.Zo != null) {
            throw new IllegalStateException(JGitText.j6().anSSHSessionHasBeenAlreadyCreated);
        } else {
            this.v5 = aux;
        }
    }

    protected aut j6() {
        if (this.Zo != null) {
            return this.Zo;
        }
        this.Zo = this.v5.j6(this.Hw, Ws(), this.FH.gn(), J0() > 0 ? J0() * 1000 : 0);
        return this.Zo;
    }

    public void DW() {
        if (this.Zo != null) {
            try {
                this.v5.j6(this.Zo);
            } finally {
                this.Zo = null;
            }
        }
    }
}

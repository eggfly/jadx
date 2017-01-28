import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;

public class avm extends auy implements avw {
    static final avl v5;

    static {
        v5 = new avm$1();
    }

    avm(aoh aoh, avn avn) {
        super(aoh, avn);
    }

    public atq QX() {
        avv avm_a = new avm$a(this, this.Hw.FH());
        atq avt = new avt(this, avm_a);
        avt.j6(avm_a.Hw());
        return avt;
    }

    public auj XL() {
        avv avm_a = new avm$a(this, this.Hw.FH());
        auj avu = new avu(this, avm_a);
        avu.j6(avm_a.Hw());
        return avu;
    }

    ChannelSftp j3() {
        int J0 = J0() > 0 ? J0() * 1000 : 0;
        try {
            Channel DW = ((atx) j6()).DW();
            DW.DW(J0);
            return (ChannelSftp) DW;
        } catch (Throwable e) {
            throw new amb(this.Hw, e.getMessage(), e);
        }
    }
}

package com.jcraft.jsch;

import java.util.Vector;

public interface IdentityRepository {

    public static class Wrapper implements IdentityRepository {
        private Vector DW;
        private boolean FH;
        private IdentityRepository j6;

        Wrapper(IdentityRepository identityRepository) {
            this(identityRepository, false);
        }

        Wrapper(IdentityRepository identityRepository, boolean z) {
            this.DW = new Vector();
            this.FH = false;
            this.j6 = identityRepository;
            this.FH = z;
        }

        public boolean j6(byte[] bArr) {
            return this.j6.j6(bArr);
        }

        public boolean DW(byte[] bArr) {
            return this.j6.DW(bArr);
        }

        public void DW() {
            this.DW.removeAllElements();
            this.j6.DW();
        }

        public Vector j6() {
            int i = 0;
            Vector vector = new Vector();
            for (int i2 = 0; i2 < this.DW.size(); i2++) {
                vector.add((Identity) this.DW.elementAt(i2));
            }
            Vector j6 = this.j6.j6();
            while (i < j6.size()) {
                vector.add(j6.elementAt(i));
                i++;
            }
            return vector;
        }

        void j6(Identity identity) {
            if (this.FH || identity.Hw() || !(identity instanceof IdentityFile)) {
                this.DW.addElement(identity);
                return;
            }
            try {
                this.j6.j6(((IdentityFile) identity).Zo().j6());
            } catch (JSchException e) {
            }
        }

        void FH() {
            if (this.DW.size() > 0) {
                Object[] toArray = this.DW.toArray();
                for (Object obj : toArray) {
                    Identity identity = (Identity) obj;
                    this.DW.removeElement(identity);
                    j6(identity);
                }
            }
        }
    }

    void DW();

    boolean DW(byte[] bArr);

    Vector j6();

    boolean j6(byte[] bArr);
}

import com.aide.uidesigner.ProxyTextView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class atk extends atg {
    final Map<ans, String> DW;
    private final avd FH;
    private String Hw;
    InputStream j6;
    private arw v5;

    atk(avd avd, InputStream inputStream) {
        this.DW = new HashMap();
        this.FH = avd;
        this.j6 = new BufferedInputStream(inputStream);
        try {
            switch (VH()) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    gn();
                default:
                    throw new amb(this.FH.Hw, JGitText.j6().notABundle);
            }
        } catch (amb e) {
            u7();
            throw e;
        } catch (Throwable e2) {
            u7();
            throw new amb(this.FH.Hw, e2.getMessage(), e2);
        } catch (Throwable e22) {
            u7();
            throw new amb(this.FH.Hw, e22.getMessage(), e22);
        }
    }

    private int VH() {
        if ("# v2 git bundle".equals(j6(new byte[1024]))) {
            return 2;
        }
        throw new amb(this.FH.Hw, JGitText.j6().notABundle);
    }

    private void gn() {
        String substring;
        byte[] bArr = new byte[1024];
        Map linkedHashMap = new LinkedHashMap();
        while (true) {
            String j6 = j6(bArr);
            if (j6.length() == 0) {
                j6(linkedHashMap);
                return;
            } else if (j6.charAt(0) == '-') {
                ans DW = ans.DW(j6.substring(1, 41));
                Object obj = null;
                if (j6.length() > 42) {
                    obj = j6.substring(42);
                }
                this.DW.put(DW, obj);
            } else {
                substring = j6.substring(41, j6.length());
                if (((aoc) linkedHashMap.put(substring, new anu$c(aoc$a.NETWORK, substring, ans.DW(j6.substring(0, 40))))) != null) {
                    break;
                }
            }
        }
        throw DW(substring);
    }

    private alq DW(String str) {
        return new alq(this.FH.Hw, MessageFormat.format(JGitText.j6().duplicateAdvertisementsOf, new Object[]{str}));
    }

    private String j6(byte[] bArr) {
        this.j6.mark(bArr.length);
        int read = this.j6.read(bArr);
        int i = 0;
        while (i < read && bArr[i] != (byte) 10) {
            i++;
        }
        this.j6.reset();
        awx.j6(this.j6, (long) i);
        if (i < read && bArr[i] == (byte) 10) {
            awx.j6(this.j6, 1);
        }
        return axe.j6(anj.DW, bArr, 0, i);
    }

    public boolean EQ() {
        return false;
    }

    protected void DW(aob aob, Collection<aoc> collection, Set<ans> set) {
        tp();
        anw Hw;
        try {
            Hw = this.FH.FH.Hw();
            aub j6 = Hw.j6(this.j6);
            j6.j6(true);
            j6.v5(this.FH.gn());
            j6.j6(this.Hw);
            this.v5 = j6.j6(anp.j6);
            Hw.FH();
            Hw.Hw();
        } catch (Throwable e) {
            u7();
            throw new amb(this.FH.Hw, e.getMessage(), e);
        } catch (Throwable e2) {
            u7();
            throw new amb(this.FH.Hw, e2.getMessage(), e2);
        } catch (Throwable th) {
            Hw.Hw();
        }
    }

    public void FH(String str) {
        this.Hw = str;
    }

    public Collection<arw> we() {
        if (this.v5 != null) {
            return Collections.singleton(this.v5);
        }
        return Collections.emptyList();
    }

    private void tp() {
        if (!this.DW.isEmpty()) {
            aql aql = new aql(this.FH.FH);
            aqe j6 = aql.j6("PREREQ");
            aqe j62 = aql.j6("SEEN");
            Map hashMap = new HashMap();
            List<aqg> arrayList = new ArrayList();
            for (Entry entry : this.DW.entrySet()) {
                anb anb = (ans) entry.getKey();
                try {
                    aqc Zo = aql.Zo(anb);
                    if (!Zo.DW(j6)) {
                        Zo.FH(j6);
                        arrayList.add(Zo);
                    }
                } catch (Throwable e) {
                    throw new amb(this.FH.Hw, JGitText.j6().cannotReadObject, e);
                } catch (ali e2) {
                    hashMap.put(anb, (String) entry.getValue());
                } catch (Throwable e3) {
                    throw new amb(this.FH.Hw, MessageFormat.format(JGitText.j6().cannotReadCommit, new Object[]{anb.DW()}), e3);
                } catch (Throwable th) {
                    aql.we();
                }
            }
            if (hashMap.isEmpty()) {
                for (aoc v5 : this.FH.FH.J8().values()) {
                    try {
                        aql.DW(aql.Zo(v5.v5()));
                    } catch (IOException e4) {
                    }
                }
                int size = arrayList.size();
                while (true) {
                    aqc Hw = aql.Hw();
                    if (Hw == null) {
                        break;
                    } else if (Hw.DW(j6)) {
                        Hw.FH(j62);
                        size--;
                        if (size == 0) {
                            break;
                        }
                    }
                }
                if (size > 0) {
                    for (aqg aqg : arrayList) {
                        if (!aqg.DW(j62)) {
                            hashMap.put(aqg, (String) this.DW.get(aqg));
                        }
                    }
                    throw new alh(this.FH.Hw, hashMap);
                }
                aql.we();
                return;
            }
            throw new alh(this.FH.Hw, hashMap);
        }
    }

    public void u7() {
        if (this.j6 != null) {
            try {
                this.j6.close();
            } catch (IOException e) {
            } finally {
                this.j6 = null;
            }
        }
    }
}

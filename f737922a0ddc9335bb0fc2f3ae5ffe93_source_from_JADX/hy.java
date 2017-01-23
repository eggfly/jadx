public class hy implements bi {
    private final ih DW;
    private ec FH;
    private int Hw;
    private final cc j6;

    public hy(cc ccVar, ih ihVar) {
        this.j6 = ccVar;
        this.DW = ihVar;
        if (ccVar != null) {
            this.FH = new ec();
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onabort")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onblur")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onchange")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onclick")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("ondblclick")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onerror")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onfocus")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onkeydown")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onkeypress")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onkeyup")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onload")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onmousedown")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onmousemove")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseout")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseover")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onmouseup")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onreset")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onselect")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onsubmit")));
            this.FH.j6(ccVar.ro.FH(ccVar.ro.j6("onunload")));
            this.Hw = ccVar.ro.j6("HREF");
        }
    }

    public void j6(bv bvVar) {
        StringBuffer stringBuffer = new StringBuffer();
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        j6(DW, DW.Ws(), stringBuffer);
        this.j6.sh.j6(DW);
        this.j6.SI.j6(bvVar, stringBuffer.toString());
    }

    private void j6(cj cjVar, int i, StringBuffer stringBuffer) {
        int i2 = 2;
        int i3 = 0;
        int Mr;
        if (cjVar.P8(i)) {
            if (cjVar.rN(i) == 14 || cjVar.rN(i) == 15) {
                char[] j3 = cjVar.j3(i);
                Mr = cjVar.Mr(i);
                int U2 = cjVar.U2(i);
                while (i3 < U2) {
                    if (Character.isJavaIdentifierPart(j3[Mr + i3])) {
                        stringBuffer.append("<span ");
                        DW(cjVar, i, stringBuffer);
                        j6(stringBuffer);
                        stringBuffer.append(">");
                        stringBuffer.append(j3, Mr, U2);
                        stringBuffer.append("</span>");
                        return;
                    }
                    i3++;
                }
            }
            stringBuffer.append(cjVar.j3(i), cjVar.Mr(i), cjVar.U2(i));
        } else if (cjVar.sy(i)) {
            stringBuffer.append(cjVar.BT(i));
        } else if (cjVar.yS(i)) {
            stringBuffer.append(cjVar.tp().Hw().XL(cjVar.rN(i)));
        } else {
            switch (cjVar.rN(i)) {
                case 203:
                    if (!this.FH.FH(ik.a8(cjVar, i))) {
                        stringBuffer.append(" ");
                        i2 = cjVar.lg(i);
                        while (i3 < i2) {
                            j6(cjVar, cjVar.Hw(i, i3), stringBuffer);
                            i3++;
                        }
                        stringBuffer.append(" ");
                    }
                case 210:
                    String j6 = this.j6.ro.j6(this.j6.ro.FH(cjVar.gW(cjVar.Hw(cjVar.Hw(i, 0), 1))));
                    if ((cjVar.lg(cjVar.Hw(i, 1)) != 0 && cjVar.rN(cjVar.Hw(cjVar.Hw(i, 1), 0)) == 46) || j6.equals("META")) {
                        return;
                    }
                    if (j6.indexOf(":") != -1) {
                        String j62;
                        if (j6.equals("ASP:BUTTON")) {
                            stringBuffer.append("<button ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            j62 = j6(cjVar, i);
                            if (j62 == null) {
                                j62 = "asp:button";
                            }
                            stringBuffer.append(j62);
                            stringBuffer.append("</button>");
                        } else if (j6.equals("ASP:LINKBUTTON")) {
                            stringBuffer.append("<button ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            j62 = j6(cjVar, i);
                            if (j62 == null) {
                                j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                            } else {
                                stringBuffer.append(j62);
                            }
                            stringBuffer.append("</button>");
                        } else if (j6.equals("ASP:LABEL")) {
                            stringBuffer.append("<span ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            j62 = j6(cjVar, i);
                            if (j62 == null) {
                                j62 = "asp:label";
                            }
                            stringBuffer.append(j62);
                            stringBuffer.append("</span>");
                        } else if (j6.equals("ASP:HYPERLINK")) {
                            stringBuffer.append("<a ");
                            stringBuffer.append(">");
                            j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                            stringBuffer.append("</a>");
                        } else if (j6.equals("ASP:TEXTBOX")) {
                            stringBuffer.append("<input ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            stringBuffer.append("</input>");
                        } else if (j6.equals("ASP:DROPDOWNLIST")) {
                            stringBuffer.append("<select ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            stringBuffer.append("</select>");
                        } else if (j6.equals("ASP:CHECKBOX")) {
                            stringBuffer.append("<input type=checkbox ");
                            DW(cjVar, i, stringBuffer);
                            j6(stringBuffer);
                            stringBuffer.append(">");
                            j62 = j6(cjVar, i);
                            if (j62 == null) {
                                j62 = "asp:checkbox";
                            }
                            stringBuffer.append(j62);
                            stringBuffer.append("</input>");
                        } else {
                            j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                        }
                    } else if (j6.equals("A")) {
                        stringBuffer.append("<a href=\"$LINK_TO_ME$\"");
                        DW(cjVar, i, stringBuffer);
                        stringBuffer.append(">");
                        j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                        stringBuffer.append("</a>");
                    } else if (j6.equals("INPUT")) {
                        stringBuffer.append("<input");
                        DW(cjVar, i, stringBuffer);
                        j6(stringBuffer);
                        i3 = cjVar.Hw(i, 0);
                        while (i2 < cjVar.lg(i3) - 1) {
                            j6(cjVar, cjVar.Hw(i3, i2), stringBuffer);
                            i2++;
                        }
                        stringBuffer.append(">");
                        j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                        stringBuffer.append("</input>");
                    } else {
                        if (!cjVar.er(cjVar.Hw(i, 0))) {
                            j6(cjVar, cjVar.Hw(i, 0), stringBuffer);
                        }
                        j6(cjVar, cjVar.Hw(i, 1), stringBuffer);
                        if (!cjVar.er(cjVar.Hw(i, 2))) {
                            j6(cjVar, cjVar.Hw(i, 2), stringBuffer);
                        }
                    }
                case 300:
                case 304:
                case 305:
                case 320:
                case 301:
                case 302:
                case 303:
                    if (cjVar.rN(cjVar.aM(i)) == 211) {
                        stringBuffer.append("<span style=\"font-size: 12; color: red; font-family: sans-serif\"");
                        DW(cjVar, i, stringBuffer);
                        j6(stringBuffer);
                        stringBuffer.append(">");
                        stringBuffer.append("&lt;% ... %&gt;");
                        stringBuffer.append("</span>");
                    }
                default:
                    Mr = cjVar.lg(i);
                    for (i2 = 0; i2 < Mr; i2++) {
                        j6(cjVar, cjVar.Hw(i, i2), stringBuffer);
                    }
            }
        }
    }

    private String j6(cj cjVar, int i) {
        int Hw = cjVar.Hw(i, 0);
        for (int i2 = 2; i2 < cjVar.lg(Hw); i2++) {
            int Hw2 = cjVar.Hw(Hw, i2);
            if (this.j6.ro.j6(this.j6.ro.FH(cjVar.gW(cjVar.Hw(Hw2, 0)))).equals("TEXT")) {
                Hw2 = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 1);
                if (cjVar.lg(Hw2) == 3 && cjVar.rN(cjVar.Hw(Hw2, 1)) == 18) {
                    return cjVar.a8(cjVar.Hw(Hw2, 1));
                }
            }
        }
        return null;
    }

    private void j6(StringBuffer stringBuffer) {
        stringBuffer.append(" style=\"cursor:hand\" ");
    }

    private void DW(cj cjVar, int i, StringBuffer stringBuffer) {
        stringBuffer.append(" onclick=\"document.title='code:");
        stringBuffer.append(cjVar.nw(i));
        stringBuffer.append(":");
        stringBuffer.append(cjVar.KD(i));
        stringBuffer.append(":");
        stringBuffer.append(cjVar.SI(i));
        stringBuffer.append(":");
        stringBuffer.append(cjVar.ro(i));
        stringBuffer.append("';return true;\" ");
    }
}

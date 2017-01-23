package com.aide.appwizard.runtime;

import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class a {
    protected Document DW;
    protected AppWizardActivity j6;

    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[d.values().length];
            try {
                j6[d.SliderDrawer.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[d.SpinnerDrawer.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[d.TabsDrawer.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[d.Drawer.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[d.Spinner.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public class a {
        private Element DW;
        final /* synthetic */ a j6;

        public a(a aVar, Element element) {
            this.j6 = aVar;
            this.DW = element;
        }

        public b j6() {
            Node appendChild = this.DW.appendChild(this.j6.DW.createElement("activity"));
            this.j6.j6(1);
            return new b(this.j6, (Element) appendChild);
        }

        public b DW() {
            return new b(this.j6, (Element) this.j6.DW.getElementsByTagName("activity").item(0));
        }
    }

    public class b {
        private Element DW;
        final /* synthetic */ a j6;

        public b(a aVar, Element element) {
            this.j6 = aVar;
            this.DW = element;
        }

        public e j6() {
            String j6 = this.j6.DW(this.DW, "theme");
            if (j6 != null) {
                return e.valueOf(j6);
            }
            return e.HoloLightDarkActionBar;
        }

        public void j6(e eVar) {
            this.DW.setAttribute("theme", eVar.name());
            this.j6.j6(1);
        }

        public d DW() {
            String j6 = this.j6.DW(this.DW, "type");
            if (j6 != null) {
                return d.valueOf(j6);
            }
            return d.Tabs;
        }

        public void j6(d dVar) {
            this.DW.setAttribute("type", dVar.name());
            Hw(Boolean.valueOf(dVar.DW()));
            if (dVar.j6() && tp().size() < 2) {
                we();
            }
            this.j6.j6(1);
        }

        public String FH() {
            String j6 = this.j6.DW(this.DW, "title");
            return j6 != null ? j6 : "MyApp";
        }

        public void j6(String str) {
            this.DW.setAttribute("title", str);
            this.j6.j6(2);
        }

        public void j6(Boolean bool) {
            Hw(bool);
            this.j6.j6(2);
        }

        private void Hw(Boolean bool) {
            this.j6.j6(this.DW, "showtitle", bool);
        }

        public boolean Hw() {
            return !Boolean.FALSE.equals(v5());
        }

        public Boolean v5() {
            return this.j6.j6(this.DW, "showtitle");
        }

        public void DW(Boolean bool) {
            this.j6.j6(this.DW, "showactionbar", bool);
            this.j6.j6(2);
        }

        public boolean Zo() {
            return !Boolean.FALSE.equals(VH());
        }

        public Boolean VH() {
            return this.j6.j6(this.DW, "showactionbar");
        }

        public void FH(Boolean bool) {
            this.j6.j6(this.DW, "fullscreen", bool);
            this.j6.j6(1);
        }

        public boolean gn() {
            return Boolean.TRUE.equals(u7());
        }

        public Boolean u7() {
            return this.j6.j6(this.DW, "fullscreen");
        }

        public c j6(int i) {
            return (c) tp().get(i);
        }

        public List<c> tp() {
            List<c> arrayList = new ArrayList();
            NodeList childNodes = this.DW.getChildNodes();
            int i = 0;
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                if (childNodes.item(i2) instanceof Element) {
                    Element element = (Element) childNodes.item(i2);
                    if ("fragment".equals(element.getTagName())) {
                        int i3 = i + 1;
                        arrayList.add(new c(this.j6, element, i));
                        i = i3;
                    }
                }
            }
            return arrayList;
        }

        public c EQ() {
            c we = we();
            this.j6.j6(2);
            return we;
        }

        private c we() {
            int size = tp().size();
            Object createElement = this.j6.DW.createElement("fragment");
            this.DW.appendChild(createElement);
            c cVar = new c(this.j6, createElement, size);
            cVar.DW("Section " + (size + 1));
            return cVar;
        }
    }

    public class c {
        private Element DW;
        private int FH;
        final /* synthetic */ a j6;

        public c(a aVar, Element element, int i) {
            this.j6 = aVar;
            this.DW = element;
            this.FH = i;
        }

        public int j6() {
            return this.FH;
        }

        public String DW() {
            return this.j6.DW(this.DW, "layout");
        }

        public void j6(String str) {
            this.DW.setAttribute("layout", str);
            this.j6.j6(0);
        }

        public b FH() {
            return this.j6.DW();
        }

        public void DW(String str) {
            this.DW.setAttribute("title", str);
            this.j6.j6(2);
        }

        public String Hw() {
            return this.j6.DW(this.DW, "title");
        }

        public void v5() {
            this.DW.getParentNode().removeChild(this.DW);
            this.j6.j6(2);
        }
    }

    public enum d {
        Single("Single Section"),
        Drawer("Single Section with Drawer"),
        Slider("Scrollable Tabs"),
        SliderDrawer("Scrollable Tabs with Drawer"),
        Tabs("Fixed Tabs"),
        TabsDrawer("Fixed Tabs with Drawer"),
        Spinner("Dropdown List"),
        SpinnerDrawer("Dropdown List with Drawer");
        
        public String u7;

        private d(String str) {
            this.u7 = str;
        }

        public boolean j6() {
            switch (1.j6[ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    return true;
                default:
                    return false;
            }
        }

        public boolean DW() {
            switch (1.j6[ordinal()]) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case 5:
                    return false;
                default:
                    return true;
            }
        }

        public static d j6(String str) {
            for (d dVar : values()) {
                if (dVar.u7.equals(str)) {
                    return dVar;
                }
            }
            return Single;
        }

        public static List<String> FH() {
            List<String> arrayList = new ArrayList();
            for (d dVar : values()) {
                arrayList.add(dVar.u7);
            }
            return arrayList;
        }
    }

    public enum e {
        HoloDark("Holo Dark"),
        HoloLight("Holo Light"),
        HoloLightHoloActionBar("Holo Light Holo ActionBar"),
        HoloLightDarkActionBar("Holo Light Dark ActionBar"),
        DeviceDefault("Device Default Dark"),
        DeviceDefaultLight("Device Default Light"),
        DeviceDefaultLightDarkActionBar("Device Default Light Dark ActionBar");
        
        public String gn;

        private e(String str) {
            this.gn = str;
        }

        public static e j6(String str) {
            for (e eVar : values()) {
                if (eVar.gn.equals(str)) {
                    return eVar;
                }
            }
            return HoloLightDarkActionBar;
        }

        public static List<String> j6() {
            List<String> arrayList = new ArrayList();
            for (e eVar : values()) {
                arrayList.add(eVar.gn);
            }
            return arrayList;
        }
    }

    public a(AppWizardActivity appWizardActivity) {
        this.j6 = appWizardActivity;
        this.DW = appWizardActivity.tp();
        if (this.DW == null) {
            j6();
        }
    }

    public void j6(Document document, int i) {
        this.DW = document;
        DW(i);
    }

    private void j6(int i) {
        if (this.j6.Ws() != null) {
            this.j6.j6(this.DW, i);
            DW(i);
        }
    }

    private void DW(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                this.j6.recreate();
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                this.j6.J0();
            default:
        }
    }

    private String DW(Element element, String str) {
        String attribute = element.getAttribute(str);
        return (attribute == null || attribute.length() <= 0) ? null : attribute;
    }

    public void j6(Element element, String str, Boolean bool) {
        if (bool == null) {
            element.setAttribute(str, null);
        } else {
            element.setAttribute(str, Boolean.toString(bool.booleanValue()));
        }
    }

    public Boolean j6(Element element, String str) {
        String DW = DW(element, str);
        if (DW == null) {
            return null;
        }
        return Boolean.valueOf("true".equals(DW));
    }

    public void j6() {
        try {
            this.DW = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            this.DW.appendChild(this.DW.createElement("app"));
            j6(1);
        } catch (ParserConfigurationException e) {
        }
        b j6 = FH().j6();
        j6.EQ();
        j6.EQ();
        j6.EQ();
    }

    public b DW() {
        return FH().DW();
    }

    public a FH() {
        return new a(this, (Element) this.DW.getElementsByTagName("app").item(0));
    }
}

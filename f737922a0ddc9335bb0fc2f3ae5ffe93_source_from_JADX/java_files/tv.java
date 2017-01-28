public final class tv {
    public static int DW;
    public static int FH;
    public static int Hw;
    public static int VH;
    public static int Zo;
    public static int j6;
    public static int v5;

    static {
        j6 = 0;
        DW = 0;
        FH = 0;
        Hw = 0;
        v5 = 0;
        Zo = 0;
        VH = 0;
    }

    public static void j6(int i) {
        VH += i;
    }

    public static void j6(ue ueVar, ue ueVar2) {
        v5 += ueVar2.Zo().v5() - ueVar.Zo().v5();
        Hw += ueVar2.Zo().Zo() - ueVar.Zo().Zo();
        Zo += ueVar2.Zo().v5();
    }

    public static void j6(aaa aaa, aaa aaa2) {
        int VH = aaa.j6().VH();
        int v5 = aaa.j6().v5();
        int VH2 = aaa2.j6().VH();
        DW = (VH2 - VH) + DW;
        j6 += aaa2.j6().v5() - v5;
        FH += VH2;
    }
}

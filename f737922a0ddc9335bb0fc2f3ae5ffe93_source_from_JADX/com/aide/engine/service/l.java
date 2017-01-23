package com.aide.engine.service;

import bh;
import cc;
import eo;
import ex;
import ey;
import fc;
import fj;
import ft;
import fz;
import gs;
import hp;
import ig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import qh;

public class l {
    public static TreeMap<String, List<String>> j6(List<String> list) {
        TreeMap<String, List<String>> treeMap = new TreeMap();
        for (bh bhVar : DW(list)) {
            treeMap.put(bhVar.j6(), Arrays.asList(bhVar.Hw()));
        }
        return treeMap;
    }

    public static bh j6(String str, List<String> list) {
        String Zo = qh.Zo(str);
        for (bh bhVar : DW(list)) {
            for (String str2 : Arrays.asList(bhVar.Hw())) {
                if (eo.j6() != null && eo.j6().j6(Zo, str2)) {
                    return bhVar;
                }
            }
        }
        return null;
    }

    private static bh[] DW(List<String> list) {
        return j6(null, (List) list);
    }

    public static bh[] j6(cc ccVar, List<String> list) {
        int i = 0;
        bh[] bhVarArr = new bh[]{new gs(ccVar), new ey(ccVar), new ig(ccVar), new fz(ccVar), new fj(ccVar), new hp(ccVar), new ft(ccVar), new fc(ccVar), new ex(ccVar)};
        List arrayList = new ArrayList();
        int length = bhVarArr.length;
        while (i < length) {
            bh bhVar = bhVarArr[i];
            if (list.contains(bhVar.j6())) {
                arrayList.add(bhVar);
            }
            i++;
        }
        return (bh[]) arrayList.toArray(new bh[arrayList.size()]);
    }
}

package org.codehaus.groovy.ast.expr;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.ast.ClassHelper;

public class MapExpression extends Expression {
    private final List<MapEntryExpression> DW;

    public MapExpression() {
        this(new ArrayList());
    }

    public MapExpression(List<MapEntryExpression> list) {
        this.DW = list;
        DW(ClassHelper.VH);
    }

    public String toString() {
        return super.toString() + this.DW;
    }

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("[");
        int size = this.DW.size();
        if (size > 0) {
            MapEntryExpression mapEntryExpression = (MapEntryExpression) this.DW.get(0);
            stringBuilder.append(mapEntryExpression.Zo().j6() + ":" + mapEntryExpression.VH().j6());
            int i = 1;
            while (i < size) {
                mapEntryExpression = (MapEntryExpression) this.DW.get(i);
                stringBuilder.append(", " + mapEntryExpression.Zo().j6() + ":" + mapEntryExpression.VH().j6());
                if (stringBuilder.length() > 120 && i < size - 1) {
                    stringBuilder.append(", ... ");
                    break;
                }
                i++;
            }
        } else {
            stringBuilder.append(":");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

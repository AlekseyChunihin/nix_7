package ua.com.alevel.level1.triangleArea;

import java.math.BigDecimal;

public class TriangleArea {

    public static BigDecimal area(int xA, int yA, int xB, int yB, int xC, int yC) {
        double AB = Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA));
        double AC = Math.sqrt((xC - xA) * (xC - xA) + (yC - yA) * (yC - yA));
        double BC = Math.sqrt((xC - xB) * (xC - xB) + (yC - yB) * (yC - yB));
        if (AB + BC < AC || AC + BC < AB || AC + AB < BC) {
            return BigDecimal.valueOf(-1);
        }
        BigDecimal result = ((BigDecimal.valueOf(xB).subtract(BigDecimal.valueOf(xA)).multiply(BigDecimal.valueOf(yC).subtract(BigDecimal.valueOf(yA))).subtract(BigDecimal.valueOf(xC).subtract(BigDecimal.valueOf(xA)).multiply(BigDecimal.valueOf(yB).subtract(BigDecimal.valueOf(yA)))))).divide(BigDecimal.valueOf(2));
        return result.abs();
    }
}

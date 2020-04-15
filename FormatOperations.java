package co.uk.directlinegroup.tt.utils.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormatOperations {

    public String FloatToStingFormat(float f) {
        DecimalFormat df = new DecimalFormat("0.0000000000");
        String str = String.valueOf(df.format(f));
        return str;
    }

    public String FloatToStingFormat(double f) {
        DecimalFormat df = new DecimalFormat("0.0000000000");
        String str = String.valueOf(df.format(f));
        return str;
    }

    public float convertStringtofloat(String str) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("0.0000000000");
        format.setDecimalFormatSymbols(symbols);

        Float val = Float.valueOf(0);
        try {
            val = format.parse(str).floatValue();
        } catch (Exception e) {

        }
        return val;
    }

}

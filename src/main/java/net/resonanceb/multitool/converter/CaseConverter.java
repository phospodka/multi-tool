package net.resonanceb.multitool.converter;

import com.google.common.base.CaseFormat;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * A class to format a string to various cases without knowing the input format. Only function for ASCII input.
 *
 * Google's CaseFormat works on the assumption of known formats. If we do not know what the format is, there can be
 * problems with attempting to do a blanket conversion.
 *
 * e.g. if `lowerCamel` was passed and we used the UPPER_UNDERSCORE converter, it would be formatted to `lowercamel`
 *
 * Has support for:
 * - lower camel - lowerCamel
 * - lower hyphen - lower-hyphen
 * - lower underscore - lower_underscore
 * - upper camel - UpperCamel
 * - upper hyphen - UPPER-HYPHEN
 * - upper underscore - UPPER_UNDERSCORE
 *
 * @author Peter Hospodka
 * @since 1.0
 */
public class CaseConverter {

    private static final Pattern LOWER_CAMEL_PATTERN = Pattern.compile("^[a-z0-9][a-zA-Z0-9]+$");
    private static final Pattern LOWER_HYPHEN_PATTERN = Pattern.compile("^[a-z0-9]+(?:-[a-z0-9]+)*$");
    private static final Pattern LOWER_UNDERSCORE_PATTERN = Pattern.compile("^[a-z0-9]+(?:_[a-z0-9]+)*$");
    private static final Pattern UPPER_CAMEL_PATTERN = Pattern.compile("[A-Z0-9][a-zA-Z0-9]+");
    private static final Pattern UPPER_HYPHEN_PATTERN = Pattern.compile("^[A-Z0-9]+(?:-[A-Z0-9]+)*$");
    private static final Pattern UPPER_UNDERSCORE_PATTERN = Pattern.compile("^[A-Z0-9]+(?:_[A-Z0-9]+)*$");

    private static final Function<String, String> LH_TO_LC = CaseFormat.LOWER_HYPHEN.converterTo(CaseFormat.LOWER_CAMEL);
    private static final Function<String, String> LU_TO_LC = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);
    private static final Function<String, String> UC_TO_LC = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_CAMEL);
    private static final Function<String, String> UU_TO_LC = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL);

    private static final Function<String, String> LC_TO_LH = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_HYPHEN);
    private static final Function<String, String> LU_TO_LH = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.LOWER_HYPHEN);
    private static final Function<String, String> UC_TO_LH = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_HYPHEN);
    private static final Function<String, String> UU_TO_LH = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.LOWER_HYPHEN);

    private static final Function<String, String> LC_TO_LU = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static final Function<String, String> LH_TO_LU = CaseFormat.LOWER_HYPHEN.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static final Function<String, String> UC_TO_LU = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static final Function<String, String> UU_TO_LU = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.LOWER_UNDERSCORE);

    private static final Function<String, String> LC_TO_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);
    private static final Function<String, String> LH_TO_UC = CaseFormat.LOWER_HYPHEN.converterTo(CaseFormat.UPPER_CAMEL);
    private static final Function<String, String> LU_TO_UC = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);
    private static final Function<String, String> UU_TO_UC = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);

    private static final Function<String, String> LC_TO_UU = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_UNDERSCORE);
    private static final Function<String, String> LH_TO_UU = CaseFormat.LOWER_HYPHEN.converterTo(CaseFormat.UPPER_UNDERSCORE);
    private static final Function<String, String> LU_TO_UU = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_UNDERSCORE);
    private static final Function<String, String> UC_TO_UU = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.UPPER_UNDERSCORE);

    /**
     * Convert a string to lower camel case i.e. <code>lowerCamelCase</code>
     * @param input String to be formatted
     * @return string converted to lower camel case
     */
    public static String toLowerCamel(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_LC.apply(input);
        } else if (LOWER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return LU_TO_LC.apply(input);
        } else if (UPPER_CAMEL_PATTERN.matcher(input).matches()) {
            return UC_TO_LC.apply(input);
        } else if (UPPER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_LC.apply(input.toUpperCase());
        } else if (UPPER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return UU_TO_LC.apply(input);
        } else {
            return input;
        }
    }

    /**
     * Convert a string to lower hyphen case i.e. <code>lower-hyphen-case</code>
     * @param input String to be formatted
     * @return string converted to lower hyphen case
     */
    public static String toLowerHyphen(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_CAMEL_PATTERN.matcher(input).matches()) {
            return LC_TO_LH.apply(input);
        } else if (LOWER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return LU_TO_LH.apply(input);
        } else if (UPPER_CAMEL_PATTERN.matcher(input).matches()) {
            return UC_TO_LH.apply(input);
        } else if (UPPER_HYPHEN_PATTERN.matcher(input).matches()) {
            return input.toLowerCase();
        } else if (UPPER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return UU_TO_LH.apply(input);
        } else {
            return input;
        }
    }

    /**
     * Convert a string to lower underscore case i.e. <code>lower_underscore_case</code>
     * @param input String to be formatted
     * @return string converted to lower underscore case
     */
    public static String toLowerUnderscore(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_CAMEL_PATTERN.matcher(input).matches()) {
            return LC_TO_LU.apply(input);
        } else if (LOWER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_LU.apply(input);
        } else if (UPPER_CAMEL_PATTERN.matcher(input).matches()) {
            return UC_TO_LU.apply(input);
        } else if (UPPER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_LU.apply(input.toLowerCase());
        } else if (UPPER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return UU_TO_LU.apply(input);
        } else {
            return input;
        }
    }

    /**
     * Convert a string to upper camel case i.e. <code>UpperCamelCase</code>
     * @param input String to be formatted
     * @return string converted to upper camel case
     */
    public static String toUpperCamel(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_CAMEL_PATTERN.matcher(input).matches()) {
            return LC_TO_UC.apply(input);
        } else if (LOWER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_UC.apply(input);
        } else if (LOWER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return LU_TO_UC.apply(input);
        } else if (UPPER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_UC.apply(input.toLowerCase());
        } else if (UPPER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return UU_TO_UC.apply(input);
        } else {
            return input;
        }
    }

    /**
     * Convert a string to upper hyphen case i.e. <code>UPPER-UNDERSCORE-CASE</code>
     * @param input String to be formatted
     * @return string converted to upper hyphen case
     */
    public static String toUpperHyphen(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_CAMEL_PATTERN.matcher(input).matches()) {
            return LC_TO_LH.apply(input).toUpperCase();
        } else if (LOWER_HYPHEN_PATTERN.matcher(input).matches()) {
            return input.toLowerCase().toUpperCase();
        } else if (LOWER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return LU_TO_LH.apply(input).toUpperCase();
        } else if (UPPER_CAMEL_PATTERN.matcher(input).matches()) {
            return UC_TO_LH.apply(input).toUpperCase();
        } else if (UPPER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return UU_TO_LH.apply(input).toUpperCase();
        } else {
            return input;
        }
    }

    /**
     * Convert a string to upper underscore case i.e. <code>UPPER_UNDERSCORE_CASE</code>
     * @param input String to be formatted
     * @return string converted to upper underscore case
     */
    public static String toUpperUnderscore(String input) {

        if (input == null) {
            return null;
        } else if (LOWER_CAMEL_PATTERN.matcher(input).matches()) {
            return LC_TO_UU.apply(input);
        } else if (LOWER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_UU.apply(input);
        } else if (LOWER_UNDERSCORE_PATTERN.matcher(input).matches()) {
            return LU_TO_UU.apply(input);
        } else if (UPPER_CAMEL_PATTERN.matcher(input).matches()) {
            return UC_TO_UU.apply(input);
        } else if (UPPER_HYPHEN_PATTERN.matcher(input).matches()) {
            return LH_TO_UU.apply(input.toLowerCase());
        } else {
            return input;
        }
    }

}

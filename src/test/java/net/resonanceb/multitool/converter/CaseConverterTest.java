package net.resonanceb.multitool.converter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CaseConverterTest {

    private static final String LOWER_CAMEL = "oneTwoThree";
    private static final String LOWER_HYPHEN = "one-two-three";
    private static final String LOWER_UNDERSCORE = "one_two_three";
    private static final String UPPER_CAMEL = "OneTwoThree";
    private static final String UPPER_HYPHEN = "ONE-TWO-THREE";
    private static final String UPPER_UNDERSCORE = "ONE_TWO_THREE";

    private static final String LOWER_CAMEL_NUM = "0neTw0Thr3e";
    private static final String LOWER_HYPHEN_NUM = "0ne-tw0-thr3e";
    private static final String LOWER_UNDERSCORE_NUM = "0ne_tw0_thr3e";
    private static final String UPPER_CAMEL_NUM = "0neTw0Thr3e";
    private static final String UPPER_HYPHEN_NUM = "0NE-TW0-THR3E";
    private static final String UPPER_UNDERSCORE_NUM = "0NE_TW0_THR3E";

    @Test
    public void testToLowerCamel() {
        assertThat(CaseConverter.toLowerCamel(LOWER_CAMEL), is(LOWER_CAMEL));
        assertThat(CaseConverter.toLowerCamel(LOWER_HYPHEN), is(LOWER_CAMEL));
        assertThat(CaseConverter.toLowerCamel(LOWER_UNDERSCORE), is(LOWER_CAMEL));
        assertThat(CaseConverter.toLowerCamel(UPPER_CAMEL), is(LOWER_CAMEL));
        assertThat(CaseConverter.toLowerCamel(UPPER_HYPHEN), is(LOWER_CAMEL));
        assertThat(CaseConverter.toLowerCamel(UPPER_UNDERSCORE), is(LOWER_CAMEL));

        assertThat(CaseConverter.toLowerCamel(LOWER_CAMEL_NUM), is(LOWER_CAMEL_NUM));
        assertThat(CaseConverter.toLowerCamel(LOWER_HYPHEN_NUM), is(LOWER_CAMEL_NUM));
        assertThat(CaseConverter.toLowerCamel(LOWER_UNDERSCORE_NUM), is(LOWER_CAMEL_NUM));
        assertThat(CaseConverter.toLowerCamel(UPPER_CAMEL_NUM), is(LOWER_CAMEL_NUM));
        assertThat(CaseConverter.toLowerCamel(UPPER_HYPHEN_NUM), is(LOWER_CAMEL_NUM));
        assertThat(CaseConverter.toLowerCamel(UPPER_UNDERSCORE_NUM), is(LOWER_CAMEL_NUM));

        assertNull(CaseConverter.toLowerCamel(null));
    }

    @Test
    public void testToLowerHyphen() {
        assertThat(CaseConverter.toLowerHyphen(LOWER_CAMEL), is(LOWER_HYPHEN));
        assertThat(CaseConverter.toLowerHyphen(LOWER_HYPHEN), is(LOWER_HYPHEN));
        assertThat(CaseConverter.toLowerHyphen(LOWER_UNDERSCORE), is(LOWER_HYPHEN));
        assertThat(CaseConverter.toLowerHyphen(UPPER_CAMEL), is(LOWER_HYPHEN));
        assertThat(CaseConverter.toLowerHyphen(UPPER_HYPHEN), is(LOWER_HYPHEN));
        assertThat(CaseConverter.toLowerHyphen(UPPER_UNDERSCORE), is(LOWER_HYPHEN));

        assertThat(CaseConverter.toLowerHyphen(LOWER_CAMEL_NUM), is(LOWER_HYPHEN_NUM));
        assertThat(CaseConverter.toLowerHyphen(LOWER_HYPHEN_NUM), is(LOWER_HYPHEN_NUM));
        assertThat(CaseConverter.toLowerHyphen(LOWER_UNDERSCORE_NUM), is(LOWER_HYPHEN_NUM));
        assertThat(CaseConverter.toLowerHyphen(UPPER_CAMEL_NUM), is(LOWER_HYPHEN_NUM));
        assertThat(CaseConverter.toLowerHyphen(UPPER_HYPHEN_NUM), is(LOWER_HYPHEN_NUM));
        assertThat(CaseConverter.toLowerHyphen(UPPER_UNDERSCORE_NUM), is(LOWER_HYPHEN_NUM));

        assertNull(CaseConverter.toLowerHyphen(null));
    }

    @Test
    public void testToLowerUnderscore() {
        assertThat(CaseConverter.toLowerUnderscore(LOWER_CAMEL), is(LOWER_UNDERSCORE));
        assertThat(CaseConverter.toLowerUnderscore(LOWER_HYPHEN), is(LOWER_UNDERSCORE));
        assertThat(CaseConverter.toLowerUnderscore(LOWER_UNDERSCORE), is(LOWER_UNDERSCORE));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_CAMEL), is(LOWER_UNDERSCORE));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_HYPHEN), is(LOWER_UNDERSCORE));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_UNDERSCORE), is(LOWER_UNDERSCORE));

        assertThat(CaseConverter.toLowerUnderscore(LOWER_CAMEL_NUM), is(LOWER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toLowerUnderscore(LOWER_HYPHEN_NUM), is(LOWER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toLowerUnderscore(LOWER_UNDERSCORE_NUM), is(LOWER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_CAMEL_NUM), is(LOWER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_HYPHEN_NUM), is(LOWER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toLowerUnderscore(UPPER_UNDERSCORE_NUM), is(LOWER_UNDERSCORE_NUM));

        assertNull(CaseConverter.toLowerUnderscore(null));
    }

    @Test
    public void testToUpperCamel() {
        assertThat(CaseConverter.toUpperCamel(LOWER_CAMEL), is(UPPER_CAMEL));
        assertThat(CaseConverter.toUpperCamel(LOWER_HYPHEN), is(UPPER_CAMEL));
        assertThat(CaseConverter.toUpperCamel(LOWER_UNDERSCORE), is(UPPER_CAMEL));
        assertThat(CaseConverter.toUpperCamel(UPPER_CAMEL), is(UPPER_CAMEL));
        assertThat(CaseConverter.toUpperCamel(UPPER_HYPHEN), is(UPPER_CAMEL));
        assertThat(CaseConverter.toUpperCamel(UPPER_UNDERSCORE), is(UPPER_CAMEL));

        assertThat(CaseConverter.toUpperCamel(LOWER_CAMEL_NUM), is(UPPER_CAMEL_NUM));
        assertThat(CaseConverter.toUpperCamel(LOWER_HYPHEN_NUM), is(UPPER_CAMEL_NUM));
        assertThat(CaseConverter.toUpperCamel(LOWER_UNDERSCORE_NUM), is(UPPER_CAMEL_NUM));
        assertThat(CaseConverter.toUpperCamel(UPPER_CAMEL_NUM), is(UPPER_CAMEL_NUM));
        assertThat(CaseConverter.toUpperCamel(UPPER_HYPHEN_NUM), is(UPPER_CAMEL_NUM));
        assertThat(CaseConverter.toUpperCamel(UPPER_UNDERSCORE_NUM), is(UPPER_CAMEL_NUM));

        assertNull(CaseConverter.toUpperCamel(null));
    }

    @Test
    public void testToUpperHyphen() {
        assertThat(CaseConverter.toUpperHyphen(LOWER_CAMEL), is(UPPER_HYPHEN));
        assertThat(CaseConverter.toUpperHyphen(LOWER_HYPHEN), is(UPPER_HYPHEN));
        assertThat(CaseConverter.toUpperHyphen(LOWER_UNDERSCORE), is(UPPER_HYPHEN));
        assertThat(CaseConverter.toUpperHyphen(UPPER_CAMEL), is(UPPER_HYPHEN));
        assertThat(CaseConverter.toUpperHyphen(UPPER_HYPHEN), is(UPPER_HYPHEN));
        assertThat(CaseConverter.toUpperHyphen(UPPER_UNDERSCORE), is(UPPER_HYPHEN));

        assertThat(CaseConverter.toUpperHyphen(LOWER_CAMEL_NUM), is(UPPER_HYPHEN_NUM));
        assertThat(CaseConverter.toUpperHyphen(LOWER_HYPHEN_NUM), is(UPPER_HYPHEN_NUM));
        assertThat(CaseConverter.toUpperHyphen(LOWER_UNDERSCORE_NUM), is(UPPER_HYPHEN_NUM));
        assertThat(CaseConverter.toUpperHyphen(UPPER_CAMEL_NUM), is(UPPER_HYPHEN_NUM));
        assertThat(CaseConverter.toUpperHyphen(UPPER_HYPHEN_NUM), is(UPPER_HYPHEN_NUM));
        assertThat(CaseConverter.toUpperHyphen(UPPER_UNDERSCORE_NUM), is(UPPER_HYPHEN_NUM));

        assertNull(CaseConverter.toUpperHyphen(null));
    }

    @Test
    public void testToUpperUnderscore() {
        assertThat(CaseConverter.toUpperUnderscore(LOWER_CAMEL), is(UPPER_UNDERSCORE));
        assertThat(CaseConverter.toUpperUnderscore(LOWER_HYPHEN), is(UPPER_UNDERSCORE));
        assertThat(CaseConverter.toUpperUnderscore(LOWER_UNDERSCORE), is(UPPER_UNDERSCORE));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_CAMEL), is(UPPER_UNDERSCORE));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_HYPHEN), is(UPPER_UNDERSCORE));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_UNDERSCORE), is(UPPER_UNDERSCORE));

        assertThat(CaseConverter.toUpperUnderscore(LOWER_CAMEL_NUM), is(UPPER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toUpperUnderscore(LOWER_HYPHEN_NUM), is(UPPER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toUpperUnderscore(LOWER_UNDERSCORE_NUM), is(UPPER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_CAMEL_NUM), is(UPPER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_HYPHEN_NUM), is(UPPER_UNDERSCORE_NUM));
        assertThat(CaseConverter.toUpperUnderscore(UPPER_UNDERSCORE_NUM), is(UPPER_UNDERSCORE_NUM));

        assertNull(CaseConverter.toUpperUnderscore(null));
    }
}

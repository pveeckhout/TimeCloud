/*
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2014 Pieter Van Eeckhout
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of
 *   this software and associated documentation files (the "Software"), to deal in
 *   the Software without restriction, including without limitation the rights to
 *   use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *   the Software, and to permit persons to whom the Software is furnished to do so,
 *   subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *   COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *   IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package timecloud.enums;

/**
 *
 * Enumeration to store the different triage emergency levels.
 *
 * @author Pieter Van Eeckhout
 */
public enum TriageLevel {

    UNDEFINED(-1, "WHITE"),
    DECEASED(0, "BLACK"),
    NOT_URGENT(1, "GREEN"),
    URGENT(2, "ORANGE"),
    VERY_URGENT(3, "RED");

    private final int triageLevel;
    private final String triageColor;

    private TriageLevel(final int triageLevel, String triageColor) {
        this.triageLevel = triageLevel;
        this.triageColor = triageColor;
    }

    /**
     * Get the value of triageLevel
     *
     * @return the value of triageLevel.
     */
    public int getTriageLevel() {
        return triageLevel;
    }

    /**
     * Get the value of triageColor
     *
     * @return the value of triageColor.
     */
    public String getTriageColor() {
        return triageColor;
    }

    /**
     * returns the TriageLevel associated with the level code
     *
     * @return the TriageLevel.
     */
    public static TriageLevel fromInteger(int level) {
        switch (level) {
            case 0:
                return DECEASED;
            case 1:
                return NOT_URGENT;
            case 2:
                return URGENT;
            case 3:
                return VERY_URGENT;
            default:
                return UNDEFINED;
        }
    }
}

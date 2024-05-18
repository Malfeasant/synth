package us.malfeasant.synth;

/**
 * Maps one of 36 keys (3 octaves) to a MIDI note-
 * further mapping to frequency is done separately
 * Keys can be mapped in two groups, upper and lower,
 * each having its own offset
 */
public class KeyMapper {
    private static final String DEFAULT_MAPPING = "ZSXDCVGBHNJM,L.;/Q2W3E4RT6Y7UI9O0P-[";

    private String mapping;
    private int upperOffset;
    private int lowerOffset;

    /**
     * Constructs KeyMapper with default mapping and offsets-
     * Lower mapping Z for C₃ through / for E₄
     * Upper mapping Q for F₄ through [ for B₅
     */
    public KeyMapper() {
        this(48, 65);
    }
    public KeyMapper(int lowerOffset, int upperOffset) {
        this(lowerOffset, upperOffset, DEFAULT_MAPPING);
    }
    public KeyMapper(int lowerOffset, int upperOffset, String mapping) {
        this.lowerOffset = lowerOffset;
        this.upperOffset = upperOffset - 17;
        this.mapping = mapping;
    }
    /**
     * Maps a key press or release to a MIDI note number
     * @param key
     * @return
     */
    public int getKey(char key) {
        int rawKey = mapping.indexOf(key);
        return rawKey + (rawKey > 16 ? upperOffset : lowerOffset);
    }
}

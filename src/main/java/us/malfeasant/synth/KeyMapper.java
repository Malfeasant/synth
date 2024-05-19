package us.malfeasant.synth;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import javafx.scene.input.KeyCode;

/**
 * Maps one of 36 keys (3 octaves) to a MIDI note-
 * further mapping to frequency is done separately
 * Keys can be mapped in two groups, upper and lower,
 * each having its own offset
 */
public class KeyMapper {
    private static final KeyCode[] DEFAULT_MAPPING = {
        //"zsxdcvgbhnjm,l.;/q2w3e4rt6y7ui9o0p-[";
        KeyCode.Z, KeyCode.S, KeyCode.X, KeyCode.D, KeyCode.C, 
        KeyCode.V, KeyCode.G, KeyCode.B, KeyCode.H, KeyCode.N,
        KeyCode.J, KeyCode.M, KeyCode.COMMA, KeyCode.L,
        KeyCode.PERIOD, KeyCode.SEMICOLON, KeyCode.SLASH,
        KeyCode.Q, KeyCode.DIGIT2, KeyCode.W, KeyCode.DIGIT3,
        KeyCode.E, KeyCode.DIGIT4, KeyCode.R, KeyCode.T,
        KeyCode.DIGIT6, KeyCode.Y, KeyCode.DIGIT7, KeyCode.U,
        KeyCode.I, KeyCode.DIGIT9, KeyCode.O, KeyCode.DIGIT0,
        KeyCode.P, KeyCode.SUBTRACT, KeyCode.OPEN_BRACKET
    };

    private Map<KeyCode, Integer> map;
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
        this.lowerOffset = lowerOffset;
        this.upperOffset = upperOffset - 17;

        map = new EnumMap<>(KeyCode.class);
        for (int i = 0; i < DEFAULT_MAPPING.length; ++i) {
            map.put(DEFAULT_MAPPING[i], i);
        }
    }
    /**
     * Maps a key press or release to a MIDI note number
     * @param key
     * @return
     */
    public Optional<Integer> getNote(KeyCode key) {
        var rawKey = map.get(key);
        if (rawKey == null) return Optional.empty();
        return Optional.of(rawKey + (rawKey > 16 ? upperOffset : lowerOffset));
    }
}

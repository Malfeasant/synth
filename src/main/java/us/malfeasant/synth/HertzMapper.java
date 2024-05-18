package us.malfeasant.synth;

/**
 * Maps a MIDI note number to a frequency in Hz
 */
public class HertzMapper {
    private float basePitch;
    private float[] pitches;

    public HertzMapper() {
        this(440);
    }
    public HertzMapper(float basePitch) {
        if (basePitch < 10) throw new IllegalArgumentException(
            "Please pass a sensible basePitch.");
        this.basePitch = basePitch;
        pitches = new float[12];
        precomputePitches();
    }

    private void precomputePitches() {
        for (int i = 0; i < 12; ++i) {
            pitches[i] = basePitch * (float) (Math.pow(2, (i - 9) / 12.0));
        }
    }

    public float getHertz(int note) {
        // sanity check
        if (note > 127 || note < 0) throw new IllegalArgumentException(
            "MIDI notes range from 0 to 127");
        int octave = (note / 12) - 5;
        int pitch = note % 12;
        return pitches[pitch] * (float)Math.pow(2, octave);
    }
}

package design.patterns.behavioral.iterator;

public class Channel {
    private final double frequency;
    private final ChannelType TYPE;

    public Channel(double frequency, ChannelType type) {
        this.frequency = frequency;
        this.TYPE = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelType getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "frequency=" + this.frequency + ", Type=" + this.TYPE;
    }
}

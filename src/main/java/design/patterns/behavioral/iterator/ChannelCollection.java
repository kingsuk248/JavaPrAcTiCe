package design.patterns.behavioral.iterator;

public interface ChannelCollection {
    void addChannel(Channel channel);
    void removeChannel(Channel channel);
    ChannelIterator iterator(ChannelType channelType);
}

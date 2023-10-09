package design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {
    private final List<Channel> channels;

    public ChannelCollectionImpl() {
        channels = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        this.channels.remove(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelType channelType) {
        return new ChannelIteratorImpl(channelType, channels);
    }

    public static class ChannelIteratorImpl implements ChannelIterator {
        private final ChannelType channelType;
        private final List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelType channelType, List<Channel> channels) {
            this.channelType = channelType;
            this.channels = channels;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel c = channels.get(position);
                if (c.getTYPE().equals(channelType) || channelType.equals(ChannelType.ALL)) {
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel channel = channels.get(position);
            position++;
            return channel;
        }
    }
}

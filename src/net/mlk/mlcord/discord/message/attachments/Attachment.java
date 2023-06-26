package net.mlk.mlcord.discord.message.attachments;

import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.attachments.util.AttachmentType;

public class Attachment implements JsonConvertible {
    private String id;
    private String filename;
    private String description;
    private String content_type;
    private long size;
    private String url;
    private String proxy_url;
    private boolean ephemeral;
    private double duration_secs;
    private String waveform;
    private long height;
    private long width;

    /**
     * @return image height
     */
    public long getHeight() {
        return this.height;
    }

    /**
     * @return image width
     */
    public long getWidth() {
        return this.width;
    }

    /**
     * @return voice message duration
     */
    public double getDuration() {
        return this.duration_secs;
    }

    /**
     * @return base64 encoded bytearray representing a sampled waveform
     */
    public String getWaveform() {
        return this.waveform;
    }

    /**
     * @return attachment id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * @return attachment description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return size in bytes
     */
    public long getSize() {
        return this.size;
    }

    /**
     * @return url to attachment
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return proxy url to attachment
     */
    public String getProxyUrl() {
        return this.proxy_url;
    }

    /**
     * @return true if message is ephemeral
     */
    public boolean isEphemeral() {
        return this.ephemeral;
    }

    /**
     * @return message attachment type
     */
    public AttachmentType getType() {
        return AttachmentType.getByName(this.content_type);
    }

    /**
     * @return message attachment raw type
     */
    public String getRawType() {
        return this.content_type;
    }
}

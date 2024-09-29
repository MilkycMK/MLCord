package net.mlk.mlcord.discord.message.components.button;

import net.mlk.jmson.Json;
import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.emoji.Emoji;
import net.mlk.mlcord.discord.message.components.button.util.ButtonComponentStyle;
import net.mlk.mlcord.discord.message.components.MessageComponent;
import net.mlk.mlcord.discord.message.components.util.MessageComponentType;

@JsonObject(methodName = "validateJson")
public class ButtonComponent extends MessageComponent implements JsonConvertible {
    private int style;
    private String label;
    private Emoji emoji;
    private String url;
    private boolean disabled;

    public ButtonComponent() {

    }

    public ButtonComponent(MessageComponentType type, int style, String label, String custom_Id) {
        super(type.getCode());
        this.style = style;
        this.label = label;
        this.custom_id = custom_Id;
    }

    /**
     * @return true if disabled
     */
    public boolean isDisabled() {
        return this.disabled;
    }

    /**
     * @return url if link button
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return emoji if exists
     */
    public Emoji getEmoji() {
        return this.emoji;
    }

    /**
     * @return label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @return raw button style
     */
    public int getStyleRaw() {
        return this.style;
    }

    /**
     * @return button sty;e
     */
    public ButtonComponentStyle getStyle() {
        return ButtonComponentStyle.getByCode(this.style);
    }

    private boolean validateJson(Json json) {
        int type = json.getInteger("type");
        return type == 2;
    }

}
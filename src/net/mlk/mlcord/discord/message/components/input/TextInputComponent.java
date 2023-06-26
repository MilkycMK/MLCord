package net.mlk.mlcord.discord.message.components.input;

import net.mlk.jmson.Json;
import net.mlk.jmson.annotations.JsonObject;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.components.MessageComponent;
import net.mlk.mlcord.discord.message.components.input.util.TextInputStyle;

@JsonObject(methodName = "validateJson")
public class TextInputComponent extends MessageComponent implements JsonConvertible {
    private int style;
    private String label;
    private int min_length;
    private int max_length;
    private boolean required;
    private String value;
    private String placeholder;

    /**
     * @return text input placeholder
     */
    public String getPlaceholder() {
        return this.placeholder;
    }

    /**
     * @return input value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @return true if required
     */
    public boolean isRequired() {
        return this.required;
    }

    /**
     * @return min text length
     */
    public int getMinLength() {
        return this.min_length;
    }

    /**
     * @return max text length
     */
    public int getMaxLength() {
        return this.max_length;
    }

    /**
     * @return text input label
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
    public TextInputStyle getStyle() {
        return TextInputStyle.getByCode(this.style);
    }

    private boolean validateJson(Json json) {
        int type = json.getInteger("type");
        return type == 4;
    }

}
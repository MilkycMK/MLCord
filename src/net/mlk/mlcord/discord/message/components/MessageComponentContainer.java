package net.mlk.mlcord.discord.message.components;

import net.mlk.jmson.annotations.JsonField;
import net.mlk.jmson.utils.JsonConvertible;
import net.mlk.mlcord.discord.message.components.button.ButtonComponent;
import net.mlk.mlcord.discord.message.components.input.TextInputComponent;
import net.mlk.mlcord.discord.message.components.select.SelectMenuComponent;
import net.mlk.mlcord.discord.message.components.util.MessageComponentType;

import java.util.ArrayList;
import java.util.List;

public class MessageComponentContainer implements JsonConvertible {
    @JsonField(types={
            ButtonComponent.class,
            TextInputComponent.class,
            SelectMenuComponent.class
    })
    private final List<MessageComponent> components = new ArrayList<>();
    private final int type = 1;

    /**
     * @param component component to add
     * @return instance
     */
    public MessageComponentContainer addComponent(MessageComponent component) {
        this.components.add(component);
        return this;
    }

    /**
     * @return raw component type
     */
    public int getTypeRaw() {
        return this.type;
    }

    /**
     * @return component type
     */
    public MessageComponentType getType() {
        return MessageComponentType.getByCode(this.type);
    }

    /**
     * @return list with components
     */
    public List<MessageComponent> getComponents() {
        return this.components;
    }
}

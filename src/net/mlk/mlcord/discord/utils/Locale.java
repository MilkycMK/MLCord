package net.mlk.mlcord.discord.utils;

public enum Locale {
    ID("Indonesian", "Bahasa Indonesia"),
    DA("Danish", "Dansk"),
    DE("German", "Deutsch"),
    en_GB("English, UK", "English, UK"),
    en_US("English, US", "English, US"),
    es_ES("Spanish", "Español"),
    FR("French", "Français"),
    HR("Croatian", "Hrvatski"),
    IT("Croatian", "Italiano"),
    LT("Lithuanian", "Lietuviškai"),
    HU("Hungarian", "Magyar"),
    NL("Dutch", "Nederlands"),
    NO("Norwegian", "Norsk"),
    PL("Polish", "Polski"),
    pt_BR("Portuguese, Brazilian", "Português do Brasil"),
    RO("Romanian, Romania", "Română"),
    FI("Finnish", "Suomi"),
    sv_SE("Swedish", "Svenska"),
    VI("Vietnamese", "Tiếng Việt"),
    TR("Turkish", "Türkçe"),
    CS("Czech", "Čeština"),
    EL("Greek", "Ελληνικά"),
    BG("Bulgarian", "български"),
    RU("Russian", "Pусский"),
    UK("Ukrainian", "Українська"),
    HI("Hindi", "हिन्दी"),
    TH("Thai", "ไทย"),
    zh_CN("Chinese, China", "中文"),
    JA("Japanese", "日本語"),
    zh_TW("Chinese, Taiwan", "繁體中文"),
    KO("Korean", "한국어");

    private final String name;
    private final String nativeName;
    Locale(String name, String nativeName) {
        this.name = name;
        this.nativeName = nativeName;
    }

    /**
     * @return language name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return native language name
     */
    public String getNativeName() {
        return this.nativeName;
    }

    /**
     * @param lang lang to get
     * @return Locale
     */
    public static Locale getLocale(String lang) {
        for (Locale locale : values()) {
            if (locale.name().replace("_", "-").equalsIgnoreCase(lang)) {
                return locale;
            }
        }
        return null;
    }

}
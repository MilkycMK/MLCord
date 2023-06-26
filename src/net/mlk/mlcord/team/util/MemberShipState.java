package net.mlk.mlcord.team.util;


public enum MemberShipState {
    UNDEFINED(-1),
    INVITED(1),
    ACCEPTED(2);

    private final int code;
    MemberShipState(int code) {
        this.code = code;
    }

    /**
     * @return state code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @code code to get
     * @return state
     */
    public static MemberShipState getByCode(int code) {
        for (MemberShipState state : MemberShipState.values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return UNDEFINED;
    }
}
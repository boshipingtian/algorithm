package io.archie.patten.statemachine;

import java.util.EnumMap;
import java.util.Map;

public class Table {

    protected static final Map<State, Map<Event, State>> TRANSITIONS = new EnumMap<>(State.class);

    static {
        TRANSITIONS.put(State.NOT_LOGGED_IN, Map.of(
            Event.CLICK_LOGIN, State.LOGGING_IN,
            Event.ACCOUNT_LOCKED, State.LOCKED
        ));
        TRANSITIONS.put(State.LOGGING_IN, Map.of(
            Event.LOGIN_SUCCESS, State.LOGGED_IN,
            Event.LOGIN_FAILURE, State.NOT_LOGGED_IN,
            Event.ACCOUNT_LOCKED, State.LOCKED,
            Event.ACCOUNT_SUSPENDED, State.SUSPENDED
        ));
        TRANSITIONS.put(State.LOGGED_IN, Map.of(
            Event.CLICK_LOGOUT, State.NOT_LOGGED_IN,
            Event.ACCOUNT_LOCKED, State.LOCKED,
            Event.ACCOUNT_SUSPENDED, State.SUSPENDED
        ));
        TRANSITIONS.put(State.LOCKED, Map.of(
            Event.RESTORE, State.NOT_LOGGED_IN
        ));
        TRANSITIONS.put(State.SUSPENDED, Map.of(
            Event.RESTORE, State.NOT_LOGGED_IN
        ));
    }

    private Table() {
    }
}

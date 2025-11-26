package io.archie.patten.statemachine;

public class App {

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine(State.NOT_LOGGED_IN, Table.TRANSITIONS);
        stateMachine.handleEvent(Event.CLICK_LOGIN);
        stateMachine.handleEvent(Event.LOGIN_SUCCESS);
        stateMachine.handleEvent(Event.CLICK_LOGOUT);
    }

}

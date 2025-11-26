package io.archie.patten.statemachine;

import java.util.Map;

public class StateMachine {

    private State currentState;
    private final Map<State, Map<Event, State>> transitions;

    public StateMachine(State initialState, Map<State, Map<Event, State>> transitions) {
        this.currentState = initialState;
        this.transitions = transitions;
    }

    public void handleEvent(Event event) {
        Map<Event, State> stateMap = transitions.get(currentState);
        if (stateMap != null && stateMap.containsKey(event)) {
            State nextState = stateMap.get(event);
            System.out.println("Transition from " + currentState + " to " + nextState);
            this.currentState = nextState;
        } else {
            System.out.println("No transition defined for event " + event + " from state " + currentState);
        }
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

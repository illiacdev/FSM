package com.example.illiacdev.myapplication

open class FSM<T> {
    lateinit var curr: State

    abstract inner class State() {
        //일반전이, 자가(self)전이
        fun transit(nextState: State) {
            onExit()
            curr = nextState
            nextState.onEntry()
            nextState.action()
        }

        //내부전이
        fun internal_transit() {
            action()
        }

        abstract fun onEvent(action: (T) -> Unit)

        //진입액션
        fun onEntry() {
            println("onEntry" + this)
        }

        //전이액션
        fun action() {
            println("action" + this)
        }

        //탈출액션
        fun onExit() {
            println("onExit" + this)
        }
    }
}
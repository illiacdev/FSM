package com.example.illiacdev.myapplication

class MP3_플레이어 : FSM<MP3_플레이어.Event>() {

    abstract class Event {
        open fun on재생() {}
        open fun on정지() {}
        open fun on전원끔() {}
        open fun on전원켬() {}
    }

    val s전원꺼짐: State = object : State() {
        override fun onEvent(action: (Event) -> Unit) {
            action(object : Event() {
                override fun on전원켬() {
                    transit(s대기)
                }
            })

        }

        override fun toString(): String {
            return "s전원꺼짐"
        }


    }

    init {
        curr = s전원꺼짐
    }


    val s대기: State = object : State() {
        override fun onEvent(action: (Event) -> Unit) {
            action(object : Event() {
                override fun on전원끔() {
                    transit(s전원꺼짐)
                }

                override fun on재생() {
                    transit(s곡재생)
                }
            })
        }

        override fun toString(): String {
            return "s대기"
        }
    }


    val s곡재생: State = object : State() {
        override fun onEvent(action: (Event) -> Unit) {
            action(object : Event() {


                override fun on정지() {
                    transit(s대기)
                }

                override fun on전원끔() {
                    transit(s전원꺼짐)
                }
            })
        }

        override fun toString(): String {
            return "s곡재생"
        }
    }
}
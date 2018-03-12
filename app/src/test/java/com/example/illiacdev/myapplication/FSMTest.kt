package com.example.illiacdev.myapplication

import com.example.illiacdev.myapplication.MP3_플레이어.Event
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class FSMTest {

    @Test
    fun func1() {
        val fsm = MP3_플레이어()

        fsm.curr.onEvent(Event::on전원켬)
        assertThat(fsm.curr.toString(), `is`("s대기"))
        println("현재상태 : " + fsm.curr)

        fsm.curr.onEvent(Event::on재생)
        assertThat(fsm.curr.toString(), `is`("s곡재생"))
        println("현재상태 : " + fsm.curr)

        fsm.curr.onEvent(Event::on정지)
        assertThat(fsm.curr.toString(), `is`("s대기"))
        println("현재상태 : " + fsm.curr)

        fsm.curr.onEvent(Event::on재생)
        assertThat(fsm.curr.toString(), `is`("s곡재생"))
        println("현재상태 : " + fsm.curr)

        fsm.curr.onEvent(Event::on전원끔)
        assertThat(fsm.curr.toString(), `is`("s전원꺼짐"))
        println("현재상태 : " + fsm.curr)

    }

}
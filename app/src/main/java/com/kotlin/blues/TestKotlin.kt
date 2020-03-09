package com.kotlin.blues

import com.kotlin.blues.util.DateUtil
import com.kotlin.blues.util.DateUtil.DATE_FORMAT
import com.kotlin.blues.util.DateUtil.convertTolong
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by qishoudong on 2017/6/12.
 */
class TestKotlin {
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            var test = Test()
        }

        fun Test() {

            System.out.println("------" + System.currentTimeMillis())
//            var lastTime = 1582607759577L
//            var lastTime = 1582529807000L
//            var lastTime = 1582519007000L
            var lastTime = 1582605407000L
//            var lastTime = 1551011807000L//23
//            var lastTime =   1582702618000
//            1582702618
//            var lastTime = 1582547807000L
//            var lastTime = System.currentTimeMillis()
//            var time = DateUtil.getTimeToDateFormat(lastTime.toString(),DATE_FORMAT)
//            println("time:$time")
////            getcurrentTimeDistanceDay2(lastTime)
//            var newTime = DateUtil.getTimeToDateFormat(System.currentTimeMillis().toString(),DATE_FORMAT)
//            println("newTime:$newTime")
//            var distanceDay = DateUtil.getIntervalDay(lastTime)
//            println("distanceDay:$distanceDay")


//            var url="https://www.test.17zuoye.net/zion/zx-parent?homework_id=5e5e0c8f70e97fb4136bc08b&student_id=334088614#homeworkReport"
            var url="https://www.test.17zuoye.net/zion/zx-parent?homework_id=5e5e0c8f70e97fb4136bc08b&student_id=334088614"

            url=DateUtil.buildUrlDefineAddParem(url,"posid","11111")
            println("----------$url")
        }

    }

}

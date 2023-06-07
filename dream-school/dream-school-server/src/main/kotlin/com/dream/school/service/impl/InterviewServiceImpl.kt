package com.dream.school.service.impl

import com.dream.school.service.InterviewService
import org.springframework.stereotype.Service

@Service
class InterviewServiceImpl: InterviewService {
    /**
     * 百元买百鸡
     */
    override fun chicken() {
        for (mother in 0..100) {
            for (rooster in 0..100) {
                val chick = 100 - mother - rooster
                if ((3 * mother + 5 * rooster + (chick / 3)) == 100) {
                    println( "母鸡数量：$mother，公鸡数量：$rooster，小鸡数量：$chick")
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    override fun bubbleSort(array: IntArray) {
        println("原始数组: ${array.contentToString()}")
        val number = array.size
        for (i in 0 until number - 1) {
            for (j in 0 until number - i - 1) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
        println("排序后数组: ${array.contentToString()}")
    }
}
package ir.sinamomken.karafs_interview0

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class karafsInterview0UnitTest {
    @Test
    fun createInArray5_isCorrect() {
        val inArray5 = arrayListOf<IntArray>(
            intArrayOf(0,1,2,3,4),
            intArrayOf(5,6,7,8,9),
            intArrayOf(10,11,12,13,14),
            intArrayOf(15,16,17,18,19),
            intArrayOf(20,21,22,23,24)
        )

        for(i:Int in 0..4){
            assertArrayEquals(MainActivity.createInArray(5)[i],inArray5[i])
        }
    }

    @Test
    fun calculateOutArray5_isCorrect(){
        val expectedOutArray = arrayListOf<IntArray>(
            intArrayOf(4,0,0,0,0),
            intArrayOf(3,9,0,0,0),
            intArrayOf(2,8,14,0,0),
            intArrayOf(1,7,13,19,0),
            intArrayOf(0,6,12,18,24),
            intArrayOf(5,11,17,23,0),
            intArrayOf(10,16,22,0,0),
            intArrayOf(15,21,0,0,0),
            intArrayOf(20,0,0,0,0)
        )
        val calculatedOutArray = MainActivity.calculateOutArray(MainActivity.createInArray(5))
        for(i:Int in 0..8){
            assertArrayEquals(expectedOutArray[i],calculatedOutArray[i])
        }
    }
}
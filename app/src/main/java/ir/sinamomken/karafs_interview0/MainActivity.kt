package ir.sinamomken.karafs_interview0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doJobs(5)
        setupListeners()
    }

    private fun setupListeners(){
        n_et.doOnTextChanged { text, start, before, count ->
            var n: Int = 5
            try {
                n = text.toString().toInt()
            }catch (e:Exception){
                n = 5
            }
            doJobs(n)
        }
    }

    private fun doJobs(n: Int){
        val inArray = createInArray(n)
        printArray(inArray, original_tv)
        val outArray = calculateOutArray(inArray)
        printArray(outArray, processed_tv)
    }

    fun printArray(a: Array<IntArray>, tv:TextView){
        var rowStr : String = " \n"
        for(i:Int in 0..a.size-1){
            for(j:Int in 0..a[i].size-1){
                rowStr = rowStr + a[i][j].toString() + " "
            }
            rowStr = rowStr + "\n"
        }
        Log.i("MainActivity", rowStr)
        tv.text = rowStr
    }

    companion object {
        fun createInArray(n: Int): Array<IntArray> {
            val outArray = Array(n) { IntArray(n) }
            for (i: Int in 0..(n - 1)) {
                for (j: Int in 0..(n - 1)) {
                    outArray[i][j] = i * n + j
                }
            }
            return outArray
        }

        fun calculateOutArray(inArr: Array<IntArray>): Array<IntArray> {
            val n: Int = inArr.size
            val outArr = Array(2 * n - 1) { IntArray(n) { 0 } }

            for (k: Int in 0..n - 1) {
                var i: Int = k
                for (j: Int in k..n - 1) {
                    outArr[i - j + n - 1][k] = inArr[i][j]
                }

                var j: Int = k
                for (i: Int in k..n - 1) {
                    outArr[i - j + n - 1][k] = inArr[i][j]
                }
            }

            return outArr
        }
    }
}
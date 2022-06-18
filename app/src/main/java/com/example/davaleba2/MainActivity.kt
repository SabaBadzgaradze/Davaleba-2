package com.example.davaleba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: AppCompatEditText
    private lateinit var button: AppCompatButton
    private lateinit var textView: AppCompatTextView

    private lateinit var numbers: Map<Int, String>
    private lateinit var help: Map<Int, String>
    private lateinit var help1: Map<Int, String>
    private lateinit var hundred: Map<Int, String>
    private lateinit var tens: Map<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        onClick()
    }

    private fun init() {
        numbers = mapOf(
            0 to "",
            1 to "ერთი",
            2 to "ორი",
            3 to "სამი",
            4 to "ოთხი",
            5 to "ხუთი",
            6 to "ექვსი",
            7 to "შვიდი",
            8 to "რვა",
            9 to "ცხრა",
            10 to "ათი",
            11 to "თერთმეტი",
            12 to "თორმეტი",
            13 to "ცამეტი",
            14 to "თოთხმეტი",
            15 to "თხუთმეტი",
            16 to "თექვსმეტი",
            17 to "ჩვიდმეტი",
            18 to "თვრამეტი",
            19 to "ცხრამეტი",
            20 to "ოცი",
            30 to "ოცდაათი",
            40 to "ორმოცი",
            50 to "ორმოცდაათი",
            60 to "სამოცი",
            70 to "სამოცდაათი",
            80 to "ოთხმოცი",
            90 to "ოთხმოცდაათი"
        )

        tens = mapOf(
            1 to "ათი",
            2 to "ოცი",
            3 to "ოცდაათი",
            4 to "ორმოცი",
            5 to "ორმოცდაათი",
            6 to "სამოცი",
            7 to "სამოცდაათი",
            8 to "ოთხმოცი",
            9 to "ოთხმოცდაათი"
        )

        help = mapOf(
            2 to "ოცდა",
            3 to "ოცდა",
            4 to "ორმოცდა",
            5 to "ორმოცდა",
            6 to "სამოცდა",
            7 to "სამოცდა",
            8 to "ოთხმოცდა",
            9 to "ოთხმოცდა"
        )

        help1 = mapOf(
            1 to "ას",
            2 to "ორას",
            3 to "სამას",
            4 to "ოთხას",
            5 to "ხუთას",
            6 to "ექვსას",
            7 to "შვიდას",
            8 to "რვაას",
            9 to "ცხრაას"
        )

        hundred = mapOf(
            1 to "ასი",
            2 to "ორასი",
            3 to "სამასი",
            4 to "ოთხასი",
            5 to "ხუთასი",
            6 to "ექვსასი",
            7 to "შვიდასი",
            8 to "რვაასი",
            9 to "ცხრაასი"
        )

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
    }

    private fun onClick() {

        button.setOnClickListener {
            if (editText.text!!.isNotEmpty()) {

            val numberAsString = editText.text.toString()
            val number = numberAsString.toInt()
            var result: String = ""

            if (number > 1000 || number < 1 ){
                Toast.makeText(this, "გთხოვთ შეიყვანოთ 1-1000 რიცხვი", Toast.LENGTH_SHORT).show()
            }

            if (number <= 20 || (numberAsString.length == 2 && numberAsString[numberAsString.length-1] == '0')) {
                result = numbers[number]!!
            } else if (numberAsString.length == 2) {
                val startNumber = Integer.parseInt(numberAsString[0].toString())

                val endNumber = if (startNumber % 2 == 0) {
                    Integer.parseInt(numberAsString[1].toString())
                } else {
                    val end = "1" + numberAsString[1].toString()
                    Integer.parseInt(end)
                }

                result = help[startNumber] + numbers[endNumber]
            } else if (numberAsString.length == 3 && (number % 100 == 0)){
                val a = Integer.parseInt(numberAsString[0].toString())
                result = hundred[a] + ""
                textView.text = result

            } else if (numberAsString.length == 3) {
                val startNumber = Integer.parseInt(numberAsString[0].toString())
                val middleNumber = Integer.parseInt(numberAsString[1].toString())
                val lastNumber = Integer.parseInt(numberAsString[2].toString())

                result = if (lastNumber == 0){

                    help1[startNumber] + tens[middleNumber]
                }else {
                    val endNumber = if (middleNumber % 2 == 0) {
                        Integer.parseInt(numberAsString[2].toString())
                    } else {
                        val end = "1" + numberAsString[2].toString()
                        Integer.parseInt(end)
                    }

                    help1[startNumber] + help[middleNumber] + numbers[endNumber]

                }

            }else if (number == 1000){
                result = "ათასი"
            }
            if ("null" in result) {
                result = result.replace("null", "")
                Log.d("saba", "test")

            }

            textView.text = result
            }
        }

    }

}
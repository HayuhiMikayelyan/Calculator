package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener{setTextFields("0")}
        binding.btn1.setOnClickListener{setTextFields("1")}
        binding.btn2.setOnClickListener{setTextFields("2")}
        binding.btn3.setOnClickListener{setTextFields("3")}
        binding.btn4.setOnClickListener{setTextFields("4")}
        binding.btn5.setOnClickListener{setTextFields("5")}
        binding.btn6.setOnClickListener{setTextFields("6")}
        binding.btn7.setOnClickListener{setTextFields("7")}
        binding.btn8.setOnClickListener{setTextFields("8")}
        binding.btn9.setOnClickListener{setTextFields("9")}
        binding.btnPlus.setOnClickListener{setTextFields("+")}
        binding.btnMinus.setOnClickListener{setTextFields("-")}
        binding.btnMultiply.setOnClickListener{setTextFields("*")}
        binding.btnDevide.setOnClickListener{setTextFields("/")}
        binding.btnOpenBracket.setOnClickListener{setTextFields("(")}
        binding.btnCloseBracket.setOnClickListener{setTextFields(")")}
        binding.btnPoint.setOnClickListener{setTextFields(".")}

        binding.btnC.setOnClickListener{
            binding.text.text=""
            binding.answer.text=""
        }

        binding.btnBack.setOnClickListener{
            val str = binding.text.text.toString()
            if (str.isNotEmpty()){
                binding.text.text = str.substring(0,str.length-1)
                binding.answer.text = ""
            }
        }

        findViewById<TextView>(R.id.btn_equals).setOnClickListener {
            try{
                val ex = ExpressionBuilder(binding.text.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()){
                    binding.answer.text = longRes.toString()
                }else{
                    binding.answer.text = result.toString()
                }
            }catch (e:Exception){
                binding.answer.text = "Ошибка"
            }
        }
    }

    fun setTextFields(str:String){
        binding.text.append(str)
    }


}
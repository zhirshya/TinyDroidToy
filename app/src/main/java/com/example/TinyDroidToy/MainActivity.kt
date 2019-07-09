package com.example.TinyDroidToy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private final var payload: Map<String, String>  = mapOf("Amount" to "1", "From" to "USD", "To" to "CNY")

//    private var r: Response?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//            var str:String = URL("http://httpbin.org/ip").readText()
//            Get our IP

        object : Thread() {
            override fun run() {
                println(HttpUtil.httpGet("http://httpbin.org/ip",payload,"utf-8"))
                println(HttpUtil.httpGet("https://www.xe.com/currencyconverter/convert/",payload,"utf-8"))
            }
        }.start()
//            // Get our IP in a simpler way
//            println(get("http://icanhazip.com").text)

//        setSupportActionBar(toolbar)
//            var r = get("https://www.xe.com/currencyconverter/convert/", params = payload)
//            var cbtn = findViewById<Button>(R.id.cvtBtn)
//        cbtn.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        }

    fun convertCurrency(view: View) {
        if(waliutText.text.isNotEmpty()) {
            val waliutValue = waliutText.text.toString().toFloat()
            //https://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=CNY
//            waliutText2.setText(r?.text ?: "erroneous response")
//            waliutText2.setText(r.text)
        }else {
            waliutText2.setText("")
        }
    }

    init {
//    https://khttp.readthedocs.io/en/latest/user/quickstart.html
//        khttp is an elegant and simple HTTP library for Kotlin and Java, built for human beings.
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        println("asdfasdfasdfasdf")
        return when (item.itemId) {
            R.id.start -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
package org.techtown.custom_font

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private var inDouble: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {

        println(" create 시작");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //메인 -> 어댑터 -> listview.xml -> listView
        var list_item = mutableListOf<ListViewModel>()
        list_item.add(ListViewModel("a", "b"))
        list_item.add(ListViewModel("c", "d"))
        list_item.add(ListViewModel("e", "f"))
        println(" list_item = " + list_item);
        //ListView에있는 어댑터에서 가져옴
        val listView = findViewById<ListView>(R.id.mainListview)
        println(" listView = " + listView);
        //데이터가 Adpter로 넘어감
        var listAdpter = ListViewAdactper(list_item)
        //어댑터에 list_item
        println(" listAdpter = " + listAdpter);
        listView.adapter = listAdpter //여기서 뭔가일어난다 //size , p0
        println(" listView = " + listView);
        println("  listView.adapter  = " + listView.adapter);
        Log.d("##### Main", list_item.toString())


    }

    //AppCompatActivity에서 받는다
    override fun onBackPressed() {
        println("실행111111111111 ")
        println("inDouble = "+inDouble)
        if(inDouble == true){
            print("inDouble == true 에옴 ")
//            finish() == 요놈을스택을없애버림
            finish()
        }
//        inDouble = true
        Toast.makeText(this, "종료하실려면 더블클릭", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            println("handler().postDelayed 실행@@@")
                inDouble = true
        }, 3000)
//        super.onBackPressed()
        print("실행222222222222")
    }

}
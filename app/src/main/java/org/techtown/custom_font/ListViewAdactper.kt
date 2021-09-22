package org.techtown.custom_font

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

//alt + Enter로 오버라이딩해라

class ListViewAdactper(val list : MutableList<ListViewModel>) : BaseAdapter(){

    //ListView의 개수이다
    override fun getCount(): Int {
//        TODO("Not yet implemented")
        println("list.size = "+list.size)
        return list.size
    }
    //특별히 신경쓰지말라함
    override fun getItem(position: Int): Any {
        println("list[position]= "+list[position])
        return list[position]
//        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        println(" p0.toLong()]= "+ p0.toLong())
        return p0.toLong()
//        TODO("Not yet implemented")
    }
//요놈이 중요함
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
    //p0이 list의 index로 보인다
    println(" getView.p0 = "+ p0.toLong())
    println(" getView.p1 = "+ p1)
    println(" getView.p2 = "+ p2)
    var convertView = p1
    println("convertView = "+convertView)

        if(convertView == null){

            println("convertView가 널입니다다")
            //LayoutInflater아이템에 잇는 View를 가져오는거라함
            //convertView가  listView.item.xml의 listView이다.
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item,p2,false)
       }

        var title = convertView!!.findViewById<TextView>(R.id.listViewItem)
        var content = convertView!!.findViewById<TextView>(R.id.listViewItem2)

        println("getView의 list[p0] = "+list[p0])

        title.text = list[p0].title //들어가게해라
        content.text = list[p0].content



        return convertView!!
    }



}



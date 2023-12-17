package com.example.mytatarstfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items2)



        val itemList: RecyclerView = findViewById(R.id.itemsList)
        val item = arrayListOf<Item>()

        item.add(Item(1,"chau","Эчпочмак","Эчпочмак с говядиной ","мясо говядины, картошка, тесто",15))
        item.add(Item(2,"tree", "Чай","Чай с молоком","1 чайная ложка заварки (лучше брать плиточный),1,5 стакана воды, 3-4 ст. л. молока, щепотка соли, перец (по вкусу), кусочек сливочного масла", 25))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemAdapter(item,this)
    }
}